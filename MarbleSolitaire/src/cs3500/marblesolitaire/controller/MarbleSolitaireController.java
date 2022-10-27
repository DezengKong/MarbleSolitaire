package cs3500.marblesolitaire.controller;

/**
 * Represents interface MarbleSolitaireController, the interface support the playGame() operation
 * for users.
 */
public interface MarbleSolitaireController {

  /**
   * Play a game of Marble Solitaire.
   *
   * @throws IllegalArgumentException only if the controller is unable to successfully read input or
   *                                  transmit output.
   */
  void playGame() throws IllegalStateException;
}
