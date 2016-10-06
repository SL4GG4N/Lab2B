package States;

import PhoneContext.Phone;

/**
 * Created by Eddie on 2016-10-05.
 */
public class Busy implements PhoneState {
    private Phone phone;
    public Busy(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String MakeCall() {
        return null;
    }

    @Override
    public String Establish() {
        return null;
    }

    @Override
    public String ACK() {
        return null;
    }

    @Override
    public String BYE() {
        phone.setCurrentState(phone.getAvailable());
        System.out.println("AVAILABLE");
        return null;
    }

    @Override
    public String OK() {
        return null;
    }
}
