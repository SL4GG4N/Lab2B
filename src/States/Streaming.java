package States;


import Connection.PhoneConnection;

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
        phoneConnection.EndSession();
        if (phoneConnection.equals(connection)){
            return new Available();
        }
        else return this;
    }

    @Override
    public PhoneState Tro(PhoneConnection phoneConnection) {
        phoneConnection.SendMessage("BUSY");
        phoneConnection.EndSession();
        return this;
    }

    @Override
    public PhoneState Ack(PhoneConnection phoneConnection) {
        phoneConnection.EndSession();
        if (phoneConnection.equals(connection)){
            return new Available();
        }
        else return this;
    }

    @Override
    public PhoneState Bye(PhoneConnection phoneConnection) {
        /* TODO
        SKICKA BYE SIGNAL
         */

        if(!phoneConnection.getIfUser()){

            phoneConnection.EndSession();
            return this;
        }
        connection.SendMessage("BYE");
        connection.getAudio().stopStreaming();
        return new WaitForOk(connection);
    }

    @Override
    public PhoneState Ok(PhoneConnection phoneConnection) {
        /* TODO
        OM VI FÅR EN BYE
        SKICKA EN OK
        */
        if(!connection.equals(phoneConnection)){
            phoneConnection.EndSession();
            return this;
        }
        connection.SendMessage("OK");
        connection.getAudio().stopStreaming();
        connection.EndSession();
        connection.getAudio().close();
        return new Available();
    }

    @Override
    public PhoneState RecieveAck(PhoneConnection phoneConnection) {
        phoneConnection.EndSession();
        if (phoneConnection.equals(connection)){
            return new Available();
        }
        else return this;
    }

    @Override
    public PhoneState RecieveOk(PhoneConnection phoneConnection) {
        phoneConnection.EndSession();
        if (phoneConnection.equals(connection)){
            return new Available();
        }
        else return this;
    }

    @Override
    public PhoneState Error(PhoneConnection phoneConnection) {

        if (connection.getClient_socket().getPort()!=(phoneConnection.getClient_socket().getPort())){
            return this;
        }
        return new Available();
    }
}