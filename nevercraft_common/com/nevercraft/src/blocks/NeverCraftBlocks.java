package NeverCraft.nevercraft_common.com.nevercraft.src.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import NeverCraft.nevercraft_common.com.nevercraft.src.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NeverCraftBlocks extends Block {
    private String blockTexture;

    public NeverCraftBlocks(int par1, Material par2Material, String par3String) {
        super(par1, par2Material);

        this.blockTexture = par3String;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        blockIcon = par1IconRegister.registerIcon(Reference.MOD_ID.toString() + ":" + blockTexture);
    }
}