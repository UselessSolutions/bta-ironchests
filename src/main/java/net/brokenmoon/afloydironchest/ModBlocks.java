package net.brokenmoon.afloydironchest;

import net.brokenmoon.afloydironchest.blocks.DiamondChest;
import net.brokenmoon.afloydironchest.blocks.GoldChest;
import net.brokenmoon.afloydironchest.blocks.IronChest;
import net.brokenmoon.afloydironchest.blocks.SteelChest;
import net.minecraft.client.render.block.model.BlockModelHorizontalRotation;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.Item;
import net.minecraft.core.sound.BlockSounds;
import turniplabs.halplibe.helper.BlockBuilder;

import static net.brokenmoon.afloydironchest.IronChestMain.MOD_ID;
import static net.brokenmoon.afloydironchest.IronChestMain.config;

public class ModBlocks {
    public static final Block ironChest = new BlockBuilder(MOD_ID)
        .setSideTextures(MOD_ID + ":block/ironchestside")
        .setNorthTexture(MOD_ID + ":block/ironchestfront")
        .setTopTexture(MOD_ID + ":block/ironchesttop")
        .setBottomTexture(MOD_ID + ":block/ironchestbottom")
        .setBlockModel(BlockModelHorizontalRotation::new)
        .setBlockSound(BlockSounds.METAL)
        .setHardness(2.5f)
        .setTags(BlockTags.MINEABLE_BY_PICKAXE)
        .build(new IronChest("chest.iron",config.getInt("ids.ironChestID"), Material.metal));
    public static final Block goldChest = new BlockBuilder(MOD_ID)
        .setSideTextures(MOD_ID + ":block/goldchestside")
        .setNorthTexture(MOD_ID + ":block/goldchestfront")
        .setTopTexture(MOD_ID + ":block/goldchesttop")
        .setBottomTexture(MOD_ID + ":block/goldchestbottom")
        .setBlockModel(BlockModelHorizontalRotation::new)
        .setBlockSound(BlockSounds.METAL)
        .setHardness(2.5f)
        .setTags(BlockTags.MINEABLE_BY_PICKAXE)
        .build(new GoldChest("chest.gold",config.getInt("ids.goldChestID"), Material.metal));
    public static final Block diamondChest = new BlockBuilder(MOD_ID)
        .setSideTextures(MOD_ID + ":block/diamondchestside")
        .setNorthTexture(MOD_ID + ":block/diamondchestfront")
        .setTopTexture(MOD_ID + ":block/diamondchesttop")
        .setBottomTexture(MOD_ID + ":block/diamondchestbottom")
        .setBlockModel(BlockModelHorizontalRotation::new)
        .setBlockSound(BlockSounds.METAL)
        .setHardness(2.5f)
        .setTags(BlockTags.MINEABLE_BY_PICKAXE)
        .build(new DiamondChest("chest.diamond",config.getInt("ids.diamondChestID"), Material.metal));
    public static final Block steelChest = new BlockBuilder(MOD_ID)
        .setSideTextures(MOD_ID + ":block/steelchestside")
        .setNorthTexture(MOD_ID + ":block/steelchestfront")
        .setTopTexture(MOD_ID + ":block/steelchesttop")
        .setBottomTexture(MOD_ID + ":block/steelchestbottom")
        .setBlockModel(BlockModelHorizontalRotation::new)
        .setBlockSound(BlockSounds.METAL)
        .setHardness(2.5f)
        .setTags(BlockTags.MINEABLE_BY_PICKAXE)
        .build(new SteelChest("chest.steel",config.getInt("ids.steelChestID"), Material.metal));
    public static void init(){
        if (Item.seat == null){
            throw new RuntimeException();
        }
    }
}
