package net.brokenmoon.afloydironchest;

import net.minecraft.core.item.Item;
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
            .addInput('A', Item.ingotIron)
            .addInput('B', "minecraft:chests")
            .create("iron_chest", ModBlocks.ironChest.getDefaultStack());

        RecipeBuilder.Shaped(IronChestMain.MOD_ID)
            .setShape(
                "AAA",
                "ABA",
                "AAA")
            .addInput('A', Item.ingotGold)
            .addInput('B', ModBlocks.ironChest)
            .create("gold_chest", ModBlocks.goldChest.getDefaultStack());

        RecipeBuilder.Shaped(IronChestMain.MOD_ID)
            .setShape(
                "AAA",
                "ABA",
                "AAA")
            .addInput('A', Item.diamond)
            .addInput('B', ModBlocks.goldChest)
            .create("diamond_chest", ModBlocks.diamondChest.getDefaultStack());

        RecipeBuilder.Shaped(IronChestMain.MOD_ID)
            .setShape(
                "AAA",
                "ABA",
                "AAA")
            .addInput('A', Item.ingotSteel)
            .addInput('B', ModBlocks.goldChest)
            .create("diamond_chest", ModBlocks.steelChest.getDefaultStack());
    }

    @Override
    public void initNamespaces() {
        RecipeBuilder.initNameSpace(IronChestMain.MOD_ID);
    }
}
