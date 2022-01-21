package com.ryorama.ryolib.mixin;

import com.ryorama.ryolib.core.client.world.ModifyWorldColor;
import com.ryorama.ryolib.utils.graphics.ColorSettings;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(LightmapTextureManager.class)
public abstract class LightmapTextureManagerMixin {

    @Inject(method = "update", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/Vec3f;lerp(Lnet/minecraft/util/math/Vec3f;F)V", ordinal = 0), cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
    public void update(float delta, CallbackInfo ci, ClientWorld clientworld, float f, float f1, float f2, Vec3f skyVector) {

        ColorSettings colorSettings = new ColorSettings(ModifyWorldColor.skyLightHexColor, ModifyWorldColor.skyLightBlendStrength, ModifyWorldColor.moonTextureHexColor, ModifyWorldColor.moonTextureBlendStrength);
        ModifyWorldColor.lastColorSettings = new ColorSettings("", 0, "", 0);

        Vec3f targetColor = ModifyWorldColor.lastColorSettings.getGLSkyLightColor().copy();

        targetColor.lerp(colorSettings.getGLSkyLightColor(), 1.0f);
        skyVector.lerp(targetColor, (float) MathHelper.lerp(1.0f, ModifyWorldColor.lastColorSettings.getSkyLightBlendStrength(), colorSettings.getSkyLightBlendStrength()));

    }
}