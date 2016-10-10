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

    @Override
    public PhoneState Ack(PhoneConnection phoneConnection) {
        return this;
    }

    @Override
    public PhoneState Bye(PhoneConnection phoneConnection) {
        /* TODO
        SKICKA BYE SIGNAL
         */
        phoneConnection.SendMessage("BYE");
        return new WaitForOk();
    }

    @Override
    public PhoneState Ok(PhoneConnection phoneConnection) {
        /* TODO
        OM VI FÅR EN BYE
        SKICKA EN OK
        */

        connection.SendMessage("OK");
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
}
