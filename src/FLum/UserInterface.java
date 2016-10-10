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
                    Socket socket = new Socket(usr_text, 5003);
                    connection = new PhoneConnection(socket, phone);
                    phone.CheckStates(usr_text.substring(usr_text.lastIndexOf(" ") + 1), connection);

                } catch (IOException e) {
                    System.out.println("USERINTERFACE:   Server is down or doesn't exist");
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Client Exits");
        System.exit(1);


    }
}
