package com.example.billingdemo;

import com.example.billingdemo.ClientEntities.ClientLit;
import com.example.billingdemo.ClientEntities.ClientTx;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.ResultSet;

@Controller
public class ClientController {

    ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(path="/clients")
    public ResponseEntity<String> getClients(){
        return ResponseEntity.ok("clients");
    }

    @GetMapping(path="/client/{id}")
    public ResponseEntity<String> getClient(@PathVariable int id){
        return ResponseEntity.ok("client" + id);
    }

    @PostMapping(path="/newLitClient")
    public ResponseEntity<Integer> newLitClient(@RequestBody ClientLit lit){
        return ResponseEntity.ok(clientService.postClientLit(lit));
    }

    // This endpoint & the related function are redundant given the only differences between this and 'lit' are (will be) the class methods.
    //I included this endpoint & function for practice.
    @PostMapping(path="/newTxClient")
    public ResponseEntity<Integer> newTxClient(@RequestBody ClientTx tx){
        return ResponseEntity.ok(clientService.postClientTx(tx));
    }

    // Returning string for now.
    // I've learned Spring doesn't serialize JSON, so my efforts to convert ResultSet to JSON
    // could have been better spent.
    @GetMapping(path="/allBillsTx/{id}")
    public ResponseEntity<String> getAllBillsByClient(@PathVariable int id){
        return ResponseEntity.ok(ClientTx.getAllBills(id).toString());
    }
}
