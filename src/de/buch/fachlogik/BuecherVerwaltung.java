package de.buch.fachlogik;

import java.util.LinkedList;
import java.util.List;

import de.buch.datenhaltung.DatenException;
import de.buch.datenhaltung.IBuchDAO;

public class BuecherVerwaltung {
  private List<Buch> liste;
  private IBuchDAO dao;
  
  public BuecherVerwaltung(IBuchDAO dao){
	  liste = new LinkedList<Buch>();
	  this.dao = dao;
  }
  
  public void add(Buch b){
	  liste.add(b);
  }
  
  public Buch getBuch(int index){
	  return liste.get(index);
  }
  
  public List<Buch> getBuchliste(){
	  return liste;
  }

  public void laden() throws DatenException{
	  liste=dao.laden();
  }
  
  public void speichern() throws DatenException{
	  dao.speichern(liste);
  }
}
