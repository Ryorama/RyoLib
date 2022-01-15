package com.ryorama.ryolib.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import com.ryorama.ryolib.core.client.world.ModifyWorldColor;
import com.ryorama.ryolib.utils.graphics.ColorUtil;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Matrix4f;
import net.minecraft.util.math.Vec3f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {

    @Shadow
    private ClientWorld world;

    @Inject(method = "renderSky", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/world/ClientWorld;getMoonPhase()I"))
    private void changeMoonColor(BufferBuilder builder, Matrix4f matrix4f, float partialTicks, Runnable runnable, CallbackInfo ci) {
        Vec3f glColor = ColorUtil.glColor(ColorUtil.unpack(ModifyWorldColor.tryParseColor(ModifyWorldColor.moonTextureHexColor)));
        RenderSystem.setShaderColor(glColor.getX(), glColor.getY(), glColor.getZ(), 1.0F - this.world.getRainGradient(partialTicks));
    }
}
