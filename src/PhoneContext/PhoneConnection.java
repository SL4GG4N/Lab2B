package PhoneContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Eddie on 2016-10-06.
 */
public class PhoneConnection implements Runnable{
    private PrintWriter output_stream;
    private BufferedReader input_client;
    private Socket client_socket = null;
    private boolean quit = false;
    private String ip_adress;

    public PhoneConnection(Socket client_socket) {
        this.client_socket = client_socket;
        ip_adress = client_socket.getInetAddress().toString();//.getHostAddress();
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            //System.out.println("before");
            input_client = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
            output_stream = new PrintWriter(client_socket.getOutputStream(), true);
            //output_stream.println("Welcome");

            String userInput;
            while (!quit && (userInput = input_client.readLine()) != null) {



                //System.out.println("Message: " + client_socket.getInetAddress() + ":  " + userInput);
            }
        } catch (Exception e) {
            System.out.println("Could not connect/lost connection");
            e.printStackTrace();
        } finally {
            output_stream.close();
            try {
                input_client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                client_socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("ClientHandler closed connection");
        }
    }
}
