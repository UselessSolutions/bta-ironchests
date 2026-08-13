package net.brokenmoon.afloydironchest.mixin.Entity;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.nbt.tags.CompoundTag;
import net.brokenmoon.afloydironchest.blocks.IronChest;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.entity.TileEntityTrommel;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = TileEntityTrommel.class, remap = false)
public class MixinTileEntityTrommel extends TileEntity {

	@Override
	public void readAdditionalData(@NotNull CompoundTag compoundTag) {

	}

	@Override
	public void writeAdditionalData(@NotNull CompoundTag compoundTag) {

	}

	@ModifyExpressionValue(method = "sieveItem",at = @At(value = "INVOKE", target = "Lnet/minecraft/core/block/Block;hasLogicClass(Lnet/minecraft/core/block/Block;Ljava/lang/Class;)Z"))
	public boolean addTheFuckingThing(boolean original,@Local(name = "adjacentId") int adjacentId){
		return original || this.worldObj != null && Block.hasLogicClass(Blocks.blocksList[adjacentId], IronChest.class);
	}

}
