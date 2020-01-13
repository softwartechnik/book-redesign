package de.softwartechnik.book.fachlogik;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BuchTest {

  private static final long BOOK_ID = 100L;
  private static final String BOOK_TITLE = "book";
  private static final float BOOK_PRICE = 100F;
  private Buch book;

  @BeforeEach
  void setUp() {
    book = new Buch(BOOK_ID, BOOK_TITLE, BOOK_PRICE);
  }

  @Test
  void testGetId() {
    var bookId = book.getID();
    assertEquals(BOOK_ID, bookId);
  }

  @Test
  void testGetTitel() {
    var title = book.getTitel();
    assertEquals(BOOK_TITLE, title);
  }

  @Test
  void testSetTitel() {
    var alternativeTitle = "theLife";
    book.setTitel(alternativeTitle);
    assertEquals(alternativeTitle, book.getTitel());
  }

  @Test
  void testGetPreis() {
    var price = book.getPreis();
    assertEquals(BOOK_PRICE, price);
  }

  @Test
  void testSetPreis() {
    var alternativePrice = -1F;
    book.setPreis(alternativePrice);
    assertEquals(alternativePrice, book.getPreis());
  }
}