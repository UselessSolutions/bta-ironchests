package midford.reinforcedchest;

import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class IronChestRecipes implements RecipeEntrypoint {
    @Override
    public void onRecipesReady() {

    }

    @Override
    public void initNamespaces() {
        RecipeBuilder.initNameSpace(IronChestMain.MOD_ID);
    }
}
