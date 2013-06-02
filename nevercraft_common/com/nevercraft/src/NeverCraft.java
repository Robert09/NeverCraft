package NeverCraft.nevercraft_common.com.nevercraft.src;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
import NeverCraft.nevercraft_common.com.nevercraft.src.blocks.Blocks;
import NeverCraft.nevercraft_common.com.nevercraft.src.blocks.WorldGenNeverCraft;
import NeverCraft.nevercraft_common.com.nevercraft.src.creativetabs.TabNeverCraft;
import NeverCraft.nevercraft_common.com.nevercraft.src.lib.BlockIds;
import NeverCraft.nevercraft_common.com.nevercraft.src.lib.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class NeverCraft {
    // Pressure Plate Ids
    public static int obsidianPlateID,
    glowstonePlateID,
    
    // Other Block Ids
    furgalOreID
    ;
    
    // Creative Tabs
    public static CreativeTabs tabNeverCraft = new TabNeverCraft(CreativeTabs.getNextID(),"DeverionXTabGems");
    
    @Instance(Reference.MOD_ID)
    public static NeverCraft instance;
    
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @PreInit
    public static void preInit(FMLPreInitializationEvent event) {
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        
        // Pressure Plates
        obsidianPlateID = config.get("Blocks", "Obsidian Pressure Plate", BlockIds.OBSIDIAN_PLATE).getInt();
        glowstonePlateID = config.get("Blocks", "TNT Pressure Plate", BlockIds.GLOWSTONE_PLATE).getInt();
        
        // Other
        furgalOreID = config.get("Blocks", "Frugal", BlockIds.FRUGAL_ORE).getInt();
        
        config.save();
    }

    @Init
    public static void init(FMLInitializationEvent event) {
        Blocks block = new Blocks();
        
        GameRegistry.registerWorldGenerator(new WorldGenNeverCraft());
        
        proxy.registerTileEntities();
    }

    @PostInit
    public static void postInit(FMLPostInitializationEvent event) {

    }

}
