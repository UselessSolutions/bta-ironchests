package net.brokenmoon.afloydironchest.tileEntities;

import net.minecraft.core.item.ItemStack;

public class TileEntitySteelChest extends TileEntityBigChest {
    public TileEntitySteelChest(){
        contents = new ItemStack[108];
    }    @Override
    public String getInvName() {
        return "Steel Chest";
    }
}
