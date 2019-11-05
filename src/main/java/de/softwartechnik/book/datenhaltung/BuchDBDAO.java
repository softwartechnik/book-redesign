package de.softwartechnik.book.datenhaltung;

import de.softwartechnik.book.fachlogik.Buch;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * Ein DAO für die Klasse Buch. Das DAO realisiert einen Zugriff auf eine relationale
 * Derby-Datenbank. Die Datenbank muss breits existieren.
 */
public class BuchDBDAO implements IBuchDAO {

  private String dbName;

  public BuchDBDAO(String dbName) {
    this.dbName = dbName;
    ensureDriver();
  }

  private void ensureDriver() {
    try {
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  private Connection open() throws DatenException {
    try {
      return DriverManager.getConnection("jdbc:derby:" + dbName);
    } catch (SQLException e) {
      e.printStackTrace();
      throw new DatenException("Keine DB-Verbindung");
    }
  }

  @Override
  public List<Buch> laden() throws DatenException {
    try (
      Connection connection = open();
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM buch")
    ) {
      List<Buch> liste = new LinkedList<>();
      while (resultSet.next()) {
        long id = resultSet.getLong(1);
        String name = resultSet.getString(2).trim();
        float preis = resultSet.getFloat(3);
        Buch buch = new Buch(id, name, preis);
        liste.add(buch);
      }
      return liste;
    } catch (SQLException e) {
      throw new DatenException("Fehler beim Lesen aus DB");
    }
  }

  @Override
  public void speichern(List<Buch> liste) throws DatenException {
    try (
      Connection connection = open();
      Statement statement = connection.createStatement()
    ) {
      statement.executeUpdate("DELETE FROM buch WHERE id > -1");
      for (Buch buch : liste) {
        statement.executeUpdate("INSERT INTO buch VALUES (" + buch.getID() + ",'"
          + buch.getTitel() + "'," + buch.getPreis() + ")");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
