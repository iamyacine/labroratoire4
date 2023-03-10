package com.labo4.point;

import com.labo4.RandomUtils;

public class PointFactory {

    private PointFactory() {}

    public static PointType1 creerPointType1() {
        return new PointType1(RandomUtils.obtenirUnePositionAleatoire(), RandomUtils.obtenirUnePositionAleatoire());
    }

    public static PointRapide creerPointRapide() {
        return new PointRapide(RandomUtils.obtenirUnePositionAleatoire(), RandomUtils.obtenirUnePositionAleatoire());
    }

    public static PointTresRapide creerPointTresRapide() {
        return new PointTresRapide(RandomUtils.obtenirUnePositionAleatoire(), RandomUtils.obtenirUnePositionAleatoire());
    }

	public static PointType2 creerPointType2() {
		return new PointType2(RandomUtils.obtenirUnePositionAleatoire(), RandomUtils.obtenirUnePositionAleatoire());
	}

	public static PointType3 creerPointType3() {
		return new PointType3(RandomUtils.obtenirUnePositionAleatoire(), RandomUtils.obtenirUnePositionAleatoire());
	}

}
