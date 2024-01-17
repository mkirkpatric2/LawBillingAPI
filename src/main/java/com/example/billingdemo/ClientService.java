package com.example.billingdemo;

import com.example.billingdemo.ClientEntities.ClientHelpers;
import com.example.billingdemo.ClientEntities.ClientLit;
import com.example.billingdemo.ClientEntities.ClientTx;
import org.json.JSONArray;
import org.springframework.stereotype.Service;
import java.sql.*;

@Service
public class ClientService {

    public int postClientLit(ClientLit lit){
        Connection conn = ClientHelpers.sqlStartConn();
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
        Connection conn = ClientHelpers.sqlStartConn();
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
//    public JSONArray getAllBillsTx(int id){
//        Connection conn = sqlStartConn();
//
//        try {
//            // execute sql query and close connection
//            Statement sql = conn.createStatement();
//            ResultSet sqlOutput = sql.executeQuery(
//                    "SELECT a.id, b.name, a.details, a.hours,\n" +
//                            "       CASE\n" +
//                            "           WHEN b.attorney=false THEN b.hourlyrate*.75\n" +
//                            "           ELSE b.hourlyrate\n" +
//                            "       END AS rate,\n" +
//                            "       ROUND(CASE\n" +
//                            "           WHEN b.attorney=false THEN b.hourlyrate*.75*a.hours\n" +
//                            "           ELSE b.hourlyrate*a.hours\n" +
//                            "       END, 2) AS subtotal\n" +
//                            "FROM bills a\n" +
//                            "JOIN billers b ON a.biller = b.id\n" +
//                            "WHERE clientcode = "
//                            + id + ";");
//            JSONArray jsonOutput = ClientHelpers.sqlToJSON(sqlOutput);
//            conn.close();
//            sql.close();
//            System.out.println(jsonOutput);
//            return jsonOutput;
//        } catch(Exception e) {
//            System.out.println(e.fillInStackTrace().toString());
//            return null;
//        }
//    }




}
