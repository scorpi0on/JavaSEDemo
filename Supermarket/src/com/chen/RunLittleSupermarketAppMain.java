package com.chen;

import com.chen.Person.Customer;
import com.chen.Supermarket.LittleSupermarket;
import com.chen.Supermarket.Merchandise;
import org.junit.Test;

import java.util.Scanner;

public class RunLittleSupermarketAppMain {
    public static void main(String[] args) {

        LittleSupermarket littleSupermarket = new LittleSupermarket("Shenzhen","Taobao", 200, 200);
        Merchandise[] all = littleSupermarket.merchandises;

        System.out.println("Max Profit merchandise:");
        littleSupermarket.getBiggestProfitMerchandise().describe();
        System.out.println("====================================");


        System.out.println("SuperMarket  is opened !");
        System.out.println("____________________________________");

        boolean open = true;
        while (open){
            Scanner scanner = new Scanner(System.in);
            littleSupermarket.describe();


            Customer customer = new Customer();

            littleSupermarket.parking(customer);

            double totalCost = 0;

            while (true){
                System.out.println("-> Mart has "+ littleSupermarket.merchandises.length +" merchandises for you. Please input the id:");
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
                System.out.println("-> How many do you want?");
                int numToBuy = scanner.nextInt();
                if (numToBuy > m.getCount()){
                    System.out.println("Merchandise nums is not enough. Try another.");
                }
                if (numToBuy <= 0){
                    System.out.println("You give up.");
                    continue;
                }
                if ( numToBuy*m.getSoldPrice() + totalCost > customer.getMoney()){
                    System.out.println("You cost: "+ numToBuy * m.getSoldPrice() +". You only have: " + customer.getMoney());
                    continue;
                }
                m.setCount(m.getCount() - numToBuy);
                totalCost += numToBuy * m.getSoldPrice();
                littleSupermarket.merchandiseSold[index] =  numToBuy;
                System.out.println("The total cost is " + totalCost);
                customer.buy(totalCost);
            }

            if (customer.isDrivingCar){
                littleSupermarket.parkingCount +=1;
            }
            System.out.println("->> Customer ID " + customer.getName() + " has spent " + totalCost + " the rest is " + customer.getMoney());
            littleSupermarket.incomingSum += totalCost;

            System.out.println("-------------The mart is opening ?-----------------");
            open = scanner.nextBoolean();
        }
        System.out.println("____________________________________");
        System.out.println("->> Market is closed !");
        littleSupermarket.summary();
    }
}
