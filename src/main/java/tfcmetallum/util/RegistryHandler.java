package tfcmetallum.util;

import static net.dries007.tfc.TerraFirmaCraft.MOD_ID;
import static net.dries007.tfc.api.types.Metal.ItemType.INGOT;
import static net.dries007.tfc.types.DefaultMetals.COPPER;
import static net.dries007.tfc.types.DefaultMetals.GOLD;
import static net.dries007.tfc.types.DefaultMetals.NICKEL;
import static net.dries007.tfc.types.DefaultMetals.SILVER;
import static net.dries007.tfc.types.DefaultMetals.STEEL;
import static net.dries007.tfc.types.DefaultMetals.TIN;
import static net.dries007.tfc.types.DefaultMetals.WROUGHT_IRON;
import static net.dries007.tfc.types.DefaultMetals.ZINC;
import static net.dries007.tfc.util.forge.ForgeRule.HIT_LAST;
import static net.dries007.tfc.util.forge.ForgeRule.HIT_SECOND_LAST;
import static net.dries007.tfc.util.forge.ForgeRule.HIT_THIRD_LAST;
import static tfcmetallum.ConfigTFCM.MELT_TEMP;
import static tfcmetallum.ConfigTFCM.METALS;
import static tfcmetallum.ConfigTFCM.NON_METALS;
import static tfcmetallum.ConfigTFCM.RECIPES;

import net.dries007.tfc.ConfigTFC;
import net.dries007.tfc.api.capability.forge.CapabilityForgeable;
import net.dries007.tfc.api.capability.forge.IForgeable;
import net.dries007.tfc.api.capability.forge.IForgeableMeasurableMetal;
import net.dries007.tfc.api.recipes.AlloyRecipe;
import net.dries007.tfc.api.recipes.BlastFurnaceRecipe;
import net.dries007.tfc.api.recipes.BloomeryRecipe;
import net.dries007.tfc.api.recipes.anvil.AnvilRecipe;
import net.dries007.tfc.api.recipes.quern.QuernRecipe;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.registries.TFCRegistryEvent;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.api.types.Metal.ItemType;
import net.dries007.tfc.api.types.Ore;
import net.dries007.tfc.objects.Powder;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.dries007.tfc.objects.items.ItemPowder;
import net.dries007.tfc.objects.items.ItemsTFC;
import net.dries007.tfc.objects.items.itemblock.ItemBlockMetalLamp;
import net.dries007.tfc.objects.items.metal.ItemMetal;
import net.dries007.tfc.util.OreDictionaryHelper;
import net.dries007.tfc.util.fuel.FuelManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;
import tfcmetallum.TFCMetallum;
import tfcmetallum.objects.ArmorMaterialsTFCM;
import tfcmetallum.objects.ToolMaterialsTFCM;

@SuppressWarnings({"unused", "WeakerAccess"})
@EventBusSubscriber(modid = TFCMetallum.MODID)
public final class RegistryHandler {
	
    //Metals
	public static final ResourceLocation ALUMINIUM = new ResourceLocation(MOD_ID, "aluminium");
    public static final ResourceLocation ALUMINIUM_BRASS = new ResourceLocation(MOD_ID, "aluminium_brass");
    public static final ResourceLocation ANTIMONY = new ResourceLocation(MOD_ID, "antimony");
    public static final ResourceLocation ARDITE = new ResourceLocation(MOD_ID, "ardite");
    public static final ResourceLocation COBALT = new ResourceLocation(MOD_ID, "cobalt");
    public static final ResourceLocation CONSTANTAN = new ResourceLocation(MOD_ID, "constantan");
    public static final ResourceLocation ELECTRUM = new ResourceLocation(MOD_ID, "electrum");
    public static final ResourceLocation INVAR = new ResourceLocation(MOD_ID, "invar");
    public static final ResourceLocation MANYULLYN = new ResourceLocation(MOD_ID, "manyullyn");
    public static final ResourceLocation MITHRIL = new ResourceLocation(MOD_ID, "mithril");
    public static final ResourceLocation OSMIUM = new ResourceLocation(MOD_ID, "osmium");
    public static final ResourceLocation TITANIUM = new ResourceLocation(MOD_ID, "titanium");
    public static final ResourceLocation TUNGSTEN = new ResourceLocation(MOD_ID, "tungsten");
    public static final ResourceLocation TUNGSTEN_STEEL = new ResourceLocation(MOD_ID, "tungsten_steel");
    public static final ResourceLocation NICKEL_SILVER = new ResourceLocation(MOD_ID, "nickel_silver"); // Copper + zinc + nickel
    public static final ResourceLocation RED_ALLOY = new ResourceLocation(MOD_ID, "red_alloy"); // Copper + redstone (although not obtainable with just TFC + metallum
    public static final ResourceLocation BORON = new ResourceLocation(MOD_ID, "boron");
    public static final ResourceLocation FERROBORON = new ResourceLocation(MOD_ID, "ferroboron"); // steel + boron
    public static final ResourceLocation THORIUM = new ResourceLocation(MOD_ID, "thorium");
    public static final ResourceLocation LITHIUM = new ResourceLocation(MOD_ID, "lithium");
    public static final ResourceLocation MANGANESE = new ResourceLocation(MOD_ID, "manganese");
    public static final ResourceLocation MAGNESIUM = new ResourceLocation(MOD_ID, "magnesium");
    public static final ResourceLocation BERYLLIUM = new ResourceLocation(MOD_ID, "beryllium");
    public static final ResourceLocation BERYLLIUM_COPPER = new ResourceLocation(MOD_ID, "beryllium_copper"); // Copper + beryllium + aluminium
    public static final ResourceLocation ZIRCONIUM = new ResourceLocation(MOD_ID, "zirconium");
    public static final ResourceLocation ZIRCALOY = new ResourceLocation(MOD_ID, "zircaloy"); // zirconium + tin
    public static final ResourceLocation HSLA_STEEL = new ResourceLocation(MOD_ID, "hsla_steel"); // steel + manganese
    public static final ResourceLocation MAGNESIUM_DIBORIDE = new ResourceLocation(MOD_ID, "magnesium_diboride"); // magnesium + steel
    public static final ResourceLocation TOUGH_ALLOY = new ResourceLocation(MOD_ID, "tough_alloy"); // Ferroboron + lithium
    public static final ResourceLocation URANIUM = new ResourceLocation(MOD_ID, "uranium");

