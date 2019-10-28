package de.buch.fachlogik;

import java.io.Serializable;

public class Buch implements Serializable {

  private static final long serialVersionUID = 7990859856056431852L;

  private static long oid;
  private long id;
  private String titel;
  private float preis;

  public Buch() {
    id = oid++;
  }

  public Buch(String titel, float preis) {
    this();
    this.titel = titel;
    this.preis = preis;
  }

  public Buch(long id, String titel, float preis) {
    this.id = id;
    if (this.id > oid) {
      oid = this.id + 1;
    }
    this.titel = titel;
    this.preis = preis;
  }


  public long getID() {
    return id;
  }

  public String getTitel() {
    return titel;
  }

  public void setTitel(String titel) {
    this.titel = titel;
  }

  public float getPreis() {
    return preis;
  }

  public void setPreis(float preis) {
    this.preis = preis;
  }

}
