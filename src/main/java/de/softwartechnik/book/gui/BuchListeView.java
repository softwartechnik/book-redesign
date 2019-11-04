package de.softwartechnik.book.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import main.java.de.softwartechnik.book.fachlogik.Buch;

public class BuchListeView extends Dialog {

  private static final long serialVersionUID = 1L;

  private Controller controller;
  private List liste;
  private java.util.List<Buch> buchliste;
  private int selectedIndex;

  public BuchListeView(Frame mainwindow, Controller controller, java.util.List<Buch> buchliste) {
    super(mainwindow, "Buchliste", true);
    this.controller = controller;
    this.buchliste = buchliste;
    selectedIndex = -1;
    add(createListenPanel());
    setSize(400, 500);
    setLocation(150, 50);
    setVisible(true);
  }

  private Panel createListenPanel() {
    Panel panel_main = new Panel();
    panel_main.setLayout(new BorderLayout());
    Panel panel_button = new Panel();

    Button button_aendern = new Button("Ändern");
    button_aendern.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (selectedIndex > -1) {
          close();
          controller.aendern(selectedIndex);
        }
      }
    });

    Button button_abbrechen = new Button("Abbrechen");
    button_abbrechen.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        close();
      }

    });
    panel_button.add(button_aendern);
    panel_button.add(button_abbrechen);
    liste = new List(20, false);
    liste.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj instanceof List) {
          selectedIndex = ((List) e.getSource()).getSelectedIndex();
          close();
          controller.aendern(selectedIndex);

        }
      }
    });
    liste.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        selectedIndex = ((Integer) e.getItem()).intValue();
      }
    });

    if (buchliste != null) {
      for (Buch b : buchliste) {
        liste.add(b.getTitel() + "   " + b.getPreis());
      }
    }
    panel_main.add(liste, BorderLayout.CENTER);
    panel_main.add(panel_button, BorderLayout.SOUTH);
    return panel_main;
  }

  private void close() {
    setVisible(false);
    dispose();
  }

}
