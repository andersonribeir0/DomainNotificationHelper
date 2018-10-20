package shared;

import notifiables.AbstractNotifiable;
import notifiables.AbstractServerNotifiable;

import java.util.List;

public class ServerNotifiable extends AbstractServerNotifiable {

    public ServerNotifiable(AbstractNotifiable command) {
        super(command);
    }

    public ServerNotifiable(List<AbstractNotifiable> commands) {
        super(commands);
    }

    public void performValidations() { }
}
