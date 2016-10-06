package PhoneContext;

import States.Available;
import States.Calling;
import States.PhoneState;

/**
 * Created by Eddie on 2016-10-06.
 */
public class Phone {
    private PhoneState current;

    public Phone(){
        current = new Available();
    }

    public void Ack(){
        current = current.Ack();
    }

    public void Invite(String phone_number){
        current = current.Invite();
    }

    public void Tro(){
        current = current.Tro();
    }

    public void Ok(){
        current = current.Ok();
    }

    public void Bye(){
        current = current.Bye();
    }

    public PhoneState getCurrent() {
        return current;
    }
}
