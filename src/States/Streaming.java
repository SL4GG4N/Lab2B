package States;



/**
 * Created by Eddie on 2016-10-05.
 */
public class Streaming implements PhoneState {
    private String stateName;

    public Streaming() {
        stateName = "STREAMING";
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
        return new WaitForOk();
    }

    @Override
    public PhoneState Ok() {
        return new Available();
    }
}
