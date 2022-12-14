package com.ryorama.ryolib.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import com.ryorama.ryolib.core.client.world.ModifyWorldColor;
import com.ryorama.ryolib.utils.graphics.ColorSettings;
import com.ryorama.ryolib.utils.graphics.ColorUtil;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.Matrix4f;
import net.minecraft.util.math.Vec3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public abstract class WorldRendererMixin {

    @Shadow
    private ClientWorld world;

    @Inject(method = "render(Lnet/minecraft/client/util/math/MatrixStack;FJZLnet/minecraft/client/render/Camera;Lnet/minecraft/client/render/GameRenderer;Lnet/minecraft/client/render/LightmapTextureManager;Lnet/minecraft/util/math/Matrix4f;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/LunarWorldView;getMoonPhase()I"))
    private void renderSky(MatrixStack matrices, float tickDelta, long limitTime, boolean renderBlockOutline, Camera camera, GameRenderer gameRenderer, LightmapTextureManager lightmapTextureManager, Matrix4f positionMatrix, CallbackInfo ci) {
        Vec3f glColor = ColorUtil.glColor(ColorUtil.unpack(ColorSettings.tryParseColor(ModifyWorldColor.moonTextureHexColor)));

        RenderSystem.setShaderColor(glColor.getX(), glColor.getY(), glColor.getZ(), 1.0F - this.world.getRainGradient(tickDelta));
    }
}