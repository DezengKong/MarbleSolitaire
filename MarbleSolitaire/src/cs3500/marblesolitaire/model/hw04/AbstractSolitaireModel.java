package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Represents the abstract class AbstractSolitaireModel implements {@link MarbleSolitaireModel} by
 * using fields of armThinkness, sRow, sCol and the boards to write constructors and specify the
 * operations mentioned in the interface.
 */
public abstract class AbstractSolitaireModel implements MarbleSolitaireModel {

  protected int armThickness;
  protected int sRow;
  protected int sCol;
  protected SlotState[][] board;

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (row < 0 || col < 0 || row > this.getBoardSize() - 1 || col > this.getBoardSize() - 1) {
      throw new IllegalArgumentException("There is no SlotState");
    } else {
      return board[row][col];
    }
  }

  // If the move is valid, then the fromSlot will be empty, and the slot between fromSlot and toSlot
  // will be empty, then the toSlot will be a marble.
  // 1: cannot move Diagonally
  // 2: cannot move from a non exist slot position
  // 3: cannot move to a non exist slot position
  // 4: cannot move to a position where the middle position is empty
  // 5: cannot move over 2 positions at one time
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (this.validMove(fromRow, fromCol, toRow, toCol)) {
      this.board[fromRow][fromCol] = SlotState.Empty;
      this.board[toRow][toCol] = SlotState.Marble;
      this.board[(toRow + fromRow) / 2][(toCol + fromCol) / 2] = SlotState.Empty;
    } else {
      throw new IllegalArgumentException("the movement is invalid");
    }
  }

  /**
   * Determine and return if the move is valid which can move horizontally and vertically with the
   * neighbor which is a marble.
   *
   * @param fromRow the row number of the position to be moved from (starts at 0)
   * @param fromCol the column number of the position to be moved from (starts at 0)
   * @param toRow   the row number of the position to be moved to (starts at 0)
   * @param toCol   the column number of the position to be moved to (starts at 0)
   * @return true if the move is valid, false otherwise
   */
  protected boolean validMove(int fromRow, int fromCol, int toRow, int toCol) {
    return this.getSlotAt(fromRow, fromCol) == SlotState.Marble // the fromSlot should be marble
        && this.getSlotAt(toRow, toCol) == SlotState.Empty // the toSlot should be empty

        // the toSlot shouldn't be invalid
        && this.getSlotAt(toRow, toCol) != SlotState.Invalid

        // the toSlot shouldn't be Marble
        && this.getSlotAt(toRow, toCol) != SlotState.Marble

        // move horizontally and only allowed to move 2 slots
        && ((Math.abs(toRow - fromRow) == 0 && Math.abs(toCol - fromCol) == 2)

        // move vertically and only allowed to move 2 slots
        || (Math.abs(toRow - fromRow) == 2 && Math.abs(toCol - fromCol) == 0))

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
        // traversal all the existed mable in the board, and check 4 directions whether there are
        // more valid move or not
        if ((i >= 2 && this.validMove(i, j, i - 2, j)) || (j >= 2 && this.validMove(i, j, i, j - 2))
            || (i < (this.getBoardSize() - 2) && this.validMove(i, j, i + 2, j))
            || (j < (this.getBoardSize() - 2) && this.validMove(i, j, i, j + 2))
            && board[i][j] == SlotState.Marble) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public int getBoardSize() {
    return armThickness * 3 - 2;
  }


  @Override
  public int getScore() {
    int scoreCount = 0;
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if (board[i][j] == SlotState.Marble) {
          scoreCount++;
        }
      }
    }
    return scoreCount;
  }
}

