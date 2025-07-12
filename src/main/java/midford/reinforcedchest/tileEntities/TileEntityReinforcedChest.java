package midford.reinforcedchest.tileEntities;

import midford.reinforcedchest.IronChestMain;
import net.brokenmoon.afloydironchest.tileEntities.TileEntityBigChest;
import net.minecraft.core.item.ItemStack;

public class TileEntityReinforcedChest extends TileEntityBigChest {
    public TileEntityReinforcedChest(){
        contents = new ItemStack[26*9];
    }
    @Override
    public String getNameTranslationKey() {
        return "container."+ IronChestMain.MOD_ID +".reinforcedChest.name";
    }
}
