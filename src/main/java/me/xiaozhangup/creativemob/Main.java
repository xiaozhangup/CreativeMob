package me.xiaozhangup.creativemob;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        reloadConfig();
        getLogger().info("CreativeMob 开始加载数据");
        getLogger().info("By xiaozhangup");
        Config.load();


    }
}
