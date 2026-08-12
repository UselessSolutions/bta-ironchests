package net.brokenmoon.afloydironchest.tileEntities;

import net.brokenmoon.afloydironchest.IronChestMain;
import net.minecraft.core.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class TileEntityGoldChest extends TileEntityBigChest {
    public TileEntityGoldChest(){
        contents = new ItemStack[81];
    }

    @Override
    public @NotNull String getNameTranslationKey() {
        return "container."+ IronChestMain.MOD_ID +".goldChest.name";
    }
}
