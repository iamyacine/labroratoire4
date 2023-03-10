package com.labo4.point;

public class PointTresRapide extends PointAbstrait {

	private static final float VITESSE = 0.7f;

	public PointTresRapide(int x, int y) {
		setX(x);
		setY(y);
		setVitesse(VITESSE);
	}

}
