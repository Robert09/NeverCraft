package com.nevercraft.src.creativetabs;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabNeverCraft extends CreativeTabs {

    public CreativeTabNeverCraft(int par1, String par2Str) {
        super(par1, par2Str);
    }
    
    @SideOnly(Side.CLIENT)
    public int getTabItemIndex() {
        return Block.endPortal.blockID;
    }

    public String getTranslatedTabLabel() {
        return "NeverCraft";
    }
}
