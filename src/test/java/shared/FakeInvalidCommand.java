package shared;

import notifiables.AbstractNotifiable;
import notifications.DomainNotification;

public class FakeInvalidCommand extends AbstractNotifiable {

    @Override
    protected FakeInvalidCommand performValidations() {
        this.addNotification(new DomainNotification(this.getClass().getSimpleName(),"This is a domain notification."));
        return this;
    }

}
