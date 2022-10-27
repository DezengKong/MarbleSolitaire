package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.AbstractSolitaireModel;

/**
 * The EnglishSolitaireModel extends{@link AbstractSolitaireModel} represented as armThinkness,
 * sRow, sCol and the boards. Specifying the operations mentioned in the interface.
 */
public class EnglishSolitaireModel extends AbstractSolitaireModel {

  /**
   * Constructs a default English Solitaire Model where the armThickness equals to 3, and the empty
   * cell is in the center.
   */
  public EnglishSolitaireModel() {
    this(3, 3, 3);
  }

  /**
   * Constructs an English Solitaire Model with the customized empty cell which depends on the input
   * of sRow and sCol.
   *
   * @param sRow the row of the empty cell
   * @param sCol the column of the empty cell
   * @throws IllegalArgumentException if the empty cell is not in the valid position
   */
  public EnglishSolitaireModel(int sRow, int sCol) {
    this(3, sRow, sCol);
  }

  /**
   * Constructs an English Solitaire Model with the customized armThickness which depends on the
   * input, and the empty cell is in the center of the board.
   *
   * @param armThickness the given armThickness (odd and non-negative)
   * @throws IllegalArgumentException if the armThickness is even or negative
   */
  public EnglishSolitaireModel(int armThickness) {
    this(armThickness, armThickness - 1 +
        armThickness / 2, armThickness - 1 + armThickness / 2);
  }

  /**
   * Constructs an English Solitaire Model with the customized armThickness and customized empty
   * cell which depends on the input of sRow and sCol.
   *
   * @param armThickness the given armThickness (odd and non-negative)
   * @param sRow         the row of the empty cell
   * @param sCol         the column of the empty cell
   * @throws IllegalArgumentException if the armThickness is even or negative
   * @throws IllegalArgumentException if the empty cell is not in the valid position
   */
  public EnglishSolitaireModel(int armThickness, int sRow, int sCol) {
    if ((sRow < armThickness - 1 && sCol < armThickness - 1) || (sRow > armThickness * 2 - 2
        && sCol > armThickness * 2 - 2) || (sRow > armThickness * 2 - 2 && sCol < armThickness - 1)
        || (sRow < armThickness - 1 && sCol > armThickness * 2 - 2)) {
      throw new IllegalArgumentException(
          "Invalid empty cell position (" + Integer.toString(sRow) + "," + Integer.toString(sCol)
              + ")");
    }
    if (armThickness % 2 != 1 || armThickness < 0) {
      throw new IllegalArgumentException(
          "Invalid arm thickness number" + Integer.toString(armThickness));
    }
    this.armThickness = armThickness;
    this.sRow = sRow;
    this.sCol = sCol;
    this.board = this.drawBoard();
  }

  // draw the board.

  /**
   * Draw the board.
   *
   * @return a 2-D array which is the SlotState[][] as the the board
   */
  private SlotState[][] drawBoard() {
    board = new SlotState[this.getBoardSize()][this.getBoardSize()];
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if (i < armThickness - 1 && j < armThickness - 1
            || i < armThickness - 1 && j > armThickness * 2 - 2
            || i > armThickness * 2 - 2 && j < armThickness - 1
            || i > armThickness * 2 - 2 && j > armThickness * 2 - 2) {
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

}
