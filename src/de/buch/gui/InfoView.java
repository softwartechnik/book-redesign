package de.buch.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.*;

public class InfoView extends Dialog {
	
	private static final long serialVersionUID = 1L;

	public InfoView(Frame mainwindow, String info) {
		super(mainwindow, "Info", true);
		setSize(290, 100);
		setLocation(150,150);
		Label text = new Label(info);
        Panel infoPanel = new Panel();
        infoPanel.add(text);
        
		Button ok = new Button("OK");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		Panel buttonPanel = new Panel();
		buttonPanel.add(ok);
		
		add(infoPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		setVisible(true);
	}

}
