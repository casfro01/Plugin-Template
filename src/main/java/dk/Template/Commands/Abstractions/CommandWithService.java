package dk.Template.Commands.Abstractions;

public interface CommandWithService<T> {

    void setService(T service);
    Class<T> getServiceType();
}
