package net.brokenmoon.afloydironchest;

import net.brokenmoon.afloydironchest.blocks.DiamondChest;
import net.brokenmoon.afloydironchest.blocks.GoldChest;
import net.brokenmoon.afloydironchest.blocks.IronChest;
import net.brokenmoon.afloydironchest.blocks.SteelChest;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Materials;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.sound.BlockSounds;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryCategory;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryPlacement;

import static net.brokenmoon.afloydironchest.IronChestMain.MOD_ID;
import static net.brokenmoon.afloydironchest.IronChestMain.config;

public class ModBlocks {
    public static Block<?> ironChest;
    public static Block<?> goldChest;
    public static Block<?> diamondChest;
    public static Block<?> steelChest;

    public static void afterBlockInit() {
        ironChest = new BlockBuilder(MOD_ID)
                .setBlockSound(BlockSounds.METAL)
                .setHardness(2.5f)
                .setTags(BlockTags.MINEABLE_BY_PICKAXE)
				.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISCELLANEOUS))
                .build("chest.iron", "iron_chest", config.getInt("ids.ironChestID"),
                        (block) -> new IronChest(block, Materials.METAL));
        goldChest = new BlockBuilder(MOD_ID)
                .setBlockSound(BlockSounds.METAL)
                .setHardness(2.5f)
                .setTags(BlockTags.MINEABLE_BY_PICKAXE)
				.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISCELLANEOUS))
                .build("chest.gold", "gold_chest", config.getInt("ids.goldChestID"),
                        (block) -> new GoldChest(block, Materials.METAL));
        diamondChest = new BlockBuilder(MOD_ID)
                .setBlockSound(BlockSounds.METAL)
                .setHardness(2.5f)
                .setTags(BlockTags.MINEABLE_BY_PICKAXE)
				.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISCELLANEOUS))
                .build("chest.diamond", "diamond_chest", config.getInt("ids.diamondChestID"),
                        (block) -> new DiamondChest(block, Materials.METAL));
        steelChest = new BlockBuilder(MOD_ID)
                .setBlockSound(BlockSounds.METAL)
                .setHardness(2.5f)
                .setTags(BlockTags.MINEABLE_BY_PICKAXE)
				.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISCELLANEOUS))
                .build("chest.steel", "steel_chest", config.getInt("ids.steelChestID"),
                        (block) -> new SteelChest(block, Materials.METAL));
    }
}
