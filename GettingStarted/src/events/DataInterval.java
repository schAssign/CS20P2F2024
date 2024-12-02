package events;

//Add Phidgets Library
import com.phidget22.*;

public class DataInterval {
    //Handle Exceptions
    public static void main(String[] args) throws Exception {

        //Create
        TemperatureSensor temperatureSensor = new TemperatureSensor();

        //Temperature Event 
        temperatureSensor.addTemperatureChangeListener(new TemperatureSensorTemperatureChangeListener() {
            public void onTemperatureChange(TemperatureSensorTemperatureChangeEvent e) {
                System.out.println("Temperature: " + e.getTemperature());
            }
        });

        //Open
        temperatureSensor.open(5000);

        //Set Data Interval 
        temperatureSensor.setDataInterval(60000);

        //Keep program running
        while (true) {
            Thread.sleep(150);
        }
    }
}
 