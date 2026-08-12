package net.brokenmoon.afloydironchest;

import net.fabricmc.api.ClientModInitializer;
import turniplabs.halplibe.event.defs.ClientEvents;
import turniplabs.halplibe.util.dependency.Key;

import static net.brokenmoon.afloydironchest.IronChestMain.LOGGER;
import static net.brokenmoon.afloydironchest.IronChestMain.MOD_ID;

public class IronChestClient  implements ClientModInitializer {


	@Override
	public void onInitializeClient() {
		LOGGER.info("Initializing Client Classes for "+MOD_ID+".");
		ClientEvents.BLOCK_MODEL_RELOAD.listen(Key.of(MOD_ID),(t)->new ModModels().initBlockModels(t));
	}
}
