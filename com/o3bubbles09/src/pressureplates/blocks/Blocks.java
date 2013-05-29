package com.o3bubbles09.src.pressureplates.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.EnumMobType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.o3bubbles09.src.pressureplates.PressurePlates;
import com.o3bubbles09.src.pressureplates.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks {
    private static Block obsidianPlate,
    glowstonePlate,
    camoPlate;
    
    public static PressurePlates plates;
    public static World world;
    
    public static int x, y, z;
    
    private String camo;
    
    public Blocks() {
        init();
    }
    
    private static void init() {
        obsidianPlate = new ModPlates(PressurePlates.obsidianPlateID, "obsidian", Material.rock, EnumMobType.players).setHardness(50.0F).setResistance(2000.0F).setStepSound(Block.soundStoneFootstep);
        glowstonePlate = new ModPlates(PressurePlates.glowstonePlateID, "lightgem", Material.glass, EnumMobType.players).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setLightValue(1.0F);
        
        initRecipes();
        addName();
        registerBlock();
    }
    
    private static void initRecipes() {
        GameRegistry.addRecipe(new ItemStack(obsidianPlate, 1), new Object[] {
            "oo", 'o', Block.obsidian
        });
        
        GameRegistry.addRecipe(new ItemStack(glowstonePlate, 1), new Object[] {
            "oo", 'o', Block.glowStone
        });
    }
    
    private static void addName() {
        LanguageRegistry.addName(obsidianPlate, Strings.OBSIDIANPLATE_IGN);
        LanguageRegistry.addName(glowstonePlate, Strings.GLOWSTONEPLATE_IGN);
    }
    
    private static void registerBlock() {
        GameRegistry.registerBlock(obsidianPlate, Strings.OBSIDIANPLATE);
        GameRegistry.registerBlock(glowstonePlate, Strings.GLOWSTONEPLATE);
    }
}
