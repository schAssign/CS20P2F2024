package simplePhidgets;

import com.phidget22.*;

public class TugOfWar 
{
	
	 public static void main(String[] args) throws Exception 
	 {
	
		 // declaration zone
		 DigitalInput redButton = new DigitalInput();
		 DigitalOutput redLED = new DigitalOutput();
		 DigitalInput greenButton = new DigitalInput();
		 DigitalOutput greenLED = new DigitalOutput();
		 boolean redButtonPreviousState = false;
		 boolean greenButtonPreviousState = false;
		 int redButtonPressedAmount = 0;
		 int greenButtonPressedAmount = 0;
		 int pressesToAchieve = 10;
		 
		 // set the address for all devices
		 redButton.setHubPort(0);
	     redButton.setIsHubPortDevice(true);
	     redLED.setHubPort(1);
	     redLED.setIsHubPortDevice(true);
	     greenButton.setHubPort(5);
	     greenButton.setIsHubPortDevice(true);
	     greenLED.setHubPort(4);
	     greenLED.setIsHubPortDevice(true);
	     
	     //Open 
	     redButton.open(1000);
	     redLED.open(1000);
	     greenButton.open(1000);
	     greenLED.open(1000);
	     
	     // game loop
	     while (redButtonPressedAmount < pressesToAchieve && greenButtonPressedAmount < pressesToAchieve ) 
	     {
	            if (redButton.getState() != redButtonPreviousState && redButton.getState() == true){ // the order of "if" statements here gives red a minimal advantage, should both buttons reach "10" on the same refresh.
	            	redButtonPressedAmount += 1;
	            	System.out.println(redButtonPressedAmount);
	            	
	            }
	            
	            if (greenButton.getState() != greenButtonPreviousState && greenButton.getState() == true){
	            	greenButtonPressedAmount += 1;
	            	System.out.println(greenButtonPressedAmount);
	            	
	            }
	            
	            greenButtonPreviousState = greenButton.getState();
	            redButtonPreviousState = redButton.getState();
	            
	            Thread.sleep(4); // Refreshes about 240 times per second. I believe this should be enough not to drop inputs, if somebody is really fast at pressing the button.
	     }
	     
	     
	     // ending scene
	     
	     redLED.setState(true);
	     greenLED.setState(true);
	     Thread.sleep(500);
	     redLED.setState(false);
	     greenLED.setState(false);
	     Thread.sleep(500);
	     
	     if (redButtonPressedAmount == 10) { // if red wins, flash their LED 5 times. If not, green must've won, so flash their LED 5 times.
	    	 for (int i = 0; i < 5; ++i) { redLED.setState(true); Thread.sleep(100); redLED.setState(false); Thread.sleep(100);}
	     } else {
	    	 for (int i = 0; i < 5; ++i) { greenLED.setState(true); Thread.sleep(100); greenLED.setState(false); Thread.sleep(100);}
	     }
	     
	    
	 }
}
