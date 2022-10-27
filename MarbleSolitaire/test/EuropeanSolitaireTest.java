import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import org.junit.Before;
import org.junit.Test;

/**
 * Represents the class EuropeanSolitaireTest to test the model and view of EuropeanSolitaire.
 */
public class EuropeanSolitaireTest {

  MarbleSolitaireModel m_1;
  MarbleSolitaireModel m_2;
  MarbleSolitaireModel m_3;
  MarbleSolitaireModel m_4;

  MarbleSolitaireView v1;
  MarbleSolitaireView v2;
  MarbleSolitaireView v3;
  MarbleSolitaireView v4;

  @Before
  public void init() {
    m_1 = new EuropeanSolitaireModel();
    v1 = new MarbleSolitaireTextView(m_1);
    m_2 = new EuropeanSolitaireModel(5);
    v2 = new MarbleSolitaireTextView(m_2);
    m_3 = new EuropeanSolitaireModel(7);
    v3 = new MarbleSolitaireTextView(m_3);
    m_4 = new EuropeanSolitaireModel(9, 9, 9);
    v4 = new MarbleSolitaireTextView(m_4);
  }

  @Test
  public void testConstructor() {
    init();
    MarbleSolitaireModel m5 = new EuropeanSolitaireModel(3, 1, 1);
    MarbleSolitaireView v5 = new MarbleSolitaireTextView(m5);
    assertEquals("    O O O\n"
        + "  _ O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", v5.toString());
    MarbleSolitaireModel m6 = new EuropeanSolitaireModel(3, 1, 5);
    MarbleSolitaireView v6 = new MarbleSolitaireTextView(m6);
    assertEquals("    O O O\n"
        + "  O O O O _\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", v6.toString());
    MarbleSolitaireModel m7 = new EuropeanSolitaireModel(3, 5, 1);
    MarbleSolitaireView v7 = new MarbleSolitaireTextView(m7);
    assertEquals("    O O O\n"
        + "  _ O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", v5.toString());
    MarbleSolitaireModel m8 = new EuropeanSolitaireModel(3, 5, 5);
    MarbleSolitaireView v8 = new MarbleSolitaireTextView(m5);
    assertEquals("    O O O\n"
        + "  _ O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", v8.toString());
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", v1.toString());
    assertEquals("        O O O O O\n"
        + "      O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O _ O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "  O O O O O O O O O O O\n"
        + "    O O O O O O O O O\n"
        + "      O O O O O O O\n"
        + "        O O O O O", v2.toString());
    assertEquals("            O O O O O O O\n"
        + "          O O O O O O O O O\n"
        + "        O O O O O O O O O O O\n"
        + "      O O O O O O O O O O O O O\n"
        + "    O O O O O O O O O O O O O O O\n"
        + "  O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O _ O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O\n"
        + "  O O O O O O O O O O O O O O O O O\n"
        + "    O O O O O O O O O O O O O O O\n"
        + "      O O O O O O O O O O O O O\n"
        + "        O O O O O O O O O O O\n"
        + "          O O O O O O O O O\n"
        + "            O O O O O O O", v3.toString());
    assertEquals("                O O O O O O O O O\n"
        + "              O O O O O O O O O O O\n"
        + "            O O O O O O O O O O O O O\n"
        + "          O O O O O O O O O O O O O O O\n"
        + "        O O O O O O O O O O O O O O O O O\n"
        + "      O O O O O O O O O O O O O O O O O O O\n"
        + "    O O O O O O O O O O O O O O O O O O O O O\n"
        + "  O O O O O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O _ O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
        + "  O O O O O O O O O O O O O O O O O O O O O O O\n"
        + "    O O O O O O O O O O O O O O O O O O O O O\n"
        + "      O O O O O O O O O O O O O O O O O O O\n"
        + "        O O O O O O O O O O O O O O O O O\n"
        + "          O O O O O O O O O O O O O O O\n"
        + "            O O O O O O O O O O O O O\n"
        + "              O O O O O O O O O O O\n"
        + "                O O O O O O O O O", v4.toString());
  }

