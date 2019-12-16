package de.softwartechnik.book.fachlogik;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.softwartechnik.book.datenhaltung.DatenException;
import de.softwartechnik.book.datenhaltung.IBuchDAO;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public final class BuecherVerwaltungMockedTest {
  private static final Buch BOOK_1 = new Buch("Das Leben", 1);
  private static final Buch BOOK_2 = new Buch("Der Tod", 2);

  @Mock
  private IBuchDAO buchDAO;
  private BuecherVerwaltung buecherVerwaltung;

  @BeforeEach
  void setUp() {
    buecherVerwaltung = new BuecherVerwaltung(buchDAO);
  }

  @Test
  void testListAfterLoad() throws DatenException {
    var givenBooks = List.of(BOOK_1, BOOK_2);

    when(buchDAO.laden()).thenReturn(givenBooks);

    buecherVerwaltung.laden();
    var buchliste = buecherVerwaltung.getBuchliste();

    verify(buchDAO).laden();
    assertEquals(givenBooks, buchliste);
  }

  @Captor
  private ArgumentCaptor<List<Buch>> bookCaptor;

  @Test
  void testSaveAfterAdd() throws DatenException {
    buecherVerwaltung.add(BOOK_1);
    buecherVerwaltung.add(BOOK_2);

    buecherVerwaltung.speichern();

    verify(buchDAO).speichern(bookCaptor.capture());

    var savedBooks = bookCaptor.getValue();
    assertEquals(2, savedBooks.size());
    assertTrue(savedBooks.contains(BOOK_1));
    assertTrue(savedBooks.contains(BOOK_2));
  }
}
