package notifiables;

import notifications.DomainNotification;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractServerNotifiable {
    private List<DomainNotification> notifications;
    private List<AbstractNotifiable> commands;

    public AbstractServerNotifiable(AbstractNotifiable command){
        this.commands = new ArrayList<AbstractNotifiable>();
        this.commands.add(command);
        this.notifications = command.getNotifications();
    }

    public AbstractServerNotifiable(List<AbstractNotifiable> commands){
        if(commands != null) {
            this.commands = new ArrayList<AbstractNotifiable>();
            this.notifications = new ArrayList<DomainNotification>();
            this.commands.addAll(commands);
            for (AbstractNotifiable command: commands ) {
                if(command != null && command.hasNotifications()) {
                    this.notifications.addAll(command.getNotifications());
                }
            }
        }
    }

    public boolean hasNotifications(){
        if (this.notifications == null) {
            return false;
        }
        return !this.notifications.isEmpty();
    }

    public List<DomainNotification> getNotifications() {
        if(this.notifications == null) {
            return new ArrayList<DomainNotification>();
        }
        return this.notifications;
    }

    public void addNotification(DomainNotification domainNotification) {
        if (domainNotification == null) {
            return;
        }
        this.notifications.add(domainNotification);
    }

    public void addNotifications(List<DomainNotification> domainNotificationList){
        if (domainNotificationList == null) {
            return;
        }
        this.notifications.addAll(domainNotificationList);
    }

    public boolean isValid() {
        return !hasNotifications();
    }

    public boolean isInvalid() {
        return hasNotifications();
    }

}
