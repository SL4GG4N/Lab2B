package PhoneContext;

import AudioStream.AudioStreamUDP;
import FLum.PhoneConnection;
import FLum.StateMessage;
import States.Available;
import States.Calling;
import States.PhoneState;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Eddie on 2016-10-06.
 */
public class Phone {
    private static PhoneState current;

    public Phone(){
        current = new Available();
    }

    public static synchronized void CheckStates(PhoneConnection phoneConnection) {
        switch (phoneConnection.getStateMessage().getSignal()) {
            //VÄRLDENS STÖRSTA BUGG i SWITCH CASE satsen.
            case "STATE":
                System.out.println("CURRENT STATE: " + getCurrent().getStateName());
                break;
            case "CALL":
                current = current.Invite(phoneConnection);
                break;
            case "CLOSE":
                current = current.Bye(phoneConnection);
                break;
            case "INVITE":
                current = current.Tro(phoneConnection);
                break;
            case "TRO":
                current = current.Ack(phoneConnection);
                break;
            case "ACK":
                current = current.RecieveAck(phoneConnection);
                break;
            case "BYE":
                current = current.Ok(phoneConnection);
                break;
            case "OK":
                current = current.RecieveOk(phoneConnection);
                break;
            case "ERROR":
                current = current.Error(phoneConnection);
                break;
            default:
                phoneConnection.EndSession();
        }
    }

    public static PhoneState getCurrent() {
        return current;
    }
}
