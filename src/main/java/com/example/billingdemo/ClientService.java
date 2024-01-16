package com.example.billingdemo;

import com.example.billingdemo.ClientEntities.ClientLit;
import com.example.billingdemo.ClientEntities.ClientTx;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class ClientService {

    public int postClientLit(ClientLit lit){
        Connection conn = sqlStartConn();
        if (conn == null) {
            return 0;
        }
        // "INSERT INTO clients"
        // Build sql string
        StringBuilder sb = new StringBuilder("INSERT INTO clients (clientname, isactive, leadattorney, clientphoneno) VALUES ('");

        sb.append(lit.getClientName()).append("', ");
        sb.append(lit.getisActive().toString()).append(", ");
        sb.append(lit.getLeadAttorney().toString()).append(", '");
        sb.append(lit.getClientPhoneNo());
        sb.append("');");
        System.out.println(sb.toString());

        try {
            // execute sql query and close connection
            Statement sql = conn.createStatement();
            sql.executeUpdate(sb.toString());
            conn.close();
            sql.close();
            return 1;
        } catch(Exception e) {
            System.out.println(e.fillInStackTrace().toString());
            return 0;
        }
    }

    public int postClientTx(ClientTx tx){
        Connection conn = sqlStartConn();
        if (conn == null) {
            return 0;
        }
        // "INSERT INTO clients"
        // Build sql string
        StringBuilder sb = new StringBuilder("INSERT INTO clients (clientname, isactive, leadattorney, clientphoneno) VALUES ('");

        sb.append(tx.getClientName()).append("', ");
        sb.append(tx.getisActive().toString()).append(", ");
        sb.append(tx.getLeadAttorney().toString()).append(", '");
        sb.append(tx.getClientPhoneNo());
        sb.append("');");
        System.out.println(sb.toString());

        try {
            // execute sql query and close connection
            Statement sql = conn.createStatement();
            sql.executeUpdate(sb.toString());
            conn.close();
            sql.close();
            return 1;
        } catch(Exception e) {
            System.out.println(e.fillInStackTrace().toString());
            return 0;
        }
    }
    public ResultSet getAllBills(int id){
        Connection conn = sqlStartConn();

        try {
            // execute sql query and close connection
            Statement sql = conn.createStatement();
            ResultSet output = sql.executeQuery("SELECT * FROM bills WHERE clientcode = " + id + ";");
            conn.close();
            sql.close();
            return output;
        } catch(Exception e) {
            System.out.println(e.fillInStackTrace().toString());
            return null;
        }
    }


    private Connection sqlStartConn(){
        String url = "jdbc:postgresql://localhost:5432/postgres";
        try {
            return DriverManager.getConnection(url, "postgres", "password");
        } catch(Exception e) {
            System.out.println(e.fillInStackTrace().toString());
            return null;
        }
    }

}
