package net.brokenmoon.afloydironchest.api.BTWaila;

import net.brokenmoon.afloydironchest.tileEntities.TileEntityBigChest;
import net.brokenmoon.afloydironchest.tileEntities.TileEntityDiamondChest;
import net.brokenmoon.afloydironchest.tileEntities.TileEntityGoldChest;
import net.brokenmoon.afloydironchest.tileEntities.TileEntityIronChest;
import net.brokenmoon.afloydironchest.tileEntities.TileEntitySteelChest;

import net.minecraft.core.player.inventory.container.Container;
import org.slf4j.Logger;
import toufoumaster.btwaila.entryplugins.waila.BTWailaCustomTooltipPlugin;
import toufoumaster.btwaila.entryplugins.waila.BTWailaPlugin;
import toufoumaster.btwaila.tooltips.TileTooltip;
import toufoumaster.btwaila.tooltips.TooltipRegistry;

public class WailaPlugin implements BTWailaCustomTooltipPlugin {
    @Override
    public void initializePlugin(TooltipRegistry tooltipRegistry, Logger logger) {
        TileTooltip<Container> inventory = BTWailaPlugin.INVENTORY;
        inventory.addClass(TileEntityBigChest.class);
        inventory.addClass(TileEntityDiamondChest.class);
        inventory.addClass(TileEntityGoldChest.class);
        inventory.addClass(TileEntityIronChest.class);
        inventory.addClass(TileEntitySteelChest.class);
    }
}
