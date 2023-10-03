package net.brokenmoon.afloydironchest.tileEntities;

import net.minecraft.core.item.ItemStack;
public class TileEntityIronChest extends TileEntityBigChest {
    public TileEntityIronChest(){
        contents = new ItemStack[54];
    }
    @Override
    public String getInvName() {
        return "Iron Chest";
    }
}
