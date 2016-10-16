package States;

import Connection.PhoneConnection;

/**
 * Created by Eddie on 2016-10-05.
 */
public interface PhoneState {
    String getStateName();
    PhoneState Invite(PhoneConnection phoneConnection);
    PhoneState Tro(PhoneConnection phoneConnection);
    PhoneState Ack(PhoneConnection phoneConnection);
    PhoneState Bye(PhoneConnection phoneConnection);
    PhoneState Ok(PhoneConnection phoneConnection);
    PhoneState RecieveAck(PhoneConnection phoneConnection);
    PhoneState RecieveOk(PhoneConnection phoneConnection);
    PhoneState Error(PhoneConnection phoneConnection);
}