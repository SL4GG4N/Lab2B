package States;


import Connection.PhoneConnection;

import java.io.IOException;
import java.net.InetAddress;

/**
 * Created by Eddie on 2016-10-05.
 */
public class Calling implements PhoneState {
    private String stateName;
    private PhoneConnection connection;

    public Calling(PhoneConnection connection) {
        stateName = "CALLING";
        this.connection = connection;
        System.out.println("STATE: " + stateName);
    }

    public String getStateName() {
        return stateName;
    }

    @Override
    public PhoneState Invite(PhoneConnection phoneConnection) {
        return this;
    }

    @Override
    public PhoneState Tro(PhoneConnection phoneConnection) {
        phoneConnection.SendMessage("BUSY");
        phoneConnection.EndSession();
        return this;
    }

    public PhoneConnection getConnection() {
        return connection;
    }

    @Override
    public PhoneState Ack(PhoneConnection phoneConnection) {
        /*TODO
        om vi får en tro
        SKICKA ACK signal
         */

        if (phoneConnection.equals(connection)) {
            try {
                connection.getAudio().connectTo(InetAddress.getByName(
                        connection.getStateMessage().getIp_caller()),
                        connection.getStateMessage().getVoice_port());
                connection.getAudio().startStreaming();
                connection.SendMessage("ACK");
                return new Streaming(connection);
            } catch (IOException e) {
                e.printStackTrace();
                return this;
            }
        } else {
            phoneConnection.SendMessage("BUSY");
            phoneConnection.EndSession();
        }
        return this;
    }

    @Override
    public PhoneState Bye(PhoneConnection phoneConnection) {
        return this;
    }

    @Override
    public PhoneState Ok(PhoneConnection phoneConnection) {
        if(phoneConnection.equals(connection)){
            connection.EndSession();
            return new Available();
        }else {
            phoneConnection.EndSession();
            return this;
        }
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
        System.out.println("BAKSDKAJSDKJAEW");
        if (connection.getClient_socket().getPort()!=(phoneConnection.getClient_socket().getPort())){
            return this;
        }
        return new Available();
    }
}