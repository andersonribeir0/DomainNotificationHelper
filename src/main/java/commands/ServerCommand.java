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
        this.commands = new ArrayList<Command>();
        this.notifications = new ArrayList<DomainNotification>();
        this.commands.addAll(commands);
        for (Command command: commands ) {
            if(command != null && command.hasNotifications()) {
                this.notifications.addAll(command.getNotifications());
            }
        }
    }

    public boolean hasNotifications(){
        return this.notifications.toArray().length > 0;
    }

    public List<DomainNotification> getNotifications() {
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
