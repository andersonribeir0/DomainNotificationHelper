package notifiables;

import org.junit.Assert;
import org.junit.Test;
import shared.Command;

public class CommandTest {

    @Test
    public void should_return_false_when_invalid_instance_is_created() {
        Command fakeCommand = new Command();
        Assert.assertEquals(false, fakeCommand.isValid());
    }

    @Test
    public void should_return_true_if_command_is_valid() {
        Command fakeCommand = new Command("test");
        Assert.assertTrue(fakeCommand.isValid());
    }
}
