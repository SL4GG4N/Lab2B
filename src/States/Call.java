package States;

import PhoneContext.Phone;

/**
 * Created by Eddie on 2016-10-05.
 */
public class Call implements PhoneState {
    private Phone phone;
    public Call(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String MakeCall() {
        System.out.println("CALL WITHIN A CALL IS NOT POSSIBLE");
        return "MakeCall ERROR";
    }

    @Override
    public String Establish() {
        phone.setCurrentState(phone.getBusy());
        System.out.println("BUSY");
        return "Establish";
    }

    @Override
    public String ACK() {
        System.out.println("WRONG STATE TO CALL: ACK");
        return "ACK ERROR";
    }

    @Override
    public String BYE() {
        return "WRONG STATE TO CALL; BYE";
    }

    @Override
    public String OK() {
        return "WRONG STATE TO CALL: OK";
    }
}
