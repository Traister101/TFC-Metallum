package tfcmetallum.objects.recipes;

import static tfcmetallum.ConfigTFCM.METALS;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;
import tfcmetallum.util.IsObtainable;

public class ConditionalFactory implements IConditionFactory {
	
	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) {
		
		String type = JsonUtils.getString(json, "config");
		
		switch (type) {
		case "aluminium":
			return () -> METALS.aluminium;
		case "beryllium_copper":
			return () -> IsObtainable.beryllim_copper;
		case "boron":
			return () -> METALS.boron;
		case "cobalt":
			return () -> METALS.cobalt;
		case "invar":
			return () -> METALS.invar;
		case "manyullyn":
			return () -> IsObtainable.manyullyn;
		case "mithril":
			return () -> IsObtainable.mithril;
		case "nickel_silver":
			return () -> METALS.nickel_silver;
		case "osmium":
			return () -> METALS.osmium;
		case "titanium":
			return () -> METALS.titanum;
		case "tungsten":
			return () -> METALS.tungsten;
		case "tungsten_steel":
			return () -> IsObtainable.tungsten_steel;
		case "zircaloy":
			return () -> IsObtainable.zircaloy;
		default:
			return () -> false;
		}
	}
}