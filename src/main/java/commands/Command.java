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
        return !notifications.isEmpty();
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
}
