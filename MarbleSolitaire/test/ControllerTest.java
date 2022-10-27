import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MockModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import java.io.IOException;
import java.io.StringReader;
import org.junit.Before;
import org.junit.Test;

/**
 * The class for testing controller.
 */
public class ControllerTest {

  EnglishSolitaireModel m_1_1;
  EnglishSolitaireModel m_2_1;
  EnglishSolitaireModel m_3_1;
  EnglishSolitaireModel m_3_2;
  EnglishSolitaireModel m_4_1;

  EnglishSolitaireModel m_4_2;

  EnglishSolitaireModel m_5_1;

  MarbleSolitaireView v_1;
  MarbleSolitaireView v_2;
  MarbleSolitaireView v_3;
  MarbleSolitaireView v_4;
  MarbleSolitaireView v_5;
  MarbleSolitaireView v_6;
  MarbleSolitaireView v_7;

  MarbleSolitaireView view;
  Readable in;
  MarbleSolitaireController controller;
  Appendable output;

  @Before
  public void init1() {
    this.m_1_1 = new EnglishSolitaireModel();
    this.m_2_1 = new EnglishSolitaireModel(2, 2);
    this.m_3_1 = new EnglishSolitaireModel(3, 3, 3);
    this.m_3_2 = new EnglishSolitaireModel(5, 4, 4);
    this.m_4_1 = new EnglishSolitaireModel(3);

    this.m_4_2 = new EnglishSolitaireModel(7);

    this.m_5_1 = new EnglishSolitaireModel(1);

    this.v_1 = new MarbleSolitaireTextView(m_1_1);
    this.v_2 = new MarbleSolitaireTextView(m_2_1);
    this.v_3 = new MarbleSolitaireTextView(m_3_1);
    this.v_4 = new MarbleSolitaireTextView(m_3_2);
    this.v_5 = new MarbleSolitaireTextView(m_4_1);
    this.v_6 = new MarbleSolitaireTextView(m_4_2);
    this.v_7 = new MarbleSolitaireTextView(m_5_1);
  }

  @Before
  public void init2() {
    this.m_1_1 = new EnglishSolitaireModel();
    this.view = new MarbleSolitaireTextView(m_1_1);
    this.in = new StringReader("");
    this.controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
    this.output = new StringBuilder();
  }


  // Test for the exception constructor
  @Test
  public void testControllerConstructor() {
    try {
      init2();
      controller = new MarbleSolitaireControllerImpl(null, view, in);
      fail("Invalid Constructor should be thrown");
    } catch (IllegalArgumentException e) {
      assertEquals("your model, view, readable input cannot be null", e.getMessage());
    }

    try {
      init2();
      controller = new MarbleSolitaireControllerImpl(m_1_1, null, in);
      fail("Invalid Constructor should be thrown");
    } catch (IllegalArgumentException e) {
      assertEquals("your model, view, readable input cannot be null", e.getMessage());
    }

    try {
      init2();
      controller = new MarbleSolitaireControllerImpl(m_1_1, view, null);
      fail("Invalid Constructor should be thrown");
    } catch (IllegalArgumentException e) {
      assertEquals("your model, view, readable input cannot be null", e.getMessage());
    }
  }

  // try to test for the move by using mockmodel
  @Test
  public void testMove() {
    Readable in = new StringReader("2 4 4 4 q");
    StringBuilder output = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(m_3_1, output);
    StringBuilder appendable = new StringBuilder();
    MarbleSolitaireModel mockModel = new MockModel(appendable);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(mockModel, view, in);
    controller.playGame();
    assertEquals("fromRow = 1 fromCol = 3 toRow = 3 toCol = 3", appendable.toString());
  }

  // test different size of the model
  @Test
  public void testDifferentSize() {
    init1();
    Readable in = new StringReader("3 4 5 6 q");
    StringBuilder output = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(m_4_2, output);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(m_4_2, view, in);
    controller.playGame();
    assertEquals("            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O _ O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "Score: 216\n"
        + "Invalid move. Play again\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O _ O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "            O O O O O O O\n"
        + "Score: 216", output.toString());
  }

