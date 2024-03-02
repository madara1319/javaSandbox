public class QuackCounter implements Quackable{
    Quackable duck;

    Observable observable;
    static int numberOfQuacks;
    public QuackCounter(Quackable duck)
    {
        this.duck=duck;
    }
    public void quack(){
        duck.quack();
        numberOfQuacks++;
    }
    public static int getQuacks(){
        return numberOfQuacks;
    }


    public void registerObserver(Observer observer){
        observable.registerObserver(observer);
    }
    public void notifyObservers(){
        observable.notifyObservers();
    }
}
