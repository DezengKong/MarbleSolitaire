import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import org.junit.Before;
import org.junit.Test;

/**
 * The class EnglishSolitaireModelTest used for testing.
 */
public class EnglishSolitaireModelTest {

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

  // Method for initializing the data used test.
  @Before
  public void init() {
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

  // When we test move a slot invalidly, then there should be an exception
  @Test
  public void testInvalidMove() {
    this.init();

    try {
      m_4_1.move(4, 3, 2, 3); // move to a position where the middle one is empty
      fail("Should have trown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      m_4_1.move(1, 3, 3, 1); // move Diagonal direction
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      m_4_1.move(1, 3, 0, 0); // move not in 2 slots
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      m_4_1.move(1, 3, 5, 1); // move not in slots
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      m_3_1.move(3, 3, 3, 1); // fromSlot is an empty slot
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      m_4_1.move(0, 0, 3, 3); // fromSlot is an Invalid slot
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      m_4_1.move(-1, -1, 6, 6); // no SlotState in this position
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }

    try {
      m_4_1.move(4, 3, 2, 1); // move not in 2 slots
      fail("Should have thrown ana IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }

    try {
      m_4_1.move(1, 2, -1, -1); // move to the position which is out of bound
      fail("Should have thrown ana IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      m_4_1.move(4, 3, 7, 7); // move to the position which is out of bound
      fail("Should have thrown ana IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    m_4_1.move(5, 3, 3, 3);
    assertEquals(SlotState.Empty, m_4_1.getSlotAt(5, 3));
    try {
      m_4_1.move(6, 3, 4, 3); // move to which the middle slot is empty
      fail("Should have thrown ana IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
  }

  // Test the void method move(int,int,int,int)
  @org.junit.Test
  public void testMoveValid() {
    this.init();
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O _ O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O", v_5.toString());
    m_4_1.move(3, 1, 3, 3); // horizontally
    assertEquals(SlotState.Marble, m_4_1.getSlotAt(3, 3));
    assertEquals(SlotState.Empty, m_4_1.getSlotAt(3, 2));
    assertEquals(SlotState.Empty, m_4_1.getSlotAt(3, 1));

    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O _ _ O O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O", v_5.toString());
    m_4_1.move(3, 4, 3, 2); // horizontally
    assertEquals(SlotState.Empty, m_4_1.getSlotAt(3, 4));
    assertEquals(SlotState.Marble, m_4_1.getSlotAt(3, 2));
    assertEquals(SlotState.Empty, m_4_1.getSlotAt(3, 3));
    assertEquals(SlotState.Empty, m_4_1.getSlotAt(3, 1));
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O _ O _ _ O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O", v_5.toString());
    m_4_1.move(1, 4, 3, 4); // vertically
    assertEquals(SlotState.Empty, m_4_1.getSlotAt(3, 1));
    assertEquals(SlotState.Marble, m_4_1.getSlotAt(3, 2));
    assertEquals(SlotState.Empty, m_4_1.getSlotAt(3, 3));
    assertEquals(SlotState.Marble, m_4_1.getSlotAt(3, 4));
    assertEquals(SlotState.Marble, m_4_1.getSlotAt(3, 4));
    assertEquals("    O O O\n" +
        "    O O _\n" +
        "O O O O _ O O\n" +
        "O _ O _ O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O", v_5.toString());
    m_4_1.move(4, 4, 2, 4); // vertically
    assertEquals(SlotState.Empty, m_4_1.getSlotAt(3, 1));
    assertEquals(SlotState.Marble, m_4_1.getSlotAt(3, 2));
    assertEquals(SlotState.Empty, m_4_1.getSlotAt(3, 3));
    assertEquals(SlotState.Empty, m_4_1.getSlotAt(3, 4));
    assertEquals(SlotState.Empty, m_4_1.getSlotAt(3, 4));
    assertEquals(SlotState.Empty, m_4_1.getSlotAt(4, 4));
    assertEquals(SlotState.Marble, m_4_1.getSlotAt(2, 4));
    assertEquals("    O O O\n" +
        "    O O _\n" +
        "O O O O O O O\n" +
        "O _ O _ _ O O\n" +
        "O O O O _ O O\n" +
        "    O O O\n" +
        "    O O O", v_5.toString());
  }

  // Play the game in the test until the game is over.
  @org.junit.Test
  public void testModelIsGameOver() {
    this.init();
    assertFalse(m_4_1.isGameOver());
    assertFalse(m_3_1.isGameOver());
    assertFalse(m_2_1.isGameOver());
    m_3_1.move(3, 1, 3, 3);
    m_3_1.move(1, 2, 3, 2);
    m_3_1.move(3, 3, 3, 1);
    m_3_1.move(3, 0, 3, 2);
    m_3_1.move(4, 2, 2, 2);
    m_3_1.move(6, 2, 4, 2);
    m_3_1.move(6, 4, 6, 2);
    m_3_1.move(5, 4, 5, 2);
    m_3_1.move(5, 2, 3, 2);
    m_3_1.move(4, 0, 4, 2);
    m_3_1.move(3, 2, 1, 2);
    m_3_1.move(4, 3, 4, 1);
    m_3_1.move(2, 0, 2, 2);
    m_3_1.move(1, 2, 3, 2);
    m_3_1.move(1, 3, 3, 3);
    m_3_1.move(4, 5, 4, 3);
    m_3_1.move(4, 3, 2, 3);
    m_3_1.move(2, 4, 4, 4);
    m_3_1.move(0, 4, 2, 4);
    m_3_1.move(0, 2, 0, 4);
    m_3_1.move(3, 6, 3, 4);
    m_3_1.move(3, 4, 5, 4);
    m_3_1.move(2, 4, 2, 2);
    m_3_1.move(3, 2, 1, 2);
    m_3_1.move(2, 6, 2, 4);
    assertEquals("    _ _ O\n" +
        "    O _ _\n" +
        "_ _ _ _ O _ _\n" +
        "_ _ _ _ _ _ _\n" +
        "_ O _ _ _ _ O\n" +
        "    _ _ O\n" +
        "    O _ _", v_3.toString());
    assertTrue(m_3_1.isGameOver());

  }

  // Test the method getBoardSize().
  @org.junit.Test
  public void testGetModelBoardSize() {
    this.init();
    assertEquals(7, m_1_1.getBoardSize());
    assertEquals(7, m_2_1.getBoardSize());
    assertEquals(7, m_3_1.getBoardSize());
    assertEquals(13, m_3_2.getBoardSize());
    assertEquals(7, m_4_1.getBoardSize());
    assertEquals(19, m_4_2.getBoardSize());
  }

  // Test the method getSlotAt()
  @org.junit.Test
  public void testModelGetSlotAt() {
    this.init();
    assertEquals(SlotState.Invalid, m_1_1.getSlotAt(1, 1));
    assertEquals(SlotState.Empty, m_1_1.getSlotAt(3, 3));
    assertEquals(SlotState.Marble, m_1_1.getSlotAt(2, 2));
    assertEquals(SlotState.Invalid, m_3_1.getSlotAt(1, 1));
    assertEquals(SlotState.Empty, m_3_2.getSlotAt(4, 4));
    assertEquals(SlotState.Empty, m_4_1.getSlotAt(3, 3));
    assertEquals(SlotState.Invalid, m_4_2.getSlotAt(5, 5));
    try {
      m_4_1.getSlotAt(-1, -1);
      fail("Should throw an illegalArgument Exception");
    } catch (IllegalArgumentException ignored) {
    }
  }

  // Test the exception to getSlotAt()
  @Test
  public void testModelGetSlotAtException() {
    this.init();
    try {
      m_4_1.getSlotAt(-1, 0);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      m_4_1.getSlotAt(0, 7);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      m_4_1.getSlotAt(0, -1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      m_4_1.getSlotAt(7, 0);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      m_4_1.getSlotAt(-1, -1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
    try {
      m_4_1.getSlotAt(7, 7);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException ignored) {

    }
  }

  // Test the method getScore()
  @Test
  public void testModelGetScore() {
    this.init();
    assertEquals(32, m_1_1.getScore());
    assertEquals(32, m_2_1.getScore());
    assertEquals(32, m_3_1.getScore());
    assertEquals(104, m_3_2.getScore());
    assertEquals(104, m_3_2.getScore());
    assertEquals(32, m_4_1.getScore());
    assertEquals(216, m_4_2.getScore());
  }

  // Test the exception to Constructors
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


}
