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
        /* TODO
        SEND INVITE HÄR
         */


        return new Calling();
    }

    @Override
    public PhoneState Tro() {
        /* TODO
        OM VI FÅR EN INVITE
        SKICKA TRO
         */
        return new GetCalled();
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
        return this;
    }
}
