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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.RecipeHelper;
import turniplabs.halplibe.util.ConfigHandler;

import java.io.*;
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

    public static final Block IronChest = new BlockBuilder(MOD_ID)
            .setSideTextures("ironchestside.png")
            .setNorthTexture("ironchestfront.png")
            .setTopTexture("ironchesttop.png")
            .setBottomTexture("ironchestbottom.png")
            .setBlockSound(BlockSounds.METAL)
            .setHardness(2.5f)
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new IronChest("chest.iron",config.getInt("ids.ironChestID"), Material.metal));
    public static final Block GoldChest = new BlockBuilder(MOD_ID)
            .setSideTextures("goldchestside.png")
            .setNorthTexture("goldchestfront.png")
            .setTopTexture("goldchesttop.png")
            .setBottomTexture("goldchestbottom.png")
            .setBlockSound(BlockSounds.METAL)
            .setHardness(2.5f)
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new GoldChest("chest.gold",config.getInt("ids.goldChestID"), Material.metal));
    public static final Block DiamondChest = new BlockBuilder(MOD_ID)
            .setSideTextures("diamondchestside.png")
            .setNorthTexture("diamondchestfront.png")
            .setTopTexture("diamondchesttop.png")
            .setBottomTexture("diamondchestbottom.png")
            .setBlockSound(BlockSounds.METAL)
            .setHardness(2.5f)
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new DiamondChest("chest.diamond",config.getInt("ids.diamondChestID"), Material.metal));
    public static final Block SteelChest = new BlockBuilder(MOD_ID)
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
        RecipeHelper.Crafting.createRecipe(IronChest, 1, new Object[]{
                "AAA",
                "ABA",
                "AAA",
                'A', Item.ingotIron,
                'B', Block.chestPlanksOak
        });
        RecipeHelper.Crafting.createRecipe(IronChest, 1, new Object[]{
                "AAA",
                "ABA",
                "AAA",
                'A', Item.ingotIron,
                'B', Block.chestPlanksOakPainted
        });
        RecipeHelper.Crafting.createRecipe(GoldChest, 1, new Object[]{
                "AAA",
                "ABA",
                "AAA",
                'A', Item.ingotGold,
                'B', IronChest
        });
        RecipeHelper.Crafting.createRecipe(DiamondChest, 1, new Object[]{
                "AAA",
                "ABA",
                "AAA",
                'A', Item.diamond,
                'B', GoldChest
        });
        RecipeHelper.Crafting.createRecipe(SteelChest, 1, new Object[]{
                "AAA",
                "ABA",
                "AAA",
                'A', Item.ingotSteel,
                'B', GoldChest
        });
    }
}