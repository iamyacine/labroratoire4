package com.labo4.main;

import javax.swing.SwingUtilities;

import com.labo4.view.CartesianFrame;

public class PlanCartesianMain {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				CartesianFrame frame = new CartesianFrame();
				frame.showUI();
				frame.setSize(750,750);
			}
		});
	}

}