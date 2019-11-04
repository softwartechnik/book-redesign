package main.java.de.softwartechnik.book.datenhaltung;

import java.util.List;
import main.java.de.softwartechnik.book.fachlogik.Buch;

/**
 * Ein Interface für ein Buch-DAO. Zur Vereinfachung wird über dieses Interface immer der komplette
 * Datenbestand gelesen und geschrieben. Für eine Zugriff auf einzelne Datansätze würde dieses
 * Interface im Normalfall die Methode create, read, update und delete bieten.
 */
public interface IBuchDAO {

  List<Buch> laden() throws DatenException;

  void speichern(List<Buch> liste) throws DatenException;
}
