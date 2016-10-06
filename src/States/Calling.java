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
}
