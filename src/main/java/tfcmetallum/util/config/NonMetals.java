package tfcmetallum.util.config;

import static tfcmetallum.TFCMetallum.MODID;

import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.common.config.Config.RequiresMcRestart;

public class NonMetals {
	
	private static final String LANG_KEY = "config." + MODID + ".non-metals.";
	
	@RequiresMcRestart
	@Comment("Enable chromite?")
	@LangKey(LANG_KEY + "chromite")
	public boolean chromite = true;
	
	@RequiresMcRestart
	@Comment("Enable villiaumite?")
	@LangKey(LANG_KEY + "villiaumite")
	public boolean villiaumite = true;
	
	@RequiresMcRestart
	@Comment("Enable rhodochrosite?")
	@LangKey(LANG_KEY + "rhodochrosite")
	public boolean rhodochrosite = true;
	
	@RequiresMcRestart
	@Comment("Enable fluorite?")
	@LangKey(LANG_KEY + "fluorite")
	public boolean fluorite = true;
	
	@RequiresMcRestart
	@Comment("Enable carobbiite?")
	@LangKey(LANG_KEY + "carobbiite")
	public boolean carobbiite = true;
	
	@RequiresMcRestart
	@Comment("Enable arsenic?")
	@LangKey(LANG_KEY + "arsenic")
	public boolean arsenic = true;
}