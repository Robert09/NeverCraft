package com.o3bubbles09.src.pressureplates;

import net.minecraftforge.common.Configuration;

import com.o3bubbles09.src.pressureplates.blocks.Blocks;
import com.o3bubbles09.src.pressureplates.lib.BlockIds;
import com.o3bubbles09.src.pressureplates.lib.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class PressurePlates {
    // Id variables
    public static int obsidianPlateID,
    glowstonePlateID;
    
    @Instance(Reference.MOD_ID)
    public static PressurePlates instance;
    
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @PreInit
    public static void preInit(FMLPreInitializationEvent event) {
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        
        obsidianPlateID = config.get("Blocks", "Obsidian Pressure Plate", BlockIds.OBSIDIAN_PLATE).getInt();
        glowstonePlateID = config.get("Blocks", "TNT Pressure Plate", BlockIds.GLOWSTONE_PLATE).getInt();
        
        config.save();
    }

    @Init
    public static void init(FMLInitializationEvent event) {
        Blocks block = new Blocks();
        
        proxy.registerTileEntities();
    }

    @PostInit
    public static void postInit(FMLPostInitializationEvent event) {

    }

}
