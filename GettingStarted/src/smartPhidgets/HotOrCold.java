package smartPhidgets;

import com.phidget22.*;

public class HotOrCold {
	public static void main(String[] args) throws Exception
	{

		//declaration zone
		TemperatureSensor temperatureSensor = new TemperatureSensor();
		DigitalOutput redLED = new DigitalOutput();
		DigitalOutput greenLED = new DigitalOutput();
		double currentTemperature;
		
		//address the "dumb" phidgets
	    redLED.setHubPort(1);
	    redLED.setIsHubPortDevice(true);
	    greenLED.setHubPort(4);
	    greenLED.setIsHubPortDevice(true);
		
		//open devices
		temperatureSensor.open(1000);
		redLED.open(1000);
		greenLED.open(1000);
		
		//sensor loop
		while (true) 
		{
			currentTemperature = temperatureSensor.getTemperature(); // makes code slightly easier to read, and also prevents us from having to poll the sensor data repeatedly every refresh. Hence, it saves a little processing power at the cost of a few bytes of memory.
			
			if (currentTemperature < 20 || currentTemperature > 24) // if  the temperature is below 20 degrees, or above 24
			{
				// System.out.println("temperature outside of comfortable range");
				redLED.setState(true);
				greenLED.setState(false);
			} else {
				// System.out.println("temperature within comfortable range");
				greenLED.setState(true);
				redLED.setState(false);
			}
			
			System.out.println("Temperature: " + currentTemperature + " °C" );
			
			
			Thread.sleep(1000); // i don't think a room thermometer needs to update even this often, but it takes minimal processing power to do it anyways.
		}
	
	}	
}
