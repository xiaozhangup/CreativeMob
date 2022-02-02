package me.xiaozhangup.creativemob;

import me.happylandmc.core.message.Message;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    //Color §

    public static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        reloadConfig();
        getLogger().info("CreativeMob 开始加载数据");
        getLogger().info("By xiaozhangup");
        Bukkit.getPluginManager().registerEvents(new Guiedit() , this);
        Config.load();

        Bukkit.getPluginCommand("creativemob").setExecutor((commandSender, command, s, inside) -> {
            Player p = (Player) commandSender;

            if (commandSender.hasPermission("creativemob.use")) {
                if (inside[0].equals("add")) {
                    commandSender.sendMessage("§c一个名为 §f" + inside[1] + " §c已经创建好了,使用 §f/cmt edit " + inside[1] + " §c进行编辑");

                    getConfig().set("MobTable.Loop" , getConfig().getInt("MobTable.Loop") + 1);
                    getConfig().set("MobTable.List." + inside[1] + ".Type" , "PIG");
                    getConfig().set("MobTable.List." + inside[1] + ".Drop" , new String[] {"NULL", "NULL"});
                    getConfig().set("MobTable.List." + inside[1] + ".Head" , "NULL");
                    getConfig().set("MobTable.List." + inside[1] + ".Chest" , "NULL");
                    getConfig().set("MobTable.List." + inside[1] + ".Leg" , "NULL");
                    getConfig().set("MobTable.List." + inside[1] + ".Foot" , "NULL");
                    getConfig().set("MobTable.List." + inside[1] + ".Hand" , "NULL");
                    getConfig().set("MobTable.List." + inside[1] + ".Offhand" , "NULL");
                    getConfig().set("MobTable.List." + inside[1] + ".Settings.Keepname" , true);
                    getConfig().set("MobTable.List." + inside[1] + ".Settings.Name" , "NULL");
                    getConfig().set("MobTable.List." + inside[1] + ".Settings.Health" , 20);
                    getConfig().set("MobTable.List." + inside[1] + ".Settings.Chance" , 12);
                    getConfig().set("MobTable.List." + inside[1] + ".Settings.World" , new String[] {"yourworld" , "yourworld2"});

                    saveConfig();
                } else if (inside[0].equals("reload")) {
                    reloadConfig();
                    commandSender.sendMessage("§c重载完成");
                } else if (inside[0].equals("edit")) {
                    Inventory inv = Bukkit.createInventory(null , 8 , Message.Color("主手/副手/头盔/护甲/裤子/靴子-" + inside[1] ));

                } else {
                    commandSender.sendMessage("§c没有这个命令或格式错误");
                }
            } else {
                commandSender.sendMessage("§c你无权限使用这个命令");
                return false;
            }

            return false;
        });
    }
}
