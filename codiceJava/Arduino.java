import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;
import com.fazecast.jSerialComm.*;
import processing.core.PApplet;
//import processing.core.PApplet.RegisteredMethods;
//import processing.serial.Serial;


public class Arduino { //class to interface the arduino software and java
    private SerialPort comPort;
    private String portDescription;
    private int baud_rate;
    private PrintWriter pout;
    PApplet parent;
    //Serial serial;
    cc.arduino.Arduino.SerialProxy serialProxy;
    int waitForData = 0;
    int executeMultiByteCommand = 0;
    int multiByteChannel = 0;
    int[] storedInputData = new int[2];
    int[] digitalOutputData = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int[] digitalInputData = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int[] analogInputData = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    int majorVersion = 0;
    int minorVersion = 0;


    public Arduino() {
        //empty constructor if port undecided
    }
    public Arduino(String portDescription) {
        //make sure to set baud rate after
        this.portDescription = portDescription;
        comPort = SerialPort.getCommPort(this.portDescription);
    }

    public Arduino(String portDescription, int baud_rate) {
        //preferred constructor
        this.portDescription = portDescription;
        comPort = SerialPort.getCommPort(this.portDescription);
        this.baud_rate = baud_rate;
        comPort.setBaudRate(this.baud_rate);
    }



    public boolean openConnection(){
        if(comPort.openPort()){
            pout = new PrintWriter(comPort.getOutputStream());
            //try {Thread.sleep(100);} catch(Exception e){}
            return true;
        }
        else {
            return false;
        }
    }

    public void closeConnection() {
        comPort.closePort();
    }

    public void setPortDescription(String portDescription){
        this.portDescription = portDescription;
        comPort = SerialPort.getCommPort(this.portDescription);
    }
    public void setBaudRate(int baud_rate){
        this.baud_rate = baud_rate;
        comPort.setBaudRate(this.baud_rate);
    }

    public String getPortDescription(){
        return portDescription;
    }

    public SerialPort getSerialPort(){
        return comPort;
    }

    public void serialWrite(String s){
        //writes the entire string at once.
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pout.print(s);
        pout.flush();

    }

    public int digitalRead(int pin) {
        return this.digitalInputData[pin];
    }
}