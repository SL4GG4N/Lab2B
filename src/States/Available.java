package States;


import FLum.PhoneConnection;

import java.sql.Connection;

/**
 * Created by Eddie on 2016-10-05.
 */
public class Available implements PhoneState {
    private String stateName;
    public Available() {
        stateName = "AVAILABLE";
    }

    public String getStateName() {
        return stateName;
    }

    @Override
    public PhoneState Invite(PhoneConnection phoneConnection) {
        /* TODO
        SEND INVITE HÄR
         */
        phoneConnection.SendMessage("INVITE");
        return new Calling();
    }

    @Override
    public PhoneState Tro(PhoneConnection phoneConnection) {
        /* TODO
        OM VI FÅR EN INVITE
        SKICKA TRO
         */
        phoneConnection.SendMessage("TRO");
        System.out.println("BAJS");

        return new GetCalled();
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
        return this;
    }

    @Override
    public PhoneState RecieveOk(PhoneConnection phoneConnection) {
        return this;
    }
}
