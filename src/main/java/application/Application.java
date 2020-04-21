package application;
import application.MySQLAccess;
import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.*;
import java.util.Scanner;

public class Application {
    private static DiningAreaService diningAreaService= new DiningAreaService();
    static WaiterService waiterService = new WaiterService();
    static BookingService bookingService= new BookingService();
    static MySQLAccess mySQLAccess= new MySQLAccess();

    public static void main(String[] args) throws Exception {
        System.out.println("****************Diamond Restaurant Management System***************");
       DiningArea diningArea = null;
        Waiter waiter = null;
        boolean n = true;
        int choice;
        char a;
        Scanner scan = new Scanner(System.in);
        while (n == true) {
            System.out.println("enter your choice= 1. Register a dining area  2. Register a waiter  3. Map dining area with waiter  4. Book a dining area");
            choice = scan.nextInt();
            switch (choice) {
                case 1:{
                 diningArea= diningAreaService.getDiningAreaDetails();
                 mySQLAccess.writeDiningDetailsInDb(diningArea.getDiningId(), diningArea.getCapacity(), diningArea.getPrice(), diningArea.getShape());
                 break;
                }
                case 2: {
                    waiter= waiterService.getWaiterDetails();
                    mySQLAccess.writeWaiterDetailsInDb(waiter.getWaiterId(),waiter.getWaiterName(),waiter.getWaiterPhoneNumber());
                    break;
                }
                case 3:
                {
                String diningID= diningAreaService.findDiningAreaId();
                String waiterID= waiterService.findWaiterId();
                mySQLAccess.mapDiningWaiterIdInDb(diningID, waiterID);
                break;
                }
                case 4:{
                    String diningAreaBookingID= bookingService.bookDiningID();
                    bookingService.book(diningAreaBookingID);
                    break;
                }
                default: {
                    System.out.println("invalid choice");
                    break;
                }
                }
            System.out.println("do you want to continue?");
            a = scan.next().charAt(0);
            if (a == 'Y' || a == 'y') {
                continue;
            }
            if (a == 'N' || a == 'n') {
                break;
            }

                }
            }
}

