package commands;

import org.junit.Assert;
import org.junit.Test;
import shared.Command;
import shared.FakeInvalidCommand;

public class CommandTest {

    @Test
    public void should_return_invalid_when_invalid_instance_is_created() {
        Command fakeCommand = new Command();
        fakeCommand.validate();
        Assert.assertEquals(true, fakeCommand.hasNotifications());
    }

    @Test
    public void should_return_valid_if_command_is_valid() {
        Command fakeCommand = new Command("test");
        fakeCommand.validate();
        Assert.assertFalse(fakeCommand.hasNotifications());
    }
}
