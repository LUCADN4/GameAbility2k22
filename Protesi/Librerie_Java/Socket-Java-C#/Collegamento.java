package Fine;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import processing.core.PApplet;

public class Collegamento {
    public static void main(String[] args) throws IOException {
        Arduino arduino;

        ServerSocket serverSocket = new ServerSocket(4343, 10);
        Socket socket = serverSocket.accept() ;
        InputStream is ;
        PApplet processing = new PApplet();
        boolean runserver = true;
        int boundRate = 115200;
        arduino = new Arduino("COM7", boundRate);
        arduino.openConnection(); //we open the connection of the arduino using the instance of the class "Arduino"
        boolean connected = arduino.openConnection(); //we define a boolean variable to know if the arduino can communicate with java or not
        System.out.println("connection established: " + connected);
        do
        {
            try {
                 runserver = true;
                 serverSocket = new ServerSocket(4343, 10);
                 socket = serverSocket.accept();
                 is = socket.getInputStream();

                // Receiving
                byte[] lenBytes = new byte[4];
                is.read(lenBytes, 0, 4);
                int len = (((lenBytes[3] & 0xff) << 24) | ((lenBytes[2] & 0xff) << 16) |
                        ((lenBytes[1] & 0xff) << 8) | (lenBytes[0] & 0xff));
                byte[] receivedBytes = new byte[len];
                is.read(receivedBytes, 0, len);
                String received = new String(receivedBytes, 0, len);

                //System.out.println("numero" + Integer.parseInt(received));
                if(Integer.parseInt(received.split(",")[0])> 35 ){
                    arduino.serialWrite("1");
                    System.out.println("ciao");
                    processing.delay(500);
                }else processing.delay(500);
                if(received != null) {
                    System.out.println("Server received: " + received);
                }
                serverSocket.close();

            }
            catch(Exception e) {
                serverSocket.close();
            }

        }

        while(runserver);

    }
}