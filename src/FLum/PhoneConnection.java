package FLum;

import PhoneContext.Phone;
import States.Available;
import States.PhoneState;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Eddie on 2016-10-06.
 */
public class PhoneConnection implements Runnable {
    private PrintWriter output_phone;
    private BufferedReader input_phone;
    private Socket client_socket = null;
    private boolean quit = false;
    private Phone phone;

    public PhoneConnection(Socket client_socket, Phone phone) {
        this.client_socket = client_socket;
        this.phone = phone;
        new Thread(this).start();
    }

    public void EndSession(){
        if (output_phone != null) {
            output_phone.close();
        }

        if (input_phone != null){
            try {
                input_phone.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (client_socket != null){
            try {
                client_socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void SendMessage(String msg) {

        System.out.println("SEND: " + msg);
        if (output_phone != null)
            output_phone.println(msg);

    }

    @Override
    public void run() {
        try {
            input_phone = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
            output_phone = new PrintWriter(client_socket.getOutputStream(), true);

            String user_input;
            while (!quit && (user_input = input_phone.readLine()) != null) {
                //System.out.println(userInput);
                System.out.println("RECEIVE: " + user_input);
                phone.CheckStates(user_input, this);
            }
        } catch (Exception e) {
            System.out.println("Could not connect/lost connection");
             Com.restartPhone(); //VARFÖR FUNGERAR INTE DENNA JÄVULEN
            e.printStackTrace();
        } finally {
            output_phone.close();
            try {
                input_phone.close();
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

    public  Socket getClient_socket() {
        return client_socket;
    }
}
