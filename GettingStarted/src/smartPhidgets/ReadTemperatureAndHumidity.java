package smartPhidgets;

import com.phidget22.*;

public class ReadTemperatureAndHumidity {
    public static void main(String[] args) throws Exception{

        //Create 
        HumiditySensor humiditySensor = new HumiditySensor();
        TemperatureSensor temperatureSensor = new TemperatureSensor();

        //Open 
        humiditySensor.open(1000);
        temperatureSensor.open(1000);

        //Use your Phidgets 
        while(true){
            
            // if humidity is below 30% relative humidity, print "humidity is too low"
            if (humiditySensor.getHumidity() < 30) {
            	System.out.print("Humidity is low! ");
            } else {
            	System.out.print("Humidity: " + humiditySensor.getHumidity() + "%RH ");
            }
            
            if (temperatureSensor.getTemperature() < 21) {
            	System.out.println("Temperature is low!");
            } else {
            	System.out.println("Temperature: " + temperatureSensor.getTemperature() + " °C");
            }
            
            Thread.sleep(150);
        }
    }
}
  