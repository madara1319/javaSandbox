public class GooseAdapter implements Quackable{
    Goose goose;
    Observable observable;

    public GooseAdapter(Goose goose){
        this.goose=goose;
    }
    public void quack(){
        goose.honk();
    }


    public void registerObserver(Observer observer){
        observable.registerObserver(observer);
    }
    public void notifyObservers(){
        observable.notifyObservers();
    }
}
