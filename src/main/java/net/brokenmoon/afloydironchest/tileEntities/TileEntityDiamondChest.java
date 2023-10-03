package net.brokenmoon.afloydironchest.tileEntities;

import net.minecraft.core.item.ItemStack;

public class TileEntityDiamondChest extends TileEntityBigChest {
    public TileEntityDiamondChest(){
        contents = new ItemStack[108];
    }
    @Override
    public String getInvName() {
        return "Diamond Chest";
    }

}
