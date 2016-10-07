package States;

/**
 * Created by Eddie on 2016-10-06.
 */
public class WaitForOk implements PhoneState {
    private String stateName;
    public WaitForOk() {
        stateName = "WAIT FOR OK";
    }

    @Override
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
        return this;
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
        // vi får in en OK
        return new Available();
    }
}
