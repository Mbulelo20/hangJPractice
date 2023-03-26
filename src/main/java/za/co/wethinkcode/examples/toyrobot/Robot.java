package za.co.wethinkcode.examples.toyrobot;

import java.util.List;

public class Robot {
    private static final List<String> VALID_COMMANDS = List.of("off", "help", "forward");


    public static final Position CENTRE = new Position(0,0);
    public static final Direction direction = new Direction();
    private final Position TOP_LEFT = new Position(-100,100);
    private final Position BOTTOM_RIGHT = new Position(100,-200);

    private int positionX;
    private int positionY;

    private final Direction.Direction_list currentDirection;
    private String status;
    private String name;
    public static Position position;
//    private Direction setDirection;

    public Robot(String name) {
        this.name = name;
        this.status = "Ready";
        this.position = CENTRE;
        this.currentDirection = direction.returnDirection();
    }

    public String getStatus() {
        return this.status;
    }

    public int getPositionX() {
        return this.position.getX();
    }

    public int getPositionY() {
        return this.position.getY();
    }
    public Position getPosition() {
        Position CENTRE = new Position(getPositionX(), getPositionY());
//        System.out.println(Robot.CENTRE.returnPosition());
        return CENTRE;
    }

    public String getCurrentDirection() {
        return String.valueOf(this.currentDirection);
    }

    public boolean isValidCommand(String commandInput){
        String[] args = commandInput.strip().split(" ");
        String command = args[0].trim().toLowerCase();
        return VALID_COMMANDS.contains(command);
    }
    public boolean handleCommand(Command command) {
        String commandName = command.getName();

        switch (commandName){
            case "off":
                this.status = "Shutting down";
                break;
            case "help":
                this.status = doHelp();
                break;
            case "forward":
                String argument = command.getArgument();
                this.status = doForward(Integer.parseInt(argument));
                break;
            default:
                this.status = "I am not programmed for: " + command.getName();
        }
        return true;
    }
    public boolean handleCommand(String commandInput){
        if (!isValidCommand(commandInput)) {
            status = "I am not programmed to: " + commandInput;
            return false;
        }

        String[] args = commandInput.strip().split(" ");
        String command = args[0].trim().toLowerCase();

        switch (command){
            case "off":
                status = "Shutting down";
                break;
            case "help":
                status = doHelp();
                break;
            case "forward":
                status = doForward(Integer.parseInt(args[1]));
                break;
            default:
                status = "I am not programmed for: " + command;
        }
        return true;
    }

    private String doHelp() {
        return "I can understand these commands:\n" +
                "OFF  - Shut down robot\n" +
                "HELP - provide information about commands\n" +
                "FORWARD - move forward by specified number of steps, e.g. 'FORWARD 10'";
    }




    private boolean updatePosition(int nrSteps){
        int newY = this.position.getY();
        int newX = this.position.getX();

        if (this.currentDirection.equals(Direction.Direction_list.NORTH)) {

            newY = newY + nrSteps;
        }

        Position newPosition = new Position(newX, newY);
        if (newPosition.isIn(TOP_LEFT,BOTTOM_RIGHT)){
            this.position = newPosition;
            return true;
        }
        return false;
    }


    private String doForward(int nrSteps){
        if (updatePosition(nrSteps)){
            return "Moved forward by "+nrSteps+" steps.";
        } else {
            return "Sorry, I cannot go outside my safe zone.";
        }
    }

    @Override
    public String toString() {
        return "[" + this.position.getX() + "," + this.position.getX() + "] "
                + "{" + currentDirection + "} "
                + name + "> " + status;
    }

    public static void main(String[] args){
        Robot r = new Robot("M");
        Command c = new Command("forward","12");
        System.out.println("hhhh: "+ r.getPosition());
    }
}