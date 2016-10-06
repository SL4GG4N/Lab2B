package PhoneContext;

import States.*;

/**
 * Created by Eddie on 2016-10-05.
 */
public class Phone {
    private PhoneState available, busy, call, incoming, ready, currentState;

    public Phone() {
        available = new Available(this);
        busy = new Busy(this);
        call = new Call(this);
        incoming = new Incoming(this);
        ready = new Ready(this);
        currentState = available;

    }

    public void setCurrentState(PhoneState nextState){
        currentState = nextState;
    }

    public String sendACK(){
        return currentState.ACK();
    }

    public String makeEstablishment(){
        return currentState.Establish();
    }

    public String makeCall(){
        return currentState.MakeCall();
    }

    public String sendBye(){
        return currentState.BYE();
    }

    public String sendOK(){
        return currentState.OK();
    }


    public PhoneState getAvailable() {
        return available;
    }

    public PhoneState getBusy() {
        return busy;
    }

    public PhoneState getCall() {
        return call;
    }

    public PhoneState getIncoming() {
        return incoming;
    }

    public PhoneState getReady() {
        return ready;
    }
}
