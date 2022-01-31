package me.xiaozhangup.creativemob;

import me.happylandmc.core.math.Number;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class Spawn implements Listener {

    @EventHandler
    public void onMobSpawn(EntitySpawnEvent e) {
        if (Config.entityTypeList.contains(e.getEntityType())) {
            Location location = e.getLocation();
            for (int i = 1 ; i < Main.plugin.getConfig().getInt("MobTable.Loop"); i++ ) {
                if (Main.plugin.getConfig().getStringList(
                        "MobTable.List." + i + ".World"
                ).contains(location.getWorld())) {
                    if (Number.getRandom(1 , 100) < Main.plugin.getConfig().getInt(
                            "MobTable.List." + i + ".Settings.Chance"
                    )) {
                        Entity entity = location.getWorld().spawnEntity(location , EntityType.fromName(
                                Main.plugin.getConfig().getString("MobTable.List." + i + ".Type")
                        ));

                        entity.setCustomNameVisible();
                    }

                }
            }
        }
    }
}
