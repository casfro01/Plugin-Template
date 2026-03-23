package dk.Template.Configs;

import org.bukkit.configuration.file.FileConfiguration;

public interface IConfig {
    boolean save();
    FileConfiguration getConfig();
}
