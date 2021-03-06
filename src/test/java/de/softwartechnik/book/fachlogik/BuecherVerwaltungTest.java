package de.softwartechnik.book.fachlogik;

import static org.junit.jupiter.api.Assertions.*;

import de.softwartechnik.book.datenhaltung.DatenException;
import de.softwartechnik.book.datenhaltung.IBuchDAO;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BuecherVerwaltungTest {
  private static final Buch BOOK_1 = new Buch("Das Leben", 1);
  private static final Buch BOOK_2 = new Buch("Der Tod", 2);

  private BuchDaoStub buchDaoStub;
  private BuecherVerwaltung buecherVerwaltung;

  @BeforeEach
  void setUp() {
    buchDaoStub = BuchDaoStub.empty();
    buecherVerwaltung = new BuecherVerwaltung(buchDaoStub);
  }

  @Test
  void testLaden() throws DatenException {
    buchDaoStub.speichern(List.of(BOOK_1));

    buecherVerwaltung.speichern();

    var books = buchDaoStub.savedBooks();
    assertTrue(books.isEmpty());
  }

  @Test
  void testSpeichern() throws DatenException {
    buecherVerwaltung.add(BOOK_1);
    buecherVerwaltung.add(BOOK_2);

    buecherVerwaltung.speichern();

    var books = buchDaoStub.savedBooks();
    assertEquals(2, books.size());
    assertTrue(books.contains(BOOK_1));
    assertTrue(books.contains(BOOK_2));
  }

  @Test
  void testGetBook() {
    var theLifeBook = new Buch("Das Leben", 1);
    buecherVerwaltung.add(theLifeBook);

    var book = buecherVerwaltung.getBuch(0);
    assertEquals(theLifeBook, book);
  }

  public static final class BuchDaoStub implements IBuchDAO {
    private List<Buch> savedBooks;

    private BuchDaoStub(List<Buch> savedBooks) {
      this.savedBooks = savedBooks;
    }

    private static BuchDaoStub empty() {
      return new BuchDaoStub(new ArrayList<>());
    }

    @Override
    public List<Buch> laden() {
      return savedBooks;
    }

    @Override
    public void speichern(List<Buch> liste) {
      savedBooks = liste;
    }

    public List<Buch> savedBooks() {
      return savedBooks;
    }
  }
}