    //Ores
    public static final ResourceLocation NATIVE_ARDITE = new ResourceLocation(MOD_ID, "native_ardite");
    public static final ResourceLocation NATIVE_OSMIUM = new ResourceLocation(MOD_ID, "native_osmium");
    public static final ResourceLocation BAUXITE = new ResourceLocation(MOD_ID, "bauxite"); // aluminium / titanium
    public static final ResourceLocation WOLFRAMITE = new ResourceLocation(MOD_ID, "wolframite"); // tungsten
    public static final ResourceLocation COBALTITE = new ResourceLocation(MOD_ID, "cobaltite"); // cobalt
    public static final ResourceLocation STIBNITE = new ResourceLocation(MOD_ID, "stibnite"); // antimony
    public static final ResourceLocation RUTILE = new ResourceLocation(MOD_ID, "rutile"); // titanium
    public static final ResourceLocation TETRABORATE = new ResourceLocation(MOD_ID, "tetraborate"); // boron
    public static final ResourceLocation SPODUMENE = new ResourceLocation(MOD_ID, "spodumene"); // lithium
    public static final ResourceLocation THORIANITE = new ResourceLocation(MOD_ID, "thorianite"); // thorium
    public static final ResourceLocation PYROLUSITE = new ResourceLocation(MOD_ID, "pyrolusite"); // manganese
    public static final ResourceLocation MAGNESITE = new ResourceLocation(MOD_ID, "magnesite"); //magnesium
    public static final ResourceLocation BERYL = new ResourceLocation(MOD_ID, "beryl"); //beryllium
    public static final ResourceLocation ZIRCON = new ResourceLocation(MOD_ID, "zircon"); // zirconium

