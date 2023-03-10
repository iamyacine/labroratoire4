package com.labo4.point;

public abstract class PointAbstrait implements Point {

	private static final int CENTRE_AXES_MOINS_3_PIXELS_DU_POINT = 447; // 447 parce que le centre est le pixel 450 x 450, cependant le point occupe 3 pixels

	public boolean bouger() {

		if (!isVisible()) {
			return false;
		}
		
		if ((Math.floor(getX()) == CENTRE_AXES_MOINS_3_PIXELS_DU_POINT || Math.round(getX()) == CENTRE_AXES_MOINS_3_PIXELS_DU_POINT)
				&& (Math.floor(getY()) == CENTRE_AXES_MOINS_3_PIXELS_DU_POINT || Math.round(getY()) == CENTRE_AXES_MOINS_3_PIXELS_DU_POINT)) {
			setVisible(false);
			setX(CENTRE_AXES_MOINS_3_PIXELS_DU_POINT);
			setY(CENTRE_AXES_MOINS_3_PIXELS_DU_POINT);
			return false;
		}

		if (getX() < CENTRE_AXES_MOINS_3_PIXELS_DU_POINT) {
			setX(getX() + getVitesse());
		} else {
			setX(getX() - getVitesse());
		}

		if (getY() < CENTRE_AXES_MOINS_3_PIXELS_DU_POINT) {
			setY(getY() + getVitesse());
		} else {
			setY(getY() - getVitesse());
		}

		return true;
	}

	float x;
	float y;

	float vitesse;

	boolean visible = true;

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setVitesse(float vitesse) {
		this.vitesse = vitesse;
	}

	public float getVitesse() {
		return vitesse;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isVisible() {
		return visible;
	}
}
