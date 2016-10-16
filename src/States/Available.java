package States;


import AudioStream.AudioStreamUDP;
import Connection.PhoneConnection;

import java.io.IOException;
import java.net.InetAddress;

/**
 * Created by Eddie on 2016-10-05.
 */
public class Available implements PhoneState {
    private String stateName;

    public Available() {
        stateName = "AVAILABLE";
        System.out.println("STATE: " + stateName);
    }

    public String getStateName() {
        return stateName;
    }

    @Override
    public PhoneState Invite(PhoneConnection phoneConnection) {
        /* TODO
        SEND INVITE HÄR
        BYGG UPP ETT INVITE MEDDELANDE
         */

        AudioStreamUDP audioStreamUDP = null;
        try {
            audioStreamUDP = new AudioStreamUDP();
            phoneConnection.setAudio(audioStreamUDP);
            String invite = "INVITE " + "EXAMPLE " + "EXAMPLE " +
                    phoneConnection.getClient_socket().getInetAddress().toString().substring(1) + " " +
                    phoneConnection.getClient_socket().getLocalAddress().toString().substring(1) + " " +
                    audioStreamUDP.getLocalPort();
            phoneConnection.SendMessage(invite);
        } catch (IOException e) {
            e.printStackTrace();
            return this;
        }
        return new Calling(phoneConnection);
    }

    @Override
    public PhoneState Tro(PhoneConnection phoneConnection) {
        /* TODO
        OM VI FÅR EN INVITE
        SKICKA TRO
         */
        //skapa
        //bygga upp TRO-meddelandet
        AudioStreamUDP audioStreamUDP = null;
        try {
            System.out.println("CALLER: " + phoneConnection.getStateMessage().getIp_caller());
            audioStreamUDP = new AudioStreamUDP();
            audioStreamUDP.connectTo(InetAddress.getByName(phoneConnection.getStateMessage().getIp_caller()),
                    phoneConnection.getStateMessage().getVoice_port());
            phoneConnection.setAudio(audioStreamUDP);
            String tro = "TRO " + "EXAMPLE " + "EXAMPLE " +
                    phoneConnection.getStateMessage().getIp_caller() + " " +
                    phoneConnection.getStateMessage().getIp_reciever() + " " +
                    audioStreamUDP.getLocalPort();
            phoneConnection.SendMessage(tro);
        } catch (IOException e) {
            e.printStackTrace();
            return this;
        }
        phoneConnection.getStateMessage().getVoice_port();
        phoneConnection.SendMessage("TRO");

        //if we answer
        return new GetCalled(phoneConnection);
        //else return this
    }

    @Override
    public PhoneState Ack(PhoneConnection phoneConnection) {
        return this;
    }

    @Override
    public PhoneState Bye(PhoneConnection phoneConnection) {
        return this;
    }

    @Override
    public PhoneState Ok(PhoneConnection phoneConnection) {
        return this;
    }

    @Override
    public PhoneState RecieveAck(PhoneConnection phoneConnection) {
        return this;
    }

    @Override
    public PhoneState RecieveOk(PhoneConnection phoneConnection) {
        return this;
    }

    @Override
    public PhoneState Error(PhoneConnection phoneConnection) {
        return this;
    }
}