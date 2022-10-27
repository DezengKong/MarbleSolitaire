package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents class MarbleSolitaireControllerImp implements {@link MarbleSolitaireController}. In
 * this class, specifying the playGame() method with the fields marbleSolitaireModel,
 * MarbleSolitaireView, readable reader, and the arrayList of the valid integers.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  private final MarbleSolitaireModel model;

  private final MarbleSolitaireView view;

  private final Readable myInputStream;

  private final ArrayList<Integer> validInts;


  /**
   * The constructor for the MarbleSolitaireControllerImpl.
   *
   * @param model         the MarbleSolitaireModel used in the view and the controller
   * @param view          the MarbleSolitaireView used for the controller
   * @param myInputStream the readable inputs
   * @throws IllegalArgumentException if one of the model or the view or the readable input is null
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model, MarbleSolitaireView view,
      Readable myInputStream) {
    if (model == null || view == null || myInputStream == null) {
      throw new IllegalArgumentException("your model, view, readable input cannot be null");
    }

    this.model = model;
    this.view = view;
    this.myInputStream = myInputStream;
    this.validInts = new ArrayList<>();
  }

  @Override
  public void playGame() throws IllegalStateException {
    Scanner scanner = new Scanner(this.myInputStream);
    renderInformation();
    while (!model.isGameOver()) {
      if (scanner.hasNext()) {
        String next = scanner.next();
        this.validInteger(next);
        if (next.equals("q") || (next.equals("Q"))) {
          this.renderQuitInformation();
          return;
        }
        if (this.validInts.size() == 4) {
          this.renderMove();
        }
      } else {
        throw new IllegalStateException("ran out");
      }
    }
    this.renderGameOver();
  }


  /**
   * The void Method used to render quit information when there is a q in the input.
   *
   * @throws IllegalStateException if there is error in the input or cannot convert to output
   */
  private void renderQuitInformation() throws IllegalStateException {
    try {
      view.renderMessage("Game quit!\n");
      view.renderMessage("State of game when quit:\n");
      view.renderBoard();
      view.renderMessage("\nScore: " + Integer.toString(this.model.getScore()));
    } catch (IOException e) {
      throw new IllegalStateException("unable to transmit output");
    }
  }

  /**
   * The void method used to render information when the game is over.
   *
   * @throws IllegalStateException if there is error in the input or cannot convert to output
   */
  private void renderGameOver() throws IllegalStateException {
    try {
      view.renderMessage("Game over!\n");
      view.renderBoard();
      view.renderMessage("\nScore: " + Integer.toString(this.model.getScore()));
    } catch (IOException e) {
      throw new IllegalStateException("unable to transmit output");
    }
  }

  /**
   * The void method used to render message and board of current model and view.
   *
   * @throws IllegalStateException if there is error in the input or cannot convert to output
   */
  private void renderInformation() throws IllegalStateException {
    try {
      view.renderBoard();
      view.renderMessage("\nScore: " + Integer.toString(model.getScore()) + "\n");
    } catch (IOException e) {
      throw new IllegalStateException("unable to transmit output");
    }
  }

  /**
   * The void method used to move when the number of the valid integers in the arraylist.
   *
   * @throws IllegalStateException if there is error in the input or cannot convert to output
   */
  private void renderMove() throws IllegalStateException {
    try {
      model.move(this.validInts.get(0) - 1, this.validInts.get(1) - 1,
          this.validInts.get(2) - 1, this.validInts.get(3) - 1);

      validInts.clear();
      renderInformation();
    } catch (IllegalArgumentException e) {

      try {
        view.renderMessage("Invalid move. Play again\n");
      } catch (IOException a) {
        throw new IllegalStateException("unable to transmit output");
      }
      validInts.clear();
    }
  }

  /**
   * The void method used to test whether the next string is a valid parseInt or not.
   *
   * @param str the next input from scanner
   */
  private void validInteger(String str) {
    try {
      int num = Integer.parseInt(str);
      if (num > 0) {
        validInts.add(num);
      }
    } catch (NumberFormatException ignored) {
    }
  }
}
