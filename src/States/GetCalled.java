package States;


import FLum.PhoneConnection;

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

        if (!phoneConnection.getClient_socket().equals(connection.getClient_socket())){
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
        return this;
    }

    @Override
    public PhoneState RecieveAck(PhoneConnection phoneConnection) {
        /*TODO
        Om vi får en ACK
        GÅ IN I STREAMING
         */
        //connection.SendMessage("kuken");
        return new Streaming(connection);
    }

    @Override
    public PhoneState RecieveOk(PhoneConnection phoneConnection) {
        return this;
    }
}
