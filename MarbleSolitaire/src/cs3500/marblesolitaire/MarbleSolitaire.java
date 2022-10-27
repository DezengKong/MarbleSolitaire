package cs3500.marblesolitaire;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Represents the MarbleSolitaire class which support the user to type input to the controller, and
 * see the output from view, interacting in the model.
 */
public class MarbleSolitaire {

  static MarbleSolitaireModel model;
  static MarbleSolitaireView view;
  static MarbleSolitaireController controller;
  static int size;
  static int sRow;
  static int sCol;

  static String type;

  /**
   * Represents the main class which records all the input the user types in the console.
   *
   * @param args the list of String arguments user inputs
   */
  public static void main(String[] args) {

    for (int i = 0; i < args.length; i++) {
      String command = args[i];
      switch (command) {
        case "english":
          type = "english";
          break;
        case "european":
          type = "european";
          break;
        case "triangular":
          type = "triangular";
          break;
        case "-size":
          size = Integer.parseInt(args[i + 1]);
          if (type.equals("triangular")) {
            sRow = 0;
            sCol = 0;
          } else {
            sRow = 3 * size / 2 - 1;
            sCol = 3 * size / 2 - 1;
          }
          break;
        case "-hole":
          sRow = Integer.parseInt(args[i + 1]) - 1;
          sCol = Integer.parseInt(args[i + 2]) - 1;
          break;
        default:
          break;
      }
    }
    switch (type) {
      case "english":
        model = new EnglishSolitaireModel(size, sRow, sCol);
        view = new MarbleSolitaireTextView(model);
        break;
      case "european":
        model = new EuropeanSolitaireModel(size, sRow, sCol);
        view = new MarbleSolitaireTextView(model);
        break;
      case "triangular":
        model = new TriangleSolitaireModel(size, sRow, sCol);
        view = new TriangleSolitaireTextView(model);
        break;
      default:
        // nothing
    }

    controller = new MarbleSolitaireControllerImpl(model, view,
        new BufferedReader(new InputStreamReader(System.in)));
    controller.playGame();
  }


}
