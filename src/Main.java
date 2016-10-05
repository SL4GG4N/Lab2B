import States.Phone;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Phone phone = new Phone();
        phone.sendACK();
        phone.makeCall();
        phone.makeCall();
        phone.makeEstablishment();
        phone.makeEstablishment();
        phone.sendACK();
        phone.sendBye();
        phone.makeCall();
    }
}
