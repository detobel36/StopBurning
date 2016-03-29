/*
 * Plugin par Detobel36
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
