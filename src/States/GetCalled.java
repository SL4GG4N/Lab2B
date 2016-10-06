package States;



/**
 * Created by Eddie on 2016-10-05.
 */
public class GetCalled implements PhoneState {
    private String stateName;
    public GetCalled() {
        stateName = "GET CALLED";
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
        return new Streaming();
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
}
