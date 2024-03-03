public abstract class Duck{
    //reference variables for the behavior interface types all 
    //duck subclasses inherit these
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
    
    public abstract void display();
//delegate behavior class-----------
    public void performQuack(){
        quackBehavior.quack();
    }

    public void performFly(){
        flyBehavior.fly();
    }
//setting behavior dynamically


    public void setFlyBehavior(FlyBehavior fb){
        flyBehavior = fb;
    }
    public void setQuackBehavior(QuackBehavior qb){
        quackBehavior = qb;
    }
//----------------------------------- 
    public void swim(){
        System.out.println("All ducks float, even decoys!");
    }
}
