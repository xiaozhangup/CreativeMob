package me.xiaozhangup.creativemob;

import me.happylandmc.core.math.Number;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.EntityEquipment;

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
                        ), CreatureSpawnEvent.SpawnReason.NATURAL);

                        entity.setCustomName(Main.plugin.getConfig().getString("MobTable.List." + i + ".Settings.Name"));
                        entity.setCustomNameVisible(Main.plugin.getConfig().getBoolean("MobTable.List." + i + ".Settings.Keepname"));

                        if(entity instanceof LivingEntity) {
                            LivingEntity mob = (LivingEntity) entity;

                            AttributeInstance attribute = mob.getAttribute(Attribute.GENERIC_MAX_HEALTH);
                            attribute.setBaseValue(Main.plugin.getConfig().getDouble("MobTable.List." + i + ".Settings.Health"));
                            mob.setHealth(Main.plugin.getConfig().getDouble("MobTable.List." + i + ".Settings.Health"));

                            EntityEquipment equipment = ((LivingEntity) entity).getEquipment();
                            equipment.clear();
                            equipment.setItemInMainHandDropChance(0);
                            equipment.setItemInOffHandDropChance(0);
                            equipment.setBootsDropChance(0);
                            equipment.setChestplateDropChance(0);
                            equipment.setHelmetDropChance(0);
                            equipment.setLeggingsDropChance(0);

                            equipment.setItemInOffHand(Main.plugin.getConfig().getItemStack(
                                    "ItemTable." + Main.plugin.getConfig().getString(
                                            "MobTable.List." + i + ".OffHand")
                            ));
                            equipment.setItemInMainHand(Main.plugin.getConfig().getItemStack(
                                    "ItemTable." + Main.plugin.getConfig().getString(
                                            "MobTable.List." + i + ".Hand")
                            ));
                            equipment.setHelmet(Main.plugin.getConfig().getItemStack(
                                    "ItemTable." + Main.plugin.getConfig().getString(
                                            "MobTable.List." + i + ".Head")
                            ));
                            equipment.setChestplate(Main.plugin.getConfig().getItemStack(
                                    "ItemTable." + Main.plugin.getConfig().getString(
                                            "MobTable.List." + i + ".Chest")
                            ));
                            equipment.setLeggings(Main.plugin.getConfig().getItemStack(
                                    "ItemTable." + Main.plugin.getConfig().getString(
                                            "MobTable.List." + i + ".Leg")
                            ));
                            equipment.setBoots(Main.plugin.getConfig().getItemStack(
                                    "ItemTable." + Main.plugin.getConfig().getString(
                                            "MobTable.List." + i + ".Foot")
                            ));

                        }

                    }

                }
            }
        }
    }
}
