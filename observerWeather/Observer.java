public interface Observer{
    //state observers get from the subject when a weather measurement changes
    public void update(float temp, float humidity, float pressure);
}