  // Test the playGame until the gameOver
  @Test
  public void testPlayGame() throws IllegalStateException {
    // move one time
    init2();
    in = new StringReader("6 4 4 4 q");
    controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O", view.toString());
    //move two more time
    in = new StringReader("3 4 5 4 1 4 3 4 q");
    view = new MarbleSolitaireTextView(m_1_1, output);
    controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O _ O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 30\n"
        + "    O _ O\n"
        + "    O _ O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 29\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O _ O\n"
        + "    O _ O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 29", output.toString());
    // gameover as win
    init2();
    in = new StringReader("4 2 4 4 6 3 4 3 5 1 5 3 5 4 5 2 5 6 5 4 7 5 5 " +
        "5 4 5 6 5 7 3 7 5 " +
        "7 5 5 5 4 5 6 5 7 3 7 5 7 5 5 5 3 3 5 3 1 3 3 3 2 5 4 5 4 5 6 5 6 " +
        "5 6 3 6 3 4 3 4 3 2 3 3 1 5 1 5 1 5 3 5 3 5 5 3 7 " +
        "3 5 3 4 3 6 5 7 3 7 3 7 3 5 1 5 1 3 1 3 " +
        " 3 3 3 2 3 4 3 4 3 6 3 6 5 6 5 6 5 4 5 4 3 4 2 4 4 4 q");
    controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
    controller.playGame();
    assertEquals("    _ _ _\n"
        + "    _ _ _\n"
        + "_ _ _ _ _ _ _\n"
        + "_ _ _ O _ _ _\n"
        + "_ _ _ _ _ _ _\n"
        + "    _ _ _\n"
        + "    _ _ _", view.toString());
  }

  // test the Invalid letter after one move
  @Test
  public void testInvalidLetterAfter1Move() {
    init2();
    in = new StringReader("6 4 4 4 a q");
    controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O", view.toString());
  }

  // test the valid letter after one valid move
  @Test
  public void testValidLetterAfter1Move() {
    init2();
    in = new StringReader("6 4 4 4 Q");
    controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O", view.toString());
  }

  // test the invalid letter after 2 move
  @Test
  public void testInvalidLetterAfter2Move() {
    init2();
    in = new StringReader("6 4 4 4 3 4 5 4 a a a a a q");
    controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O _ O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O O O", view.toString());
  }

  // test the valid letter after two move
  @Test
  public void testValidLetterAfter2Move() {
    init2();
    in = new StringReader("6 4 4 4 3 4 5 4 q q q q q");
    controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O _ O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O O O", view.toString());
  }

  // test the valid move and then an invalid move
  @Test
  public void testValidMoveThenInvalidMove() {
    init2();
    in = new StringReader("6 4 4 4 1 2 3 4 q");
    view = new MarbleSolitaireTextView(m_1_1, output);
    controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Invalid move. Play again\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31", output.toString());
  }

  // test the invalid letter in the position zero
  @Test
  public void testInvalidLetter_p0() {
    init2();
    in = new StringReader("a 6 4 4 4 q");
    view = new MarbleSolitaireTextView(m_1_1, output);
    controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31", output.toString());
  }

  // test the invalid letter in the position 1
  @Test
  public void testInvalidLetter_p1() {
    init2();
    in = new StringReader("6 a 4 4 4 q");
    view = new MarbleSolitaireTextView(m_1_1, output);
    controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31", output.toString());
  }

  // test the invalid letter in the position2
  @Test
  public void testInvalidLetter_p2() {
    init2();
    in = new StringReader("6 4 n 4 4 q");
    controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O", view.toString());
  }

  // test the invalid letter in the position3
  @Test
  public void testInvalidLetter_p3() {
    init2();
    in = new StringReader("6 4 4 m 4 q");
    controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O", view.toString());
  }

  // test the several invalid move
  @Test
  public void testInvalidMove() {

    // invalid move
    init2();
    in = new StringReader("1 2 3 4 q");
    controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", view.toString());

    // move from negative to positive
    init2();
    in = new StringReader("-1 3 3 4 3 3 3 4 q");
    controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", view.toString());

    // move to negative
    init2();
    in = new StringReader("6 4 4 4 4 4 -3 3 q");
    controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O", view.toString());

    // move one valid, one invalid
    init2();
    in = new StringReader("6 4 4 4 1 2 3 4 q");
    controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O", view.toString());

    // move one invalid, one valid
    init2();
    in = new StringReader("1 2 3 4 6 4 4 4 q");
    controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O", view.toString());

    // move one valid, one negative invalid
    init2();
    in = new StringReader("6 4 4 4 4 4 -3 3 q");
    controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O", view.toString());

    // move one valid, one then use invalid letter
    init2();
    in = new StringReader("6 4 4 4 4 A B D q");
    controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O", view.toString());

    // only 6 inputs
    init2();
    in = new StringReader("6 4 4 4 4 1 q");
    controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O", view.toString());
  }

  // test when the input only has one q
  @Test
  public void testOnlyQ() {
    init2();
    in = new StringReader("q");
    controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", view.toString());
  }

  // test the exception when the playGame is running out
  @Test
  public void testRanOut_Exception() throws IOException {

    // when there is no inputs
    try {
      init2();
      in = new StringReader("");
      controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
      controller.playGame();
    } catch (IllegalStateException e) {
      assertEquals("ran out", e.getMessage());
    }

    // when there is 8 wrong inputs
    try {
      init2();
      in = new StringReader("1 2 3 4 5 6 7 8");
      controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
      controller.playGame();
    } catch (IllegalStateException e) {
      assertEquals("ran out", e.getMessage());
    }

    // when there is 4 valid inputs, but not quit
    try {
      init2();
      in = new StringReader("6 4 4 4");
      controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
      controller.playGame();
    } catch (IllegalStateException e) {
      assertEquals("ran out", e.getMessage());
    }

    // when there is 3 valid inputs, but not quit
    try {
      init2();
      in = new StringReader("6 4 4 ");
      controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
      controller.playGame();
    } catch (IllegalStateException e) {
      assertEquals("ran out", e.getMessage());
    }
  }

  // test when there is only 1 input
  @Test
  public void test1Input() {
    init2();
    in = new StringReader("1 q");
    controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", view.toString());
  }

  // test when there is only 2 inputs
  @Test
  public void test2Input() {
    init2();
    in = new StringReader("1 2 q");
    controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", view.toString());
  }

  // test when there is 3 inputs
  @Test
  public void test3Input() {
    init2();
    in = new StringReader("1 2 3 q");
    controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", view.toString());
  }

  // test the message will render when they move invalidly
  @Test
  public void testMoveMessage() {
    init2();
    in = new StringReader("2 3 4 5 q");
    view = new MarbleSolitaireTextView(m_1_1, output);
    controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Invalid move. Play again\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32", output.toString());

    init2();
    in = new StringReader("a a a a b b b 1 3 4 2 a a a q");
    view = new MarbleSolitaireTextView(m_1_1, output);
    controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Invalid move. Play again\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32", output.toString());
  }

  // test the playgame when the output is a fakeAppendable, so the unable to transmit output.
  @Test
  public void testFakeAppendableViewWhenGamePlay() {
    try {
      in = new StringReader(" 6 4 4 4 q");
      Appendable output = new FakeTestAppendable();
      view = new MarbleSolitaireTextView(m_1_1, output);
      controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
      controller.playGame();
      fail();
    } catch (IllegalStateException e) {
      assertEquals("unable to transmit output", e.getMessage());
    }
  }

  // When the game is finished to test is that ending game
  @Test
  public void testGameoverWithoutQuit() {
    init2();
    in = new StringReader("4 2 4 4 6 3 4 3 5 1 5 3 5 4 5 2 5 6 5 4 7 5 5 " +
        "5 4 5 6 5 7 3 7 5 " +
        "7 5 5 5 4 5 6 5 7 3 7 5 7 5 5 5 3 3 5 3 1 3 3 3 2 5 4 5 4 5 6 5 6 " +
        "5 6 3 6 3 4 3 4 3 2 3 3 1 5 1 5 1 5 3 5 3 5 5 3 7 " +
        "3 5 3 4 3 6 5 7 3 7 3 7 3 5 1 5 1 3 1 3 " +
        " 3 3 3 2 3 4 3 4 3 6 3 6 5 6 5 6 5 4 5 4 3 4 2 4 4 4");
    view = new MarbleSolitaireTextView(m_1_1, output);
    controller = new MarbleSolitaireControllerImpl(m_1_1, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ O O O O O\n"
        + "O O _ O O O O\n"
        + "    _ O O\n"
        + "    O O O\n"
        + "Score: 30\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ O O O O O\n"
        + "_ _ O O O O O\n"
        + "    _ O O\n"
        + "    O O O\n"
        + "Score: 29\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ O O O O O\n"
        + "_ O _ _ O O O\n"
        + "    _ O O\n"
        + "    O O O\n"
        + "Score: 28\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ O O O O O\n"
        + "_ O _ O _ _ O\n"
        + "    _ O O\n"
        + "    O O O\n"
        + "Score: 27\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ O O O O O\n"
        + "_ O _ O O _ O\n"
        + "    _ O _\n"
        + "    O O _\n"
        + "Score: 26\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ O O _ O O\n"
        + "_ O _ O _ _ O\n"
        + "    _ O O\n"
        + "    O O _\n"
        + "Score: 25\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ O O _ O O\n"
        + "_ O _ O _ _ O\n"
        + "    _ O O\n"
        + "    _ _ O\n"
        + "Score: 24\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ O O _ O O\n"
        + "_ O _ O O _ O\n"
        + "    _ O _\n"
        + "    _ _ _\n"
        + "Score: 23\n"
        + "Invalid move. Play again\n"
        + "Invalid move. Play again\n"
        + "Invalid move. Play again\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O _ O O O O\n"
        + "O _ _ O _ O O\n"
        + "_ O O O O _ O\n"
        + "    _ O _\n"
        + "    _ _ _\n"
        + "Score: 22\n"
        + "    _ O O\n"
        + "    _ O O\n"
        + "O O O O O O O\n"
        + "O _ _ O _ O O\n"
        + "_ O O O O _ O\n"
        + "    _ O _\n"
        + "    _ _ _\n"
        + "Score: 21\n"
        + "    _ O O\n"
        + "    _ O _\n"
        + "O O O O _ O O\n"
        + "O _ _ O O O O\n"
        + "_ O O O O _ O\n"
        + "    _ O _\n"
        + "    _ _ _\n"
        + "Score: 20\n"
        + "    _ O O\n"
        + "    _ O _\n"
        + "O O O O _ O O\n"
        + "O _ _ O _ O O\n"
        + "_ O O O _ _ O\n"
        + "    _ O O\n"
        + "    _ _ _\n"
        + "Score: 19\n"
        + "    _ O O\n"
        + "    _ O _\n"
        + "O O O O _ O O\n"
        + "O _ _ O _ O O\n"
        + "_ O O O _ _ O\n"
        + "    O _ _\n"
        + "    _ _ _\n"
        + "Score: 18\n"
        + "    _ O O\n"
        + "    _ O _\n"
        + "O O O O _ O O\n"
        + "O _ O O _ O O\n"
        + "_ O _ O _ _ O\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "Score: 17\n"
        + "    _ O O\n"
        + "    O O _\n"
        + "O O _ O _ O O\n"
        + "O _ _ O _ O O\n"
        + "_ O _ O _ _ O\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "Score: 16\n"
        + "    _ O O\n"
        + "    O O _\n"
        + "_ O _ O _ O O\n"
        + "_ _ _ O _ O O\n"
        + "O O _ O _ _ O\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "Score: 15\n"
        + "    _ O O\n"
        + "    O O _\n"
        + "_ O _ O _ O O\n"
        + "_ _ _ O _ O O\n"
        + "_ _ O O _ _ O\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "Score: 14\n"
        + "    _ O O\n"
        + "    O O _\n"
        + "_ O _ O _ O O\n"
        + "_ _ _ O _ O O\n"
        + "_ _ _ _ O _ O\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "Score: 13\n"
        + "    _ O O\n"
        + "    O O _\n"
        + "_ O _ O O _ _\n"
        + "_ _ _ O _ O O\n"
        + "_ _ _ _ O _ O\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "Score: 12\n"
        + "    _ O O\n"
        + "    O O _\n"
        + "_ O _ _ _ O _\n"
        + "_ _ _ O _ O O\n"
        + "_ _ _ _ O _ O\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "Score: 11\n"
        + "    _ O O\n"
        + "    O O _\n"
        + "_ O _ _ _ O O\n"
        + "_ _ _ O _ O _\n"
        + "_ _ _ _ O _ _\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "Score: 10\n"
        + "    _ O O\n"
        + "    O O _\n"
        + "_ O _ _ O _ _\n"
        + "_ _ _ O _ O _\n"
        + "_ _ _ _ O _ _\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "Score: 9\n"
        + "    O _ _\n"
        + "    O O _\n"
        + "_ O _ _ O _ _\n"
        + "_ _ _ O _ O _\n"
        + "_ _ _ _ O _ _\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "Score: 8\n"
        + "    _ _ _\n"
        + "    _ O _\n"
        + "_ O O _ O _ _\n"
        + "_ _ _ O _ O _\n"
        + "_ _ _ _ O _ _\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "Score: 7\n"
        + "    _ _ _\n"
        + "    _ O _\n"
        + "_ _ _ O O _ _\n"
        + "_ _ _ O _ O _\n"
        + "_ _ _ _ O _ _\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "Score: 6\n"
        + "    _ _ _\n"
        + "    _ O _\n"
        + "_ _ _ _ _ O _\n"
        + "_ _ _ O _ O _\n"
        + "_ _ _ _ O _ _\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "Score: 5\n"
        + "    _ _ _\n"
        + "    _ O _\n"
        + "_ _ _ _ _ _ _\n"
        + "_ _ _ O _ _ _\n"
        + "_ _ _ _ O O _\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "Score: 4\n"
        + "    _ _ _\n"
        + "    _ O _\n"
        + "_ _ _ _ _ _ _\n"
        + "_ _ _ O _ _ _\n"
        + "_ _ _ O _ _ _\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "Score: 3\n"
        + "    _ _ _\n"
        + "    _ O _\n"
        + "_ _ _ O _ _ _\n"
        + "_ _ _ _ _ _ _\n"
        + "_ _ _ _ _ _ _\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "Score: 2\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "_ _ _ _ _ _ _\n"
        + "_ _ _ O _ _ _\n"
        + "_ _ _ _ _ _ _\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "Score: 1\n"
        + "Game over!\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "_ _ _ _ _ _ _\n"
        + "_ _ _ O _ _ _\n"
        + "_ _ _ _ _ _ _\n"
        + "    _ _ _\n"
        + "    _ _ _\n"
        + "Score: 1", output.toString());
  }

}

