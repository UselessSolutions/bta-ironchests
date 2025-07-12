package midford.reinforcedchest;

import midford.reinforcedchest.blocks.ReinforcedChest;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.sound.BlockSounds;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.util.BlockInitEntrypoint;

import static midford.reinforcedchest.IronChestMain.MOD_ID;
import static midford.reinforcedchest.IronChestMain.config;

public class ModBlocks implements BlockInitEntrypoint {
    public static Block<?> reinforcedChest;

    @Override
    public void afterBlockInit() {
        reinforcedChest = new BlockBuilder(MOD_ID)
                .setBlockSound(BlockSounds.METAL)
                .setHardness(2.5f)
                .setTags(BlockTags.MINEABLE_BY_PICKAXE)
                .build("chest.reinforced", "reinforced_chest", config.getInt("ids.reinforcedChestID"),
                        (block) -> new ReinforcedChest(block, Material.metal));
    }
}
