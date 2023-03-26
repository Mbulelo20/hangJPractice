package za.co.wethinkcode.examples.toyrobot;

public class Command {
    private String name;
    private String argument;

    public Command(String name, String argument){      // tell class to accept two args
        this(name);
        this.argument = argument.trim();
    }

    public Command(String name) {
        this.name = name;
    }

//    public Command(String name) {          // tell class to also accept 1 arg
//        this.name = name;
//    }

    public String getName() {
        return this.name;
    }
    public String getArgument() {
        return this.argument;
    }
}
