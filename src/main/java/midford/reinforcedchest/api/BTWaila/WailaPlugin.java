package midford.reinforcedchest.api.BTWaila;

import midford.reinforcedchest.tileEntities.TileEntityReinforcedChest;

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
        inventory.addClass(TileEntityReinforcedChest.class);
    }
}
