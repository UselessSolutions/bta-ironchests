package net.brokenmoon.afloydironchest.blocks;

import net.brokenmoon.afloydironchest.MixinInterfaces.IEntityPlayer;
import net.brokenmoon.afloydironchest.tileEntities.TileEntitySteelChest;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.player.inventory.container.Container;


public class SteelChest extends IronChest{
    public SteelChest(Block<?> block, Material material) {
        super(block, material);
        block.withEntity(TileEntitySteelChest::new);
    }

    public void displayGui(Player player, Container inventory){
        ((IEntityPlayer)player).afloydironchest$displayGUIDiamondChest(inventory);
    }
}
