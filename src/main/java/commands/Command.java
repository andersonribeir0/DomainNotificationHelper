package commands;

import notifications.DomainNotification;

import java.util.ArrayList;
import java.util.List;

public class Command {
    private List<DomainNotification> notifications;

    public Command(){
        this.notifications = new ArrayList<DomainNotification>();
    }

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

    public void AddNotifications(List<DomainNotification> domainNotificationList) {
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
}
