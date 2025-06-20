package net.brokenmoon.afloydironchest;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.Items;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class IronChestRecipes implements RecipeEntrypoint {
    @Override
    public void onRecipesReady() {
        RecipeBuilder.Shaped(IronChestMain.MOD_ID)
            .setShape(
                "AAA",
                "ABA",
                "AAA")
            .addInput('A', Items.INGOT_IRON)
            .addInput('B', "minecraft:chests")
            .create("iron_chest", ModBlocks.ironChest.getDefaultStack());

        RecipeBuilder.Shaped(IronChestMain.MOD_ID)
            .setShape(
                "AAA",
                "ABA",
                "AAA")
            .addInput('A', Items.INGOT_GOLD)
            .addInput('B', ModBlocks.ironChest)
            .create("gold_chest", ModBlocks.goldChest.getDefaultStack());

        RecipeBuilder.Shaped(IronChestMain.MOD_ID)
            .setShape(
                "AAA",
                "ABA",
                "AAA")
            .addInput('A', Items.DIAMOND)
            .addInput('B', ModBlocks.goldChest)
            .create("diamond_chest", ModBlocks.diamondChest.getDefaultStack());

        RecipeBuilder.Shaped(IronChestMain.MOD_ID)
            .setShape(
                "AAA",
                "ABA",
                "AAA")
            .addInput('A', Items.INGOT_STEEL)
            .addInput('B', ModBlocks.goldChest)
            .create("diamond_chest", ModBlocks.steelChest.getDefaultStack());
    }

    @Override
    public void initNamespaces() {
        RecipeBuilder.initNameSpace(IronChestMain.MOD_ID);
    }
}