  @Test
  public void testInvalidConstructor() {
    try {
      EuropeanSolitaireModel m5 = new EuropeanSolitaireModel(-1);
      MarbleSolitaireView v5 = new MarbleSolitaireTextView(m5);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("The side is invalid", e.getMessage());
    }
    try {
      EuropeanSolitaireModel m5 = new EuropeanSolitaireModel(2);
      MarbleSolitaireView v5 = new MarbleSolitaireTextView(m5);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("The side is invalid", e.getMessage());
    }
    try {
      EuropeanSolitaireModel m5 = new EuropeanSolitaireModel(3, 0, 0);
      MarbleSolitaireView v5 = new MarbleSolitaireTextView(m5);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (0,0)", e.getMessage());
    }
    try {
      EuropeanSolitaireModel m5 = new EuropeanSolitaireModel(3, 6, 6);
      MarbleSolitaireView v5 = new MarbleSolitaireTextView(m5);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (6,6)", e.getMessage());
    }
    try {
      EuropeanSolitaireModel m5 = new EuropeanSolitaireModel(3, -1, -1);
      MarbleSolitaireView v5 = new MarbleSolitaireTextView(m5);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (-1,-1)", e.getMessage());
    }
    try {
      EuropeanSolitaireModel m5 = new EuropeanSolitaireModel(3, 7, 7);
      MarbleSolitaireView v5 = new MarbleSolitaireTextView(m5);
      fail();
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (7,7)", e.getMessage());
    }
  }


  @Test
  public void testValidMove() {
    this.init();
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", v1.toString());
    m_1.move(3, 1, 3, 3); // horizontally
    assertEquals(SlotState.Marble, m_1.getSlotAt(3, 3));
    assertEquals(SlotState.Empty, m_1.getSlotAt(3, 2));
    assertEquals(SlotState.Empty, m_1.getSlotAt(3, 1));

    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", v1.toString());
    m_1.move(3, 4, 3, 2); // horizontally
    assertEquals(SlotState.Empty, m_1.getSlotAt(3, 4));
    assertEquals(SlotState.Marble, m_1.getSlotAt(3, 2));
    assertEquals(SlotState.Empty, m_1.getSlotAt(3, 3));
    assertEquals(SlotState.Empty, m_1.getSlotAt(3, 1));
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O _ O _ _ O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", v1.toString());
    m_1.move(1, 4, 3, 4); // vertically
    assertEquals(SlotState.Empty, m_1.getSlotAt(3, 1));
    assertEquals(SlotState.Marble, m_1.getSlotAt(3, 2));
    assertEquals(SlotState.Empty, m_1.getSlotAt(3, 3));
    assertEquals(SlotState.Marble, m_1.getSlotAt(3, 4));
    assertEquals(SlotState.Marble, m_1.getSlotAt(3, 4));
    assertEquals("    O O O\n"
        + "  O O O _ O\n"
        + "O O O O _ O O\n"
        + "O _ O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", v1.toString());
    m_1.move(4, 4, 2, 4); // vertically
    assertEquals(SlotState.Empty, m_1.getSlotAt(3, 1));
    assertEquals(SlotState.Marble, m_1.getSlotAt(3, 2));
    assertEquals(SlotState.Empty, m_1.getSlotAt(3, 3));
    assertEquals(SlotState.Empty, m_1.getSlotAt(3, 4));
    assertEquals(SlotState.Empty, m_1.getSlotAt(3, 4));
    assertEquals(SlotState.Empty, m_1.getSlotAt(4, 4));
    assertEquals(SlotState.Marble, m_1.getSlotAt(2, 4));
    assertEquals("    O O O\n"
        + "  O O O _ O\n"
        + "O O O O O O O\n"
        + "O _ O _ _ O O\n"
        + "O O O O _ O O\n"
        + "  O O O O O\n"
        + "    O O O", v1.toString());
  }

