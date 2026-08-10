package net.brokenmoon.afloydironchest;

import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.BlockModelHorizontalRotation;
import net.minecraft.core.util.helper.Side;

import static net.brokenmoon.afloydironchest.IronChestMain.MOD_ID;

public class ModModels {

    public void initBlockModels(BlockModelDispatcher blockModelDispatcher) {
        blockModelDispatcher.addDispatch(ModBlocks.ironChest,
                new BlockModelHorizontalRotation<>(ModBlocks.ironChest)
                        .setTex(MOD_ID + ":block/ironchesttop", Side.TOP)
                        .setTex(MOD_ID + ":block/ironchestbottom", Side.BOTTOM)
                        .setTex(MOD_ID + ":block/ironchestfront", Side.NORTH)
                        .setTex(MOD_ID + ":block/ironchestside", Side.SOUTH)
                        .setTex(MOD_ID + ":block/ironchestside", Side.EAST)
                        .setTex(MOD_ID + ":block/ironchestside", Side.WEST)

        );

		blockModelDispatcher.addDispatch(ModBlocks.goldChest,
                new BlockModelHorizontalRotation<>(ModBlocks.goldChest)
                        .setTex(MOD_ID + ":block/goldchesttop", Side.TOP)
                        .setTex(MOD_ID + ":block/goldchestbottom", Side.BOTTOM)
                        .setTex(MOD_ID + ":block/goldchestfront", Side.NORTH)
                        .setTex(MOD_ID + ":block/goldchestside", Side.SOUTH)
                        .setTex(MOD_ID + ":block/goldchestside", Side.EAST)
                        .setTex(MOD_ID + ":block/goldchestside", Side.WEST)

        );

		blockModelDispatcher.addDispatch(ModBlocks.diamondChest,
                new BlockModelHorizontalRotation<>(ModBlocks.diamondChest)
                        .setTex(MOD_ID + ":block/diamondchesttop", Side.TOP)
                        .setTex(MOD_ID + ":block/diamondchestbottom", Side.BOTTOM)
                        .setTex(MOD_ID + ":block/diamondchestfront", Side.NORTH)
                        .setTex(MOD_ID + ":block/diamondchestside", Side.SOUTH)
                        .setTex(MOD_ID + ":block/diamondchestside", Side.EAST)
                        .setTex(MOD_ID + ":block/diamondchestside", Side.WEST)

        );

		blockModelDispatcher.addDispatch(ModBlocks.steelChest,
                new BlockModelHorizontalRotation<>(ModBlocks.steelChest)
                        .setTex(MOD_ID + ":block/steelchesttop", Side.TOP)
                        .setTex(MOD_ID + ":block/steelchestbottom", Side.BOTTOM)
                        .setTex(MOD_ID + ":block/steelchestfront", Side.NORTH)
                        .setTex(MOD_ID + ":block/steelchestside", Side.SOUTH)
                        .setTex(MOD_ID + ":block/steelchestside", Side.EAST)
                        .setTex(MOD_ID + ":block/steelchestside", Side.WEST)

        );
    }

}