    //Ore without TFC-M metals
    public static final ResourceLocation CHROMITE = new ResourceLocation(MOD_ID, "chromite"); // chrome
    public static final ResourceLocation VILLIAUMITE = new ResourceLocation(MOD_ID, "villiaumite");
    public static final ResourceLocation RHODOCHROSITE = new ResourceLocation(MOD_ID, "rhodochrosite");
    public static final ResourceLocation FLUORITE = new ResourceLocation(MOD_ID, "fluorite");
    public static final ResourceLocation CAROBBIITE = new ResourceLocation(MOD_ID, "carobbiite");
    public static final ResourceLocation ARSENIC = new ResourceLocation(MOD_ID, "arsenic");
    
    
    @SubscribeEvent
    public static void onPreRegisterMetal(TFCRegistryEvent.RegisterPreBlock<Metal> event) {
    	
        IForgeRegistry<Metal> r = event.getRegistry();
        TFCMetallum.getLog().info("The below warnings about unintended overrides are normal. The override is intended. ;)");
        
        if (METALS.lithium) {
        	r.register(new Metal(LITHIUM, Metal.Tier.TIER_II, true, 0.25f, MELT_TEMP.lithium, 0xC9CBC3, null, null));
        }
        
        if (METALS.constantan) {
        	r.register(new Metal(CONSTANTAN, Metal.Tier.TIER_II, true, 0.5f, MELT_TEMP.constantan, 0xFFD28874, null, null));
        }
        
        if (METALS.electrum) {
        	r.register(new Metal(ELECTRUM, Metal.Tier.TIER_II, true, 0.5f, MELT_TEMP.electrum, 0xFFDFB950, null, null));
        }
        
        if (METALS.nickel_silver) {
        	r.register(new Metal(NICKEL_SILVER, Metal.Tier.TIER_II, true, 0.35f, MELT_TEMP.nickel_silver, 0xFFA4A4A5, ToolMaterialsTFCM.NICKEL_SILVER, ArmorMaterialsTFCM.NICKEL_SILVER));
        }
        
        if (METALS.red_alloy) {
        	r.register(new Metal(RED_ALLOY, Metal.Tier.TIER_II, true, 0.35f, MELT_TEMP.red_alloy, 0xFFDA6E6E, null, null));
        }
        
        if (METALS.invar) {	
        	r.register(new Metal(INVAR, Metal.Tier.TIER_III, true, 0.35f, MELT_TEMP.invar, 0xFFAAAA9E, ToolMaterialsTFCM.INVAR, ArmorMaterialsTFCM.INVAR));
        }
        
        if (METALS.thorium) {
        	r.register(new Metal(THORIUM, Metal.Tier.TIER_III, true, 0.3f, MELT_TEMP.thorium, 0xFF3D4548, null, null));
        }
        
        if (METALS.uranium) {
        	r.register(new Metal(URANIUM, Metal.Tier.TIER_III, true, 0.3f, MELT_TEMP.uranium, 0xFF3A6724, null, null));
        }
        
        if (METALS.osmium) {
        	r.register(new Metal(OSMIUM, Metal.Tier.TIER_VI, true, 0.35f, MELT_TEMP.osmium, 0xFFB8D8DE, ToolMaterialsTFCM.OSMIUM, ArmorMaterialsTFCM.OSMIUM));
        }
        
        if (METALS.titanum) {
        	r.register(new Metal(TITANIUM, Metal.Tier.TIER_VI, true, 0.3f, MELT_TEMP.titanum, 0xFFC2C4CC, ToolMaterialsTFCM.TITANIUM, ArmorMaterialsTFCM.TITANIUM));
        }
        
        if (IsObtainable.manyullyn) {
        	r.register(new Metal(ARDITE, Metal.Tier.TIER_III, true, 0.3f, MELT_TEMP.ardite, 0xFFF09614, null, null));
        	r.register(new Metal(COBALT, Metal.Tier.TIER_III, true, 0.3f, MELT_TEMP.cobalt, 0xFF6CA6E5, ToolMaterialsTFCM.COBALT, ArmorMaterialsTFCM.COBALT));        	
        	r.register(new Metal(MANYULLYN, Metal.Tier.TIER_IV, true, 0.3f, MELT_TEMP.manyullyn, 0xFFB052C0, ToolMaterialsTFCM.MANYULLYN, ArmorMaterialsTFCM.MANYULLYN));
        	
        } else {
        	if (METALS.ardite) {
            	r.register(new Metal(ARDITE, Metal.Tier.TIER_III, true, 0.3f, MELT_TEMP.ardite, 0xFFF09614, null, null));
            }
        	
        	if (METALS.cobalt) {	
            	r.register(new Metal(COBALT, Metal.Tier.TIER_III, true, 0.3f, MELT_TEMP.cobalt, 0xFF6CA6E5, ToolMaterialsTFCM.COBALT, ArmorMaterialsTFCM.COBALT));
            }
        }
        
        if (IsObtainable.mithril) {
            r.register(new Metal(ANTIMONY, Metal.Tier.TIER_I, true, 0.25f, MELT_TEMP.antimony, 0xFFE7E7F5, null, null));
            r.register(new Metal(MITHRIL, Metal.Tier.TIER_II, true, 0.35f, MELT_TEMP.mithril, 0xFF8ADAF6, ToolMaterialsTFCM.MITHRIL, ArmorMaterialsTFCM.MITHRIL));
            
        } else if (METALS.antimony) {
        	r.register(new Metal(ANTIMONY, Metal.Tier.TIER_I, true, 0.25f, MELT_TEMP.antimony, 0xFFE7E7F5, null, null));
        }
        
        if (IsObtainable.magnesium_diboride) {	
        	r.register(new Metal(MAGNESIUM, Metal.Tier.TIER_III, true, 0.30f, MELT_TEMP.magnesium, 0xFF978195, null, null));
            r.register(new Metal(MAGNESIUM_DIBORIDE, Metal.Tier.TIER_III, true, 0.35f, MELT_TEMP.magnesium_diboride, 0xFF46391E, null, null));
            
        } else if (METALS.magnesium) {
        	r.register(new Metal(MAGNESIUM, Metal.Tier.TIER_III, true, 0.30f, MELT_TEMP.magnesium, 0xFF978195, null, null));
        }
        
        if (IsObtainable.hsla_steel) {	
        	r.register(new Metal(MANGANESE, Metal.Tier.TIER_III, true, 0.29f, MELT_TEMP.manganese, 0xFF9397A8, null, null));
        	r.register(new Metal(HSLA_STEEL, Metal.Tier.TIER_V, true, 0.35f, MELT_TEMP.hsla_steel, 0xFF3F4180, null, null));
        	
        } else if (METALS.manganese) {
        	r.register(new Metal(MANGANESE, Metal.Tier.TIER_III, true, 0.29f, MELT_TEMP.manganese, 0xFF9397A8, null, null));
        }
        
        if (IsObtainable.tungsten_steel) {
        	r.register(new Metal(TUNGSTEN, Metal.Tier.TIER_VI, true, 0.2f, MELT_TEMP.tungsten, 0xFF41454B, ToolMaterialsTFCM.TUNGSTEN, ArmorMaterialsTFCM.TUNGSTEN));
        	r.register(new Metal(TUNGSTEN_STEEL, Metal.Tier.TIER_VI, true, 0.2f, MELT_TEMP.tungsten_steel, 0xFF565F6E, ToolMaterialsTFCM.TUNGSTEN_STEEL, ArmorMaterialsTFCM.TUNGSTEN_STEEL));
        	
        } else if (METALS.tungsten) {
        	r.register(new Metal(TUNGSTEN, Metal.Tier.TIER_VI, true, 0.2f, MELT_TEMP.tungsten, 0xFF41454B, ToolMaterialsTFCM.TUNGSTEN, ArmorMaterialsTFCM.TUNGSTEN));
        }
        
        if (IsObtainable.zircaloy) {	
        	r.register(new Metal(ZIRCONIUM, Metal.Tier.TIER_VI, true, 0.35f, MELT_TEMP.zirconium, 0xFF747527, null, null));
        	r.register(new Metal(ZIRCALOY, Metal.Tier.TIER_VI, true, 0.35f, MELT_TEMP.zircaloy, 0xFF43423A, ToolMaterialsTFCM.ZIRCALOY, ArmorMaterialsTFCM.ZIRCALOY));
        	
        } else if (METALS.zirconium) {
        	r.register(new Metal(ZIRCONIUM, Metal.Tier.TIER_VI, true, 0.35f, MELT_TEMP.zirconium, 0xFF747527, null, null));
        }
        
        if (IsObtainable.aluminium_brass && IsObtainable.beryllim_copper) {
        	r.register(new Metal(ALUMINIUM, Metal.Tier.TIER_III, true, 0.3f, MELT_TEMP.aluminium, 0xFFD9FBFC, ToolMaterialsTFCM.ALUMINIUM, ArmorMaterialsTFCM.ALUMINIUM));
        	r.register(new Metal(BERYLLIUM, Metal.Tier.TIER_VI, true, 0.35f, MELT_TEMP.beryllim, 0xFFE4EADA, null, null));
        	r.register(new Metal(ALUMINIUM_BRASS, Metal.Tier.TIER_III, true, 0.3f, MELT_TEMP.aluminium_brass, 0xFFDCDABE, null, null));
        	r.register(new Metal(BERYLLIUM_COPPER, Metal.Tier.TIER_VI, true, 0.35f, MELT_TEMP.beryllim_copper, 0xFFEAAE90, ToolMaterialsTFCM.BERYLLIUM_COPPER, ArmorMaterialsTFCM.BERYLLIUM_COPPER));
        	
        } else {
        	
        	if (IsObtainable.beryllim_copper) {	
        		r.register(new Metal(BERYLLIUM_COPPER, Metal.Tier.TIER_VI, true, 0.35f, MELT_TEMP.beryllim_copper, 0xFFEAAE90, ToolMaterialsTFCM.BERYLLIUM_COPPER, ArmorMaterialsTFCM.BERYLLIUM_COPPER));
        		r.register(new Metal(BERYLLIUM, Metal.Tier.TIER_VI, true, 0.35f, MELT_TEMP.beryllim, 0xFFE4EADA, null, null));
        		
        	} else if (METALS.beryllim) {
        		r.register(new Metal(BERYLLIUM, Metal.Tier.TIER_VI, true, 0.35f, MELT_TEMP.beryllim, 0xFFE4EADA, null, null));
        	}

        	if (IsObtainable.aluminium_brass) {
        		r.register(new Metal(ALUMINIUM, Metal.Tier.TIER_III, true, 0.3f, MELT_TEMP.aluminium, 0xFFD9FBFC, ToolMaterialsTFCM.ALUMINIUM, ArmorMaterialsTFCM.ALUMINIUM));
        		r.register(new Metal(ALUMINIUM_BRASS, Metal.Tier.TIER_III, true, 0.3f, MELT_TEMP.aluminium_brass, 0xFFDCDABE, null, null));
        		
        	} else if (METALS.aluminium) {
        		r.register(new Metal(ALUMINIUM, Metal.Tier.TIER_III, true, 0.3f, MELT_TEMP.aluminium, 0xFFD9FBFC, ToolMaterialsTFCM.ALUMINIUM, ArmorMaterialsTFCM.ALUMINIUM));
        	}
        }
        
        if (IsObtainable.tough_alloy) {
        	r.register(new Metal(BORON, Metal.Tier.TIER_III, true, 0.3f, MELT_TEMP.boron, 0xFF252525, ToolMaterialsTFCM.BORON, ArmorMaterialsTFCM.BORON));
        	r.register(new Metal(FERROBORON, Metal.Tier.TIER_V, true, 0.3f, MELT_TEMP.ferroboron, 0xFF4B4B4B, null, null));
        	r.register(new Metal(TOUGH_ALLOY, Metal.Tier.TIER_VI, true, 0.3f, MELT_TEMP.tough, 0xFF3F2B61, null, null));
        	
        } else if (IsObtainable.ferroboron) {
        	r.register(new Metal(BORON, Metal.Tier.TIER_III, true, 0.3f, MELT_TEMP.boron, 0xFF252525, ToolMaterialsTFCM.BORON, ArmorMaterialsTFCM.BORON));
        	r.register(new Metal(FERROBORON, Metal.Tier.TIER_V, true, 0.3f, MELT_TEMP.ferroboron, 0xFF4B4B4B, null, null));

        } else if (METALS.boron) {
        	r.register(new Metal(BORON, Metal.Tier.TIER_III, true, 0.3f, MELT_TEMP.boron, 0xFF252525, ToolMaterialsTFCM.BORON, ArmorMaterialsTFCM.BORON));
        }
    }


