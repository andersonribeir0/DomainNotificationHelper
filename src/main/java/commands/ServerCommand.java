package commands;

import notifications.DomainNotification;

import java.util.ArrayList;
import java.util.List;

public class ServerCommand {
    private List<DomainNotification> notifications;
    private List<Command> commands;

    public ServerCommand(Command command){
        this.commands = new ArrayList<Command>();
        this.commands.add(command);
        this.notifications = command.getNotifications();
    }

    public ServerCommand(List<Command> commands){
        if(commands != null) {
            this.commands = new ArrayList<Command>();
            this.notifications = new ArrayList<DomainNotification>();
            this.commands.addAll(commands);
            for (Command command: commands ) {
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
}
