package application;
import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.*;
import java.util.Scanner;
import java.util.Date;
import java.util.UUID;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BookingService {
    public Booking book( String diningAreaBookID){
        Scanner scanner= new Scanner(System.in);
        Booking booking= new Booking();
        booking.setDiningAreaBookID( diningAreaBookID);
        System.out.println("==========Diamond Restaurant Management System==========");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        booking.setUuid(UUID.randomUUID());
        UUID uuid = booking.getUuid();
        System.out.println(" Your dining area of ID="+ diningAreaBookID+"has been booked with booking Id="+uuid);
        char checkout;
        System.out.println("do you want to check out? Y/N");
        checkout= scanner.next().charAt(0);
        if( checkout == 'Y'|| checkout=='y'){
            System.out.println("enter the number of fooditems ordered");
            int n= scanner.nextInt();
            String[] fooditems = new String[n];
            float[] foodprice= new float[n];
            float sum=0;

            for(int i=0; i<n; i++){
                System.out.println("enter the food items");
                fooditems[i]= scanner.nextLine();
                fooditems[i]= scanner.nextLine();
                System.out.println("enter the cost of this food item");
                foodprice[i]= scanner.nextFloat();
                sum= sum+ foodprice[i];
            }
            System.out.println("***************Diamond Restaurant Bill****************");
            System.out.println(dtf.format(now));
            System.out.println("food items ordered at dining area :"+diningAreaBookID);
            for(int j=0; j<n; j++){
                System.out.println(fooditems[j]+"             "+foodprice[j]);
            }
            System.out.println("total bill=                 "+sum);
            System.out.println("Thank you for visiting our restaurant");
            booking.setStatus("Available");
        }
        else{
            booking.setStatus("Not Available");
        }
        return booking;

    }
    public String bookDiningID() {
        System.out.println("enter dining area ID to be booked: ");
        Scanner scanner = new Scanner(System.in);
        String diningID = scanner.nextLine();
        return diningID;
    }
}
