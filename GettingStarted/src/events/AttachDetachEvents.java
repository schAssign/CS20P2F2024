package events;

//Add Phidgets Library
import com.phidget22.*;

public class AttachDetachEvents {

    public static void main(String[] args) throws Exception {
       
         //Create
        TemperatureSensor temperatureSensor = new TemperatureSensor();
        DigitalInput redButton = new DigitalInput();
        DigitalInput greenButton = new DigitalInput();
        DigitalOutput redLED = new DigitalOutput();
        DigitalOutput greenLED = new DigitalOutput();
        boolean redLEDState = false;
        
        // address
        redButton.setHubPort(0);
        redButton.setIsHubPortDevice(true);
        redLED.setHubPort(1);
        redLED.setIsHubPortDevice(true);;


        //Data Event 
        temperatureSensor.addTemperatureChangeListener(new TemperatureSensorTemperatureChangeListener() {
            public void onTemperatureChange(TemperatureSensorTemperatureChangeEvent e) {
                //Print temperature
                System.out.println("Temperature: " + e.getTemperature() + "°C");
            }
        });

        //Attach Event 
        temperatureSensor.addAttachListener(new AttachListener() {
            public void onAttach(AttachEvent e) {
                System.out.println("Attach Humidity Sensor");
            }
        });
        
        //red button Attach Event 
        redButton.addAttachListener(new AttachListener() {
            public void onAttach(AttachEvent e) {
                System.out.println("Attach Red Button");
            }
        });
        
        //red button Detach Event 
        redButton.addDetachListener(new DetachListener() {
            public void onDetach(DetachEvent e) {
                System.out.println("Detach Red Button");
            }
        });

        //Detach Event 
        temperatureSensor.addDetachListener(new DetachListener() {
            public void onDetach(DetachEvent e) {
                System.out.println("Detach Humidity Sensor");
            }
        });
        
        //red LED Attach Event 
        redLED.addAttachListener(new AttachListener() {
            public void onAttach(AttachEvent e) {
                System.out.println("Attach Red LED");
            }
        });
        
        //red LED Detach Event 
        redLED.addDetachListener(new DetachListener() {
            public void onDetach(DetachEvent e) {
                System.out.println("Detach Red LED");
            }
        });


        //Open
        temperatureSensor.open(1000);
        redButton.open(1000);
        redLED.open(1000);

        //Keep program running
        while (true) {
        	redLEDState = !redLEDState;
        	redLED.setState(redLEDState);
            Thread.sleep(1000);
        }
    }
}
 