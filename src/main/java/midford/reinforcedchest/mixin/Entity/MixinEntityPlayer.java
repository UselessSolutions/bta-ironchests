package midford.reinforcedchest.mixin.Entity;

import midford.reinforcedchest.MixinInterfaces.IEntityPlayer;

import net.minecraft.core.entity.player.Player;
import net.minecraft.core.player.inventory.container.Container;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = Player.class, remap = false)
public class MixinEntityPlayer implements IEntityPlayer {
    @Override
    public void reinforcedchest$displayGUIReinforcedChest(Container iinventory) {}
}
