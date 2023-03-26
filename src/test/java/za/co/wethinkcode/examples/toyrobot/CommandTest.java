package za.co.wethinkcode.examples.toyrobot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {
    @Test
    void getNameAndArgment() {
        Command test = new Command("test", "100");
        assertEquals("test", test.getName());
        assertEquals("100", test.getArgument());
    }
    @Test
    void getHelpName() {
        HelpCommand test = new HelpCommand();
        assertEquals("help", test.getName());
    }

    @Test
    void getShutdownName() {
        ShutdownCommand test = new ShutdownCommand();
        assertEquals("off", test.getName());
    }
    @Test
    void getForwardName() {
        ForwardCommand test = new ForwardCommand("100");
        assertEquals("forward", test.getName());
        assertEquals("100", test.getArgument());
    }

}