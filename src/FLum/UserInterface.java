package FLum;

import PhoneContext.Phone;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Scalman on 10/10/16.
 */
public class UserInterface implements Runnable {

    private Phone phone;
    private boolean shut_down = false;
    private PhoneConnection connection;
    private String calling_ip;
    private int _port;

    public UserInterface(Phone phone) {
        this.phone = phone;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("running interface");
        Scanner input = new Scanner(System.in);
        while (!shut_down) {

           // System.out.print("Call <NUMBER>: ");
            String usr_text = input.nextLine();
            Socket socket = null;
            if (usr_text.toUpperCase().equals("SHUTDOWN")){
                shut_down = true;
            }else if (usr_text.toUpperCase().contains("CALL")){
                try {
                    String[] splitted = usr_text.split(" ");
                    calling_ip = splitted[1];
                    _port = Integer.parseInt(splitted[2]);
                    socket = new Socket(calling_ip, _port);

                    System.out.println("SOCKET BUILDED");
                    connection = new PhoneConnection(socket, phone);
                    Thread.sleep(3000);

                    connection.setStateMessage(new StateMessage("CALL"));
                    phone.CheckStates(connection);
                } catch (IOException e) {
                    System.out.println("USERINTERFACE:   Server is down or doesn't exist");
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else if (usr_text.toUpperCase().contains("BYE")) {

            }
        }

        System.out.println("Client Exits");
        System.exit(1);


    }

}
