package shared;

import assertions.Assert;
import notifiables.AbstractNotifiable;

public class Command extends AbstractNotifiable {
    private final String name;

    public Command(String name) {
        this.name = name;
        this.performValidations();
    }

    public Command() {
        this(null);
    }

    @Override
    protected final Command performValidations() {
        addNotification(Assert.isNotNull(this.name, this.getClass().getSimpleName(), "Não pode ser nulo."));
        return this;
    }
}
