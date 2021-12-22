package com.ryorama.ryolib.core.client.world;

import com.ryorama.ryolib.utils.graphics.ColorSettings;

public class ModifyWorldColor {

    public static ColorSettings lastColorSettings = new ColorSettings("", 0, "", 0);

    public static String skyLightHexColor = "";
    public static int skyLightBlendStrength = 0;
    public static String moonTextureHexColor = "";
    public static int moonTextureBlendStrength = 0;

    public static void changeWorldColor(String skyLightHexColor2, int skyLightBlendStrength2, String moonTextureHexColor2, int moonTextureBlendStrength2) {
        skyLightHexColor = skyLightHexColor2;
        skyLightBlendStrength = skyLightBlendStrength2;
        moonTextureHexColor = moonTextureHexColor2;
        moonTextureBlendStrength = moonTextureBlendStrength2;
    }
}
