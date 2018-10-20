package assertions;

import notifiables.AbstractNotifiable;
import notifications.DomainNotification;
import org.junit.Test;
import shared.Command;

public class AssertTest {

    @Test
    public void should_return_notification_if_value_is_null() {
        
    	DomainNotification domainNotification = Assert.isNotNull(null, "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNotNull(domainNotification);
    }

    @Test
    public void should_not_return_notification_if_value_is_not_null() {
        
        DomainNotification domainNotification = Assert.isNotNull(new Object(), "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNull(domainNotification);
    }

    @Test
    public void should_return_notification_if_value_is_empty_or_whitespace() {

        AbstractNotifiable command = new Command("test");
        command.addNotification(Assert.notEmpty(null, "NotificationKey", "NotificationValue"));
        command.addNotification(Assert.notEmpty(" ", "NotificationKey", "NotificationValue"));
        command.addNotification(Assert.notEmpty("   ", "NotificationKey", "NotificationValue"));

        org.junit.Assert.assertTrue(command.getNotifications().size() == 3);
    }

    @Test
    public void should_not_return_notification_if_length_range_matches() {
        
        DomainNotification domainNotification = Assert.length("12345678", 8, 8, "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNull(domainNotification);
    }

    @Test
    public void should_return_notification_if_length_range_does_not_match() {
        
        DomainNotification domainNotification = Assert.length("12345678", 9, 10, "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNotNull(domainNotification);
    }

    @Test
    public void should_return_notification_if_not_match(){
       
        DomainNotification domainNotification = Assert.matches("test", "tet1", "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNotNull(domainNotification);
    }

    @Test
    public void should_not_return_notification_if_match(){
        
        DomainNotification domainNotification = Assert.matches("test", "any_prefix_test_any_suffix", "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNull(domainNotification);
    }

    @Test
    public void should_return_notification_if_is_not_equal() {
       
        Command command = new Command("test");
        DomainNotification domainNotification = Assert.areEquals("test1","test2", "NotificationKey", "NotificationValue");
        command.addNotification(domainNotification);

        org.junit.Assert.assertTrue(command.hasNotifications());
    }

    @Test
    public void should_not_return_notification_if_is_equal() {
        
        Command command = new Command("test");
        DomainNotification domainNotification = Assert.areEquals("test","test", "NotificationKey", "NotificationValue");
        command.addNotification(domainNotification);

        org.junit.Assert.assertFalse(command.hasNotifications());
    }

    @Test
    public void should_not_return_notification_if_check_null_param_value_is_null() {
        
        DomainNotification domainNotification = Assert.isNull(null, "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNull(domainNotification);
    }

    @Test
    public void should_return_notification_if_check_null_param_value_is_not_null() {
        
        DomainNotification domainNotification = Assert.isNull(new Object(), "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNotNull(domainNotification);
    }

    @Test
    public void should_not_return_notification_if_param_value_is_true() {

        DomainNotification domainNotification = Assert.isTrue(true, "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNull(domainNotification);
    }

    @Test
    public void should_return_notification_if_param_value_is_false() {

        DomainNotification domainNotification = Assert.isTrue(false, "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNotNull(domainNotification);
    }

    @Test
    public void should_not_return_notification_if_first_argument_value_is_greater_than_the_second_one() {

        DomainNotification domainNotification = Assert.isGreaterThan(2, 1, "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNull(domainNotification);

        domainNotification = Assert.isGreaterThan(1.01, 1.005, "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNull(domainNotification);
    }

    @Test
    public void should_return_notification_if_first_argument_value_is_equal_or_less_than_the_second_one() {

        DomainNotification domainNotification = Assert.isGreaterThan(1, 1, "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNotNull(domainNotification);

        domainNotification = Assert.isGreaterThan(1, 2, "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNotNull(domainNotification);

        domainNotification = Assert.isGreaterThan(1.1, 1.1, "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNotNull(domainNotification);

        domainNotification = Assert.isGreaterThan(1.1, 1.2, "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNotNull(domainNotification);

    }

    @Test
    public void should_not_return_notification_if_first_argument_value_is_greater_or_equal_than_the_second_one() {

        DomainNotification domainNotification = Assert.isGreaterOrEqualThan(1, 1, "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNull(domainNotification);

        domainNotification = Assert.isGreaterOrEqualThan(2.003, 2.003, "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNull(domainNotification);

        domainNotification = Assert.isGreaterOrEqualThan(2, 0, "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNull(domainNotification);

        domainNotification = Assert.isGreaterOrEqualThan(1.3, 1.2, "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNull(domainNotification);

    }

    @Test
    public void should_return_notification_if_first_argument_value_is_less_than_the_second_one() {

        DomainNotification domainNotification = Assert.isGreaterOrEqualThan(1, 2, "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNotNull(domainNotification);

        domainNotification = Assert.isGreaterOrEqualThan(2.003, 2.004, "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNotNull(domainNotification);

    }

    @Test
    public void should_not_return_notification_if_email_is_valid() {

        DomainNotification domainNotification = Assert.emailIsValid("aa@sss.com", "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNull(domainNotification);
    }

    @Test
    public void should_return_notification_if_email_is_not_valid() {

        DomainNotification domainNotification = Assert.emailIsValid("@.aaa.com", "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNotNull(domainNotification);

        domainNotification = Assert.emailIsValid("ddd.@@l.aaa.com", "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNotNull(domainNotification);

    }

    @Test
    public void should_not_return_notification_if_regex_match() {

        DomainNotification domainNotification = Assert.regexMatch("123-45-6789", "^(\\d{3}-?\\d{2}-?\\d{4})$", "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNull(domainNotification);

    }

    @Test
    public void should_not_return_notification_if_url_is_valid() {

        DomainNotification domainNotification = Assert.urlIsValid("http://localhost/", "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNull(domainNotification);

        domainNotification = Assert.urlIsValid("https://localhost/", "NotificationKey", "NotificationValue");

        org.junit.Assert.assertNull(domainNotification);

    }


}
