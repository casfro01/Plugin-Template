package dk.Template.Commands.Abstractions;

public interface ICommand {
    void execute();

    String getName();
    String getDescription();
    String getPermission();
}
