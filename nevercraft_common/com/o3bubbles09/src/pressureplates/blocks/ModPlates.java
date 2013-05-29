package com.o3bubbles09.src.pressureplates.blocks;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.EnumMobType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ModPlates extends BlockPressurePlate {
    private EnumMobType triggerMob;
    
    protected ModPlates(int id, String texture, Material material, EnumMobType mobType) {
        super(id, texture, material, mobType);
        this.triggerMob = mobType;
    }

    @Override
    protected int getPowerSupply(int par1) {
        return par1 == 1 ? 30 : 0;
    }

    /**
     * Returns the current state of the pressure plate. Returns a value between 0 and 15 based on the number of items on
     * it.
     */
    protected int getPlateState(World world, int par2, int par3, int par4) {
        @SuppressWarnings("rawtypes")
        List list = null;

        if (this.triggerMob == EnumMobType.players) {
            list = world.getEntitiesWithinAABB(EntityPlayer.class, this.getSensitiveAABB(par2, par3, par4));
        }

        if (!list.isEmpty()) {
            @SuppressWarnings("rawtypes")
            Iterator iterator = list.iterator();

            while (iterator.hasNext()) {
                Entity entity = (Entity) iterator.next();

                if (!entity.doesEntityNotTriggerPressurePlate()) {
                    return 15;
                }
            }
        }

        return 0;
    }
}
