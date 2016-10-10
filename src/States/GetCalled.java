package States;


import FLum.PhoneConnection;

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
        /*TODO
        Om vi får en ACK
        GÅ IN I STREAMING
         */
        return new Streaming();
    }

    @Override
    public PhoneState RecieveOk(PhoneConnection phoneConnection) {
        return this;
    }
}
