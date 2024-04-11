package net.brokenmoon.afloydironchest;

import net.brokenmoon.afloydironchest.blocks.DiamondChest;
import net.brokenmoon.afloydironchest.blocks.GoldChest;
import net.brokenmoon.afloydironchest.blocks.IronChest;
import net.brokenmoon.afloydironchest.blocks.SteelChest;
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
    public static void init(){
        if (Item.seat == null){
            throw new RuntimeException();
        }
    }
}
