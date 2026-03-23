package dk.Template.Commands.User;

import dk.Template.Commands.Abstractions.AbstractCommand;
import org.bukkit.OfflinePlayer;

public class TemplateCommand extends AbstractCommand {
    @Override
    public void execute() {
        String[] args = getArgs();
        OfflinePlayer p = (OfflinePlayer) getSender();
        sendPlayerMessage(getStyle().getPrimaryColor() + "Hej med dig " + getStyle().getSecondaryColor() + p.getName());
    }


    @Override
    public String getName() {
        return "template";
    }

    @Override
    public String getDescription() {
        return getStyle().getPrimaryColor() + "/command1 template " + getStyle().getSecondaryColor() + " Beskrivelse";
    }

    @Override
    public String getPermission() {
        return "permission";
    }
}
