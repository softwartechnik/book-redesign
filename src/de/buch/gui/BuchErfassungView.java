package de.buch.gui;

import java.awt.*;
import java.awt.event.*;

import de.buch.fachlogik.Buch;

public class BuchErfassungView extends Dialog {

	private static final long serialVersionUID = 1L;
	private Buch buch;
	private Controller controller;
	private TextField tf_name;
	private TextField tf_preis;

	public BuchErfassungView(Frame mainwindow, Controller controller, Buch buch) {
		super(mainwindow, "Bucherfassung", true);
		this.buch = buch;
		this.controller = controller;
		setSize(290, 150);
		setLocation(150,100);
		Panel mainPanel = new Panel(new FlowLayout());
		mainPanel.add(createPanel());
		add(mainPanel);
		add(createButtonPanel(), BorderLayout.SOUTH);
		setVisible(true);
	}

	private Panel createPanel() {
		Panel p = new Panel();
		p.setLayout(new GridLayout(2, 1));

		Panel ptop = new Panel(new FlowLayout(FlowLayout.RIGHT));
		ptop.add(new Label("Titel:"));
		tf_name = new TextField(15);
		ptop.add(tf_name);

		Panel pbottom = new Panel(new FlowLayout(FlowLayout.RIGHT));
		tf_preis = new TextField(15);
		pbottom.add(new Label("Preis:"));
		pbottom.add(tf_preis);

		if (buch != null) {
			update();
		}

		p.add(ptop);
		p.add(pbottom);
		return p;
	}

	private Panel createButtonPanel() {
		Panel footer = new Panel();
		Button button_speichern = new Button("Speichern");
		button_speichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
				close();
				controller.erfassenPerformed(buch);
			}
		});
		footer.add(button_speichern);

		Button button_abr = new Button("Abbrechen");
		button_abr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		footer.add(button_abr);
		return footer;
	}

	private void update() {
		tf_name.setText(buch.getTitel());
		tf_preis.setText(String.valueOf(buch.getPreis()));
	}

	private void save() {
		try {
			String name = tf_name.getText();
			buch.setTitel(name);
			float preis = Float.parseFloat(tf_preis.getText());
			buch.setPreis(preis);
		} catch (NumberFormatException a) {
			close();
			controller.erfassenFehler(buch);
		}
	}

	private void close() {
		setVisible(false);
		dispose();
	}

}
