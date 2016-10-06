package States;

import PhoneContext.Phone;

/**
 * Created by Eddie on 2016-10-05.
 */
public class Ready implements PhoneState
{
    private Phone phone;
    public Ready(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String MakeCall() {
        System.out.println("CALLED WRONG FUNCTION: MakeCall");
        return "WRONG STATE TO CALL:";
    }

    @Override
    public String Establish() {
        System.out.println("CALLED WRONG FUNCTION: Establish");
        return "WRONG STATE TO CALL:";
    }

    @Override
    public String ACK() {
        phone.setCurrentState(phone.getBusy());
        System.out.println("BUSY");
        return "ACK";
    }

    @Override
    public String BYE() {
        System.out.println("CALLED WRONG FUNCTION: BYE");
        return "WRONG STATE TO CALL:";
    }

    @Override
    public String OK() {
        System.out.println("CALLED WRONG FUNCTION: OK");
        return "WRONG STATE TO CALL:";
    }
}