    @SubscribeEvent
    public static void onPreRegisterOre(TFCRegistryEvent.RegisterPreBlock<Ore> event) {
    	
        IForgeRegistry<Ore> r = event.getRegistry();
        
        //  Ores which *could* be melted directly if it's temperature is met
        if (METALS.antimony) {
        	r.register(new Ore(STIBNITE, ANTIMONY, true));
        }
        		
        if (METALS.lithium) {
        	r.register(new Ore(SPODUMENE, LITHIUM, true));
        }
                
        // Ores which we add tools, armor and textures inside TFC realm, but can't be melted directly by default (processing by other mods required)
        if (METALS.ardite) {
        	r.register(new Ore(NATIVE_ARDITE, ARDITE, false));
        }
        
        if (METALS.osmium) {
        	r.register(new Ore(NATIVE_OSMIUM, OSMIUM, false));
        }
        
        if (METALS.aluminium) {
        	r.register(new Ore(BAUXITE, ALUMINIUM, false));
        }
        
        if (METALS.tungsten) {
        	r.register(new Ore(WOLFRAMITE, TUNGSTEN, false));
        }
        
        if (METALS.cobalt) {
        	r.register(new Ore(COBALTITE, COBALT, false));
        }
        
        if (METALS.titanum) {
        	r.register(new Ore(RUTILE, TITANIUM, false));
        }
        
        if (METALS.thorium) {
        	r.register(new Ore(THORIANITE, THORIUM, false));
        }
        
        if (METALS.manganese) {
        	r.register(new Ore(PYROLUSITE, MANGANESE, false));
        }
        
        if (METALS.magnesium) {
        	r.register(new Ore(MAGNESITE, MAGNESIUM, false));
        }
        
        if (METALS.zirconium) {
        	r.register(new Ore(ZIRCON, ZIRCONIUM, false));
        }
        
        // Ores without metals registered inside TFC
        if (NON_METALS.chromite) {
        	r.register(new Ore(CHROMITE));
        }
        
        if (NON_METALS.villiaumite) {
        	r.register(new Ore(VILLIAUMITE));
        }
        
        if (NON_METALS.rhodochrosite) {
        	r.register(new Ore(RHODOCHROSITE));
        }
        
        if (NON_METALS.fluorite) {
        	r.register(new Ore(FLUORITE));
        }
        
        if (NON_METALS.carobbiite) {
        	r.register(new Ore(CAROBBIITE));
        }
        
        if (NON_METALS.arsenic) {
        	r.register(new Ore(ARSENIC));
        }
    }	
    
