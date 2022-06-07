package tfcmetallum.util;

import static tfcmetallum.ConfigTFCM.METALS;
import static tfcmetallum.ConfigTFCM.RECIPES;

public class IsObtainable {

	public static boolean manyullyn;
	public static boolean mithril;
	public static boolean magnesium_diboride;
	public static boolean hsla_steel;
	public static boolean tungsten_steel;
	public static boolean zircaloy;
	public static boolean aluminium_brass;
	public static boolean beryllim_copper;
	public static boolean ferroboron;
	public static boolean tough_alloy;

	public static void checkObtanability() {

		if (METALS.ardite && RECIPES.ardite && METALS.cobalt && RECIPES.cobalt && METALS.manyullyn) {
			manyullyn = true;
		}

		if (METALS.antimony && METALS.mithril) {
			mithril = true;
		}

		if (METALS.magnesium && METALS.magnesium_diboride) {
			magnesium_diboride = true;
		}

		if (METALS.manganese && METALS.hsla_steel) {
			hsla_steel = true;
		}

		if (METALS.tungsten && RECIPES.tungsten && METALS.tungsten_steel) {
			tungsten_steel = true;
		}

		if (METALS.zirconium && RECIPES.zirconium && METALS.zircaloy) {
			zircaloy = true;
		}

		if (METALS.aluminium && METALS.aluminium_brass) {
			aluminium_brass = true;
		}

		if (METALS.aluminium && RECIPES.aluminium && METALS.beryllim && METALS.beryllim_copper) {
			beryllim_copper = true;
		}

		if (METALS.boron && METALS.ferroboron) {
			ferroboron = true;
		}

		if (IsObtainable.ferroboron && METALS.lithium && METALS.tough_alloy) {
			tough_alloy = true;
		}
	}
}