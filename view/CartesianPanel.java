package com.labo4.view;

import javax.swing.*;

import com.labo4.point.PointAbstrait;
import com.labo4.point.PointFactory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CartesianPanel extends JPanel {

	private static final int CENTRE_AXES = 450;
	private static final int CENTRE_AXES_MOINS_3_PIXELS_DU_POINT = 447; // Le centre est le pixel 450 x 450, mais le point occupe 3 pixels
	private static final int CENTRE_AXES_AVEC_3_PIXELS_DU_POINT = 453; // Le centre est le pixel 450 x  450, mais le point occupe 3 pixels
	private static final int VALEUR_MINIMUM_POSSIBLE = 20;
	private static final int VALEUR_MAXIMUM_POSSIBLE = 880;

	public static final int QUANTITE_TOTAL_UNITES_DISTANCE = 107;

	Graphics graphics2D;

	PointAbstrait point1;
	PointAbstrait point2;
	PointAbstrait point3;
	PointAbstrait point4;
	PointAbstrait point5;

	Timer refreshUITimer;
	Timer uneSecondeArret;
	
	boolean dessinerDesFlechesAxes = false;

	public CartesianPanel(Timer timer) {
		startAll(timer);
	}
	
	public void startAll(Timer timer) {
		refreshUITimer = timer;

		point1 = PointFactory.creerPointType1();
		point2 = PointFactory.creerPointRapide();
		point3 = PointFactory.creerPointType3();
		point4 = PointFactory.creerPointTresRapide();
		point5 = PointFactory.creerPointType2();

		// 1 sec timer
		UneSecondeArretTimerListener uneSecondeArretTimerListener = new UneSecondeArretTimerListener();
		uneSecondeArret = new Timer(1000, uneSecondeArretTimerListener);
		uneSecondeArret.setRepeats(false);		
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		graphics2D = g;

		dessinerAxeX();
		dessinerAxeY();

		if(dessinerDesFlechesAxes) {
			dessinerDesFlechesAxes();
		}
		dessinerTextesAxes();

		dessinerEchellesAxes();

		// points
		graphics2D.setColor(Color.BLUE);
		dessinerPoint(point1);
		graphics2D.setColor(Color.ORANGE);
		dessinerPoint(point2);
		graphics2D.setColor(Color.PINK);
		dessinerPoint(point3);
		graphics2D.setColor(Color.GREEN);
		dessinerPoint(point4);
		graphics2D.setColor(Color.RED);
		dessinerPoint(point5);

	}

	private void dessinerPoint(PointAbstrait point) {
		if (point != null) {
			graphics2D.fillOval(Math.round(point.getX()), Math.round(point.getY()), 6, 6);
		}
	}

	private void dessinerAxeX() {
		graphics2D.drawLine(VALEUR_MINIMUM_POSSIBLE, CENTRE_AXES, VALEUR_MAXIMUM_POSSIBLE, CENTRE_AXES);
	}

	private void dessinerAxeY() {
		graphics2D.drawLine(CENTRE_AXES, VALEUR_MINIMUM_POSSIBLE, CENTRE_AXES, VALEUR_MAXIMUM_POSSIBLE);
	}

	private void dessinerDesFlechesAxes() {
		// x-axis arrow (begin)
		graphics2D.drawLine(VALEUR_MINIMUM_POSSIBLE, CENTRE_AXES, 30, 440);
		graphics2D.drawLine(VALEUR_MINIMUM_POSSIBLE, CENTRE_AXES, 30, 460);
		// x-axis arrow (end)
		graphics2D.drawLine(VALEUR_MAXIMUM_POSSIBLE, CENTRE_AXES, 870, 440);
		graphics2D.drawLine(VALEUR_MAXIMUM_POSSIBLE, CENTRE_AXES, 870, 460);

		// y-axis arrow (begin)
		graphics2D.drawLine(CENTRE_AXES, VALEUR_MINIMUM_POSSIBLE, 440, 30);
		graphics2D.drawLine(CENTRE_AXES, VALEUR_MINIMUM_POSSIBLE, 460, 30);
		// y-axis arrow (end)
		graphics2D.drawLine(CENTRE_AXES, VALEUR_MAXIMUM_POSSIBLE, 440, 870);
		graphics2D.drawLine(CENTRE_AXES, VALEUR_MAXIMUM_POSSIBLE, 460, 870);
	}

	private void dessinerTextesAxes() {
		// Dessiner les textes "X" et "Y"
		graphics2D.drawString("X", VALEUR_MAXIMUM_POSSIBLE, 480);
		graphics2D.drawString("Y", 430, VALEUR_MINIMUM_POSSIBLE);
	}

	private void dessinerEchellesAxes() {
		// x negativo
		for (int i = 1; i <= QUANTITE_TOTAL_UNITES_DISTANCE; i++) {
			graphics2D.drawLine(CENTRE_AXES - (4 * i), CENTRE_AXES_MOINS_3_PIXELS_DU_POINT, CENTRE_AXES - (4 * i),
					CENTRE_AXES_AVEC_3_PIXELS_DU_POINT);
		}
		// x positivo
		for (int i = 1; i <= QUANTITE_TOTAL_UNITES_DISTANCE; i++) {
			graphics2D.drawLine(CENTRE_AXES + (4 * i), CENTRE_AXES_MOINS_3_PIXELS_DU_POINT, CENTRE_AXES + (4 * i),
					CENTRE_AXES_AVEC_3_PIXELS_DU_POINT);
		}
		// y positivo
		for (int i = 1; i <= QUANTITE_TOTAL_UNITES_DISTANCE; i++) {
			graphics2D.drawLine(CENTRE_AXES_MOINS_3_PIXELS_DU_POINT, CENTRE_AXES - (4 * i), CENTRE_AXES_AVEC_3_PIXELS_DU_POINT,
					CENTRE_AXES - (4 * i));
		}
		// y negativo
		for (int i = 1; i <= QUANTITE_TOTAL_UNITES_DISTANCE; i++) {
			graphics2D.drawLine(CENTRE_AXES_MOINS_3_PIXELS_DU_POINT, CENTRE_AXES + (4 * i), CENTRE_AXES_AVEC_3_PIXELS_DU_POINT,
					CENTRE_AXES + (4 * i));
		}
	}

	public void bougerPoints(Timer timer) {

		boolean isUnPointArriveAuCentre = false;

		if (point1 != null && !point1.bouger()) {
			isUnPointArriveAuCentre = true;
		}

		if (point2 != null && !point2.bouger()) {
			isUnPointArriveAuCentre = true;
		}

		if (point3 != null && !point3.bouger()) {
			isUnPointArriveAuCentre = true;
		}

		if (point4 != null && !point4.bouger()) {
			isUnPointArriveAuCentre = true;
		}

		if (point5 != null && !point5.bouger()) {
			isUnPointArriveAuCentre = true;
		}

		if (isUnPointArriveAuCentre) {
			timer.stop();
			uneSecondeArret.start();
		}

	}

	class UneSecondeArretTimerListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			if (point1 != null && !point1.isVisible()) {
				point1 = null;
			}

			if (point2 != null && !point2.isVisible()) {
				point2 = null;
			}

			if (point3 != null && !point3.isVisible()) {
				point3 = null;
			}

			if (point4 != null && !point4.isVisible()) {
				point4 = null;
			}

			if (point5 != null && !point5.isVisible()) {
				point5 = null;
			}

			refreshUITimer.start();
		}
	}

}
