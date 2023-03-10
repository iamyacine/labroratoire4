package com.labo4.point;

public class PointType1 extends PointAbstrait {
	
	private static final float VITESSE = 0.307f;

	public PointType1(int x, int y) {
		setX(x);
		setY(y);
		
		//En raison de problèmes de performances et/ou de limitation de javax.Swing, une moyenne de 65 itérations ont été effectuées en 1 seconde au lieu de 1000.
		//		Alors:
		//			se déplaçant à 0,02 par milliseconde, nous serions capables de déplacer 20 unités par seconde
		//			compte tenu de 65 itérations, il faut déplacer 0,307 pour que la
		//			continuez à marcher 20 unités par seconde
		setVitesse(VITESSE);
	}

}
