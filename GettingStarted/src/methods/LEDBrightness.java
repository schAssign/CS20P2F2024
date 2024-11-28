package methods;

//Add Phidgets Library 
import com.phidget22.*;

public class LEDBrightness {
    //Handle Exceptions 
    public static void main(String[] args) throws Exception{

        //Create 
        DigitalOutput redLED = new DigitalOutput();

        //Address 
        redLED.setHubPort(1);
        redLED.setIsHubPortDevice(true);

        //Open 
        redLED.open(1000);

        //Use your Phidgets with Duty Cycle | Duty Cycle controls the power to your Phidget (Digital Output object). Duty Cycle values range from 0.0 - 1.0.
        	// (this is PWM.)
        
        for (int i = 0; i < 100; ++i)  // increase in brightness
        {
        	redLED.setDutyCycle((double)i / 100);
        	Thread.sleep(16);;
        }
        
        for (int i = 100; i > 0; --i)  // decrease in brightness
        {
        	redLED.setDutyCycle((double)i / 100);
        	Thread.sleep(16);
        }
        
        redLED.setState(false); // turn off
        
        
    }
}
  