package net.brokenmoon.afloydironchest;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.event.defs.ClientEvents;
import turniplabs.halplibe.util.dependency.Key;

import static net.brokenmoon.afloydironchest.IronChestMain.MOD_ID;

public class IronChestClient  implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitializeClient() {
		ClientEvents.BLOCK_MODEL_RELOAD.listen(Key.of(MOD_ID),(t)->new ModModels().initBlockModels(t));
	}
}
