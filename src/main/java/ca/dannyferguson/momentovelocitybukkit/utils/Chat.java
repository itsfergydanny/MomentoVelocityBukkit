package ca.dannyferguson.momentovelocitybukkit.utils;

import org.bukkit.ChatColor;

public class Chat {
    public static String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
