/*
 * Plugin par Detobel36
 */
package be.detobel36.stopburning;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustEvent;

/**
 * Listener
 * 
 * @author Detobel36
 */
class StopBurningListener implements Listener {

    private final StopBurning plugin;
    private final ArrayList<EntityType> listMob;
    
    public StopBurningListener(StopBurning pl) {
        plugin = pl;
        listMob = new ArrayList<EntityType>();
        
        List<String> configList = (List<String>) pl.getConfig().getList("Mob");
        for(String mob : configList) {
            listMob.add(EntityType.valueOf(mob));
        }
    }
    
    @EventHandler
    public void onMobCombust(EntityCombustEvent event) {
        if(listMob.contains(event.getEntityType())) {
            event.setCancelled(true);
        }
    }
    
}
