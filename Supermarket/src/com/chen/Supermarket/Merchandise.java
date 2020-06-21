package com.chen.Supermarket;

public class Merchandise {
    public String name;
    public String id;
    public int count;
    public double soldPrice;
    public double purchasePrice;

    public void describe(){
        System.out.println(this.name + ", id is " + id + ", soldPrice is " + this.soldPrice + "Rest Pcs is " + this.count );
    }
}
