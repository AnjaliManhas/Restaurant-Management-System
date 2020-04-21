package application;
import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.*;
import java.util.Scanner;

public class WaiterService {
    public Waiter getWaiterDetails() {
        Waiter waiter = new Waiter();
        Scanner scanner = new Scanner(System.in);
        System.out.println("==============Waiter Details Input for Registration=================");
        System.out.println("Please enter waiter ID : ");
        String waiterId = scanner.nextLine();
        waiter.setWaiterId(waiterId);
        System.out.println("Please enter the name");
        String waiterName = scanner.nextLine();
        waiter.setWaiterName(waiterName);
        System.out.println("Enter phone number");
        String waiterPhoneNumber= scanner.nextLine();
        waiter.setWaiterPhoneNumber(waiterPhoneNumber);
        return waiter;

    }
    public String findWaiterId() {
        System.out.println("Waiter ID to assign a dining area: ");
        Scanner scanner = new Scanner(System.in);
        String waiterID = scanner.nextLine();
        return waiterID;
    }
}
