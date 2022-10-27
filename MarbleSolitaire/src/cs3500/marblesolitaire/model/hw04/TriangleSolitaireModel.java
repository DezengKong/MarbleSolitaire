package cs3500.marblesolitaire.model.hw04;

/**
 * Represented class TriangleSolitaireModel extends {@link AbstractSolitaireModel}. Using the fields
 * extending from parent class, and then using the field of itself to initialize itself, and
 * override the method which is not same as the parent class.
 */
public class TriangleSolitaireModel extends AbstractSolitaireModel {

  private final int dimension;

  /**
   * Constructs a default triangular Solitaire Model where the dimension equals to 5, and the empty
   * cell is in the center.
   */
  public TriangleSolitaireModel() {
    this(5);
  }

  /**
   * Constructs a triangular Solitaire Model with the customized dimension which depends on the
   * input, and the empty cell is in the top of the board.
   *
   * @param dimension the given non negative dimension
   * @throws IllegalArgumentException if the dimension is negative
   */
  public TriangleSolitaireModel(int dimension) {
    this(dimension, 0, 0);
  }

  /**
   * Constructs a Triangular Solitaire Model with the customized empty cell which depends on the
   * input of sRow and sCol and the default dimension which is 5.
   *
   * @param sRow the row of the empty cell
   * @param sCol the column of the empty cell
   * @throws IllegalArgumentException if the empty cell is not in the valid position
   */
  public TriangleSolitaireModel(int sRow, int sCol) {
    this(5, sRow, sCol);
  }

  /**
   * Constructs a triangular Solitaire Model with the customized dimension and customized empty cell
   * which depends on the input of sRow and sCol.
   *
   * @param dimension the given dimension
   * @param sRow      the row of the empty cell
   * @param sCol      the column of the empty cell
   * @throws IllegalArgumentException if the dimension negative
   * @throws IllegalArgumentException if the empty cell is not in the valid position
   */
  public TriangleSolitaireModel(int dimension, int sRow, int sCol) {
    if (dimension <= 0) {
      throw new IllegalArgumentException(
          "Invalid dimension number" + Integer.toString(dimension));
    }

    if (sRow < 0 || sCol < 0 || sRow >= dimension || sCol >= dimension || sRow < sCol) {
      throw new IllegalArgumentException(
          "Invalid empty cell position (" + Integer.toString(sRow) + "," + Integer.toString(sCol)
              + ")");
    }
    this.dimension = dimension;
    this.sRow = sRow;
    this.sCol = sCol;
    this.board = this.drawBoard();
  }

  /**
   * Draw the board which is the helper method for what the board should be initialized.
   *
   * @return a 2D array SlotState[][]
   */
  private SlotState[][] drawBoard() {
    board = new SlotState[this.getBoardSize()][this.getBoardSize()];
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if (i < j) {
          board[i][j] = SlotState.Invalid;
        } else if (i == sRow && j == sCol) {
          board[i][j] = SlotState.Empty;
        } else {
          board[i][j] = SlotState.Marble;
        }
      }
    }
    return board;
  }

  @Override
  protected boolean validMove(int fromRow, int fromCol, int toRow, int toCol) {
    return this.getSlotAt(fromRow, fromCol) == SlotState.Marble // the fromSlot should be marble
        && this.getSlotAt(toRow, toCol) == SlotState.Empty // the toSlot should be empty

        // the toSlot shouldn't be invalid
        && this.getSlotAt(toRow, toCol) != SlotState.Invalid

        // the toSlot shouldn't be invalid
        && this.getSlotAt(toRow, toCol) != SlotState.Marble

        // move horizontally and only allowed to move 2 slots
        && ((Math.abs(toRow - fromRow) == 0 && Math.abs(toCol - fromCol) == 2)

        // move vertically and only allowed to move 2 slots
        || (Math.abs(toRow - fromRow) == 2 && Math.abs(toCol - fromCol) == 0)
        || (fromRow - toRow == 2 && fromCol - toCol == 2)
        || (toRow - fromRow == 2 && toCol - fromCol == 2))

        // the middle slot between fromSlot and the toSlot should be a marble
        && this.getSlotAt((toRow + fromRow) / 2, (toCol + fromCol) / 2) == SlotState.Marble

        // all the move should inside the board
        && fromRow >= 0 && fromRow < this.getBoardSize() && toRow >= 0
        && toRow < this.getBoardSize()
        && fromCol >= 0 && fromCol < this.getBoardSize() && toCol >= 0
        && toCol < this.getBoardSize();
  }

  @Override
  public boolean isGameOver() {
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if ((i >= 2 && this.validMove(i, j, i - 2, j))
            || (j >= 2 && this.validMove(i, j, i, j - 2))
            || (i < (this.getBoardSize() - 2) && this.validMove(i, j, i + 2, j))
            || (j < (this.getBoardSize() - 2) && this.validMove(i, j, i, j + 2))
            || (i >= 2 && j >= 2 && this.validMove(i, j, i - 2, j - 2))
            ||
            (i < (this.getBoardSize() - 2) && j < (this.getBoardSize() - 2) && this.validMove(i, j,
                i + 2, j + 2))
                && board[i][j] == SlotState.Marble) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public int getBoardSize() {
    return dimension;
  }
}
