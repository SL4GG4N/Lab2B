package States;

/**
 * Created by Eddie on 2016-10-05.
 */
public interface PhoneState {
    String getStateName();
    PhoneState Invite();
    PhoneState Tro();
    PhoneState Ack();
    PhoneState Bye();
    PhoneState Ok();
}