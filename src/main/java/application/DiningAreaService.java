package application;
import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.*;
import java.util.Scanner;

public class DiningAreaService {
    public DiningArea getDiningAreaDetails() {
        DiningArea diningArea = new DiningArea();
        Scanner scanner = new Scanner(System.in);
        System.out.println("==============Dining Details Input for Registration=================");
        System.out.println("Please enter dining ID : ");
        String diningId = scanner.nextLine();
        diningArea.setDiningId(diningId);
        System.out.println("Please enter the capacity( number of seats) of the dining area");
        int capacity = scanner.nextInt();
        diningArea.setCapacity(capacity);
        System.out.println("Enter its price");
        float price = scanner.nextFloat();
        diningArea.setPrice(price);
        System.out.println("enter its shape");
        String shape = scanner.nextLine();
        shape=scanner.nextLine();
        diningArea.setShape(shape);

        return diningArea;

    }
    public String findDiningAreaId() {
        System.out.println("Dining ID to map: ");
        Scanner scanner = new Scanner(System.in);
        String diningID = scanner.nextLine();
        return diningID;
    }
}
