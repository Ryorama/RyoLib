package com.ryorama.ryolib.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import com.ryorama.ryolib.core.client.world.ModifyWorldColor;
import com.ryorama.ryolib.utils.graphics.ColorSettings;
import com.ryorama.ryolib.utils.graphics.ColorUtil;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.Matrix4f;
import net.minecraft.util.math.Vec3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;

@Mixin(WorldRenderer.class)
public abstract class WorldRendererMixin {

    @Shadow
    @Nullable
    private ClientWorld world;

    @Inject(method = "renderSky", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/LunarWorldView;getMoonPhase()I"))
    private void renderSky(MatrixStack stack, Matrix4f matrix, float tickDelta, Camera camera, boolean bl, Runnable runnable, CallbackInfo ci) {
        Vec3f glColor = ColorUtil.glColor(ColorUtil.unpack(ColorSettings.tryParseColor(ModifyWorldColor.moonTextureHexColor)));

        RenderSystem.setShaderColor(glColor.getX(), glColor.getY(), glColor.getZ(), 1.0F - this.world.getRainGradient(tickDelta));
    }
}