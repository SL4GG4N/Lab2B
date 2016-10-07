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
    public String getStateName(/* Skicka socket */) {
        return stateName;
    }

    @Override
    public PhoneState Invite(/* Skicka socket */) {
        return this;
    }

    @Override
    public PhoneState Tro(/* Skicka socket */) {
        return this;
    }

    @Override
    public PhoneState Ack(/* Skicka socket */) {
        return this;
    }

    @Override
    public PhoneState Bye(/* Skicka socket */) {
        /* TODO
        SKICKA BYE SIGNAL
         */

        return new WaitForOk();
    }

    @Override
    public PhoneState Ok(/* Skicka socket */) {
        /* TODO
        OM VI FÅR EN BYE
        SKICKA EN OK
        */

        return new Available();
    }

    @Override
    public PhoneState RecieveAck(/* Skicka ingen socket */) {
        return this;
    }

    @Override
    public PhoneState RecieveOk(/* Skicka ingen socket */) {
        return this;
    }
}
