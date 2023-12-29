package me.ballmc.BarrierVisibility.mixins;

import net.minecraft.client.multiplayer.WorldClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.ballmc.BarrierVisibility.BarrierVisibility;
import me.ballmc.BarrierVisibility.Config;

@Mixin(WorldClient.class)
public abstract class MixinWorldClient {
    BarrierVisibility bv = BarrierVisibility.getInstance();
    Config config = bv.getConfig();

    @Inject(method = "doVoidFogParticles", at = @At("HEAD"), cancellable = true)
    public void getRenderType(CallbackInfo ci) {
        if (config.BarrierVisibilityEnabled) {
            ci.cancel();
        }
    }
}