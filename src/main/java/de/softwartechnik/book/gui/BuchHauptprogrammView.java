package de.softwartechnik.book.gui;

import de.softwartechnik.book.datenhaltung.BuchSerializeDAO;
import de.softwartechnik.book.datenhaltung.IBuchDAO;
import de.softwartechnik.book.fachlogik.BuecherVerwaltung;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.io.File;


public class BuchHauptprogrammView extends Frame {

  private static final long serialVersionUID = 1L;
  private Controller controller;

  public BuchHauptprogrammView(Controller controller) {
    super("Buchverwaltung");
    this.controller = controller;
    setSize(250, 290);
    setLocation(50, 100);
    add(createButtonPanel());
    setVisible(true);
  }

  public static void main(String[] args) {
    //IBuchDAO buchDAO = new BuchDBDAO("/home/dwiesmann/DB/buchDB");
    IBuchDAO buchDAO = new BuchSerializeDAO(new File("/Users/dwiesmann/IO/buchliste.ser"));
    BuecherVerwaltung buchliste = new BuecherVerwaltung(buchDAO);

    Controller controller = new Controller(buchliste);
    controller.start();

  }

  private Panel createButtonPanel() {
    Panel p = new Panel(new GridLayout(5, 1));

    Button neu = new Button("Neu");
    neu.addActionListener(action -> controller.neu());

    Button laden = new Button("Laden");
    laden.addActionListener(action -> controller.laden());

    Button listen = new Button("Liste");
    listen.addActionListener(action -> controller.liste());

    Button speicher = new Button("Speichern");
    speicher.addActionListener(action -> controller.speichern());

    Button abr = new Button("Fertig");
    abr.addActionListener(action -> controller.fertig());

    p.add(neu);
    p.add(laden);
    p.add(listen);
    p.add(speicher);
    p.add(abr);
    return p;
  }
}
