package de.buch.datenhaltung;

import de.buch.fachlogik.Buch;
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

  private Connection conn;
  private String dbname;

  public BuchDBDAO(String dbname) {
    this.dbname = dbname;
    try {
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  private void open() throws DatenException {
    try {
      conn = DriverManager.getConnection("jdbc:derby:" + dbname);
    } catch (SQLException e) {
      e.printStackTrace();
      throw new DatenException("Keine DB-Verbindung");
    }
  }

  @Override
  public List<Buch> laden() throws DatenException {
    Statement s = null;
    List<Buch> liste = new LinkedList<Buch>();
    open();
    try {
      s = conn.createStatement();
      ResultSet rs = s.executeQuery("SELECT * FROM buch");
      while (rs.next()) {
        long id = rs.getLong(1);
        String name = rs.getString(2).trim();
        float preis = rs.getFloat(3);
        Buch buch = new Buch(id, name, preis);
        liste.add(buch);
      }
    } catch (SQLException e) {
      throw new DatenException("Fehler beim Lesen aus DB");
    } finally {
      try {
        s.close();
        conn.close();
      } catch (SQLException e) {
      }
    }
    return liste;
  }

  @Override
  public void speichern(List<Buch> liste) throws DatenException {
    Statement s = null;
    open();
    try {
      s = conn.createStatement();
      s.executeUpdate("DELETE FROM buch WHERE id > -1");
      for (Buch buch : liste) {
        s.executeUpdate("INSERT INTO buch VALUES (" + buch.getID() + ",'"
            + buch.getTitel() + "'," + buch.getPreis() + ")");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        s.close();
        conn.close();
      } catch (SQLException e) {
      }

    }

  }


}
