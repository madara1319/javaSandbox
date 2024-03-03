public class WeatherData{
    //instance variable declarations
    public void measurementsChanged(){

//grab most recent measurements by calling WeatheData getter methods
        float temp = getTemperature();
        float humidity = getHumidity();
        float pressure = getPressure();
//update each display
        currentConditionsDisplay.update(temp, humidity, pressure);
        statisticsDisplay.update(temp, humidity, pressure);
        forecastDisplay.update(temp, humidity, pressure);
    }
}
            '
