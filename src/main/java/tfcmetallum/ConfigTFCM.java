package tfcmetallum;

import static tfcmetallum.TFCMetallum.MODID;
import static tfcmetallum.TFCMetallum.NAME;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.common.config.Config.RequiresMcRestart;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tfcmetallum.util.config.*;

@LangKey("config." + MODID + ".general")
@EventBusSubscriber(modid = MODID)		// Might wanna do a prettier file name. This will "reset" config for users
@Config(modid = MODID, type = Type.INSTANCE/*, name = NAME*/)
public final class ConfigTFCM {

	protected static final String LANG_KEY = "config." + MODID + ".general";

	@SubscribeEvent
	public static void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.getModID().equals(MODID)) {
			ConfigManager.sync(MODID, Type.INSTANCE);
		}
	}
	
	@Comment("Recipe configuration")
	@LangKey("config." + MODID + ".recipes")
	public static final Recipes RECIPES = new Recipes();
	
	@Comment({
		"Configuration for melting temperatures. Values higher than around 2000 are not reachable in base TFC.",
		"Warming starts at 1, ends at 80", "Hot starts at 80, ends at 210",
		"Very Hot starts at 210, ends at 480", "Faint Red starts at 480, ends at 580",
		"Dark Red starts at 580, ends at 730", "Bright Red starts at 730, ends at 930",
		"Orange starts at 930, ends at 1100", "Yellow starts at 1100, ends at 1300",
		"Yellow White starts at 1300, ends at 1400", "White starts at 1400, ends at 1500",
		"Brilliant White starts at 1500"})
	@LangKey("config." + MODID + ".melt_temps")
	public static final MeltTemps MELT_TEMP = new MeltTemps();
	
	@Comment("Metals configuration. Alloys will be disabled if any of the metals included are disabled")
	@LangKey("config." + MODID + ".metals")
	public static final Metals METALS = new Metals();
	
	@Comment("Non-Metals configuration")
	@LangKey("config." + MODID + ".non-metals")
	public static final NonMetals NON_METALS = new NonMetals();
	
	@Comment("Vein config")
	@LangKey("config." + MODID + ".veins")
	public static final Veins VEINS = new Veins();
	
	public static class Veins {
		
		@RequiresMcRestart
		@Comment({"Disable this if you are doing custom vein data", "(make sure to remove the ones you no longer need)"})
		@LangKey("config." + MODID + ".veins.manage")
		public boolean manage = true;
	}
}