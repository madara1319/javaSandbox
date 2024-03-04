public interface Subject{
    //both methods take an Observer as argument that is Obsever to be registered or removed
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    //this method is called to notify all observers when the subject state has changed
    public void notifyObservers();

}
