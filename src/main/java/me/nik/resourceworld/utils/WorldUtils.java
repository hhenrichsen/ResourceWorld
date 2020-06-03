package me.nik.resourceworld.utils;

import me.nik.resourceworld.files.Config;
import org.bukkit.Bukkit;

import java.io.File;

public class WorldUtils {

    public static boolean deleteDirectory(File directory) {
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null)
                for (File file : files) {
                    if (file.isDirectory()) {
                        deleteDirectory(file);
                    } else {
                        file.delete();
                    }
                }
        }
        return directory.delete();
    }

    public static boolean worldExists() {
        return Bukkit.getWorld(Config.get().getString("world.settings.world_name")) != null;
    }

    public static boolean netherExists() {
        return Bukkit.getWorld(Config.get().getString("nether_world.settings.world_name")) != null;
    }

    public static boolean endExists() {
        return Bukkit.getWorld(Config.get().getString("end_world.settings.world_name")) != null;
    }
}
