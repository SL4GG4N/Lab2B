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
    private final int _PORT = 5003;
    private PhoneConnection connection;
    private Phone phone;

    public void Open() {
        running = true;
        phone = new Phone();
        ServerSocket server_socket = null;

        try {
            server_socket = new ServerSocket(_PORT);
            System.out.println("Phone created, waiting for socket accept....");

            UserInterface ui = new UserInterface(phone,connection);

            while (running) {
                Socket client_socket = null;
                //System.out.println("PHONE connecting.....");
                client_socket = server_socket.accept();
                System.out.println("Accept recieved");

                if (connection == null || phone.getCurrent().getStateName().equals("AVAILABLE")) {
                    connection = new PhoneConnection(client_socket, phone);
                } else {
                    phone.CheckStates("INVITE", new PhoneConnection(client_socket));
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                server_socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}