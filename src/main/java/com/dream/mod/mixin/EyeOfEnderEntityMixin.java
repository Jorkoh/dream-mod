package com.dream.mod.mixin;

import net.minecraft.entity.EyeOfEnderEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin({EyeOfEnderEntity.class})
public abstract class EyeOfEnderEntityMixin {
    @Shadow
    private boolean dropsItem;

    @Inject(method = "moveTowards(Lnet/minecraft/util/math/BlockPos;)V", at = @At("RETURN"))
    private void mixin(CallbackInfo ci) {
        this.dropsItem = new Random().nextInt(15) > 0;
    }
}
