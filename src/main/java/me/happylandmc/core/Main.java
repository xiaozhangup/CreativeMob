package me.happylandmc.core;

import me.happylandmc.core.message.Message;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static Plugin Core;
    public static String format = null;
    @Override
    public void onEnable() {
        Core = this;
        getLogger().info(this + " Loaded!");
        getLogger().info("HappyLandMC Core");
        getLogger().info("By xiaozhangup");
        //Bukkit.getPluginManager().registerEvents(new Chat(),this);
        saveDefaultConfig();
        reloadConfig();
        format = getConfig().getString("ChatFormat").replace("&" ,Message.CP);
    }
}
