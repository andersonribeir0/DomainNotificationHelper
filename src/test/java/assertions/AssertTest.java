package assertions;

import commands.Command;
import notifications.DomainNotification;
import org.junit.Test;

public class AssertTest {

    @Test
    public void should_return_notification_if_value_is_null() {
        assertions.Assert assertion = new Assert();

        DomainNotification domainNotification = assertion.isNotNull(null, "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNotNull(domainNotification);
    }

    @Test
    public void should_not_return_notification_if_value_is_not_null() {
        assertions.Assert assertion = new Assert();

        DomainNotification domainNotification = assertion.isNotNull(new Object(), "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNull(domainNotification);
    }

    @Test
    public void should_return_notification_if_value_is_empty_or_whitespace() {
        assertions.Assert assertion = new Assert();

        Command command = new Command();
        command.addNotification(assertion.notEmpty(null, "NotificationKey", "NotificationValue"));
        command.addNotification(assertion.notEmpty(" ", "NotificationKey", "NotificationValue"));
        command.addNotification(assertion.notEmpty("   ", "NotificationKey", "NotificationValue"));

        org.junit.Assert.assertTrue(command.getNotifications().size() == 3);
    }

    @Test
    public void should_not_return_notification_if_length_range_matches() {
        assertions.Assert assertion = new Assert();

        DomainNotification domainNotification = assertion.length("12345678", 8, 8, "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNull(domainNotification);
    }

    @Test
    public void should_return_notification_if_length_range_does_not_match() {
        assertions.Assert assertion = new Assert();

        DomainNotification domainNotification = assertion.length("12345678", 9, 10, "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNotNull(domainNotification);
    }

    @Test
    public void should_return_notification_if_not_match(){
        assertions.Assert assertion = new Assert();

        DomainNotification domainNotification = assertion.matches("test", "tet1", "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNotNull(domainNotification);
    }

    @Test
    public void should_not_return_notification_if_match(){
        assertions.Assert assertion = new Assert();

        DomainNotification domainNotification = assertion.matches("test", "any_prefix_test_any_suffix", "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNull(domainNotification);
    }

    @Test
    public void should_return_notification_if_is_not_equal() {
        assertions.Assert assertion = new Assert();

        Command command = new Command();
        DomainNotification domainNotification = assertion.areEquals("test1","test2", "NotificationKey", "NotificationValue");
        command.addNotification(domainNotification);

        org.junit.Assert.assertTrue(command.hasNotifications());
    }

    @Test
    public void should_not_return_notification_if_is_equal() {
        assertions.Assert assertion = new Assert();

        Command command = new Command();
        DomainNotification domainNotification = assertion.areEquals("test","test", "NotificationKey", "NotificationValue");
        command.addNotification(domainNotification);

        org.junit.Assert.assertFalse(command.hasNotifications());
    }

    @Test
    public void should_not_return_notification_if_check_null_param_value_is_null() {
        assertions.Assert assertion = new Assert();

        DomainNotification domainNotification = assertion.isNull(null, "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNull(domainNotification);
    }

    @Test
    public void should_return_notification_if_check_null_param_value_is_not_null() {
        assertions.Assert assertion = new Assert();

        DomainNotification domainNotification = assertion.isNull(new Object(), "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNotNull(domainNotification);
    }
}
