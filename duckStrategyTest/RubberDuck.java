public class RubberDuck extends Duck{
    public RubberDuck(){
        quackBehavior = new Squeak();
        flyBehavior = new FlyNoWay();
    }

    public void display(){
        System.out.println("Im a rubber duck!");
    }
    
}
