package com.ryorama.ryolib.utils;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class ChatUtils {

    public static void sendChatMessage(PlayerEntity player, String msg) {
        player.sendMessage(Text.translatable(msg), false);
    }

    public static void sendColoredChatMessage(PlayerEntity player, String msg, Formatting color) {
        player.sendMessage(Text.translatable(msg).formatted(color), false);
    }

    public static void sendBoldChatMessage(PlayerEntity player, String msg) {
        player.sendMessage(Text.translatable(msg).formatted(Formatting.BOLD), false);
    }

    public static void sendColoredBoldChatMessage(PlayerEntity player, String msg, Formatting color) {
        player.sendMessage(Text.translatable(msg).formatted(Formatting.BOLD, color), false);
    }
}
