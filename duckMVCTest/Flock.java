import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


public class Flock implements Quackable{
    Observable observable;
    List<Quackable> quackers = new ArrayList<Quackable>();
    

    public void add(Quackable quacker)
    {
        quackers.add(quacker);
    }

    public void quack(){
        Iterator<Quackable> iterator = quackers.iterator();
        while(iterator.hasNext()){
            Quackable quacker = iterator.next();
            quacker.quack();
        }
    }
    public void registerObserver(Observer observer){
        observable.registerObserver(observer);
    }
    public void notifyObservers(){
        observable.notifyObservers();
    }
}
