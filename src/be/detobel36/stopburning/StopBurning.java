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

import java.util.Arrays;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main class
 * 
 * @author Detobel36
 */
public class StopBurning extends JavaPlugin {

    @Override
    public void onEnable() {
        
        getLogger().info("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        getLogger().info("Démarrage du plugin StopBurning");
        
        getLogger().info("Chargement de la configuration");
        loadConfig();
        
        getLogger().info("Activation du listener");
        Bukkit.getPluginManager().registerEvents(new StopBurningListener(this), this);
        
        getLogger().info("Démarrge fini ;) ");
        getLogger().info("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }
    
    private void loadConfig() {
        // Create Config defaults
        getConfig().options().copyDefaults(true);
        getConfig().options().header("Plugin fait par Detobel36\n"
                + "La liste des mobs pouvant être mis dans la config se trouvent ici:\n"
                + "https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/EntityType.html\n"
                + "-----------------------------------------\n");
        
        List<String> listMob = Arrays.asList("ZOMBIE", "SKELETON");
        getConfig().addDefault("Mob", listMob);
        
        saveConfig();
    }
    
    
}
