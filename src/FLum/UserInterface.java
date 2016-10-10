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

    public UserInterface(Phone phone,PhoneConnection connection) {
        this.connection = connection;
        this.phone = phone;
        new Thread(this).start();
    }

    @Override
    public void run() {

        Scanner input = new Scanner(System.in);
        while (!shut_down) {

            System.out.print("Call <NUMBER>: ");
            String usr_text = input.nextLine();

            if (usr_text.toUpperCase().equals("SHUTDOWN")){
                shut_down = true;
            }else if (usr_text.toUpperCase().contains("CALL")){
                try {
                    System.out.println("USER TEXT: " + usr_text);
                    usr_text = usr_text.substring(usr_text.lastIndexOf(" ") + 1);
                    Socket socket = new Socket(usr_text, 5010);
                    System.out.println("SOCKET BUILDED");
                    connection = new PhoneConnection(socket, phone);
                    Thread.sleep(3000);
                    phone.CheckStates("CALL", connection);
                } catch (IOException e) {
                    System.out.println("USERINTERFACE:   Server is down or doesn't exist");
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Client Exits");
        System.exit(1);


    }
}
