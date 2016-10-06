package States;


import PhoneContext.Phone;

/**
 * Created by Eddie on 2016-10-05.
 */
public class Available implements PhoneState {
    private Phone phone;
    public Available(Phone phone) {
        this.phone = phone;
    }


    @Override
    public String MakeCall() {
        System.out.println("CALLING...");
        System.out.println("STATE: CALL");
        phone.setCurrentState(phone.getCall());
        return "SENDING INVITE";
    }

    @Override
    public String Establish() {
        System.out.println("WRONG STATE TO CALL: Establish");
        return "Establish ERROR";
    }

    @Override
    public String ACK() {
        System.out.println("WRONG STATE TO CALL: ACK");
        return "ACK ERROR";
    }

    @Override
    public String BYE() {
        System.out.println("WRONG STATE TO CALL: BYE");
        return "BYE ERROR";
    }

    @Override
    public String OK() {
        System.out.println("WRONG STATE TO CALL: OK");
        return "OK ERROR";
    }
}
