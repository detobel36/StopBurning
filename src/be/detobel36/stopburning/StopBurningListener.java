/*
 * Copyright (C) 2016 Detobel36.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
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
