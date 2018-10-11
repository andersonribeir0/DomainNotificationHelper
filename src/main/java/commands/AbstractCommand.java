package commands;

import notifications.DomainNotification;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCommand {
    private List<DomainNotification> notifications;

    public AbstractCommand() {
        this.notifications = new ArrayList<DomainNotification>();
    }

    protected abstract AbstractCommand performValidations();

    public boolean hasNotifications(){
        if(this.notifications == null) {
            return false;
        }
        return !this.notifications.isEmpty();
    }

    public void addNotification(DomainNotification domainNotification) {
        if (domainNotification == null) {
            return;
        }
        this.notifications.add(domainNotification);
    }

    public void addNotifications(List<DomainNotification> domainNotificationList) {
        if (domainNotificationList == null){
            return;
        }
        this.notifications.addAll(domainNotificationList);
    }

    public List<DomainNotification> getNotifications() {
        if(this.notifications == null) {
            return new ArrayList<DomainNotification>();
        }
        return this.notifications;
    }

    public boolean isValid() {
        return !hasNotifications();
    }

    public boolean isInvalid() {
        return hasNotifications();
    }



}
