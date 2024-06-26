package net.brokenmoon.afloydironchest;

import net.brokenmoon.afloydironchest.tileEntities.TileEntityDiamondChest;
import net.brokenmoon.afloydironchest.tileEntities.TileEntityGoldChest;
import net.brokenmoon.afloydironchest.tileEntities.TileEntityIronChest;
import net.brokenmoon.afloydironchest.tileEntities.TileEntitySteelChest;
import net.fabricmc.api.ModInitializer;
import net.minecraft.server.net.handler.NetServerHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.EntityHelper;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.GameStartEntrypoint;

import java.util.Properties;


public class IronChestMain implements GameStartEntrypoint {
    public static final String MOD_ID = "ironchest";
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



    public static void logNetwork(String message){ // Might fix some weird class missing crash
        NetServerHandler.logger.info(message);
    }

    @Override
    public void beforeGameStart() {
        ModBlocks.init();
    }

    @Override
    public void afterGameStart() {
        EntityHelper.createTileEntity(TileEntityIronChest.class, "Iron Chest");
        EntityHelper.createTileEntity(TileEntityGoldChest.class, "Gold Chest");
        EntityHelper.createTileEntity(TileEntityDiamondChest.class, "Diamond Chest");
        EntityHelper.createTileEntity(TileEntitySteelChest.class, "Steel Chest");
        LOGGER.info("AFloydIronChest initialized.");
    }
}
