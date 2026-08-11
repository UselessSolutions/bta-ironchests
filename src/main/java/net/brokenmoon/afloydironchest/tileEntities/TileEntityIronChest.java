package net.brokenmoon.afloydironchest.tileEntities;

import net.brokenmoon.afloydironchest.IronChestMain;
import net.minecraft.core.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class TileEntityIronChest extends TileEntityBigChest {
    public TileEntityIronChest(){
        contents = new ItemStack[54];
    }

    @Override
    public @NotNull String getNameTranslationKey() {
        return "container."+ IronChestMain.MOD_ID +".ironChest.name";
    }
}
