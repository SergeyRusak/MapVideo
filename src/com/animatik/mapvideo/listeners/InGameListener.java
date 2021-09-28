package com.animatik.mapvideo.listeners;


import com.animatik.mapvideo.maprenders.PlainMapRender;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapView;

public class InGameListener implements Listener {


    @EventHandler
    public void onPlayerTouch2(PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getType().equals(EntityType.ITEM_FRAME)){
            ItemFrame fr = (ItemFrame) e.getRightClicked();

            e.setCancelled(true);
            e.getPlayer().sendRawMessage("Ты кликнул по рамке");
            MapView mv = Bukkit.getServer().createMap(e.getPlayer().getWorld());
            mv.getRenderers().clear();
            mv.addRenderer(new PlainMapRender());
            ItemStack itemmap = new ItemStack(Material.FILLED_MAP);
            MapMeta mm = (MapMeta) itemmap.getItemMeta();
            mm.setMapView(mv);
            itemmap.setItemMeta(mm);
            fr.setItem(itemmap);
    }

}
}





