import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import java.io.IOException;
import org.junit.Test;

/**
 * The class presented to test the view of English Solitaire.
 */
public class EnglishSolitaireViewTest {

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


  // Initializing the Data with this method
  private void init() {
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

  // Test the toString method in the view
  @Test
  public void testToString() {
    this.init();
    assertEquals("_", v_7.toString());
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O _ O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O", v_1.toString());

    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O _ O O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O", v_2.toString());

    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O _ O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O", v_3.toString());

    assertEquals("        O O O O O\n" +
        "        O O O O O\n" +
        "        O O O O O\n" +
        "        O O O O O\n" +
        "O O O O _ O O O O O O O O\n" +
        "O O O O O O O O O O O O O\n" +
        "O O O O O O O O O O O O O\n" +
        "O O O O O O O O O O O O O\n" +
        "O O O O O O O O O O O O O\n" +
        "        O O O O O\n" +
        "        O O O O O\n" +
        "        O O O O O\n" +
        "        O O O O O", v_4.toString());

    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O _ O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O", v_5.toString());

    assertEquals("            O O O O O O O\n" +
        "            O O O O O O O\n" +
        "            O O O O O O O\n" +
        "            O O O O O O O\n" +
        "            O O O O O O O\n" +
        "            O O O O O O O\n" +
        "O O O O O O O O O O O O O O O O O O O\n" +
        "O O O O O O O O O O O O O O O O O O O\n" +
        "O O O O O O O O O O O O O O O O O O O\n" +
        "O O O O O O O O O _ O O O O O O O O O\n" +
        "O O O O O O O O O O O O O O O O O O O\n" +
        "O O O O O O O O O O O O O O O O O O O\n" +
        "O O O O O O O O O O O O O O O O O O O\n" +
        "            O O O O O O O\n" +
        "            O O O O O O O\n" +
        "            O O O O O O O\n" +
        "            O O O O O O O\n" +
        "            O O O O O O O\n" +
        "            O O O O O O O", v_6.toString());
  }

  // test the exception to the Constructor
  @Test
  public void testConstructorException() {
    this.init();
    try {
      MarbleSolitaireModelState m1 = new EnglishSolitaireModel(1, 1);
      MarbleSolitaireView v1 = new MarbleSolitaireTextView(m1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      MarbleSolitaireModelState m2 = new EnglishSolitaireModel(1, 5);
      MarbleSolitaireView v2 = new MarbleSolitaireTextView(m2);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }

    try {
      MarbleSolitaireModelState m3 = new EnglishSolitaireModel(6, 0);
      MarbleSolitaireView v3 = new MarbleSolitaireTextView(m3);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }

    try {
      MarbleSolitaireModelState m4 = new EnglishSolitaireModel(0, 6);
      MarbleSolitaireView v4 = new MarbleSolitaireTextView(m4);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }

    try {
      MarbleSolitaireModelState m5 = new EnglishSolitaireModel(2);
      MarbleSolitaireView v5 = new MarbleSolitaireTextView(m5);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }

    try {
      MarbleSolitaireModelState m6 = new EnglishSolitaireModel(-1);
      MarbleSolitaireView v6 = new MarbleSolitaireTextView(m6);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }

    try {
      MarbleSolitaireModelState m7 = new EnglishSolitaireModel(3, 1, 1);
      MarbleSolitaireView v7 = new MarbleSolitaireTextView(m7);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }

    try {
      MarbleSolitaireModelState m8 = new EnglishSolitaireModel(3, 6, 1);
      MarbleSolitaireView v8 = new MarbleSolitaireTextView(m8);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }

    try {
      MarbleSolitaireModelState m9 = new EnglishSolitaireModel(4, 1, 5);
      MarbleSolitaireView v9 = new MarbleSolitaireTextView(m9);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }

    try {
      MarbleSolitaireModelState m10 = new EnglishSolitaireModel(4, 1, 2);
      MarbleSolitaireView v10 = new MarbleSolitaireTextView(m10);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }

    try {
      MarbleSolitaireModelState m11 = new EnglishSolitaireModel(6, 1, 3);
      MarbleSolitaireView v11 = new MarbleSolitaireTextView(m11);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
  }

  // Test the constructor of view when the model called by view is null
  @Test
  public void testViewConstructionNull() {
    try {
      EnglishSolitaireModel m1 = null;
      MarbleSolitaireView v1 = new MarbleSolitaireTextView(m1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
  }

  // Test the IOException when the
  @Test
  public void testRenderBoard() throws IOException {
    init();
    Appendable fakeApp = new FakeTestAppendable();
    try {
      v_1 = new MarbleSolitaireTextView(m_1_1, fakeApp);
      v_1.renderBoard();
    } catch (IOException e) {
      assertEquals("cannot render the board", e.getMessage());
    }
  }

  @Test
  public void testRenderMessage() throws IOException {
    init();
    Appendable fakeApp = new FakeTestAppendable();
    try {
      v_1 = new MarbleSolitaireTextView(m_1_1, fakeApp);
      v_1.renderMessage("hahahahahha");
    } catch (IOException e) {
      assertEquals("this message is invalid to append", e.getMessage());
    }
  }
}
