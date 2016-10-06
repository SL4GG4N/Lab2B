package PhoneContext;

/**
 * Created by Eddie on 2016-10-06.
 */
public class PhoneConnection implements Runnable{
    public PhoneConnection() {
        new Thread(this).start();
    }

    @Override
    public void run() {

    }
}
