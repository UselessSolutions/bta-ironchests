package midford.reinforcedchest.blocks;

import midford.reinforcedchest.MixinInterfaces.IEntityPlayer;
import midford.reinforcedchest.tileEntities.TileEntityReinforcedChest;
import net.brokenmoon.afloydironchest.blocks.IronChest;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.player.inventory.container.Container;


public class ReinforcedChest extends IronChest {

    public ReinforcedChest(Block<?> block, Material material) {
        super(block, material);
        block.withEntity(TileEntityReinforcedChest::new);
    }

    public void displayGui(Player player, Container inventory){
        ((IEntityPlayer)player).reinforcedchest$displayGUIReinforcedChest(inventory);
    }
}
