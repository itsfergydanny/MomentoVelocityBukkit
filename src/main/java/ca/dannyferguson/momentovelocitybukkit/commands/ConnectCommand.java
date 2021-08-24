package ca.dannyferguson.momentovelocitybukkit.commands;

import ca.dannyferguson.momentovelocitybukkit.MomentoVelocityBukkit;
import ca.dannyferguson.momentovelocitybukkit.utils.Chat;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ConnectCommand implements CommandExecutor {
    private MomentoVelocityBukkit plugin;

    public ConnectCommand(MomentoVelocityBukkit plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Chat.format("&cOnly players can do this."));
            return true;
        }

        Player player = (Player) sender;
        if (args.length != 1) {
            player.sendMessage(Chat.format("&cInvalid usage. Try /connect <server>"));
            return true;
        }

        String cleanedName = args[0].replaceAll("[^A-Za-z0-9-]", "");

        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(cleanedName);  //server's name, set in the  velocity config
        player.sendPluginMessage(plugin, "BungeeCord", out.toByteArray());

        return true;
    }
}
