package za.co.wethinkcode.examples.toyrobot;

public class Direction {

    private Direction_list robotDirection = Direction_list.NORTH;
    enum Direction_list{
        EAST,
        WEST,
        NORTH,
        SOUTH

    }


//    private final Directions direction;

    public void setDirection(Direction_list newDirection){
        this.robotDirection = newDirection;
    }

    public Direction_list returnDirection(){
        return this.robotDirection;
    }

    public static void main(String[] g){
        Direction p = new Direction();
        System.out.println("Get this: "+ p.returnDirection());
    }
}
