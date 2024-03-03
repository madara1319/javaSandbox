public class MiniDuckSimulator{
    public static void main(String[] args){
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        Duck model = new ModelDuck();
        //flybehavior object set in model duck which is nofly instance
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        //model inherited beahvior setter method rocketpowerflying ability
        model.performFly();
    }
}
