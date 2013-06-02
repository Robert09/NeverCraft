package NeverCraft.nevercraft_common.com.nevercraft.src.creativetabs;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabNeverCraft extends CreativeTabs {

    public TabNeverCraft(int par1, String par2Str) {
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
