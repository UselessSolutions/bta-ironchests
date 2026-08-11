package net.brokenmoon.afloydironchest.tileEntities;

import net.brokenmoon.afloydironchest.IronChestMain;
import net.minecraft.core.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class TileEntityDiamondChest extends TileEntityBigChest {
    public TileEntityDiamondChest(){
        contents = new ItemStack[108];
    }

    @Override
    public @NotNull String getNameTranslationKey() {
        return "container."+ IronChestMain.MOD_ID +".diamondChest.name";
    }

}
