import notifications.DomainNotification;

import java.util.ArrayList;
import java.util.List;

public class RunTime {

    private List<DomainNotification> notifications;

    public RunTime() {
        this.notifications = new ArrayList<DomainNotification>();
    }

    public boolean hasNotifications(){
        return this.notifications.toArray().length > 0;
    }

    public List<DomainNotification> GetNotifications(){
        return this.notifications;
    }

    public void addNotification(DomainNotification notification){
        if (notification == null)
            return;

        this.notifications.add(notification);
    }

    public void addNotifications(List<DomainNotification> notifications){
        if (notifications == null)
            return;

        this.notifications.addAll(notifications);
    }
}
