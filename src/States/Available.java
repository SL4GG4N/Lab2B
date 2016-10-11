package States;


import FLum.PhoneConnection;

import java.net.Socket;
import java.sql.Connection;

/**
 * Created by Eddie on 2016-10-05.
 */
public class Available implements PhoneState {
    private String stateName;

    public Available() {
        stateName = "AVAILABLE";
        System.out.println("STATE: " + stateName);
    }

    public String getStateName() {
        return stateName;
    }

    @Override
    public PhoneState Invite(PhoneConnection phoneConnection) {
        /* TODO
        SEND INVITE HÄR
        BYGG UPP ETT INVITE MEDDELANDE
         */

        phoneConnection.SendMessage("INVITE");
        return new Calling(phoneConnection);
    }

    @Override
    public PhoneState Tro(PhoneConnection phoneConnection) {
        /* TODO
        OM VI FÅR EN INVITE
        SKICKA TRO
         */
        //skapa
        //bygga upp TRO-meddelandet


        phoneConnection.SendMessage("TRO");

        //if we answer
        return new GetCalled(phoneConnection);
        //else return this
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

//exempel på meddelande INVITE
// INVITE?SENDERHOSTNAME?RECIEVERHOSTNAME?PORT