package notifiables;

import notifications.DomainNotification;
import org.junit.Assert;
import org.junit.Test;
import shared.Command;
import shared.ServerNotifiable;

import java.util.ArrayList;
import java.util.List;

public class ServerCommandTest {

    public List<DomainNotification> notifications = new ArrayList<DomainNotification>();
    public List<AbstractNotifiable> commands = new ArrayList<AbstractNotifiable>();

    @Test
    public void should_has_notification_if_any_of_commands_has_notification(){
        AbstractNotifiable commandWithNotifications = new Command();
        commandWithNotifications.addNotification(new DomainNotification());

        AbstractNotifiable commandWithoutNotifications = new Command();

        commands.add(commandWithNotifications);
        commands.add(commandWithoutNotifications);

        AbstractServerNotifiable serverCommand = new ServerNotifiable(commands);

        Assert.assertTrue(serverCommand.hasNotifications());
    }

    @Test
    public void should_has_all_commands_notifications() {
        AbstractNotifiable commandWithNotifications = new Command();

        Command commandWithNotifications2 = new Command();

        Command commandWithoutNotifications = new Command();

        commands.add(commandWithNotifications);
        commands.add(commandWithNotifications2);
        commands.add(commandWithoutNotifications);

        AbstractServerNotifiable serverCommand = new ServerNotifiable(commands);

        Assert.assertEquals(3, serverCommand.getNotifications().toArray().length);
    }


}
