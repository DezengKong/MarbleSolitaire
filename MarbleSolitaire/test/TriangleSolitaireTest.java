import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;
import org.junit.Before;
import org.junit.Test;

/**
 * Represents the class TriangleSolitaireTest to test the triangle solitaire model and view.
 */
public class TriangleSolitaireTest {

  MarbleSolitaireModel m_1;
  MarbleSolitaireModel m_2;
  MarbleSolitaireModel m_3;
  MarbleSolitaireModel m_4;

  TriangleSolitaireTextView v1;
  TriangleSolitaireTextView v2;
  TriangleSolitaireTextView v3;
  TriangleSolitaireTextView v4;

  @Before
  public void init() {
    m_1 = new TriangleSolitaireModel();
    m_2 = new TriangleSolitaireModel(7);
    m_3 = new TriangleSolitaireModel(3, 3);
    m_4 = new TriangleSolitaireModel(5, 0, 0);

    v1 = new TriangleSolitaireTextView(m_1);
    v2 = new TriangleSolitaireTextView(m_2);
    v3 = new TriangleSolitaireTextView(m_3);
    v4 = new TriangleSolitaireTextView(m_4);
  }

  @Test
  public void testConstructor() {
    assertEquals("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O", v1.toString());
    assertEquals("      _\n"
        + "     O O\n"
        + "    O O O\n"
        + "   O O O O\n"
        + "  O O O O O\n"
        + " O O O O O O\n"
        + "O O O O O O O", v2.toString());
    assertEquals("    O\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O _\n"
        + "O O O O O", v3.toString());
    assertEquals("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O", v4.toString());
  }

  @Test
  public void testValidMove() {
    // Go to top left
    m_4.move(2, 2, 0, 0);
    assertEquals("    O\n"
        + "   O _\n"
        + "  O O _\n"
        + " O O O O\n"
        + "O O O O O", v4.toString());
    assertEquals(SlotState.Empty, m_4.getSlotAt(2, 2));
    assertEquals(SlotState.Marble, m_4.getSlotAt(0, 0));
    assertEquals(SlotState.Empty, m_4.getSlotAt(1, 1));

    // Go to right top
    m_4.move(4, 2, 2, 2);
    assertEquals("    O\n"
        + "   O _\n"
        + "  O O O\n"
        + " O O _ O\n"
        + "O O _ O O", v4.toString());
    assertEquals(SlotState.Empty, m_4.getSlotAt(4, 2));
    assertEquals(SlotState.Marble, m_4.getSlotAt(2, 2));
    assertEquals(SlotState.Empty, m_4.getSlotAt(3, 2));

    // horizontally move right
    m_4.move(3, 0, 3, 2);
    assertEquals("    O\n"
        + "   O _\n"
        + "  O O O\n"
        + " _ _ O O\n"
        + "O O _ O O", v4.toString());
    assertEquals(SlotState.Empty, m_4.getSlotAt(3, 0));
    assertEquals(SlotState.Marble, m_4.getSlotAt(3, 2));
    assertEquals(SlotState.Empty, m_4.getSlotAt(3, 1));

    // horizontally move left
    m_4.move(3, 3, 3, 1);
    assertEquals("    O\n"
        + "   O _\n"
        + "  O O O\n"
        + " _ O _ _\n"
        + "O O _ O O", v4.toString());
    assertEquals(SlotState.Empty, m_4.getSlotAt(3, 3));
    assertEquals(SlotState.Marble, m_4.getSlotAt(3, 1));
    assertEquals(SlotState.Empty, m_4.getSlotAt(3, 2));

    // Go to down right
    m_4.move(1, 0, 3, 2);
    assertEquals("    O\n"
        + "   _ _\n"
        + "  O _ O\n"
        + " _ O O _\n"
        + "O O _ O O", v4.toString());
    assertEquals(SlotState.Empty, m_4.getSlotAt(1, 0));
    assertEquals(SlotState.Marble, m_4.getSlotAt(3, 2));
    assertEquals(SlotState.Empty, m_4.getSlotAt(2, 1));

    // Go to down left
    m_4.move(2, 2, 4, 2);
    assertEquals("    O\n"
        + "   _ _\n"
        + "  O _ _\n"
        + " _ O _ _\n"
        + "O O O O O", v4.toString());
    assertEquals(SlotState.Empty, m_4.getSlotAt(2, 2));
    assertEquals(SlotState.Marble, m_4.getSlotAt(4, 2));
    assertEquals(SlotState.Empty, m_4.getSlotAt(3, 2));
  }

  @Test
  public void testIsGameOver() {
    assertFalse(m_4.isGameOver());
    m_4.move(2, 2, 0, 0);
    m_4.move(4, 2, 2, 2);
    m_4.move(3, 0, 3, 2);
    assertFalse(m_4.isGameOver());
    m_4.move(3, 3, 3, 1);
    m_4.move(1, 0, 3, 2);
    assertFalse(m_4.isGameOver());
    m_4.move(2, 2, 4, 2);
    assertEquals("    O\n"
        + "   _ _\n"
        + "  O _ _\n"
        + " _ O _ _\n"
        + "O O O O O", v4.toString());
    assertFalse(m_4.isGameOver());
    m_4.move(4, 1, 2, 1);
    assertEquals("    O\n"
        + "   _ _\n"
        + "  O O _\n"
        + " _ _ _ _\n"
        + "O _ O O O", v4.toString());
    m_4.move(4, 3, 4, 1);
    m_4.move(4, 0, 4, 2);
    m_4.move(2, 0, 2, 2);
    assertTrue(m_4.isGameOver());
  }

