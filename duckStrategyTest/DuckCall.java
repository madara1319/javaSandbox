public class DuckCall{
    QuackBehavior quackBehavior;

    public DuckCall(){
        quackBehavior = new Quack();
    }
    public void display(){
        System.out.println("Im a device that sound like a duck!");
    }
    public void performQuack(){
        quackBehavior.quack();
    }
}
