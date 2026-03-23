package dk.Template.Options;

import dk.Template.Configs.Config;
import dk.Template.Configs.IConfig;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigOptions {
    private boolean kitCache = true;
    private IConfig config;

    public ConfigOptions(Config config) {
        this.config = config;
        reload();
    }


    public void reload(){
        FileConfiguration config = this.config.getConfig();
        kitCache = config.getBoolean("KitCaching");
    }

    public boolean isKitCache() {
        return kitCache;
    }
}
