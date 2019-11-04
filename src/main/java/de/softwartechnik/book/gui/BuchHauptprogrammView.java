package de.softwartechnik.book.gui;

import main.java.de.softwartechnik.book.datenhaltung.BuchSerializeDAO;
import main.java.de.softwartechnik.book.fachlogik.BuecherVerwaltung;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    BuecherVerwaltung buchliste = new BuecherVerwaltung(
        new BuchSerializeDAO(new File("/Users/dwiesmann/IO/buchliste.ser")));
    //BuecherVerwaltung buchliste = new BuecherVerwaltung(new BuchDBDAO("/home/dwiesmann/DB/buchDB"));
    Controller controller = new Controller(buchliste);
    controller.start();

  }

  private Panel createButtonPanel() {
    Panel p = new Panel(new GridLayout(5, 1));
    Button neu = new Button("Neu");
    neu.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        controller.neu();
      }
    });
    Button laden = new Button("Laden");
    laden.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        controller.laden();
      }

    });
    Button listen = new Button("Liste");
    listen.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        controller.liste();
      }
    });
    Button speicher = new Button("Speichern");
    speicher.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        controller.speichern();
      }

    });
    Button abr = new Button("Fertig");
    abr.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        controller.fertig();
      }
    });
    p.add(neu);
    p.add(laden);
    p.add(listen);
    p.add(speicher);
    p.add(abr);
    return p;
  }
}
