package com.chen.Supermarket;

import com.chen.Person.Customer;

public class LittleSupermarket {
    //商店类的数据
    public String superMarketName;
    public String address;
    public int parkingCount;
    public double incomingSum;
    public Merchandise[] merchandises;
    public int[] merchandiseSold;

    public LittleSupermarket(String address, String superMarketName, int parkingCount, int m_nums){
        this.address = address ;
        this.superMarketName = superMarketName ;
        this.parkingCount = parkingCount;
        this.merchandises = new Merchandise[m_nums];


        for (int i = 0; i<this.merchandises.length; ++i){
            Merchandise m = new Merchandise("ID "+i,"merchandise " + i,200, Math.random() * 10, Math.random() * 100);
            this.merchandises[i] = m;
        }

        this.merchandiseSold = new int[this.merchandises.length];

    }

    public void summary(){
        System.out.println("====================================");
        System.out.println("->> Total income is " + this.incomingSum );
        for (int i = 0; i<this.merchandiseSold.length; ++i){
            Merchandise m = this.merchandises[i];
            int numSold = this.merchandiseSold[i];
            if(numSold>0){
                System.out.println("    " + m.getName() + " has been sold total " + numSold + "pcs. And income is " + m.getSoldPrice()*numSold + " and net profit is "+ (m.getSoldPrice()*numSold - m.getPurchasePrice()*numSold + "..."));
            }
        }
    }

    public void parking(Customer customer){
        if (customer.isDrivingCar){
            if (this.parkingCount > 0){
                System.out.println("Welcome" + customer.getName() + ", the rest number of slots is "+ this.parkingCount);
                this.parkingCount -= 1;
            }else{
                System.out.println("No slot available");
            }
        }else{
            System.out.println("Welcome"  + customer.getName());
        }
    }

    public void describe(){
        System.out.println("Now, "+ this.superMarketName + " address is " + this.address);
        System.out.println("Now the parking's slot is " + this.parkingCount);
        System.out.println("Now the mart incoming sum is " + this.incomingSum);
        System.out.println("Now the mart merchandises' total num is " + this.merchandises.length);
    }

    public Merchandise getBiggestProfitMerchandise(){
        Merchandise curr = null;
        for (int i = 0; i<merchandises.length; ++i){
            Merchandise m = this.merchandises[i];
            if ( curr == null){
                curr = m;
                continue;
            }
            double currProfit = curr.calculateProfit();
            double newProfit = m.calculateProfit();
            if (currProfit < newProfit){
                curr = m;
            }
        }
        return curr;
    }
}
