package de.softwartechnik.book.fachlogik;

import de.softwartechnik.book.datenhaltung.IBuchDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public final class BuecherVerwaltungMockedTest {

  @Mock
  private IBuchDAO buchDAO;
  private BuecherVerwaltung buecherVerwaltung;

  @BeforeEach
  void setUp() {
    buecherVerwaltung = new BuecherVerwaltung(buchDAO);
  }
}
