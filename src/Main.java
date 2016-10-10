
import FLum.Com;
import PhoneContext.Phone;
import States.Available;
import States.PhoneState;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //Create phone

        System.out.print("Enter Server Port: ");
        Scanner input = new Scanner(System.in);
        Com com = new Com(Integer.parseInt(input.nextLine()));

    }
}
