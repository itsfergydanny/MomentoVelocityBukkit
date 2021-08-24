package ca.dannyferguson.momentovelocitybukkit;

import ca.dannyferguson.momentovelocitybukkit.commands.ConnectCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class MomentoVelocityBukkit extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        getCommand("connect").setExecutor(new ConnectCommand(this));
    }

    @Override
    public void onDisable() {
        getServer().getMessenger().unregisterOutgoingPluginChannel(this, "BungeeCord");
    }
}
