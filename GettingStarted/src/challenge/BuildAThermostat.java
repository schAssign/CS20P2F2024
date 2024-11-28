package challenge;

import com.phidget22.*;

public class BuildAThermostat {
	public static void main(String[] args) throws Exception
	{

		//declaration zone
		TemperatureSensor temperatureSensor = new TemperatureSensor();
		DigitalOutput redLED = new DigitalOutput();
		DigitalOutput greenLED = new DigitalOutput();
		DigitalInput redButton = new DigitalInput();
		DigitalInput greenButton = new DigitalInput();
        boolean redButtonPreviousState = false;
        boolean greenButtonPreviousState = false;
        int thermostatSetTemperature = 21; // room temperature by default
		int printTemperatureEvery_Seconds = 1;
		int pollingSpeedInHertz = 100;
		int printTemperatureEvery_Refresh = printTemperatureEvery_Seconds * pollingSpeedInHertz;
		int refreshNumber = 0;
		
		//address the "dumb" phidgets
	    redLED.setHubPort(1);
	    redLED.setIsHubPortDevice(true);
	    greenLED.setHubPort(4);
	    greenLED.setIsHubPortDevice(true);
	    redButton.setHubPort(0);
	    redButton.setIsHubPortDevice(true);
	    greenButton.setHubPort(5);
	    greenButton.setIsHubPortDevice(true);
		
		//open devices
		temperatureSensor.open(1000);
		redLED.open(1000);
		greenLED.open(1000);
		redButton.open(1000);
		greenButton.open(1000);
		
		 while(true){
			 
			 	refreshNumber += 1;
			 	
	            if (redButton.getState() != redButtonPreviousState && redButton.getState() == true){ // in other words: "if button is pressed"
	            	System.out.println("redbutton pressed");
	            	thermostatSetTemperature -= 1;
	            }
	            
	            if (greenButton.getState() != greenButtonPreviousState && greenButton.getState() == true){ // in other words: "if button is pressed"
	            	System.out.println("green button pressed");
	            	thermostatSetTemperature += 1;
	            }
	            
	            redButtonPreviousState = redButton.getState(); // must be placed after (redbutton.getState != redButtonPreviousState)
	            
	            greenButtonPreviousState = greenButton.getState(); // must be placed after (redbutton.getState != redButtonPreviousState)
	            
	            if (refreshNumber % printTemperatureEvery_Refresh == 0) // will cause the temperature to be printed, matching the printTemperatureEvery_Seconds variable
	            { 
	            	System.out.println("Temperature: " + temperatureSensor.getTemperature() + " Set Temperature: " + thermostatSetTemperature); 
	            	
	            	if (thermostatSetTemperature > temperatureSensor.getTemperature() - 2 && thermostatSetTemperature < temperatureSensor.getTemperature() + 2) 
	            	{
	            		greenLED.setState(true);
	            		redLED.setState(false);
	            	} else {
	            		greenLED.setState(false);
	            		redLED.setState(true);
	            	}
	            } 
	            
	            


	            Thread.sleep((int)(((1 / (double)pollingSpeedInHertz) * 1000))); // convert the polling speed to miliseconds. MAKE SURE YOU'RE DOING REAL DIVISION!!
	            
	        }
			
			
	
	}
	
}
