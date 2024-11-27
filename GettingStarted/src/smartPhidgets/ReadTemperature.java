package smartPhidgets;

import com.phidget22.*;

public class ReadTemperature {
    public static void main(String[] args) throws Exception{

        //Create 
        TemperatureSensor temperatureSensor = new TemperatureSensor();

        //Open 
        temperatureSensor.open(1000);

        //Use your Phidgets 
        while (true) {
            System.out.println("Temperature: " + temperatureSensor.getTemperature() + " °C" );
            System.out.println("Temperature: " + ((temperatureSensor.getTemperature() * 1.8 ) + 32) + " °F\n" );
            Thread.sleep(150);
        }
    }
}
  