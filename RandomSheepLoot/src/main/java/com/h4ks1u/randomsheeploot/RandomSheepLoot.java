package com.h4ks1u.randomsheeploot;

import com.h4ks1u.randomsheeploot.listeners.SheepListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class RandomSheepLoot extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new SheepListener(this), this);
    }

    @Override
    public void onDisable() {
    }
}
