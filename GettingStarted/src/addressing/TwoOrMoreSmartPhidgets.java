package addressing;

//Add Phidgets Library 
import com.phidget22.*;

public class TwoOrMoreSmartPhidgets {
	
    public static void main(String[] args) throws Exception{

        //Create 
        TemperatureSensor temperatureSensor0 = new TemperatureSensor();
        TemperatureSensor temperatureSensor1 = new TemperatureSensor();
        DigitalInput redButton = new DigitalInput();
        DigitalInput greenButton = new DigitalInput();

         //Address 
         temperatureSensor0.setHubPort(3);
         temperatureSensor1.setHubPort(2);
         redButton.setHubPort(0);
         redButton.setIsHubPortDevice(true);
         greenButton.setHubPort(5);
         greenButton.setIsHubPortDevice(true);
         
         //Event | Event code runs when data input from the sensor changes. The following event is a state change event. The code will listen to the button (Digital Input Object) and only run the contain code when the button is pressed or released (state changes).
         redButton.addStateChangeListener(new DigitalInputStateChangeListener() {
             public void onStateChange(DigitalInputStateChangeEvent e) {
                 if (e.getState()) {
                	 try {
                		 System.out.println("Temperature 0: " + temperatureSensor0.getTemperature() + " °C");
                	 } catch (PhidgetException e1) {
                		 // TODO Auto-generated catch block
                		 e1.printStackTrace();
				}
                 }
             }
         });

         //Event | Event code runs when data input from the sensor changes. The following event is a state change event. It will listen to the button (Digital Input Object) and only run the contain code when the button is pressed or released (state changes).
         greenButton.addStateChangeListener(new DigitalInputStateChangeListener() {
             public void onStateChange(DigitalInputStateChangeEvent e) {
                 if (e.getState()) {
                	 try {
                		 System.out.println("Temperature 1: " + temperatureSensor1.getTemperature() + " °C");
                	 } catch (PhidgetException e1) {
                		 // TODO Auto-generated catch block
                		 e1.printStackTrace();
				}
                 }
             }
         });

        //Open 
        temperatureSensor0.open(1000);
        temperatureSensor1.open(1000);
        redButton.open(1000);
        greenButton.open(1000);

        //Use your Phidgets 
        while (true) {
        	
            Thread.sleep(150);
        }
    }
}