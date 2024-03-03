public class MiniDuckSimulator{
    public static void main(String[] args){
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performQuack();
        mallard.performFly();
        Duck redhead = new RedheadDuck();
        redhead.display();
        redhead.performQuack();
        redhead.performFly();

        redhead.setFlyBehavior(new FlyRocketPowered());
        redhead.performFly();
        
        redhead.setQuackBehavior(new MuteQuack());
        redhead.performQuack();


        Duck model = new ModelDuck();
        model.display();
        //flybehavior object set in model duck which is nofly instance
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        //model inherited beahvior setter method rocketpowerflying ability
        model.performFly();

        Duck rubber = new RubberDuck();
        rubber.display();
        rubber.swim();

        rubber.performFly();

        DuckCall duckcall = new DuckCall();
        duckcall.display();
        duckcall.performQuack();
    }
}
