package net.brokenmoon.afloydironchest;

import net.brokenmoon.afloydironchest.blocks.DiamondChest;
import net.brokenmoon.afloydironchest.blocks.GoldChest;
import net.brokenmoon.afloydironchest.blocks.IronChest;
import net.brokenmoon.afloydironchest.blocks.SteelChest;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.sound.block.BlockSounds;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.server.net.handler.NetServerHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.RecipeHelper;
import turniplabs.halplibe.util.ConfigHandler;

import java.util.Properties;


public class IronChestMain implements ModInitializer {
    public static final String MOD_ID = "ironchest";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final ConfigHandler config;
    static {
        // Config
        Properties prop = new Properties();
        prop.setProperty("ids.ironChestID", "1500");
        prop.setProperty("ids.goldChestID", "1501");
        prop.setProperty("ids.diamondChestID", "1502");
        prop.setProperty("ids.steelChestID", "1503");
        prop.setProperty("ids.diamondWindowID", "21");
        config = new ConfigHandler(MOD_ID, prop);
    }

    public static final Block ironChest = new BlockBuilder(MOD_ID)
            .setSideTextures("ironchestside.png")
            .setNorthTexture("ironchestfront.png")
            .setTopTexture("ironchesttop.png")
            .setBottomTexture("ironchestbottom.png")
            .setBlockSound(BlockSounds.METAL)
            .setHardness(2.5f)
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new IronChest("chest.iron",config.getInt("ids.ironChestID"), Material.metal));
    public static final Block goldChest = new BlockBuilder(MOD_ID)
            .setSideTextures("goldchestside.png")
            .setNorthTexture("goldchestfront.png")
            .setTopTexture("goldchesttop.png")
            .setBottomTexture("goldchestbottom.png")
            .setBlockSound(BlockSounds.METAL)
            .setHardness(2.5f)
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new GoldChest("chest.gold",config.getInt("ids.goldChestID"), Material.metal));
    public static final Block diamondChest = new BlockBuilder(MOD_ID)
            .setSideTextures("diamondchestside.png")
            .setNorthTexture("diamondchestfront.png")
            .setTopTexture("diamondchesttop.png")
            .setBottomTexture("diamondchestbottom.png")
            .setBlockSound(BlockSounds.METAL)
            .setHardness(2.5f)
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new DiamondChest("chest.diamond",config.getInt("ids.diamondChestID"), Material.metal));
    public static final Block steelChest = new BlockBuilder(MOD_ID)
            .setSideTextures("steelchestside.png")
            .setNorthTexture("steelchestfront.png")
            .setTopTexture("steelchesttop.png")
            .setBottomTexture("steelchestbottom.png")
            .setBlockSound(BlockSounds.METAL)
            .setHardness(2.5f)
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new SteelChest("chest.steel",config.getInt("ids.steelChestID"), Material.metal));

    @Override
    public void onInitialize() {
        LOGGER.info("AFloydIronChest initialized.");
        //Recipes
        RecipeHelper.craftingManager.addRecipe(new ItemStack(ironChest, 1),true, false, new Object[]{
                "AAA",
                "ABA",
                "AAA",
                'A', Item.ingotIron,
                'B', Block.chestPlanksOak
        });
        RecipeHelper.craftingManager.addRecipe(new ItemStack(ironChest, 1),true,false, new Object[]{
                "AAA",
                "ABA",
                "AAA",
                'A', Item.ingotIron,
                'B', Block.chestPlanksOakPainted
        });
        RecipeHelper.Crafting.createRecipe(goldChest, 1, new Object[]{
                "AAA",
                "ABA",
                "AAA",
                'A', Item.ingotGold,
                'B', ironChest
        });
        RecipeHelper.Crafting.createRecipe(diamondChest, 1, new Object[]{
                "AAA",
                "ABA",
                "AAA",
                'A', Item.diamond,
                'B', goldChest
        });
        RecipeHelper.Crafting.createRecipe(steelChest, 1, new Object[]{
                "AAA",
                "ABA",
                "AAA",
                'A', Item.ingotSteel,
                'B', goldChest
        });
    }
    public static void logNetwork(String message){ // Might fix some weird class missing crash
        NetServerHandler.logger.info(message);
    }
}