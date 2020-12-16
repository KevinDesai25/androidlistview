package com.example.listview;

public class Product {

    String pName;
    String pRice;


    public Product(String pName, String pRice) {
        this.pName = pName;
        this.pRice = pRice;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpRice() {
        return pRice;
    }

    public void setpRice(String pRice) {
        this.pRice = pRice;
    }
}