  @Test
  public void testInvalidMove() {
    this.init();

    try {
      m_1.move(4, 3, 2, 3); // move to a position where the middle one is empty
      fail("Should have trown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      m_1.move(1, 3, 3, 1); // move Diagonal direction
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      m_1.move(1, 3, 0, 0); // move not in 2 slots
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      m_1.move(1, 3, 5, 1); // move not in slots
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      m_1.move(3, 3, 3, 1); // fromSlot is an empty slot
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      m_1.move(0, 0, 3, 3); // fromSlot is an Invalid slot
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      m_1.move(-1, -1, 6, 6); // no SlotState in this position
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }

    try {
      m_1.move(4, 3, 2, 1); // move not in 2 slots
      fail("Should have thrown ana IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }

    try {
      m_1.move(1, 2, -1, -1); // move to the position which is out of bound
      fail("Should have thrown ana IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      m_1.move(4, 3, 7, 7); // move to the position which is out of bound
      fail("Should have thrown ana IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    m_1.move(5, 3, 3, 3);
    assertEquals(SlotState.Empty, m_1.getSlotAt(5, 3));
    try {
      m_1.move(6, 3, 4, 3); // move to which the middle slot is empty
      fail("Should have thrown ana IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
  }

  @Test
  public void testGetBoardSize() {
    init();
    assertEquals(7, m_1.getBoardSize());
    assertEquals(13, m_2.getBoardSize());
    assertEquals(19, m_3.getBoardSize());
    assertEquals(25, m_4.getBoardSize());
  }

  @Test
  public void testGameOver() {
    assertFalse(m_1.isGameOver());
    assertFalse(m_2.isGameOver());
    assertFalse(m_3.isGameOver());
    assertFalse(m_4.isGameOver());
    m_1.move(3, 1, 3, 3);
    m_1.move(1, 2, 3, 2);
    m_1.move(3, 3, 3, 1);
    m_1.move(3, 0, 3, 2);
    m_1.move(4, 2, 2, 2);
    m_1.move(6, 2, 4, 2);
    m_1.move(6, 4, 6, 2);
    m_1.move(5, 4, 5, 2);
    m_1.move(5, 2, 3, 2);
    m_1.move(4, 0, 4, 2);
    m_1.move(3, 2, 1, 2);
    m_1.move(4, 3, 4, 1);
    m_1.move(2, 0, 2, 2);
    m_1.move(1, 2, 3, 2);
    m_1.move(1, 3, 3, 3);
    m_1.move(4, 5, 4, 3);
    m_1.move(4, 3, 2, 3);
    m_1.move(2, 4, 4, 4);
    m_1.move(0, 4, 2, 4);
    m_1.move(0, 2, 0, 4);
    m_1.move(3, 6, 3, 4);
    m_1.move(3, 4, 5, 4);
    m_1.move(2, 4, 2, 2);
    m_1.move(3, 2, 1, 2);
    m_1.move(2, 6, 2, 4);
    assertFalse(m_1.isGameOver());
    m_1.move(5, 1, 3, 1);
    m_1.move(5, 5, 5, 3);
    m_1.move(1, 1, 1, 3);
    assertTrue(m_1.isGameOver());
  }

  // Test the method getSlotAt()
  @org.junit.Test
  public void testModelGetSlotAt() {
    this.init();
    assertEquals(SlotState.Marble, m_1.getSlotAt(1, 1));
    assertEquals(SlotState.Empty, m_1.getSlotAt(3, 3));
    assertEquals(SlotState.Marble, m_1.getSlotAt(2, 2));
    assertEquals(SlotState.Invalid, m_3.getSlotAt(1, 1));
    assertEquals(SlotState.Marble, m_1.getSlotAt(4, 4));
    assertEquals(SlotState.Empty, m_2.getSlotAt(6, 6));
    assertEquals(SlotState.Empty, m_4.getSlotAt(9, 9));
    try {
      m_1.getSlotAt(-1, -1);
      fail("Should thrwon an illegalArgument Exception");
    } catch (IllegalArgumentException ignored) {
    }
  }

  // Test the exception to getSlotAt()
  @Test
  public void testModelGetSlotAtException() {
    this.init();
    try {
      m_1.getSlotAt(-1, 0);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      m_1.getSlotAt(0, 7);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      m_1.getSlotAt(0, -1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      m_1.getSlotAt(7, 0);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      m_1.getSlotAt(-1, -1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      m_1.getSlotAt(7, 7);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
  }

  @Test
  public void testInvalidViewConstructor() {
    try {
      MarbleSolitaireModelState m5 = null;
      MarbleSolitaireView v5 = new MarbleSolitaireTextView(m5);
      fail("some message");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      MarbleSolitaireView v5 = new MarbleSolitaireTextView(m_4, null);
      fail("some message");
    } catch (IllegalArgumentException ignored) {

    }
  }
}
