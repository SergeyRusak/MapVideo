package com.animatik.mapvideo;

import com.animatik.mapvideo.listeners.InGameListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {

        super.onEnable();
        Bukkit.getServer().broadcastMessage("IT WORKS!!!");
        getServer().getPluginManager().registerEvents(new InGameListener(), this);
    }
}