    @SubscribeEvent
    public static void onRegisterAlloyRecipe(RegistryEvent.Register<AlloyRecipe> event) {
    	
        IForgeRegistry<AlloyRecipe> r = event.getRegistry();
        
        if (METALS.constantan) {
        	r.register(new AlloyRecipe.Builder(CONSTANTAN).add(COPPER, 0.4, 0.6).add(NICKEL, 0.4, 0.6).build());
        }
        
        if (METALS.electrum) {
        	r.register(new AlloyRecipe.Builder(ELECTRUM).add(GOLD, 0.4, 0.6).add(SILVER, 0.4, 0.6).build());
        }
        
        if (METALS.invar) {
        	r.register(new AlloyRecipe.Builder(INVAR).add(WROUGHT_IRON, 0.6, 0.7).add(NICKEL, 0.3, 0.4).build());
        }
        
        if (METALS.nickel_silver) {
        	r.register(new AlloyRecipe.Builder(NICKEL_SILVER).add(COPPER, 0.50, 0.65).add(ZINC, 0.1, 0.3).add(NICKEL, 0.1, 0.3).build());
        }
        
        if (IsObtainable.aluminium_brass && IsObtainable.beryllim_copper) {
        	r.register(new AlloyRecipe.Builder(ALUMINIUM_BRASS).add(ALUMINIUM, 0.65, 0.85).add(COPPER, 0.15, 0.35).build());
        	r.register(new AlloyRecipe.Builder(BERYLLIUM_COPPER).add(BERYLLIUM, 0.3, 0.6).add(COPPER, 0.3, 0.6).add(ALUMINIUM, 0.1, 0.3).build());
        	
        } else {
        	if (IsObtainable.aluminium_brass) {
        		r.register(new AlloyRecipe.Builder(ALUMINIUM_BRASS).add(ALUMINIUM, 0.65, 0.85).add(COPPER, 0.15, 0.35).build());
        	}
        	
        	if (IsObtainable.beryllim_copper) {
            	r.register(new AlloyRecipe.Builder(BERYLLIUM_COPPER).add(BERYLLIUM, 0.3, 0.6).add(COPPER, 0.3, 0.6).add(ALUMINIUM, 0.1, 0.3).build());
        	}
        }
        
        if (IsObtainable.manyullyn) {
        	r.register(new AlloyRecipe.Builder(MANYULLYN).add(COBALT, 0.4, 0.6).add(ARDITE, 0.4, 0.6).build());
        }
        
        if (IsObtainable.mithril) {
        	r.register(new AlloyRecipe.Builder(MITHRIL).add(COPPER, 0.88, 0.92).add(ANTIMONY, 0.08, 0.12).build());
        }
        
        if (IsObtainable.tungsten_steel) {
        	r.register(new AlloyRecipe.Builder(TUNGSTEN_STEEL).add(TUNGSTEN, 0.02, 0.18).add(STEEL, 0.72, 0.98).build());
        }
        
        if (IsObtainable.tough_alloy) {
        	r.register(new AlloyRecipe.Builder(FERROBORON).add(STEEL, 0.4, 0.6).add(BORON, 0.4, 0.6).build());
        	r.register(new AlloyRecipe.Builder(TOUGH_ALLOY).add(FERROBORON, 0.4, 0.6).add(LITHIUM, 0.4, 0.6).build());
        	
        } else if (IsObtainable.ferroboron) {
        	r.register(new AlloyRecipe.Builder(FERROBORON).add(STEEL, 0.4, 0.6).add(BORON, 0.4, 0.6).build());
        }
        
        if (IsObtainable.magnesium_diboride) {
        	r.register(new AlloyRecipe.Builder(MAGNESIUM_DIBORIDE).add(BORON, 0.4, 0.6).add(MAGNESIUM, 0.2, 0.4).build());
        }
        
        if (IsObtainable.magnesium_diboride) {
        	r.register(new AlloyRecipe.Builder(HSLA_STEEL).add(STEEL, 0.4, 0.6).add(MANGANESE, 0.4, 0.6).build());
        }
        
        if (IsObtainable.zircaloy) {
        	r.register(new AlloyRecipe.Builder(ZIRCALOY).add(ZIRCONIUM, 0.72, 0.98).add(TIN, 0.2, 0.4).build());
        }
    }

