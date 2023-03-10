package com.labo4;

import java.util.Random;

public class RandomUtils {

	private static final int VALEUR_MINIMUM_POSSIBLE = 20;
	private static final int VALEUR_MAXIMUM_POSSIBLE = 873;
	private static final int MULTIPLES_VALEURS_QUI_VONT_AU_CENTRE = 8;

	private RandomUtils() {
	}

	public static int obtenirUnePositionAleatoire() {

		/*
		 * Des points aléatoires à chaque exécution: 
		 *  - Comme nous avons 107 unités de distance en tout de 20 à 27 comme valeur minimum possible 
		 *  - Et 873 à 880 comme valeur maximum possible
		 */

		int lePlusPetitNombrePermis = VALEUR_MINIMUM_POSSIBLE + new Random().nextInt(MULTIPLES_VALEURS_QUI_VONT_AU_CENTRE);
		int lePlusGrandNombrePermis = VALEUR_MAXIMUM_POSSIBLE + new Random().nextInt(MULTIPLES_VALEURS_QUI_VONT_AU_CENTRE);

		return new Random().nextInt(2) == 0 ? lePlusPetitNombrePermis : lePlusGrandNombrePermis; // à decider entre le plus petit
																								// et le plus grand
	}

}
