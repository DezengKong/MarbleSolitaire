package cs3500.marblesolitaire.model.hw02;

/**
 * Class MockModel which used to test the controller implements to {@link MarbleSolitaireModel}.
 * Also, it used to test whether the input sends to the model from controller correctly.
 */
public class MockModel implements MarbleSolitaireModel {

  private final StringBuilder appendable;

  /**
   * Constructor of mock model.
   *
   * @param appendable the string builder to record the output
   * @throws IllegalArgumentException if the appendable is null
   */
  public MockModel(StringBuilder appendable) throws IllegalArgumentException {
    if (appendable == null) {
      throw new IllegalArgumentException("the mock model cannot be empty");
    }
    this.appendable = appendable;
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    this.appendable.append(
        "fromRow = " + fromRow + " fromCol = " + fromCol + " toRow = " + toRow + " toCol = "
            + toCol);
  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public int getBoardSize() {
    return 0;
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    return null;
  }

  @Override
  public int getScore() {
    return 0;
  }
}
