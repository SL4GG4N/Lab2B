package Connection;

import Interface.UserInterface;
import PhoneContext.Phone;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Eddie on 2016-10-07.
 */
public class Server {
    //private static ArrayList<ClientHandler> clientHandlers;
    private static boolean running;
    private final int _PORT;
    private PhoneConnection connection;
    private ServerSocket server_socket;

    public Server(int _PORT) {
        this._PORT = _PORT;
        running = true;
        server_socket = null;
        Phone phone = new Phone();
        Open();
    }

    private void Open() {

        try {
            server_socket = new ServerSocket(_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        UserInterface ui = new UserInterface(connection);
        while (running) {
            try {
                //System.out.println("Phone created, waiting for socket accept....");
                // socket är satt här
                Socket client_socket = null;
                client_socket = server_socket.accept();
                System.out.println("hello");
                //fixme set ringing mode so that no one can interrupt
                connection = new PhoneConnection(client_socket);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("kuken i fittan anus");
            }
        }
    }
}
