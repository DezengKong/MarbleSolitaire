package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;
import java.io.IOException;

/**
 * The class MarbleSolitaireTextView implemented {@link MarbleSolitaireView} by using fields of
 * MarbleSolitareModelState, and the appendable output to output the view from model to the console
 * where the user could see the output.
 */
public class MarbleSolitaireTextView implements MarbleSolitaireView {

  protected final MarbleSolitaireModelState model;
  protected final Appendable out;

  /**
   * Constructs a Marble Solitaire Text View according to the given model.
   *
   * @param model the given model (cannot be null)
   * @throws IllegalArgumentException the model equals to null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState model) {
    if (model == null) {
      throw new IllegalArgumentException("The provided model is null");
    }

    this.model = model;
    this.out = System.out;
  }

  /**
   * Constructs a MarbleSolitaireTextView according to the given model and output.
   *
   * @param model the given model
   * @param out   the given appendable output stream
   * @throws IllegalArgumentException if one of the model and out is null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState model, Appendable out)
      throws IllegalArgumentException {
    if (model == null || out == null) {
      throw new IllegalArgumentException(
          "The provided model is null or the appendable object is null");
    }
    this.model = model;
    this.out = out;
  }

  /**
   * Return a string that represents the current state of the board. The string should have one line
   * per row of the game board. Each slot on the game board is a single character (O, _ or space for
   * a marble, empty and invalid position respectively). Slots in a row should be separated by a
   * space. Each row has no space before the first slot and after the last slot.
   *
   * @return the game state as a string
   */
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < model.getBoardSize(); i++) {
      for (int j = 0; j < model.getBoardSize(); j++) {
        if (model.getSlotAt(i, j) == SlotState.Invalid) {
          sb.append("  ");
        }
        if (model.getSlotAt(i, j) == SlotState.Empty) {
          sb.append("_ ");
        }
        if (model.getSlotAt(i, j) == SlotState.Marble) {
          sb.append("O ");
        }
      }

      while (sb.charAt(sb.length() - 1) == ' ') {
        sb.deleteCharAt(sb.length() - 1);
      }
      // After traversal a row, we will add "\n" to skip the line to the next line.
      sb.append("\n");
    }
    // After traversal every row, we will delete the last \n
    // to avoid skip the next line in the last line.
    sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }

  @Override
  public void renderBoard() throws IOException {
    try {
      out.append(this.toString());
    } catch (IOException e) {
      throw new IOException("cannot render the board");
    }
  }

  @Override
  public void renderMessage(String message) throws IOException {
    try {
      out.append(message);
    } catch (IOException e) {
      throw new IOException("this message is invalid to append");
    }
  }
}
