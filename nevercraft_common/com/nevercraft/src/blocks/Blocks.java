package com.nevercraft.src.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.EnumMobType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.nevercraft.src.NeverCraft;
import com.nevercraft.src.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks {
    // Pressure Plates.
    public static Block obsidianPlate,
    glowstonePlate,
    camoPlate, 
    
    // Other Blocks.
    frugalOre
    ;
    
    public Blocks() {
        init();
    }
    
    private static void init() {
        // Pressure Plates.
        obsidianPlate = new ModPlates(NeverCraft.obsidianPlateID, "obsidian", Material.rock, EnumMobType.players).setHardness(50.0F).setResistance(2000.0F).setStepSound(Block.soundStoneFootstep);
        glowstonePlate = new ModPlates(NeverCraft.glowstonePlateID, "lightgem", Material.glass, EnumMobType.players).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setLightValue(1.0F);
        
        // Other Blocks.
        frugalOre = new NeverCraftBlocks(NeverCraft.furgalOreID, Material.ground, "FrugalOre").setHardness(4.0F).setCreativeTab(NeverCraft.tabNeverCraft).setLightValue(0.2F).setUnlocalizedName("FrugalOre");
        
        initRecipes();
        addName();
        registerBlock();
    }
    
    // Add recipes in this method.
    private static void initRecipes() {
        GameRegistry.addRecipe(new ItemStack(obsidianPlate, 1), new Object[] {
            "oo", 'o', Block.obsidian
        });
        
        GameRegistry.addRecipe(new ItemStack(glowstonePlate, 1), new Object[] {
            "oo", 'o', Block.glowStone
        });
    }
    
    // Give blocks name in this method.
    private static void addName() {
        LanguageRegistry.addName(obsidianPlate, Strings.OBSIDIANPLATE_IGN);
        LanguageRegistry.addName(glowstonePlate, Strings.GLOWSTONEPLATE_IGN);
        
        LanguageRegistry.addName(frugalOre, "Frugal Ore");
    }
    
    // Register Blocks in this method.
    private static void registerBlock() {
        GameRegistry.registerBlock(obsidianPlate, Strings.OBSIDIANPLATE);
        GameRegistry.registerBlock(glowstonePlate, Strings.GLOWSTONEPLATE);
        
        GameRegistry.registerBlock(frugalOre, "FurgalOre");
    }
}
