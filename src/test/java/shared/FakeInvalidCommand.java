package shared;

import commands.AbstractCommand;
import notifications.DomainNotification;

public class FakeInvalidCommand extends AbstractCommand {

    protected void validate() {
        this.addNotification(new DomainNotification(this.getClass().getSimpleName(),"This is a domain notification."));
    }

}
