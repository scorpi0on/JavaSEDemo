package com.chen;

import com.chen.Person.Customer;
import com.chen.Supermarket.LittleSupermarket;
import com.chen.Supermarket.Merchandise;

import java.util.Scanner;

public class RunLittleSupermarketAppMain {
    public static void main(String[] args) {
        LittleSupermarket littleSupermarket = new LittleSupermarket();
        littleSupermarket.address = "Shenzhen";
        littleSupermarket.superMarketName = "Taobao";
        littleSupermarket.parkingCount = 200;
        littleSupermarket.merchandises = new Merchandise[200];
        littleSupermarket.merchandiseSold = new int[littleSupermarket.merchandises.length];

        Merchandise[] all = littleSupermarket.merchandises;
        for (int i = 0; i<all.length; ++i){
            Merchandise m = new Merchandise();
            m.count = 200;
            m.id = "ID "+i;
            m.name = "merchandise " + i;
            m.purchasePrice = Math.random() * 100;
            m.soldPrice = Math.random() * 1000;
            all[i] = m;
        }

        System.out.println("SuperMarket  is opened !");
        System.out.println("____________________________________");
        boolean open = true;
        while (open){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Now, "+ littleSupermarket.superMarketName + " address is " + littleSupermarket.address);
            System.out.println("Now the parking's slot is " + littleSupermarket.parkingCount);
            System.out.println("Now the mart incoming sum is " + littleSupermarket.incomingSum);
            System.out.println("Now the mart merchandises' total num is " + littleSupermarket.merchandises.length);

            Customer customer = new Customer();
            customer.name = "Customer Name"+ (int)Math.random()*10000;
            customer.money = (1 + Math.random())*1000;
            customer.isDrivingCar = Math.random() >+ 0.5;

            if (customer.isDrivingCar){
                if (littleSupermarket.parkingCount > 0){
                    System.out.println("Welcome" + customer.name + ", the rest number of slots is "+ littleSupermarket.parkingCount);
                    littleSupermarket.parkingCount -= 1;
                }else{
                    System.out.println("No slot available");
                }
            }else{
                System.out.println("Welcome"  + customer.name);
            }

            double totalCost = 0;

            while (true){
                System.out.println("Mart has "+ littleSupermarket.merchandises.length +" merchandises for you. Please input the id:");
                int index = scanner.nextInt();
                if (index < 0){
                    break;
                }
                if (index >= all.length){
                    System.out.println("No this id. Plz re-input id [0,199]");
                    continue;
                }
                Merchandise m = all[index];


                m.describe();
                System.out.println("How many do you want?");
                int numToBuy = scanner.nextInt();
                if (numToBuy > m.count){
                    System.out.println("Merchandise nums is not enough. Try another.");
                }
                if (numToBuy <= 0){
                    System.out.println("Try another.");
                    continue;
                }
                if ( numToBuy*m.soldPrice + totalCost > customer.money){
                    System.out.println("error");
                    continue;
                }
                m.count -= numToBuy;
                totalCost += numToBuy * m.soldPrice;
                littleSupermarket.merchandiseSold[index] =  numToBuy;
                System.out.println("The total cost is " + totalCost);
            }
            customer.money -= totalCost;
            if (customer.isDrivingCar){
                littleSupermarket.parkingCount +=1;
            }
            System.out.println("Customer ID " + customer.name + " has spent " + totalCost + " the rest is " + customer.money);
            littleSupermarket.incomingSum += totalCost;

            System.out.println("-------------The mart is opening ?-----------------");
            open = scanner.nextBoolean();
        }
        System.out.println("____________________________________");
        System.out.println("MArket is closed !");
        System.out.println("Total income is " + littleSupermarket.incomingSum );
        for (int i = 0; i<littleSupermarket.merchandiseSold.length; ++i){
            Merchandise m = all[i];
            int numSold = littleSupermarket.merchandiseSold[i];
            if(numSold>0){
                System.out.println(" " + m.name + " has been sold total " + numSold + "pcs. And income is " + m.soldPrice*numSold + " and net profit is "+ (m.soldPrice*numSold - m.purchasePrice*numSold + "..."));
            }
        }
    }
}
