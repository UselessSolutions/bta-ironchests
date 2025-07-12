package midford.reinforcedchest.mixin.Entity;

import midford.reinforcedchest.MixinInterfaces.IEntityPlayer;
import midford.reinforcedchest.gui.ScreenReinforcedChest;
import net.minecraft.client.Minecraft;

import net.minecraft.client.entity.player.PlayerLocal;
import net.minecraft.core.player.inventory.container.Container;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value = PlayerLocal.class, remap = false)
public class MixinEntityPlayerSP implements IEntityPlayer {
    @Shadow protected Minecraft mc;
    @Unique
    private final PlayerLocal thisAs = (PlayerLocal)(Object)this;

    public void reinforcedchest$displayGUIReinforcedChest(Container iinventory) {
        this.mc.displayScreen(new ScreenReinforcedChest(thisAs.inventory, iinventory));
    }
}
