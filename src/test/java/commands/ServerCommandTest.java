package commands;

import notifications.DomainNotification;
import org.junit.Assert;
import org.junit.Test;
import shared.Command;
import shared.ServerCommand;

import java.util.ArrayList;
import java.util.List;

public class ServerCommandTest {

    public List<DomainNotification> notifications = new ArrayList<DomainNotification>();
    public List<AbstractCommand> commands = new ArrayList<AbstractCommand>();

    @Test
    public void should_has_notification_if_any_of_commands_has_notification(){
        AbstractCommand commandWithNotifications = new Command();
        commandWithNotifications.addNotification(new DomainNotification());

        AbstractCommand commandWithoutNotifications = new Command();

        commands.add(commandWithNotifications);
        commands.add(commandWithoutNotifications);

        AbstractServerCommand serverCommand = new ServerCommand(commands);

        Assert.assertTrue(serverCommand.hasNotifications());
    }

    @Test
    public void should_has_all_commands_notifications() {
        AbstractCommand commandWithNotifications = new Command();
        commandWithNotifications.addNotification(new DomainNotification());

        Command commandWithNotifications2 = new Command();
        commandWithNotifications2.addNotification(new DomainNotification());

        Command commandWithoutNotifications = new Command();

        commands.add(commandWithNotifications);
        commands.add(commandWithNotifications2);
        commands.add(commandWithoutNotifications);

        AbstractServerCommand serverCommand = new ServerCommand(commands);

        Assert.assertEquals(2, serverCommand.getNotifications().toArray().length);
    }


}
