package dk.Template;

import dk.Template.Commands.Abstractions.ICommand;
import dk.ScriptForge.kitSystem.Commands.Admin.*;
import dk.Template.Commands.Admin.*;
import dk.Template.Commands.CommandFactory;
import dk.Template.Commands.Registry.CommandAdminRegistry;
import dk.Template.Commands.Registry.CommandRegistry;
import dk.Template.Commands.Registry.IRegistry;
import dk.Template.Commands.User.TemplateCommand;
import dk.Template.Commands.User.UserCommandExecutor;
import dk.Template.Configs.StyleConfig;
import dk.Template.Configs.Config;
import dk.Template.Options.ConfigOptions;
import dk.Template.Options.StyleOptions;
import dk.Template.Service.Service;
import org.bukkit.plugin.java.JavaPlugin;

public final class Template extends JavaPlugin {

    @Override
    public void onEnable() {

        // load configs
        saveResource("styleConfig.yml", false);
        saveResource("config.yml", false);

        StyleConfig style = new StyleConfig(this, "styleConfig.yml");
        Config conf = new Config(this, "config.yml");

        // options
        StyleOptions sOptions = new StyleOptions(style);
        ConfigOptions options = new ConfigOptions(conf);

        String dbpath = "/template.db";

        // services
        Service s = new Service(this, dbpath, options);;

        // setup
        CommandFactory.setStyleOptions(sOptions);
        CommandFactory.setService(s);
        CommandFactory.setConfigOptions(options);

        // register commands
        IRegistry<ICommand> Commands = CommandRegistry.getInstance();
        IRegistry<ICommand> adminCommands = CommandAdminRegistry.getInstance();
        Commands.registerCommand(new TemplateCommand());

        adminCommands.registerCommand(new AdminHelpCommand());

        // base commands
        getCommand("command1").setExecutor(new UserCommandExecutor());
        getCommand("command2").setExecutor(new AdminCommandExecutor());



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("[Template] Shutting down, good bye.");
    }
}
