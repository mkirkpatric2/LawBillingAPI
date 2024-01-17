package com.example.billingdemo.ClientEntities;

import com.example.billingdemo.ClientService;
import org.json.JSONArray;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ClientTx{

    private Integer clientCode;
    private String clientName;
    private Boolean isActive;
    private Integer leadAttorney;
    private String clientPhoneNo;
    private Boolean isLit = false;


    public ArrayList<Object> getUnpaidBills() {
        return null;
    }


    public ArrayList<Object> getMonthBills() {
        return null;
    }


    public ArrayList<Object> getPaidBills() {
        return null;
    }


    public static JSONArray getAllBills(int id){
        Connection conn = ClientHelpers.sqlStartConn();

        try {
            // execute sql query and close connection
            Statement sql = conn.createStatement();
            ResultSet sqlOutput = sql.executeQuery(
                    "SELECT a.id, b.name, a.details, a.hours,\n" +
                            "       CASE\n" +
                            "           WHEN b.attorney=false THEN b.hourlyrate*.75\n" +
                            "           ELSE b.hourlyrate\n" +
                            "       END AS rate,\n" +
                            "       ROUND(CASE\n" +
                            "           WHEN b.attorney=false THEN b.hourlyrate*.75*a.hours\n" +
                            "           ELSE b.hourlyrate*a.hours\n" +
                            "       END, 2) AS subtotal\n" +
                            "FROM bills a\n" +
                            "JOIN billers b ON a.biller = b.id\n" +
                            "WHERE clientcode = "
                            + id + ";");
            JSONArray jsonOutput = ClientHelpers.sqlToJSON(sqlOutput);
            conn.close();
            sql.close();
            System.out.println(jsonOutput);
            return jsonOutput;
        } catch(Exception e) {
            System.out.println(e.fillInStackTrace().toString());
            return null;
        }
    }

    public Integer getClientCode() {
        return this.clientCode;
    }

    public void setClientCode(Integer code) {
        this.clientCode = code;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Boolean getisActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getLeadAttorney() {
        return leadAttorney;
    }

    public void setLeadAttorney(Integer leadAttorney) {
        this.leadAttorney = leadAttorney;
    }

    public String getClientPhoneNo() {
        return clientPhoneNo;
    }

    public void setClientPhoneNo(String clientPhoneNo) {
        this.clientPhoneNo = clientPhoneNo;
    }

    public Boolean getisLit() {
        return isLit;
    }

    public void setisLit(Boolean lit) {
        isLit = lit;
    }
}
