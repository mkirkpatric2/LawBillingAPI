package com.example.billingdemo.ClientEntities;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.sql.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Converts resultSet to JSONArray.
// Problem: Spring doesn't want to serialize JSON.
public class ClientHelpers {
    public static JSONArray sqlToJSON(ResultSet resultSet) throws SQLException {
        ResultSetMetaData md = resultSet.getMetaData();
        int numCols = md.getColumnCount();
        List<String> colNames = IntStream.range(0, numCols)
                .mapToObj(i -> {
                    try {
                        return md.getColumnName(i + 1);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        return "?";
                    }
                })
                .collect(Collectors.toList());

        JSONArray result = new JSONArray();
        while (resultSet.next()) {
            JSONObject row = new JSONObject();
            colNames.forEach(cn -> {
                try {
                    row.put(cn, resultSet.getObject(cn));
                } catch (JSONException | SQLException e) {
                    e.printStackTrace();
                }
            });
            result.put(row);
        }
        return result;
    }

    public static Connection sqlStartConn(){
        String url = "jdbc:postgresql://localhost:5432/postgres";
        try {
            return DriverManager.getConnection(url, "postgres", "password");
        } catch(Exception e) {
            System.out.println(e.fillInStackTrace().toString());
            return null;
        }
    }
}