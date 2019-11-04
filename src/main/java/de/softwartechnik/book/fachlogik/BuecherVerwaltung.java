package main.java.de.softwartechnik.book.fachlogik;

import java.util.LinkedList;
import java.util.List;
import main.java.de.softwartechnik.book.datenhaltung.DatenException;
import main.java.de.softwartechnik.book.datenhaltung.IBuchDAO;

/**
 * A management suite on top of the dao to provide domain specific books. Basically a repository
 * that was called "Verwaltung" by someone.
 */
public class BuecherVerwaltung {

  private List<Buch> liste;
  private IBuchDAO dao;

  /**
   * Create a new management with an underlying book dao.
   *
   * @param dao The book dao.
   */
  public BuecherVerwaltung(IBuchDAO dao) {
    liste = new LinkedList<Buch>();
    this.dao = dao;
  }

  public void add(Buch b) {
    liste.add(b);
  }

  public Buch getBuch(int index) {
    return liste.get(index);
  }

  public List<Buch> getBuchliste() {
    return liste;
  }

  /**
   * Load all books from disk.
   *
   * @throws DatenException If somethings go wrong while reading data.
   */
  public void laden() throws DatenException {
    liste = dao.laden();
  }

  /**
   * Save all books to disk.
   *
   * @throws DatenException If somethings go wrong while writing data.
   */
  public void speichern() throws DatenException {
    dao.speichern(liste);
  }
}
