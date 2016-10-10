package PhoneContext;

import FLum.PhoneConnection;
import States.Available;
import States.Calling;
import States.PhoneState;

import java.net.Socket;

/**
 * Created by Eddie on 2016-10-06.
 */
public class Phone {
    private PhoneState current;

    public Phone(){
        current = new Available();
    }

    public synchronized void CheckStates(String msg, PhoneConnection phoneConnection){
        switch (msg){
            case "CALL":    current = current.Invite(phoneConnection); break;
            case "CLOSE":   current = current.Bye(phoneConnection); break;
            case "INVITE":  current = current.Tro(phoneConnection); break;
            case "TRO":     current = current.Ack(phoneConnection); break;
            case "ACK":     current = current.RecieveAck(phoneConnection); break;
            case "BYE":     current = current.Ok(phoneConnection); break;
            case "OK":      current = current.RecieveOk(phoneConnection); break;
            default:        phoneConnection.EndSession();
        }
    }

    public PhoneState getCurrent() {
        return current;
    }
}
