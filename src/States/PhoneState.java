package States;

/**
 * Created by Eddie on 2016-10-05.
 */
public interface PhoneState {
    String MakeCall();
    String Establish();
    String ACK();
    String BYE();
    String OK();
}
