package me.happylandmc.core.console;

import me.happylandmc.core.Main;
import org.bukkit.Bukkit;

public class Console {
    public static void ConsolePrint(String s ,Boolean a) {
        if (a) {
            Main.Core.getLogger().warning(s);
        } else {
            Main.Core.getLogger().info(s);
        }
    }
    public static void ConsoleCom(String s) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender() , s);
    }
    public static void AirLine() {
        System.out.println();
    }
    public static void FullLine() {
        System.out.println("===========================");
    }
}
