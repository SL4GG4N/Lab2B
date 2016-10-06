package States;


import java.sql.Connection;

/**
 * Created by Eddie on 2016-10-05.
 */
public class Available implements PhoneState {
    private String stateName;
    public Available() {
        stateName = "AVAIABLE";
    }

    public String getStateName() {
        return stateName;
    }

    @Override
    public PhoneState Invite() {
        //connect





        return new Calling();
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
}
