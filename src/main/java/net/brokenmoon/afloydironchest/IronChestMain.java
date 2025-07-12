package net.brokenmoon.afloydironchest;

import net.brokenmoon.afloydironchest.tileEntities.TileEntityDiamondChest;
import net.brokenmoon.afloydironchest.tileEntities.TileEntityGoldChest;
import net.brokenmoon.afloydironchest.tileEntities.TileEntityIronChest;
import net.brokenmoon.afloydironchest.tileEntities.TileEntitySteelChest;
import net.minecraft.core.util.HardIllegalArgumentException;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.server.net.handler.PacketHandlerServer;
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
        PacketHandlerServer.LOGGER.info(message);
    }

    @Override
    public void beforeGameStart() {

    }

    @Override
    public void afterGameStart() {
        try {
            EntityHelper.createTileEntity(TileEntityIronChest.class, NamespaceID.getPermanent(MOD_ID+":iron_chest"));
            EntityHelper.createTileEntity(TileEntityGoldChest.class, NamespaceID.getPermanent(MOD_ID+":gold_chest"));
            EntityHelper.createTileEntity(TileEntityDiamondChest.class, NamespaceID.getPermanent(MOD_ID+":diamond_chest"));
            EntityHelper.createTileEntity(TileEntitySteelChest.class, NamespaceID.getPermanent(MOD_ID+":steel_chest"));
        } catch (HardIllegalArgumentException e) {
            throw new RuntimeException(e);
        }

        LOGGER.info("AFloydIronChest initialized.");
    }
}
