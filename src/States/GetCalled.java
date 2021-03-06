package States;


import Connection.PhoneConnection;

/**
 * Created by Eddie on 2016-10-05.
 */
public class GetCalled implements PhoneState {
    private String stateName;
    private PhoneConnection connection;

    public GetCalled(PhoneConnection connection) {
        this.connection = connection;
        stateName = "GET CALLED";
        System.out.println("STATE: " + stateName);
    }

    public PhoneConnection getConnection() {
        return connection;
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
        //Todo check if the phone connection is the same.

        if (!phoneConnection.getClient_socket().equals(connection.getClient_socket())) {
            phoneConnection.SendMessage("BUSY");
            phoneConnection.EndSession();
        }

        return this;
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
        /*TODO
        Om vi får en ACK
        GÅ IN I STREAMING
         */
        //connection.SendMessage("kuken");
        if (phoneConnection.equals(connection)) {
            connection.getAudio().startStreaming();
            return new Streaming(connection);
        }
        phoneConnection.SendMessage("BUSY");
        phoneConnection.EndSession();
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