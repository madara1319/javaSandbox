import java.util.*;

//WeatherData implements Subject interface
public class WeatherData implements Subject{
//ArrayList to hold observers we create it in constructor
    public List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(){
        observers = new ArrayList<Observer>();
    }

    public void registerObserver(Observer o){
        observers.add(o);
    }

    public void removeObserver(Observer o){
        observers.remove(o);
    }
   //we know all observers must implement update method so we notify them like that 
    public void notifyObservers(){
        for (Observer observer : observers){
            observer.update(temperature, humidity, pressure);
        }
    }
    
//we notify everytime we get new data
    public void measurementsChanged(){
        notifyObservers();
    }
//we dont have real measurements so we implement this method to test our display elements could take measurements from web someday tho
    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
//other WeatherData methods here
    }
