package com.labo4.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CartesianFrame extends JFrame implements ActionListener {
	
	private static final int DELAI_INITIAL_ET_ENTRE_EVENEMENTS_MS = 1;

	CartesianPanel panel;
	JButton boutonDemarrer;
	JButton boutonNewGame;
	Timer refreshUITimer;
	ActionListener miseAJourListener = new MyUpdateListener();

	public CartesianFrame() {

		refreshUITimer = new Timer(DELAI_INITIAL_ET_ENTRE_EVENEMENTS_MS, miseAJourListener);

		setLayout(new BorderLayout());

		boutonDemarrer = new JButton("Démarrer");
		boutonDemarrer.addActionListener(this);

		boutonNewGame = new JButton("Recommencer");
		boutonNewGame.addActionListener(this);

		final JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.add(boutonDemarrer);
		buttonPanel.add(boutonNewGame);
		
		getContentPane().add(buttonPanel, BorderLayout.PAGE_START);

		panel = new CartesianPanel(refreshUITimer);
		panel.setBackground(Color.black);
		panel.setSize(500, 500);
		getContentPane().add(panel, BorderLayout.CENTER);
	}

	class MyUpdateListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			panel.bougerPoints(refreshUITimer);
			panel.repaint();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boutonDemarrer) {
			refreshUITimer.start();
		}
		if (e.getSource() == boutonNewGame) {
			refreshUITimer.stop();
			refreshUITimer = new Timer(DELAI_INITIAL_ET_ENTRE_EVENEMENTS_MS, miseAJourListener);
			panel.repaint();
			panel.startAll(refreshUITimer);
		}
	}

	public void showUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Course dans un plan cartésien");
		setSize(750, 750);
		setVisible(true);
	}

}