package com.labo4.point;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class PointType3 extends PointAbstrait {

	private static final float VITESSE = 0.460f;
	private static final float VITESSE_BACK = -0.1535f;
	private static final int INTERCHANGER_CHAQUE_MS = 500;

	private static final int CENTRE_AXES_MOINS_3_PIXELS_DU_POINT = 447; // 447 parce que le centre est le pixel 450 x
																		// 450, cependant le point occupe 3 pixels

	private boolean avancerPlutotReculer = true;
	private boolean zigOrZag = true;

	private float vitesseArriere;

	private LocalTime debutIntervalleDirection;
	private LocalTime finalIntervalleDirection;

	public PointType3(int x, int y) {
		setX(x);
		setY(y);

		//En raison de problèmes de performances et/ou de limitation de javax.Swing, une moyenne de 65 itérations ont été effectuées en 1 seconde au lieu de 1000.
		//		Alors:
		//			se déplaçant à 0,03 par milliseconde, nous serions capables de déplacer 20 unités par seconde
		//			compte tenu de 65 itérations, il faut déplacer 0,460 pour que la
		//			continuez à marcher 20 unités par seconde
		setVitesse(VITESSE);
		setVitesseArriere(VITESSE_BACK);
	}

	public boolean bouger() {
		if (!isVisible()) {
			return false;
		}

		System.out.println("X:"+Math.floor(getX()));
		System.out.println("Y:"+Math.floor(getY()));
		if ((Math.floor(getX()) == CENTRE_AXES_MOINS_3_PIXELS_DU_POINT
				|| Math.round(getX()) == CENTRE_AXES_MOINS_3_PIXELS_DU_POINT)
				|| (Math.floor(getY()) == CENTRE_AXES_MOINS_3_PIXELS_DU_POINT
						|| Math.round(getY()) == CENTRE_AXES_MOINS_3_PIXELS_DU_POINT)) {
			setVisible(false);
			setX(CENTRE_AXES_MOINS_3_PIXELS_DU_POINT);
			setY(CENTRE_AXES_MOINS_3_PIXELS_DU_POINT);
			return false;
		}

		deciderZigOrZag();

		if (zigOrZag) {
			if (getX() < CENTRE_AXES_MOINS_3_PIXELS_DU_POINT) {
				setX(getX() + getVitesse());
			} else {
				setX(getX() - getVitesse());
			}

			if (getY() < CENTRE_AXES_MOINS_3_PIXELS_DU_POINT) {
				setY(getY() + getVitesseBack());
			} else {
				setY(getY() - getVitesseBack());
			}

		} else {
			if (getX() < CENTRE_AXES_MOINS_3_PIXELS_DU_POINT) {
				setX(getX() + getVitesseBack());
			} else {
				setX(getX() - getVitesseBack());
			}
			if (getY() < CENTRE_AXES_MOINS_3_PIXELS_DU_POINT) {
				setY(getY() + getVitesse());
			} else {
				setY(getY() - getVitesse());
			}
		}
		return true;
	}

	private void deciderZigOrZag() {
		if (debutIntervalleDirection == null) {
			debutIntervalleDirection = LocalTime.now();
		} else {
			finalIntervalleDirection = LocalTime.now();

			int dureeNanosecondes = Duration.between(debutIntervalleDirection, finalIntervalleDirection).getNano();
			long dureeMillisecondes = TimeUnit.NANOSECONDS.toMillis(dureeNanosecondes);
			if (dureeMillisecondes > INTERCHANGER_CHAQUE_MS) {
				debutIntervalleDirection = LocalTime.now();
				avancerPlutotReculer = !avancerPlutotReculer;
				zigOrZag = !zigOrZag;
			}
		}
	}

	public float getVitesseBack() {
		return vitesseArriere;
	}

	private void setVitesseArriere(float vitesseArriere) {
		this.vitesseArriere = vitesseArriere;
	}

}
