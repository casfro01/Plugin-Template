package dk.Template.Commands;


import dk.Template.Commands.Abstractions.AbstractCommand;
import dk.Template.Commands.Abstractions.CommandWithService;
import dk.Template.Commands.Abstractions.ICommand;
import dk.Template.Commands.Admin.NotAnAdminCommand;
import dk.Template.Commands.Registry.CommandAdminRegistry;
import dk.Template.Commands.Registry.CommandRegistry;
import dk.Template.Commands.Registry.IRegistry;
import dk.Template.Options.ConfigOptions;
import dk.Template.Options.StyleOptions;
import dk.Template.Service.Service;

public class CommandFactory {
    private static Service service;
    private static StyleOptions styleOptions;
    private static ConfigOptions configOptions;

    public static AbstractCommand newCommand(String command, CommandType type) {
        IRegistry<ICommand> registry = type.getRegistry();
        try {
            ICommand c = registry.getCommands().get(command).getDeclaredConstructor().newInstance();
            if (c instanceof CommandWithService) {
                if (((CommandWithService<?>) c).getServiceType().equals(Service.class)) {
                    ((CommandWithService<Service>) c).setService(service);
                }
//                else if (((CommandWithService<?>) c).getServiceType().equals(......class)) {
//                    ((CommandWithService<K.....>) c).setService(adminService);
//                }
            }
            if (c instanceof AbstractCommand){
                AbstractCommand abs = (AbstractCommand) c;
                abs.setStyle(styleOptions);
                return abs;
            }

        } catch (Exception e) {
            // Logger?
            //throw new NotACommandException("Invalid command: " + command + "\n" + e.getMessage());
        }
        AbstractCommand NotACommand = type == CommandType.USER ? new NotACommand() : new NotAnAdminCommand();
        NotACommand.setStyle(styleOptions);
        return NotACommand;
    }


    public static void setService(Service service) {
        CommandFactory.service = service;
    }

    public static void setStyleOptions(StyleOptions styleOptions) {
        CommandFactory.styleOptions = styleOptions;
    }

    public static void setConfigOptions(ConfigOptions configOptions) {
        if (configOptions != null){
            CommandFactory.configOptions = configOptions;
            service.setConfig(configOptions);
        }
    }


    public static enum CommandType{
        ADMIN(CommandAdminRegistry.getInstance()),
        USER(CommandRegistry.getInstance());

        private IRegistry<ICommand> registry;

        CommandType(IRegistry<ICommand> reg){
            registry = reg;
        }

        IRegistry<ICommand> getRegistry(){
            return registry;
        }
    }
}
