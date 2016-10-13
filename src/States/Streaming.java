package States;


import FLum.PhoneConnection;

/**
 * Created by Eddie on 2016-10-05.
 */
public class Streaming implements PhoneState {
    private String stateName;
    private PhoneConnection connection;
    public Streaming(PhoneConnection connection) {
        this.connection = connection;
        stateName = "STREAMING";
        System.out.println("STATE: " + stateName);
    }

    @Override
    public String getStateName(/* Skicka socket */) {
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
        /* TODO
        SKICKA BYE SIGNAL
         */
        if(!phoneConnection.equals(connection) || !phoneConnection.getIfUser()){
            return this;
        }
        phoneConnection.SendMessage("BYE");
        connection.getAudio().stopStreaming();
        return new WaitForOk(connection);
    }

    @Override
    public PhoneState Ok(PhoneConnection phoneConnection) {
        /* TODO
        OM VI FÅR EN BYE
        SKICKA EN OK
        */
        connection.SendMessage("OK");
        connection.getAudio().stopStreaming();
        connection.getAudio().close();
        connection.EndSession();
        return new Available();
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
