
import Connection.Server;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //Create phone


        System.out.print("Enter Server Port: ");
        Scanner input = new Scanner(System.in);
        Server com = new Server(Integer.parseInt(input.nextLine()));

    }
}
