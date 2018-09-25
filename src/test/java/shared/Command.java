package shared;

import assertions.Assert;
import commands.AbstractCommand;

public class Command extends AbstractCommand {
    private final String name;

    public Command(String name) {
        this.name = name;
    }

    public Command() {
        this(null);
    }

    @Override
    public boolean isValid() {
        addNotification(Assert.isNotNull(this.name, this.getClass().getSimpleName(), "Não pode ser nulo."));
        return !this.hasNotifications();
    }
}
