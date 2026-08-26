package net.brokenmoon.afloydironchest;

import net.brokenmoon.afloydironchest.tileEntities.TileEntityDiamondChest;
import net.brokenmoon.afloydironchest.tileEntities.TileEntityGoldChest;
import net.brokenmoon.afloydironchest.tileEntities.TileEntityIronChest;
import net.brokenmoon.afloydironchest.tileEntities.TileEntitySteelChest;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.server.net.handler.PacketHandlerServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.HalpLibe;
import turniplabs.halplibe.event.defs.CommonEvents;
import turniplabs.halplibe.helper.EntityHelper;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.dependency.Key;

import java.util.Properties;


public class IronChestMain implements ModInitializer {
    public static final String MOD_ID = HalpLibe.registerMod("ironchest",true);
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final ConfigHandler config;
    static {
        // Config
        Properties prop = new Properties();
        prop.setProperty("ids.ironChestID", "2500");
        prop.setProperty("ids.goldChestID", "2501");
        prop.setProperty("ids.diamondChestID", "2502");
        prop.setProperty("ids.steelChestID", "2503");
        prop.setProperty("ids.diamondWindowID", "21");
        config = new ConfigHandler(MOD_ID, prop);
    }

	@Override
	public void onInitialize() {
		CommonEvents.AFTER_BLOCK_INIT.listen(Key.of(MOD_ID),ModBlocks::afterBlockInit);
		CommonEvents.RECIPES_READY.listen(Key.of(MOD_ID),IronChestRecipes::onRecipesReady);
		CommonEvents.RECIPES_NAMESPACE_INIT.listen(Key.of(MOD_ID),IronChestRecipes::initNamespaces);
		CommonEvents.BEFORE_GAME_START.listen(Key.of(MOD_ID),this::beforeGameStart);
		EntityHelper.addMapping(TileEntityIronChest.class,new NamespaceID(MOD_ID,"iron_chest"));
		EntityHelper.addMapping(TileEntityGoldChest.class,new NamespaceID(MOD_ID,"gold_chest"));
		EntityHelper.addMapping(TileEntityDiamondChest.class,new NamespaceID(MOD_ID,"diamond_chest"));
		EntityHelper.addMapping(TileEntitySteelChest.class,new NamespaceID(MOD_ID,"steel_chest"));
	}


    public static void logNetwork(String message){ // Might fix some weird class missing crash
        PacketHandlerServer.LOGGER.info(message);
    }


    public void beforeGameStart() {
		LOGGER.info("AFloydIronChest initialized.");
    }


    public void afterGameStart() {

    }

}