    @SuppressWarnings("ConstantConditions")
    @SubscribeEvent
    public static void onRegisterBloomeryRecipeEvent(RegistryEvent.Register<BloomeryRecipe> event) {
    	
        IForgeRegistry<BloomeryRecipe> registry = event.getRegistry();
        
        if (METALS.aluminium && RECIPES.aluminium) {
        	registry.register(new BloomeryRecipe(TFCRegistries.METALS.getValue(ALUMINIUM), FuelManager::isItemBloomeryFuel));
        }
        
        if (METALS.ardite && RECIPES.ardite) {
        	registry.register(new BloomeryRecipe(TFCRegistries.METALS.getValue(ARDITE), FuelManager::isItemBloomeryFuel));
        }
        
        if (METALS.cobalt && RECIPES.cobalt) {
        	registry.register(new BloomeryRecipe(TFCRegistries.METALS.getValue(COBALT), FuelManager::isItemBloomeryFuel));
        }
        
        if (METALS.thorium && RECIPES.thorium) {
        	registry.register(new BloomeryRecipe(TFCRegistries.METALS.getValue(THORIUM), FuelManager::isItemBloomeryFuel));
        }
        
        if (METALS.manganese && RECIPES.manganese) {
        	registry.register(new BloomeryRecipe(TFCRegistries.METALS.getValue(MANGANESE), FuelManager::isItemBloomeryFuel));
        }
        
        if (METALS.magnesium && RECIPES.magnesium) {
        	registry.register(new BloomeryRecipe(TFCRegistries.METALS.getValue(MAGNESIUM), FuelManager::isItemBloomeryFuel));
        }
    }

