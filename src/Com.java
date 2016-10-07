import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Eddie on 2016-10-07.
 */
public class Com {
    //private static ArrayList<ClientHandler> clientHandlers;
    private static boolean running;
    private final int _PORT = 5002;

    public void Open(){
        running = true;

        ServerSocket server_socket = null;
        try {
            server_socket = new ServerSocket(_PORT);
            System.out.println("Server started....");

            while (running) {
                Socket client_socket = null;
                System.out.println("PHONE connecting.....");
                client_socket = server_socket.accept();
                System.out.println("PHONE connected " + client_socket.getInetAddress() + " " + client_socket.getPort());


                //sockets.add(client_socket);
                //clientHandlers.add(new ClientHandler(client_socket));

                //System.out.println("Number of Clients connected: " + clientHandlers.size() + "\n\n");

            }
        } catch (IOException e) {
            System.out.println("Could not accept a client");
        } finally {
            try {
                server_socket.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Could not close server socket");
            }
        }
    }
    public void Recieve(){

    }
    public void Send(){

    }

}
