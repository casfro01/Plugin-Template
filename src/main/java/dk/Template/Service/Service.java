package dk.Template.Service;

import dk.Template.DataAccess.DataAccess;
import dk.Template.Template;
import dk.Template.Models.X;
import dk.Template.Options.ConfigOptions;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private DataAccess dataAccess;
    private ConfigOptions config;

    public Service(Template plugin, String dbpath, ConfigOptions config){
        this.config = config;
        try {
            this.dataAccess = new DataAccess(plugin, dbpath);

        } catch (Exception e) {
            // logger?????
            throw new RuntimeException(e);
        }
    }

    public void setConfig(ConfigOptions configOptions) {
        config = configOptions;
    }
}
