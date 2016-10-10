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
    private final int _PORT = 5002;
    private PhoneConnection connection;
    private Phone phone;

    public void Open() {
        running = true;
        phone = new Phone();
        ServerSocket server_socket = null;

        try {
            server_socket = new ServerSocket(_PORT);
            System.out.println("Phone created, waiting for socket accept....");

            UserInterface ui = new UserInterface(phone, connection);

            while (running) {
                // socket är satt här
                Socket client_socket = server_socket.accept();

                //lyssna efter meddelanden;

                //skicka meddelandet till checkstates
                phone.CheckStates("INVITE", new PhoneConnection(client_socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server_socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
