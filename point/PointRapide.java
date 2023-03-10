package com.labo4.point;
public class PointRapide extends PointAbstrait {
	
	private static final float VITESSE = 0.5f;

    public PointRapide(int x, int y) {
        setX(x);
        setY(y);
        setVitesse(VITESSE);
    }

}
