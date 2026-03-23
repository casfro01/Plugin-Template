package dk.Template.Commands;

import dk.Template.Commands.Abstractions.ICommand;

public class CommandInvoker {

    /**
     * Eksekvér en kommando.
     * @param command Den {@link ICommand} som skal eksekveres
     */
    public void executeCommand(ICommand command){
        // execute
        command.execute();
    }
}
