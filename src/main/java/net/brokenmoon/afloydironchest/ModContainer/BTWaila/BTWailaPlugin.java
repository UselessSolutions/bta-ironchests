package net.brokenmoon.afloydironchest.ModContainer.BTWaila;

import org.slf4j.Logger;
import toufoumaster.btwaila.BTWailaCustomTootltipPlugin;

public class BTWailaPlugin implements BTWailaCustomTootltipPlugin {
    @Override
    public void initializePlugin(Logger logger) {
        new IronChestTooltip().addTooltip();
    }
}