    @SubscribeEvent
    public static void onRegisterBlastFurnaceRecipeEvent(RegistryEvent.Register<BlastFurnaceRecipe> event) {
    	
        IForgeRegistry<BlastFurnaceRecipe> registry = event.getRegistry();
        
        if (METALS.osmium && RECIPES.osmium) {
        	Metal osmium = TFCRegistries.METALS.getValue(OSMIUM);
        	if (osmium != null) {
        		registry.register(new BlastFurnaceRecipe(osmium, osmium, IIngredient.of("dustFlux")));
        	}
        }
        
        if (METALS.titanum && RECIPES.titanium) {
        	Metal titanium = TFCRegistries.METALS.getValue(TITANIUM);
        	if (titanium != null) {
        		registry.register(new BlastFurnaceRecipe(titanium, titanium, IIngredient.of("dustFlux")));
        	}
        }
        
        if (METALS.tungsten && RECIPES.tungsten) {
        	Metal tungsten = TFCRegistries.METALS.getValue(TUNGSTEN);
        	if (tungsten != null) {
        		registry.register(new BlastFurnaceRecipe(tungsten, tungsten, IIngredient.of("dustFlux")));
        	}
        }
        
        if (METALS.beryllim && RECIPES.beryllium) {
        	Metal beryllium = TFCRegistries.METALS.getValue(BERYLLIUM);
        	if (beryllium != null) {
        		registry.register(new BlastFurnaceRecipe(beryllium, beryllium, IIngredient.of("dustFlux")));
        	}
        }
        
        if (METALS.zirconium && RECIPES.zirconium) {
        	Metal zirconium = TFCRegistries.METALS.getValue(ZIRCONIUM);
        	if (zirconium != null) {
        		registry.register(new BlastFurnaceRecipe(zirconium, zirconium, IIngredient.of("dustFlux")));
        	}
        }
    }

