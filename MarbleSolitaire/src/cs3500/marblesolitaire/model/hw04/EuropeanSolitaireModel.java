package cs3500.marblesolitaire.model.hw04;


/**
 * Represented class EuropeanSolitaireModel extends {@link AbstractSolitaireModel}. Using the fields
 * extending from parent class, and then using the field of itself to initialize itself, and
 * override the method which is not same as the parent class.
 */
public class EuropeanSolitaireModel extends AbstractSolitaireModel {

  private final int side;

  /**
   * Initializes the constructor with 0 parameter which should be size of 3 and the empty cell
   * should be in the center of the board.
   */
  public EuropeanSolitaireModel() {
    this(3, 3, 3);
  }

  /**
   * Initializes the constructor with 1 parameter which should be size which is in the parameter,
   * and the empty slot should in the center of the board by default.
   *
   * @param side the given side which is customized
   * @throws IllegalArgumentException if the side is less than 0 or the side is an even number
   */
  public EuropeanSolitaireModel(int side) throws IllegalArgumentException {
    this(side, side - 1 + side / 2, side - 1 + side / 2);
  }

  /**
   * Initializes the constructor with 2 parameter. The customized European SolitaireModel should be
   * the default size and the empty slot should be based on the sRow and sCol.
   *
   * @param sRow the given sRow
   * @param sCol the given sCol
   * @throws IllegalArgumentException if the sRow and sCol is in the invalid area or in the non
   *                                  existing area.
   */
  public EuropeanSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this(3, sRow, sCol);
  }

  /**
   * Initializes the constructor with 2 parameter. The customized European SolitaireModel should be
   * the customized size and the empty slot should be based on the sRow and sCol.
   *
   * @param side the given side
   * @param sRow the given sRow
   * @param sCol the given sCol
   * @throws IllegalArgumentException if the sRow and sCol is in the invalid area or in the
   *                                  non-existing area.
   * @throws IllegalArgumentException if the side is negative
   */
  public EuropeanSolitaireModel(int side, int sRow, int sCol) throws IllegalArgumentException {

    if (side < 0 || side % 2 == 0) {
      throw new IllegalArgumentException("The side is invalid");
    }

    if (sRow < 0 || sCol < 0 || sRow > 3 * side - 2 - 1 || sCol > 3 * side - 2 - 1
        || (sRow + sCol < side - 1) || (sRow - sCol > 2 * side - 2)
        || (sRow + sCol >= 5 * side - 4) || (sCol - sRow > 2 * side - 2)) {
      throw new IllegalArgumentException(
          "Invalid empty cell position (" + Integer.toString(sRow) + "," + Integer.toString(sCol)
              + ")");
    }
    this.side = side;
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
    SlotState[][] board = new SlotState[this.getBoardSize()][this.getBoardSize()];
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if (i + j < side - 1
            || i - j > 2 * side - 2
            || i + j >= 5 * side - 4
            || j - i > 2 * side - 2) {
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
  public int getBoardSize() {
    return (this.side * 3) - 2;
  }
}
