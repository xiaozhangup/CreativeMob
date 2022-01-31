package me.xiaozhangup.creativemob;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;

public class Config {

    public static List<EntityType> entityTypeList;
    public static boolean mixmode;

    public static void load() {

        for (int i = 1 ; i < Main.plugin.getConfig().getInt("MobTable.Loop"); i++ ) {
            entityTypeList.add(EntityType.fromName(Main.plugin.getConfig().getString(
                    "MobTable.List." + i + ".Type"
            )));
        }
        Main.plugin.getLogger().info("已将 " + entityTypeList.size() + " 添加到缓存");
        mixmode = Main.plugin.getConfig().getBoolean("Random.Mixmode");
        Main.plugin.getLogger().info("Mixmode模式当前为 " + mixmode);

    }

    public static void saveItem(String name , ItemStack item) {
        Main.plugin.getConfig().set("ItemTable." + name , item);
    }

}
