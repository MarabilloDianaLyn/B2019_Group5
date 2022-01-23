package com.example.financewise;

public class Data {

    String item, date, id;
    int amount, month;

    public Data() {
    }

    public Data(String item, String date, String id, int amount, int month) {
        this.item = item;
        this.date = date;
        this.id = id;
        this.amount = amount;
        this.month = month;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}
