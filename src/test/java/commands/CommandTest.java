package commands;

import org.junit.Assert;
import org.junit.Test;
import shared.FakeInvalidCommand;

public class CommandTest {

    @Test
    public void should_return_invalid_when_invalid_instance_is_created() {
        FakeInvalidCommand fakeInvalidCommand = new FakeInvalidCommand();
        Assert.assertEquals(true, fakeInvalidCommand.hasNotifications());
    }
}
