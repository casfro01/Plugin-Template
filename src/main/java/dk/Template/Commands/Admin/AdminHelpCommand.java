package dk.Template.Commands.Admin;

import dk.Template.Commands.Abstractions.AbstractCommand;
import dk.Template.Commands.CommandFactory;
import dk.Template.Options.StyleOptions;

public class AdminHelpCommand extends AbstractCommand {
    @Override
    public void execute() {

        // send dem her - dette er hardcoded for at man selv kan styre hvordan de vises
        StyleOptions options = getStyle();
        sendAdminPlayerMessage(options.getPrimaryColor() + "Admin Kommandoer:");
        sendPlayerMessage(getDescription(), false);
        // Loop? el. andet
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return getStyle().getPrimaryColor() + "/command2 help " + getStyle().getSecondaryColor() + "Viser dig en liste over tilgængelige kommandoer.";
    }

    @Override
    public String getPermission() {
        return "";
    }
}
