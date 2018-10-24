package de.buch.gui;

import de.buch.datenhaltung.DatenException;
import de.buch.fachlogik.Buch;
import de.buch.fachlogik.BuecherVerwaltung;

public class Controller {
	private BuecherVerwaltung buchliste;
	private BuchHauptprogrammView gui;
	private ErfassungStrategie strategie;

	public Controller(BuecherVerwaltung buchliste) {
		this.buchliste = buchliste;
	}

	public void start() {
		gui = new BuchHauptprogrammView(this);
	}

	private abstract class ErfassungStrategie {
		public void erfassen(Buch buch) {
			new BuchErfassungView(gui, Controller.this, buch);
		}

		public abstract void erfassenPerformed(Buch buch);
	}

	private class ErfassungNeuStrategie extends ErfassungStrategie {
		@Override
		public void erfassenPerformed(Buch buch) {
			buchliste.add(buch);
		}
	}
	
	private class ErfassungAendernStrategie extends ErfassungStrategie{
		@Override
		public void erfassenPerformed(Buch buch) {
			
		}		
	}
	
	public void neu(){
		strategie = new ErfassungNeuStrategie();
		strategie.erfassen(new Buch());
	}

	public void aendern(int index) {
		strategie = new ErfassungAendernStrategie();
		strategie.erfassen(buchliste.getBuch(index));
	}

	public void erfassenPerformed(Buch buch) {
		strategie.erfassenPerformed(buch);
	}
	
	public void erfassenFehler(Buch buch){
		new InfoView(gui, "Bitte ein gültige Zahl eingeben");
		strategie.erfassen(buch);
	}

	public void laden() {
		try {
			buchliste.laden();
			new InfoView(gui, "Daten wurden geladen.");
		} catch (DatenException e) {
			new InfoView(gui, "Fehler: Daten konnten nicht geladen werden!");
		}
	}

	public void liste() {
		strategie = new ErfassungAendernStrategie();
		new BuchListeView(gui, this, buchliste.getBuchliste());
	}


	public void speichern() {
		try {
			buchliste.speichern();
			new InfoView(gui, "Daten wurden gespeichert.");
		} catch (DatenException e) {
			new InfoView(gui, "Fehler: Daten konnten nicht gespeichert werden!");
		}
	}

	public void fertig() {
		gui.setVisible(false);
		gui.dispose();
		System.exit(0);
	}

}
