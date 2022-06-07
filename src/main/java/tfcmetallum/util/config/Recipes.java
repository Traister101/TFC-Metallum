package tfcmetallum.util.config;

import static tfcmetallum.TFCMetallum.MODID;

import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.common.config.Config.RequiresMcRestart;

public class Recipes {
	
	private static final String LANG_KEY = "config." + MODID + ".recipes.";
	
	@RequiresMcRestart
	@Comment("Register ardite recipe via bloomery?")
	@LangKey(LANG_KEY + "ardite")
	public boolean ardite = true;
	
	@RequiresMcRestart
	@Comment("Register aluminium recipe via bloomery?")
	@LangKey(LANG_KEY + "aluminium")
	public boolean aluminium = true;
	
	@RequiresMcRestart
	@Comment("Register cobalt recipe via bloomery?")
	@LangKey(LANG_KEY + "cobalt")
	public boolean cobalt = true;
	
	@RequiresMcRestart
	@Comment("Register thorium recipe via bloomery?")
	@LangKey(LANG_KEY + "thorium")
	public boolean thorium = true;
	
	@RequiresMcRestart
	@Comment("Register manganese recipe via bloomery?")
	@LangKey(LANG_KEY + "manganese")
	public boolean manganese = true;
	
	@RequiresMcRestart
	@Comment("Register magnesium recipe via bloomery?")
	@LangKey(LANG_KEY + "magnesium")
	public boolean magnesium = true;
	
	@RequiresMcRestart
	@Comment("Register osmium recipe via blast furnace?")
	@LangKey(LANG_KEY + "osmium")
	public boolean osmium = true;
	
	@RequiresMcRestart
	@Comment("Register titanium recipe via blast furnace?")
	@LangKey(LANG_KEY + "titanium")
	public boolean titanium = true;
	
	@RequiresMcRestart
	@Comment("Register tungsten recipe via blast furnace?")
	@LangKey(LANG_KEY + "tungsten")
	public boolean tungsten = true;
	
	@RequiresMcRestart
	@Comment("Register beryllium recipe via blast furnace?")
	@LangKey(LANG_KEY + "beryllium")
	public boolean beryllium = true;
	
	@RequiresMcRestart
	@Comment("Register zirconium recipe via blast furnace?")
	@LangKey(LANG_KEY + "zirconium")
	public boolean zirconium = true;
	
	@RequiresMcRestart
	@Comment("Register uranium dust recipe via quern?")
	@LangKey(LANG_KEY + "uranium")
	public boolean uranium_dust = true;
	
	@RequiresMcRestart
	@Comment("Register boron dust recipe via quern?")
	@LangKey(LANG_KEY + "boron")
	public boolean boron_dust = true;
}