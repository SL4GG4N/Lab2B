package FLum;

import AudioStream.AudioStreamUDP;
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
    private StateMessage stateMessage;
    private boolean ifUser = false;

    //private Phone phone;
    private AudioStreamUDP audio;

    public PhoneConnection(Socket client_socket) {
        this.client_socket = client_socket;
        //this.phone = phone;
        new Thread(this).start();
    }
    public PhoneConnection(Socket client_socket, boolean isUser) {
        this.client_socket = client_socket;
        this.ifUser = isUser;
        stateMessage = new StateMessage("BYE");

    }

    public void EndSession(){


        quit = true;

        /*if (input_phone != null){
            try {

                input_phone.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

    }

    public void SendMessage(String msg) {

        System.out.println("SEND: " + msg);
        if (output_phone != null)
            output_phone.println(msg);

    }

    public AudioStreamUDP getAudio() {
        return audio;
    }

    public void setAudio(AudioStreamUDP audio) {
        this.audio = audio;
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
                stateMessage = new StateMessage(user_input);
                Phone.CheckStates(this);
            }
        } catch (IOException e) {
            System.out.println("Could not connect/lost connection");
            e.printStackTrace();
        } finally {
            output_phone.close();

            try {
                input_phone.close();
            } catch (IOException e) {
                //e.printStackTrace();
            }
            try {
                client_socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("ClientHandler closed connection");
            stateMessage = new StateMessage("ERROR");
            Phone.CheckStates(this);
        }
    }


    public  Socket getClient_socket() {
        return client_socket;
    }

    public StateMessage getStateMessage() {
        return stateMessage;
    }

    public void setStateMessage(StateMessage stateMessage){
        this.stateMessage = stateMessage;
    }


    public void setIfUser(boolean ifUser) {
        this.ifUser = ifUser;
    }

    public boolean getIfUser() {
        return ifUser;
    }
}
