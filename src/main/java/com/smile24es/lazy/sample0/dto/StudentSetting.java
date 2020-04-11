package com.smile24es.lazy.sample0.dto;

public class StudentSetting {

    private String key;
    private String value;
    private Double amount;

    public StudentSetting(String key, String value, Double amount) {
        this.key = key;
        this.value = value;
        this.amount = amount;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
