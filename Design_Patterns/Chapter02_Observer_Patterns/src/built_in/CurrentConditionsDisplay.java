package built_in;

import manual.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:04 2019/2/21
 * @Modified By:
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    public void update(Observable obs, Object arg){
        if (obs instanceof WeatherData){
            WeatherData weatherData = (WeatherData) obs;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}
