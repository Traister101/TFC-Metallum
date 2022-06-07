package tfcmetallum.util.config;

import static tfcmetallum.TFCMetallum.MODID;

import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.common.config.Config.RequiresMcRestart;

public class Metals {
	
	private static final String LANG_KEY = "config." + MODID + ".metals.";
	
	@RequiresMcRestart
	@Comment("Enable antimony metal?")
	@LangKey(LANG_KEY + "antimony")
	public boolean antimony = true;
	
	@RequiresMcRestart
	@Comment("Enable lithuium metal?")
	@LangKey(LANG_KEY + "lithium")
	public boolean lithium = true;
	
	@RequiresMcRestart
	@Comment("Enable constantan alloy?")
	@LangKey(LANG_KEY + "constantan")
	public boolean constantan = true;
	
	@RequiresMcRestart
	@Comment("Enable electrum alloy?")
	@LangKey(LANG_KEY + "electrum")
	public boolean electrum = true;

	@RequiresMcRestart
	@Comment("Enable nickel silver alloy?")
	@LangKey(LANG_KEY + "nickel_silver")
	public boolean nickel_silver = true;

	@RequiresMcRestart
	@Comment("Enable red alloy?")
	@LangKey(LANG_KEY + "red_alloy")
	public boolean red_alloy = true;

	@RequiresMcRestart
	@Comment("Enable mithril alloy?")
	@LangKey(LANG_KEY + "mithril")
	public boolean mithril = true;

	@RequiresMcRestart
	@Comment("Enable invar alloy?")
	@LangKey(LANG_KEY + "invar")
	public boolean invar = true;

	@RequiresMcRestart
	@Comment("Enable aluminium metal?")
	@LangKey(LANG_KEY + "aluminium")
	public boolean aluminium = true;

	@RequiresMcRestart
	@Comment("Enable aluminium brass alloy?")
	@LangKey(LANG_KEY + "aluminium_brass")
	public boolean aluminium_brass = true;

	@RequiresMcRestart
	@Comment("Enable magnesium metal?")
	@LangKey(LANG_KEY + "magnesium")
	public boolean magnesium = true;

	@RequiresMcRestart
	@Comment("Enable manganese metal?")
	@LangKey(LANG_KEY + "manganese")
	public boolean manganese = true;

	@RequiresMcRestart
	@Comment("Enable boron metal?")
	@LangKey(LANG_KEY + "boron")
	public boolean boron = true;

	@RequiresMcRestart
	@Comment("Enable magnesium diboride alloy?")
	@LangKey(LANG_KEY + "magnesium_diboride")
	public boolean magnesium_diboride = true;

	@RequiresMcRestart
	@Comment("Enable thorium metal?")
	@LangKey(LANG_KEY + "thorium")
	public boolean thorium = true;

	@RequiresMcRestart
	@Comment("Enable uranium metal?")
	@LangKey(LANG_KEY + "uranium")
	public boolean uranium = true;

	@RequiresMcRestart
	@Comment("Enable ardite metal?")
	@LangKey(LANG_KEY + "ardite")
	public boolean ardite = true;

	@RequiresMcRestart
	@Comment("Enable cobalt metal?")
	@LangKey(LANG_KEY + "cobalt")
	public boolean cobalt = true;

	@RequiresMcRestart
	@Comment("Enable manyullyn alloy?")
	@LangKey(LANG_KEY + "manyullyn")
	public boolean manyullyn = true;

	@RequiresMcRestart
	@Comment("Enable hsla steel alloy?")
	@LangKey(LANG_KEY + "hsla_steel")
	public boolean hsla_steel = true;

	@RequiresMcRestart
	@Comment("Enable ferroboron alloy?")
	@LangKey(LANG_KEY + "ferroboron")
	public boolean ferroboron = true;

	@RequiresMcRestart
	@Comment("Enable beryllim metal?")
	@LangKey(LANG_KEY + "beryllim")
	public boolean beryllim = true;

	@RequiresMcRestart
	@Comment("Enable beryllim copper alloy?")
	@LangKey(LANG_KEY + "beryllim_copper")
	public boolean beryllim_copper = true;

	@RequiresMcRestart
	@Comment("Enable osmium metal?")
	@LangKey(LANG_KEY + "osmium")
	public boolean osmium = true;

	@RequiresMcRestart
	@Comment("Enable titanum metal?")
	@LangKey(LANG_KEY + "titanum")
	public boolean titanum = true;

	@RequiresMcRestart
	@Comment("Enable tungsten metal?")
	@LangKey(LANG_KEY + "tungsten")
	public boolean tungsten = true;

	@RequiresMcRestart
	@Comment("Enable tungsten steel alloy?")
	@LangKey(LANG_KEY + "tungsten_steel")
	public boolean tungsten_steel = true;

	@RequiresMcRestart
	@Comment("Enable zirconium metal?")
	@LangKey(LANG_KEY + "zirconium")
	public boolean zirconium = true;

	@RequiresMcRestart
	@Comment("Enable zircaloy metal?")
	@LangKey(LANG_KEY + "zircaloy")
	public boolean zircaloy = true;

	@RequiresMcRestart
	@Comment("Enable tough alloy?")
	@LangKey(LANG_KEY + "tough")
	public boolean tough_alloy = true;
}