  @Test
  public void testGetModelBoardSize() {
    assertEquals(5, m_1.getBoardSize());
    assertEquals(7, m_2.getBoardSize());
    assertEquals(5, m_3.getBoardSize());
    assertEquals(5, m_4.getBoardSize());
  }

  // Test the method getSlotAt()
  @org.junit.Test
  public void testModelGetSlotAt() {
    this.init();
    assertEquals(SlotState.Marble, m_4.getSlotAt(1, 1));
    assertEquals(SlotState.Marble, m_4.getSlotAt(3, 3));
    assertEquals(SlotState.Marble, m_4.getSlotAt(2, 2));
    assertEquals(SlotState.Marble, m_4.getSlotAt(1, 1));
    assertEquals(SlotState.Marble, m_1.getSlotAt(4, 4));
    assertEquals(SlotState.Marble, m_2.getSlotAt(3, 3));
    assertEquals(SlotState.Empty, m_4.getSlotAt(0, 0));
    assertEquals(SlotState.Invalid, m_4.getSlotAt(0, 1));

    try {
      m_4.getSlotAt(5, 5);
      fail("Should have thrwon an illegalArgument Exception");
    } catch (IllegalArgumentException ignored) {
    }

    try {
      m_4.getSlotAt(-1, -1);
      fail("Should have thrwon an illegalArgument Exception");
    } catch (IllegalArgumentException ignored) {
    }

    try {
      m_4.getSlotAt(-1, 0);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      m_4.getSlotAt(0, 7);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      m_4.getSlotAt(0, -1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
  }

  @Test
  public void testGetScore() {
    assertEquals(14, m_4.getScore());
    assertEquals(14, m_1.getScore());
    assertEquals(27, m_2.getScore());
    assertEquals(14, m_3.getScore());
  }

  @Test
  public void testInvalidMove() {

    // cannot move from marble to marble
    try {
      m_4.move(3, 3, 1, 1);
      fail("Should have thrown ana IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {
    }
    // cannot move from Empty to marble
    try {
      m_4.move(0, 0, 2, 2);
      fail("Should have thrown ana IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {
    }
    m_4.move(2, 2, 0, 0);
    m_4.move(3, 1, 1, 1);
    System.out.println(v4.toString());

    // cannot move from Invalid to Empty
    try {
      m_4.move(0, 1, 2, 1);
      fail("Should have thrown ana IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {
    }
    // cannot move from Invalid to marble
    try {
      m_4.move(1, 2, 1, 0);
      fail("Should have thrown ana IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {
    }
    // cannot move from marble to Invalid
    try {
      m_4.move(4, 3, 2, 3);
      fail("Should have thrown ana IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {
    }
    // cannot move from not existing slot to Empty
    try {
      m_4.move(-1, -2, 1, 0);
      fail("Should have thrown ana IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {
    }

    // cannot move from marble to not existing slot
    try {
      m_4.move(4, 3, 4, 5);
      fail("Should have thrown ana IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {
    }
    // move not in 2 slots
    try {
      m_4.move(0, 0, 3, 1);
      fail("Should have thrown ana IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {
    }

    // move to which the middle slot is empty
    try {
      m_4.move(4, 1, 2, 1);
      fail("Should have thrown ana IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {
    }

    // move from a marble to empty, but not regular
    try {
      m_4.move(0, 0, 2, 1);
      fail("Should have thrown ana IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {
    }
  }

  @Test
  public void testInvalidConstructor() {
    try {
      MarbleSolitaireModelState m5 = new TriangleSolitaireModel(-1);
      MarbleSolitaireView v5 = new TriangleSolitaireTextView(m5);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {
    }
    try {
      MarbleSolitaireModelState m5 = new TriangleSolitaireModel(5, 5);
      MarbleSolitaireView v5 = new TriangleSolitaireTextView(m5);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {
    }
    try {
      MarbleSolitaireModelState m5 = new TriangleSolitaireModel(0, 2);
      MarbleSolitaireView v5 = new TriangleSolitaireTextView(m5);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {
    }
    try {
      MarbleSolitaireModelState m5 = new TriangleSolitaireModel(0, 1);
      MarbleSolitaireView v5 = new TriangleSolitaireTextView(m5);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {
    }
    try {
      MarbleSolitaireModelState m5 = new TriangleSolitaireModel(-3, 0, 0);
      MarbleSolitaireView v5 = new TriangleSolitaireTextView(m5);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {
    }
    try {
      MarbleSolitaireModelState m5 = new TriangleSolitaireModel(5, 0, 1);
      MarbleSolitaireView v5 = new TriangleSolitaireTextView(m5);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {
    }
    try {
      MarbleSolitaireModelState m5 = new TriangleSolitaireModel(5, -1, -1);
      MarbleSolitaireView v5 = new TriangleSolitaireTextView(m5);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {
    }
    try {
      MarbleSolitaireModelState m5 = new TriangleSolitaireModel(3, 5, 5);
      MarbleSolitaireView v5 = new TriangleSolitaireTextView(m5);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {
    }
    try {
      MarbleSolitaireModelState m5 = new TriangleSolitaireModel(5, 1, 2);
      MarbleSolitaireView v5 = new TriangleSolitaireTextView(m5);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {
    }
  }

  // Test the constructor of view when the model called by view is null
  @Test
  public void testViewConstructionNull() {
    try {
      TriangleSolitaireModel m5 = null;
      MarbleSolitaireView v5 = new TriangleSolitaireTextView(m5);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      MarbleSolitaireView v5 = new TriangleSolitaireTextView(m_3, null);
      fail("should have thrown an IllegalArugumentException");
    } catch (IllegalArgumentException ignored) {

    }
  }
}
