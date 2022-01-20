package com.ryorama.ryolib.core.client.world;

import com.ryorama.ryolib.utils.graphics.ColorSettings;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class ModifyWorldColor {

    public static ColorSettings lastColorSettings = new ColorSettings("", 0, "", 0);

    public static String defaultSkyLightHexColor = "";
    public static double defaultSkyLightBlendStrength = 0;
    public static String defaultMoonTextureHexColor = "";
    public static double defaultMoonTextureBlendStrength = 0;

    public static String skyLightHexColor = "";
    public static double skyLightBlendStrength = 0;
    public static String moonTextureHexColor = "";
    public static double moonTextureBlendStrength = 0;

    public static void changeWorldColor(String skyLightHexColor2, double skyLightBlendStrength2, String moonTextureHexColor2, double moonTextureBlendStrength2) {
        skyLightHexColor = skyLightHexColor2;
        skyLightBlendStrength = skyLightBlendStrength2;
        moonTextureHexColor = moonTextureHexColor2;
        moonTextureBlendStrength = moonTextureBlendStrength2;
    }

    public static void resetToDefaultColor() {
        skyLightHexColor = defaultSkyLightHexColor;
        skyLightBlendStrength = defaultSkyLightBlendStrength;
        moonTextureHexColor = defaultMoonTextureHexColor;
        moonTextureBlendStrength = defaultMoonTextureBlendStrength;
    }

    public static int tryParseColor(String input) {
        int result = Integer.MAX_VALUE;

        if (input.isEmpty()) {
            return result;
        }

        try {
            result = (int) Long.parseLong(input.replace("#", "").replace("0x", ""), 16);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return result;
    }
}
