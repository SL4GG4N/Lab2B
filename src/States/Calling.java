package States;



/**
 * Created by Eddie on 2016-10-05.
 */
public class Calling implements PhoneState {
    private String stateName;
    public Calling() {
        stateName = "CALLING";
    }

    public String getStateName() {
        return stateName;
    }

    @Override
    public PhoneState Invite() {
        return this;
    }

    @Override
    public PhoneState Tro() {
        return this;
    }

    @Override
    public PhoneState Ack() {
        /*TODO
        om vi får en tro
        SKICKA ACK signal
         */

        return new Streaming();
    }

    @Override
    public PhoneState Bye() {
        return this;
    }

    @Override
    public PhoneState Ok() {
        return this;
    }

    @Override
    public PhoneState RecieveAck() {
        return this;
    }

    @Override
    public PhoneState RecieveOk() {
        return this;
    }
}
