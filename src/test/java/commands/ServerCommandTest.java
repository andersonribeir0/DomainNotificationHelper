package commands;

import notifications.DomainNotification;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ServerCommandTest {

    public List<DomainNotification> notifications = new ArrayList<DomainNotification>();
    public List<Command> commands = new ArrayList<Command>();

    @Test
    public void should_has_notification_if_any_of_commands_has_notification(){
        Command commandWithNotifications = new Command();
        commandWithNotifications.addNotification(new DomainNotification());

        Command commandWithoutNotifications = new Command();

        commands.add(commandWithNotifications);
        commands.add(commandWithoutNotifications);

        ServerCommand serverCommand = new ServerCommand(commands);

        Assert.assertTrue(serverCommand.hasNotifications());
    }

    @Test
    public void should_has_all_commands_notifications() {
        Command commandWithNotifications = new Command();
        commandWithNotifications.addNotification(new DomainNotification());

        Command commandWithNotifications2 = new Command();
        commandWithNotifications2.addNotification(new DomainNotification());

        Command commandWithoutNotifications = new Command();

        commands.add(commandWithNotifications);
        commands.add(commandWithNotifications2);
        commands.add(commandWithoutNotifications);

        ServerCommand serverCommand = new ServerCommand(commands);

        Assert.assertEquals(2, serverCommand.getNotifications().toArray().length);
    }
}
