package com.example.billingdemo.ClientEntities;

import java.util.ArrayList;

// Current implementation not used.
public interface ClientInterface {

    public ArrayList<Object> getUnpaidBills();
    public ArrayList<Object> getMonthBills();
    public ArrayList<Object> getPaidBills();
    public ArrayList<Object> getAllBills();


}
