package tfcmetallum.util.config;

import static tfcmetallum.TFCMetallum.MODID;

import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.common.config.Config.RangeInt;
import net.minecraftforge.common.config.Config.RequiresMcRestart;

public class MeltTemps {
	
	private static final String LANG_KEY = "config." + MODID + ".melt_temp.";
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for lithium")
	@LangKey(LANG_KEY + "lithium")
	public float lithium = 630;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for constantan")
	@LangKey(LANG_KEY + "constantan")
	public float constantan = 1200;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for electrum")
	@LangKey(LANG_KEY + "electrum")
	public float electrum = 1200;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for nickel_silver")
	@LangKey(LANG_KEY + "nickel_silver")
	public float nickel_silver = 1450;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for red_alloy")
	@LangKey(LANG_KEY + "red_alloy")
	public float red_alloy = 1080;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for invar")
	@LangKey(LANG_KEY + "invar")
	public float invar = 1450;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for thorium")
	@LangKey(LANG_KEY + "thorium")
	public float thorium = 630;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for uranium")
	@LangKey(LANG_KEY + "uranium")
	public float uranium = 3000;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for osmium")
	@LangKey(LANG_KEY + "osmium")
	public float osmium = 3025;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for titanum")
	@LangKey(LANG_KEY + "titanum")
	public float titanum = 1700;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for ardite")
	@LangKey(LANG_KEY + "ardite")
	public float ardite = 1050;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for cobalt")
	@LangKey(LANG_KEY + "cobalt")
	public float cobalt = 1495;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for manyullyn")
	@LangKey(LANG_KEY + "manyullyn")
	public float manyullyn = 1550;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for mithril")
	@LangKey(LANG_KEY + "mithril")
	public float mithril = 940;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for antimony")
	@LangKey(LANG_KEY + "antimony")
	public float antimony = 630;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for magnesium")
	@LangKey(LANG_KEY + "magnesium")
	public float magnesium = 630;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for magnesium_diboride")
	@LangKey(LANG_KEY + "magnesium_diboride")
	public float magnesium_diboride = 2000;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for manganese")
	@LangKey(LANG_KEY + "manganese")
	public float manganese = 1250;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for hsla_steel")
	@LangKey(LANG_KEY + "hsla_steel")
	public float hsla_steel = 2000;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for tungsten")
	@LangKey(LANG_KEY + "tungsten")
	public float tungsten = 3400;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for tungsten_steel")
	@LangKey(LANG_KEY + "tungsten_steel")
	public float tungsten_steel = 3695;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for zirconium")
	@LangKey(LANG_KEY + "zirconium")
	public float zirconium = 1500;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for zircaloy")
	@LangKey(LANG_KEY + "zircaloy")
	public float zircaloy = 1500;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for aluminium")
	@LangKey(LANG_KEY + "aluminium")
	public float aluminium = 660;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for beryllim")
	@LangKey(LANG_KEY + "beryllim")
	public float beryllim = 1300;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for aluminium_brass")
	@LangKey(LANG_KEY + "aluminium_brass")
	public float aluminium_brass = 630;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for beryllim_copper")
	@LangKey(LANG_KEY + "beryllim_copper")
	public float beryllim_copper = 1500;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for boron")
	@LangKey(LANG_KEY + "boron")
	public float boron = 630;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for ferroboron")
	@LangKey(LANG_KEY + "ferroboron")
	public float ferroboron = 3000;
	
	@RangeInt(min = 0)
	@RequiresMcRestart
	@Comment("Melting temp for tough")
	@LangKey(LANG_KEY + "tough")
	public float tough = 3000;
}