package PhoneContext;

import Connection.PhoneConnection;
import States.Available;
import States.PhoneState;

/**
 * Created by Eddie on 2016-10-06.
 */
public class Phone {
    private static PhoneState current;
    private PhoneConnection connection;

    public Phone(){
        current = new Available();
        connection = null;
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
