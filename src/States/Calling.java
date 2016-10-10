package States;


import FLum.PhoneConnection;

/**
 * Created by Eddie on 2016-10-05.
 */
public class Calling implements PhoneState {
    private String stateName;
    public Calling() {
        stateName = "CALLING";
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

    @Override
    public PhoneState Ack(PhoneConnection phoneConnection) {
        /*TODO
        om vi får en tro
        SKICKA ACK signal
         */
        phoneConnection.SendMessage("ACK");
        return new Streaming();
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
}
