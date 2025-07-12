package net.brokenmoon.afloydironchest;

import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelChest;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.BlockModelHorizontalRotation;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.core.util.helper.Side;
import turniplabs.halplibe.helper.ModelHelper;
import turniplabs.halplibe.util.ModelEntrypoint;

import static net.brokenmoon.afloydironchest.IronChestMain.MOD_ID;

public class ModModels implements ModelEntrypoint {
    @Override
    public void initBlockModels(BlockModelDispatcher blockModelDispatcher) {
        ModelHelper.setBlockModel(ModBlocks.ironChest,() ->
                new BlockModelHorizontalRotation<>(ModBlocks.ironChest)
                        .setTex(0, MOD_ID + ":block/ironchesttop", Side.TOP)
                        .setTex(0, MOD_ID + ":block/ironchestbottom", Side.BOTTOM)
                        .setTex(0, MOD_ID + ":block/ironchestfront", Side.NORTH)
                        .setTex(0, MOD_ID + ":block/ironchestside", Side.SOUTH)
                        .setTex(0, MOD_ID + ":block/ironchestside", Side.EAST)
                        .setTex(0, MOD_ID + ":block/ironchestside", Side.WEST)

        );

        ModelHelper.setBlockModel(ModBlocks.goldChest,() ->
                new BlockModelHorizontalRotation<>(ModBlocks.goldChest)
                        .setTex(0, MOD_ID + ":block/goldchesttop", Side.TOP)
                        .setTex(0, MOD_ID + ":block/goldchestbottom", Side.BOTTOM)
                        .setTex(0, MOD_ID + ":block/goldchestfront", Side.NORTH)
                        .setTex(0, MOD_ID + ":block/goldchestside", Side.SOUTH)
                        .setTex(0, MOD_ID + ":block/goldchestside", Side.EAST)
                        .setTex(0, MOD_ID + ":block/goldchestside", Side.WEST)

        );

        ModelHelper.setBlockModel(ModBlocks.diamondChest,() ->
                new BlockModelHorizontalRotation<>(ModBlocks.diamondChest)
                        .setTex(0, MOD_ID + ":block/diamondchesttop", Side.TOP)
                        .setTex(0, MOD_ID + ":block/diamondchestbottom", Side.BOTTOM)
                        .setTex(0, MOD_ID + ":block/diamondchestfront", Side.NORTH)
                        .setTex(0, MOD_ID + ":block/diamondchestside", Side.SOUTH)
                        .setTex(0, MOD_ID + ":block/diamondchestside", Side.EAST)
                        .setTex(0, MOD_ID + ":block/diamondchestside", Side.WEST)

        );

        ModelHelper.setBlockModel(ModBlocks.steelChest,() ->
                new BlockModelHorizontalRotation<>(ModBlocks.steelChest)
                        .setTex(0, MOD_ID + ":block/steelchesttop", Side.TOP)
                        .setTex(0, MOD_ID + ":block/steelchestbottom", Side.BOTTOM)
                        .setTex(0, MOD_ID + ":block/steelchestfront", Side.NORTH)
                        .setTex(0, MOD_ID + ":block/steelchestside", Side.SOUTH)
                        .setTex(0, MOD_ID + ":block/steelchestside", Side.EAST)
                        .setTex(0, MOD_ID + ":block/steelchestside", Side.WEST)

        );
    }

    @Override
    public void initItemModels(ItemModelDispatcher itemModelDispatcher) {

    }

    @Override
    public void initEntityModels(EntityRenderDispatcher entityRenderDispatcher) {

    }

    @Override
    public void initTileEntityModels(TileEntityRenderDispatcher tileEntityRenderDispatcher) {

    }

    @Override
    public void initBlockColors(BlockColorDispatcher blockColorDispatcher) {

    }
}
