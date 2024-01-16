package com.example.billingdemo.ClientEntities;

import java.util.ArrayList;

public class ClientLit implements ClientInterface {

    private Integer clientCode;
    private String clientName;
    private Boolean isActive;
    private Integer leadAttorney;
    private String clientPhoneNo;

    @Override
    public ArrayList<Object> getUnpaidBills() {
        return null;
    }

    @Override
    public ArrayList<Object> getMonthBills() {
        return null;
    }

    @Override
    public ArrayList<Object> getPaidBills() {
        return null;
    }

    @Override
    public ArrayList<Object> getAllBills() {
        return null;
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
}
