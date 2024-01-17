package com.example.billingdemo;

import com.example.billingdemo.ClientEntities.ClientHelpers;
import com.example.billingdemo.ClientEntities.ClientLit;
import com.example.billingdemo.ClientEntities.ClientTx;
import org.json.JSONArray;
import org.springframework.stereotype.Service;
import java.sql.*;

import static com.example.billingdemo.ClientEntities.ClientHelpers.sqlStartConn;

@Service
public class ClientService {

    public int postClientLit(ClientLit lit){
        Connection conn = sqlStartConn();
        if (conn == null) {
            return 0;
        }
        // "INSERT INTO clients"
        // Build sql string
        StringBuilder sb = new StringBuilder("INSERT INTO clients (clientname, isactive, leadattorney, clientphoneno, islit) VALUES ('");

        sb.append(lit.getClientName()).append("', ");
        sb.append(lit.getisActive().toString()).append(", ");
        sb.append(lit.getLeadAttorney().toString()).append(", '");
        sb.append(lit.getClientPhoneNo()).append("', ");
        sb.append(lit.getisLit());
        sb.append(");");
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
        StringBuilder sb = new StringBuilder("INSERT INTO clients (clientname, isactive, leadattorney, clientphoneno, islit) VALUES ('");

        sb.append(tx.getClientName()).append("', ");
        sb.append(tx.getisActive().toString()).append(", ");
        sb.append(tx.getLeadAttorney().toString()).append(", '");
        sb.append(tx.getClientPhoneNo()).append("', ");
        sb.append(tx.getisLit());
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
    public JSONArray getClientById(int id){
        Connection conn = sqlStartConn();

        try {
            // execute sql query and close connection
            Statement sql = conn.createStatement();
            ResultSet sqlOutput = sql.executeQuery(
                    "SELECT * FROM clients WHERE clientcode = "+ id + ";");
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
    public JSONArray getAllClients(){
        Connection conn = sqlStartConn();

        try {
            // execute sql query and close connection
            Statement sql = conn.createStatement();
            ResultSet sqlOutput = sql.executeQuery(
                    "SELECT * FROM clients;");
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




}