    @SubscribeEvent
    public static void onRegisterAnvilRecipeEvent(RegistryEvent.Register<AnvilRecipe> event) {
    	
        IForgeRegistry<AnvilRecipe> r = event.getRegistry();
        
        if (METALS.aluminium && RECIPES.aluminium) {
        	Metal aluminium = TFCRegistries.METALS.getValue(ALUMINIUM);
        	if (aluminium != null) {
        		r.register(new AnvilRecipe(new ResourceLocation(TFCMetallum.MODID, "aluminium_bloom"),
        				getBloomIngredient(aluminium),
        				new ItemStack(ItemMetal.get(aluminium, INGOT)),
        				Metal.Tier.TIER_II, null, HIT_LAST, HIT_SECOND_LAST, HIT_THIRD_LAST));
        	}
        }
        
        if (METALS.ardite && RECIPES.ardite) {
        	Metal ardite = TFCRegistries.METALS.getValue(ARDITE);
        	if (ardite != null) {
        		r.register(new AnvilRecipe(new ResourceLocation(TFCMetallum.MODID, "ardite_bloom"),
        				getBloomIngredient(ardite),
        				new ItemStack(ItemMetal.get(ardite, INGOT)),
        				Metal.Tier.TIER_II, null, HIT_LAST, HIT_SECOND_LAST, HIT_THIRD_LAST));
        	}
        }
        
        if (METALS.cobalt && RECIPES.cobalt) {
        	Metal cobalt = TFCRegistries.METALS.getValue(COBALT);
        	if (cobalt != null) {
        		r.register(new AnvilRecipe(new ResourceLocation(TFCMetallum.MODID, "cobalt_bloom"),
        				getBloomIngredient(cobalt),
        				new ItemStack(ItemMetal.get(cobalt, INGOT)),
        				Metal.Tier.TIER_II, null, HIT_LAST, HIT_SECOND_LAST, HIT_THIRD_LAST));
        	}
        }
        
        if (METALS.thorium && RECIPES.thorium) {
        	Metal thorium = TFCRegistries.METALS.getValue(THORIUM);
        	if (thorium != null) {
        		r.register(new AnvilRecipe(new ResourceLocation(TFCMetallum.MODID, "thorium_bloom"),
        				getBloomIngredient(thorium),
        				new ItemStack(ItemMetal.get(thorium, INGOT)),
        				Metal.Tier.TIER_II, null, HIT_LAST, HIT_SECOND_LAST, HIT_THIRD_LAST));
        	}            
        }
        
        if (METALS.magnesium && RECIPES.magnesium) {
        	Metal magnesium = TFCRegistries.METALS.getValue(MAGNESIUM);
        	if (magnesium != null) {
        		r.register(new AnvilRecipe(new ResourceLocation(TFCMetallum.MODID, "magnesium_bloom"),
        				getBloomIngredient(magnesium),
        				new ItemStack(ItemMetal.get(magnesium, INGOT)),
        				Metal.Tier.TIER_II, null, HIT_LAST, HIT_SECOND_LAST, HIT_THIRD_LAST));
        	}
        }
        
        if (METALS.manganese && RECIPES.manganese) {
        	Metal manganese = TFCRegistries.METALS.getValue(MANGANESE);
        	if (manganese != null) {
        		r.register(new AnvilRecipe(new ResourceLocation(TFCMetallum.MODID, "manganese_bloom"),
        				getBloomIngredient(manganese),
        				new ItemStack(ItemMetal.get(manganese, INGOT)),
        				Metal.Tier.TIER_II, null, HIT_LAST, HIT_SECOND_LAST, HIT_THIRD_LAST));
        	}
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    	
        // Register "aluminum" ore dict (because american mod-dev people are dumb, the international standard is Alumin"i"um, period)
        // And yes, we have to run it here because some mods are dumber: instead of querying ore dictionary at run time they do after item registration.
    	if (METALS.aluminium) {
    		
    		Metal aluminium = TFCRegistries.METALS.getValue(ALUMINIUM);
            if (aluminium != null) {
                for (ItemType type : ItemType.values()) {
                	
                    Item metalItem = ItemMetal.get(aluminium, type);
                    if (metalItem != null && !(metalItem instanceof ItemBlockMetalLamp)) {
                    	
                        if (type == Metal.ItemType.DOUBLE_INGOT) {
                            OreDictionary.registerOre(OreDictionaryHelper.toString("ingot", "double", "aluminum"), metalItem);
                        } else if (type == Metal.ItemType.DOUBLE_SHEET) {
                            OreDictionary.registerOre(OreDictionaryHelper.toString( "sheet", "double", "aluminum"), metalItem);
                        }else if (!type.isToolItem()) {
                            OreDictionary.registerOre(OreDictionaryHelper.toString( type, "aluminum"), metalItem);
                            if (type == Metal.ItemType.SHEET && ConfigTFC.General.MISC.dictionaryPlates) {
                                OreDictionary.registerOre(OreDictionaryHelper.toString( "plate", "aluminum"), metalItem);
                            }
                        }
                    }
                }
            }
    	}
    }

    @SubscribeEvent
    public static void onRegisterQuernRecipeEvent(RegistryEvent.Register<QuernRecipe> event) {
    	
        IForgeRegistry<QuernRecipe> r = event.getRegistry();
        
        if (METALS.uranium && RECIPES.uranium_dust) {            
        	Metal uranium = TFCRegistries.METALS.getValue(URANIUM);
        	if (uranium != null) {
        		r.register(new QuernRecipe(IIngredient.of("gemPitchblende"), new ItemStack(ItemMetal.get(uranium, ItemType.DUST), 4)).setRegistryName("uranium_dust"));
        	}
        }
        
        if (METALS.boron && RECIPES.boron_dust) {
        	Metal boron = TFCRegistries.METALS.getValue(BORON);
        	if (boron != null) {
        		IForgeRegistryModifiable<QuernRecipe> modRegistry = (IForgeRegistryModifiable<QuernRecipe>) TFCRegistries.QUERN;
        		
        		modRegistry.remove(new ResourceLocation(MOD_ID, "borax"));
        		r.register(new QuernRecipe(IIngredient.of("gemBorax"), new ItemStack(ItemMetal.get(boron, ItemType.DUST), 4)).setRegistryName("boron_dust"));
        	}
        }
        r.register(new QuernRecipe(IIngredient.of("gemFluorite"), new ItemStack(ItemPowder.get(Powder.FLUX), 6)).setRegistryName("fluorite_flux"));
    }
    
    private static IIngredient<ItemStack> getBloomIngredient(Metal metal) {
        return x -> 
        {
            if (x.getItem() == ItemsTFC.REFINED_BLOOM) {
                IForgeable cap = x.getCapability(CapabilityForgeable.FORGEABLE_CAPABILITY, null);
                if (cap instanceof IForgeableMeasurableMetal) {
                    return ((IForgeableMeasurableMetal) cap).getMetal() == metal && ((IForgeableMeasurableMetal) cap).getMetalAmount() == 100;
                }
            }
            return false;
        };
    }
}
