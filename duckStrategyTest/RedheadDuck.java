public class RedheadDuck extends Duck{
    public RedheadDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }
    public void display(){
        System.out.println("Im a real Redhead Duck!");
    }
}
