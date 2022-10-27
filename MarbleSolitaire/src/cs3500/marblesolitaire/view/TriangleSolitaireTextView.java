package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;

/**
 * Represents the class TriangleSolitaireTextView extends {@link MarbleSolitaireTextView}. It has
 * the function which the parent class MarbleSolitaireTextView has, and it overrides the toString
 * because the difference of view to output to allow user to see.
 */
public class TriangleSolitaireTextView extends MarbleSolitaireTextView {

  /**
   * Constructs a TriangleSolitaireTextView according to the given model.
   *
   * @param model the given model (cannot be null)
   * @throws IllegalArgumentException the model equals to null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState model) {
    super(model);
  }

  /**
   * Constructs a TriangleSolitaireTextView according to the given model and output.
   *
   * @param model  the given model
   * @param output the given appendable output stream
   * @throws IllegalArgumentException if one of the model and out is null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState model, Appendable output) {
    super(model, output);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    // printing the spaces which are before the first Marble in every row
    for (int i = 0; i < model.getBoardSize(); i++) {
      sb.append(" ".repeat(Math.max(0, model.getBoardSize() - i - 1)));

      // begin to print the marble depends on their position of model
      for (int w = 0; w <= i; w++) {
        if (model.getSlotAt(i, w) == SlotState.Marble) {
          sb.append("O");
        } else {
          sb.append("_");
        }
        if (i != w) {
          sb.append(" ");
        }
      }

      while (sb.charAt(sb.length() - 1) == ' ') {
        sb.deleteCharAt(sb.length() - 1);
      }
      // Moving cursor to next line
      sb.append("\n");
    }
    sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }

}
