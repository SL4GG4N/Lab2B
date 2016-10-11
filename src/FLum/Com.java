package FLum;

import PhoneContext.Phone;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Eddie on 2016-10-07.
 */
public class Com {
    //private static ArrayList<ClientHandler> clientHandlers;
    private static boolean running;
    private final int _PORT;
    private PhoneConnection connection;
    private static Phone phone;
    private ServerSocket server_socket;

    public Com(int _PORT) {
        this._PORT = _PORT;
        running = true;
        try {
            phone = new Phone();
        } catch (Exception e) {
            System.out.println("COM HAS NO PHONE");
            e.printStackTrace();
        }
        server_socket = null;
        Open();
    }

    private void Open() {


        try {
            server_socket = new ServerSocket(_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        UserInterface ui = new UserInterface(phone);
        while (running) {

            try {


                System.out.println("Phone created, waiting for socket accept....");
                // socket är satt här
                Socket client_socket = server_socket.accept();
                System.out.println("hello");
                //fixme set ringing mode so that no one can interrupt
                connection = new PhoneConnection(client_socket, phone);

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("kuken i fittan anus");
            } finally {
                try {
                    server_socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    public static void restartPhone()throws Exception{
        phone = new Phone();
    }


}
