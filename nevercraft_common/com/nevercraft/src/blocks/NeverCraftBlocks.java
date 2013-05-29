package com.nevercraft.src.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class NeverCraftBlocks extends Block {
    private String blockTexture;

    public NeverCraftBlocks(int par1, Material par2Material, String par3String) {
        super(par1, par2Material);

        this.blockTexture = par3String;
    }

    @SideOnly(Side.CLIENT)
    public void func_94332_a(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon("Blocks/" + this.blockTexture + ".png");
    }
}