package States;

import Connection.PhoneConnection;

/**
 * Created by Eddie on 2016-10-06.
 */
public class WaitForOk implements PhoneState {
    private String stateName;
    private PhoneConnection connection;

    public WaitForOk(PhoneConnection connection) {
        stateName = "WAIT FOR OK";
        this.connection = connection;
        System.out.println("STATE: " + stateName);
    }

    @Override
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

    @Override
    public PhoneState Ack(PhoneConnection phoneConnection) {
        if (phoneConnection.equals(connection)) {
            phoneConnection.EndSession();
            return new Available();
        }
        else{
            phoneConnection.EndSession();
        }return this;
    }

    @Override
    public PhoneState Bye(PhoneConnection phoneConnection) {
        if (phoneConnection.equals(connection)) {
            phoneConnection.EndSession();
            return new Available();
        }
        else{
            phoneConnection.EndSession();
        }return this;
    }

    @Override
    public PhoneState Ok(PhoneConnection phoneConnection) {
        if (phoneConnection.equals(connection)) {
            phoneConnection.EndSession();
            return new Available();
        }
        else{
            phoneConnection.EndSession();
        }return this;
    }

    @Override
    public PhoneState RecieveAck(PhoneConnection phoneConnection) {
        if (phoneConnection.equals(connection)) {
            phoneConnection.EndSession();
            return new Available();
        }
        else{
            phoneConnection.EndSession();
        }return this;
    }

    @Override
    public PhoneState RecieveOk(PhoneConnection phoneConnection) {
        // vi får in en OK

        connection.getAudio().stopStreaming();
        connection.getAudio().close();
        connection.EndSession();
        return new Available();
    }

    @Override
    public PhoneState Error(PhoneConnection phoneConnection) {
        if (connection.getClient_socket().getPort()!=(phoneConnection.getClient_socket().getPort())){
            return this;
        }
        return new Available();
    }
}
