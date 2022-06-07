package tfcmetallum.util;

import static tfcmetallum.ConfigTFCM.METALS;
import static tfcmetallum.ConfigTFCM.NON_METALS;
import static tfcmetallum.TFCMetallum.getLog;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.io.FileUtils;

import net.dries007.tfc.world.classic.worldgen.vein.VeinRegistry;

public class VeinDataManager {
	
	public static List<String> onList;
	public static List<String> offList;
	
	public static void doVeinList() {
		
		List<String> oresOnList = new ArrayList();
		List<String> oresOffList = new ArrayList();
		
		if (NON_METALS.arsenic) {
			oresOnList.add("arsenic");
		} else {
			oresOffList.add("arsenic");
		}
		
		if (METALS.aluminium) {
			oresOnList.add("bauxite");
		} else {
			oresOffList.add("bauxite");
		}
		
		if (METALS.cobalt) {
			oresOnList.add("cobaltite");
		} else {
			oresOffList.add("cobaltite");
		}
		
		if (NON_METALS.chromite) {
			oresOnList.add("chromite");
		} else {
			oresOffList.add("chromite");
		}
		
		if (NON_METALS.fluorite) {
			oresOnList.add("fluorite");
		} else {
			oresOffList.add("fluorite");
		}
		
		if (METALS.magnesium) {
			oresOnList.add("magnesite");
		} else {
			oresOffList.add("magnesite");
		}
		
		if (METALS.ardite) {
			oresOnList.add("native_ardite");
		} else {
			oresOffList.add("native_ardite");
		}
		
		if (METALS.osmium) {
			oresOnList.add("native_osmium");
		} else {
			oresOffList.add("native_osmium");
		}
		
		if (METALS.uranium) {
			oresOnList.add("pitchblende");
		} else {
			oresOffList.add("pitchblende");
		}
		
		if (METALS.manganese) {
			oresOnList.add("pyrolusite");
		} else {
			oresOffList.add("pyrolusite");
		}
		
		if (NON_METALS.rhodochrosite) {
			oresOnList.add("rhodochrosite");
		} else {
			oresOffList.add("rhodochrosite");
		}
		
		if (METALS.lithium) {
			oresOnList.add("spodumene");
		} else {
			oresOffList.add("spodumene");
		}
		
		if (METALS.antimony) {
			oresOnList.add("stibnite");
		} else {
			oresOffList.add("stibnite");
		}
		
		if (METALS.thorium) {
			oresOnList.add("thorianite");
		} else {
			oresOffList.add("thorianite");
		}
		
		if (NON_METALS.villiaumite) {
			oresOnList.add("villiaumite");
		} else {
			oresOffList.add("villiaumite");
		}
		
		if (METALS.tungsten) {
			oresOnList.add("wolframite");
		} else {
			oresOffList.add("wolframite");
		}
		
		if (METALS.zirconium) {
			oresOnList.add("zircon");
		} else {
			oresOffList.add("zircon");
		}
		
		VeinDataManager.onList = oresOnList;
		VeinDataManager.offList = oresOffList;
	}
	
	public static List<String> getOnList() {
		return onList;
	}
	
	public static List<String> getOffList() {
		return offList;
	}
	
	public static void copyVeinFile(String veinFileName, File metallumGenFile) {
		try {
			if (!metallumGenFile.exists()) {
				getLog().info("Copying " + veinFileName + ".json to config\\tfc\\metallum_ores");
				FileUtils.copyInputStreamToFile(Objects.requireNonNull(VeinRegistry.class.getClassLoader().getResourceAsStream("assets/tfcmetallum/ore_gen_data/" + veinFileName + ".json")), metallumGenFile);
			}
		} catch (IOException e) {
			throw new Error("Problem copying " + veinFileName + ".json into TFC config directory.", e);
		}
	}
	
	public static void removeVeinFile(String veinFileName, File metallumGenFile) {
		if (metallumGenFile.exists()) {
			getLog().info("Deleting " + veinFileName + ".json");
			metallumGenFile.delete();
		}
	}
}
