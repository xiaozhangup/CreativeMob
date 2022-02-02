package me.xiaozhangup.creativemob;

import me.happylandmc.core.message.Message;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

import java.util.UUID;

public class Guiedit implements Listener {

    @EventHandler
    public void onGuiclose(InventoryCloseEvent e) {
        if (e.getView().getTitle().startsWith("主手/副手/头盔/护甲/裤子/靴子-")) {
            String mobid = e.getView().getTitle().replace("主手/副手/头盔/护甲/裤子/靴子-" , "");

            UUID uuid = UUID.randomUUID();
            Config.saveItem(uuid.toString() , e.getView().getItem(0));
            Main.plugin.getConfig().set("MobTable.List." + mobid + ".Hand" , uuid.toString());

            UUID uuid1 = UUID.randomUUID();
            Config.saveItem(uuid.toString() , e.getView().getItem(1));
            Main.plugin.getConfig().set("MobTable.List." + mobid + ".OffHand" , uuid1.toString());

            UUID uuid2 = UUID.randomUUID();
            Config.saveItem(uuid.toString() , e.getView().getItem(2));
            Main.plugin.getConfig().set("MobTable.List." + mobid + ".Head" , uuid2.toString());

            UUID uuid3 = UUID.randomUUID();
            Config.saveItem(uuid.toString() , e.getView().getItem(3));
            Main.plugin.getConfig().set("MobTable.List." + mobid + ".Chest" , uuid3.toString());

            UUID uuid4 = UUID.randomUUID();
            Config.saveItem(uuid.toString() , e.getView().getItem(4));
            Main.plugin.getConfig().set("MobTable.List." + mobid + ".Leg" , uuid4.toString());

            UUID uuid5 = UUID.randomUUID();
            Config.saveItem(uuid.toString() , e.getView().getItem(5));
            Main.plugin.getConfig().set("MobTable.List." + mobid + ".Foot" , uuid5.toString());

            Main.plugin.saveConfig();
            Message.AdvMessage((Player) e.getPlayer(), "&c操作已经保存" , false);
        }
    }
}
