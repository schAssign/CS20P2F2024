package simplePhidgets;

//Add Phidgets Library 
import com.phidget22.*;

public class ReadButton {
	
	   //Handle Exceptions 
    public static void main(String[] args) throws Exception{
        
        //Create 
        DigitalInput redButton = new DigitalInput();
        DigitalInput greenButton = new DigitalInput();
        boolean redButtonPreviousState = false;
        boolean greenButtonPreviousState = false;

        //Address 
        redButton.setHubPort(0);
        redButton.setIsHubPortDevice(true);
        greenButton.setHubPort(5);
        greenButton.setIsHubPortDevice(true);

        //Open 
        redButton.open(1000);
        greenButton.open(1000);

        //Use your Phidgets 
        while(true){
        	
        	if (redButton.getState() != redButtonPreviousState) {
        		System.out.println("Red Button State: " + redButton.getState());
        		redButtonPreviousState = redButton.getState(); // refresh this inside the "if" loop. If the condition doesn't pass, we know that the red button's previous state is equal to it's current state anyways.
        	}
        	
        	if (greenButton.getState() != greenButtonPreviousState) {
        		System.out.println("Green Button State: " + greenButton.getState());
        		greenButtonPreviousState = greenButton.getState(); 
        	}
        	            
            Thread.sleep(16); // i've decided to make the button refresh about once per frame, on a 60fps monitor. As responsive as it gets without using excessive system resources.
        }
    }

}
