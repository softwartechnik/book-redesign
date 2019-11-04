package main.java.de.softwartechnik.book.datenhaltung;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import main.java.de.softwartechnik.book.fachlogik.Buch;

public class BuchSerializeDAO implements IBuchDAO {

  private File f;

  public BuchSerializeDAO(File f) {
    this.f = f;
  }

  @SuppressWarnings("unchecked")
  public List<Buch> laden() throws DatenException {
    List<Buch> liste = null;
    ObjectInputStream ois = null;
    try {
      FileInputStream fis = new FileInputStream(f);
      ois = new ObjectInputStream(fis);
      liste = ((List<Buch>) ois.readObject());
    } catch (Exception e) {
      e.printStackTrace();
      throw new DatenException("Laden nicht möglich.");
    } finally {
      try {
        ois.close();
      } catch (IOException e) {
      }
    }
    if (liste == null) {
      liste = new LinkedList<Buch>();
    }
    return liste;
  }

  public void speichern(List<Buch> liste) throws DatenException {
    ObjectOutputStream oos = null;

    try {
      FileOutputStream fos = new FileOutputStream(f);
      oos = new ObjectOutputStream(fos);
      oos.writeObject(liste);
    } catch (Exception e) {
      throw new DatenException("Laden nicht möglich");
    } finally {
      try {
        oos.close();
      } catch (IOException e) {

      }
    }
  }

}
