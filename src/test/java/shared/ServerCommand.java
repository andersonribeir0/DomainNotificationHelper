package shared;

import commands.AbstractCommand;
import commands.AbstractServerCommand;

import java.util.List;

public class ServerCommand extends AbstractServerCommand {

    public ServerCommand(AbstractCommand command) {
        super(command);
    }

    public ServerCommand(List<AbstractCommand> commands) {
        super(commands);
    }

    public boolean isValid() {
        return !this.hasNotifications();
    }
}
