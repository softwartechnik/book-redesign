package de.softwartechnik.book.datenhaltung;

import de.softwartechnik.book.fachlogik.Buch;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

public class BuchSerializeDAO implements IBuchDAO {

  private File f;

  public BuchSerializeDAO(File f) {
    this.f = f;
  }

  @SuppressWarnings("unchecked")
  public List<Buch> laden() throws DatenException {
    try (
      FileInputStream fileInputStream = new FileInputStream(f);
      ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
    ) {
      List<Buch> books = (List<Buch>) objectInputStream.readObject();
      return books != null ? books : new LinkedList<>();
    } catch (Exception e) {
      e.printStackTrace();
      throw new DatenException("Laden nicht möglich.");
    }
  }

  public void speichern(List<Buch> liste) throws DatenException {
    try (
      FileOutputStream fileOutputStream = new FileOutputStream(f);
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
    ) {
      objectOutputStream.writeObject(liste);
    } catch (Exception e) {
      throw new DatenException("Laden nicht möglich");
    }
  }
}
