package States;

import FLum.PhoneConnection;

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

    public PhoneConnection getConnection() {
        return connection;
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
        // vi får in en OK
        connection.getAudio().close();
        connection.EndSession();
        return new Available();
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
