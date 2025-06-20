package net.brokenmoon.afloydironchest.blocks;

import net.brokenmoon.afloydironchest.MixinInterfaces.IEntityPlayer;
import net.brokenmoon.afloydironchest.tileEntities.TileEntityDiamondChest;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.player.inventory.container.Container;


public class DiamondChest extends IronChest{

    public DiamondChest(Block<?> block, Material material) {
        super(block, material);
        block.withEntity(TileEntityDiamondChest::new);
    }

    public void displayGui(Player player, Container inventory){
        ((IEntityPlayer)player).afloydironchest$displayGUIDiamondChest(inventory);
    }
}
