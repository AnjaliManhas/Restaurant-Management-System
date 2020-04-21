package application;
import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.*;
import java.util.Scanner;
import java.util.Date;
import java.util.UUID;


public class Booking {
    private UUID uuid;
    private String status;
    private String diningAreaBookID;

    public UUID getUuid() {
        return uuid;
    }
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getDiningAreaBookID() {
        return diningAreaBookID;
    }
    public void setDiningAreaBookID(String diningAreaBookID) {
        this.status = diningAreaBookID;
    }

}
