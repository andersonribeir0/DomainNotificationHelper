package shared;

import commands.AbstractCommand;
import notifications.DomainNotification;

public class FakeInvalidCommand extends AbstractCommand {

    @Override
    protected FakeInvalidCommand performValidations() {
        this.addNotification(new DomainNotification(this.getClass().getSimpleName(),"This is a domain notification."));
        return this;
    }

}
