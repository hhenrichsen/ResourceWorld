package me.nik.resourceworld.utils;

import me.nik.resourceworld.ResourceWorld;
import me.nik.resourceworld.api.Manager;
import me.nik.resourceworld.listeners.DisabledCmds;
import me.nik.resourceworld.listeners.OreRegen;
import me.nik.resourceworld.listeners.WorldSettings;

public class Initializer extends Manager {
    public Initializer(ResourceWorld plugin) {
        super(plugin);
    }

    public void initialize() {
        if (configBoolean("disabled_commands.enabled")) {
            registerEvent(new DisabledCmds(plugin));
        }
        if (configBoolean("world.settings.block_regeneration.enabled")) {
            registerEvent(new OreRegen(plugin));
        }
        if (configBoolean("world.settings.disable_suffocation_damage") || configBoolean("world.settings.disable_drowning_damage") || configBoolean("world.settings.disable_entity_spawning")) {
            registerEvent(new WorldSettings(plugin));
        }
    }
}