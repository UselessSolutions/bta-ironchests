package net.brokenmoon.afloydironchest;

import net.minecraft.core.block.Block;
import net.minecraft.core.data.DataLoader;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.RecipeGroup;
import net.minecraft.core.data.registry.recipe.RecipeNamespace;
import net.minecraft.core.data.registry.recipe.RecipeSymbol;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryCrafting;
import net.minecraft.core.item.ItemStack;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class IronChestRecipes implements RecipeEntrypoint {
    public static final RecipeNamespace IRONCHESTS = new RecipeNamespace();
    public static final RecipeGroup<RecipeEntryCrafting<?, ?>> WORKBENCH = new RecipeGroup<>(new RecipeSymbol(new ItemStack(Block.workbench)));
    @Override
    public void onRecipesReady() {
        IRONCHESTS.register("workbench", WORKBENCH);
        Registries.RECIPES.register("ironchest", IRONCHESTS);
        Registries.ITEM_GROUPS.register("ironchest:ironchest",Registries.stackListOf(IronChestMain.ironChest));
        Registries.ITEM_GROUPS.register("ironchest:goldchest", Registries.stackListOf(IronChestMain.goldChest));
        Registries.ITEM_GROUPS.register("ironchest:diamondchest", Registries.stackListOf(IronChestMain.diamondChest));
        Registries.ITEM_GROUPS.register("ironchest:steelchest", Registries.stackListOf(IronChestMain.steelChest));
        DataLoader.loadRecipes("/assets/ironchest/recipes/workbench.json");
    }
}
