package events;

//Add Phidgets Library
import com.phidget22.*;

public class ButtonAndLEDEvents {
    //Turn on/off LEDs with Global Variables
    static boolean turnRedLEDOn = false;
    static boolean turnGreenLEDOn = false;
    static int redButtonPresses = 0;
    static int greenButtonPresses = 0;

    //Handle Exceptions
    public static void main(String[] args) throws Exception {

        //Create
        DigitalInput redButton = new DigitalInput();
        DigitalInput greenButton = new DigitalInput();
        DigitalOutput redLED = new DigitalOutput();
        DigitalOutput greenLED = new DigitalOutput();

        //Address
        redButton.setHubPort(0);
        redButton.setIsHubPortDevice(true);
        greenButton.setHubPort(5);
        greenButton.setIsHubPortDevice(true);
        redLED.setHubPort(1);
        redLED.setIsHubPortDevice(true);
        greenLED.setHubPort(4);
        greenLED.setIsHubPortDevice(true);

        //Event | Event code runs when data input from the sensor changes. The following event is a state change event. The code will listen to the button (Digital Input Object) and only run the contain code when the button is pressed or released (state changes).
        redButton.addStateChangeListener(new DigitalInputStateChangeListener() {
            public void onStateChange(DigitalInputStateChangeEvent e) {
                //Record button state to turn on/off the red LED
                turnRedLEDOn = e.getState(); 
                if (e.getState() == true) {
                redButtonPresses += 1; }
            }
        });

        //Event | Event code runs when data input from the sensor changes. The following event is a state change event. It will listen to the button (Digital Input Object) and only run the contain code when the button is pressed or released (state changes).
        greenButton.addStateChangeListener(new DigitalInputStateChangeListener() {
            public void onStateChange(DigitalInputStateChangeEvent e) {
                //Record button state to turn on/off the green LED
                turnGreenLEDOn = e.getState();
                if (e.getState() == true) {
                greenButtonPresses += 1; }
            }
        });

        //Open
        redLED.open(1000);
        greenLED.open(1000);
        redButton.open(1000);
        greenButton.open(1000);

        //Use your Phidgets | In the button events you recorded the Button State. Here we will use that data to turn on/off the LEDs
        while(redButtonPresses < 10 && greenButtonPresses < 10) {
            //turn red LED on based on red button input
            redLED.setState(turnGreenLEDOn);
            //turn green LED on based on green button input
            greenLED.setState(turnRedLEDOn);
            
            Thread.sleep(16); // ~60hz
        }
        
        // ending scene
	     
	     redLED.setState(true);
	     greenLED.setState(true);
	     Thread.sleep(500);
	     redLED.setState(false);
	     greenLED.setState(false);
	     Thread.sleep(500);
	     
	     if (redButtonPresses == 10) { // if red wins, flash their LED 5 times. If not, green must've won, so flash their LED 5 times.
	    	 for (int i = 0; i < 5; ++i) { redLED.setState(true); Thread.sleep(100); redLED.setState(false); Thread.sleep(100);}
	     } else {
	    	 for (int i = 0; i < 5; ++i) { greenLED.setState(true); Thread.sleep(100); greenLED.setState(false); Thread.sleep(100);}
	     }
    }
}
  