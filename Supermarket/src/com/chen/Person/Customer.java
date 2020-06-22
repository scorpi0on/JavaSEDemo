package com.chen.Person;

public class Customer {
    private String name;
    private double money;

    public Customer(){
        this.name = "Customer Name"+ (int)Math.random()*10000;
        this.money = (1 + Math.random())*1000;
        this.isDrivingCar = Math.random() >+ 0.5;
    }

    public void buy(double totalCost){
        this.money -= totalCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public boolean isDrivingCar() {
        return isDrivingCar;
    }

    public void setDrivingCar(boolean drivingCar) {
        isDrivingCar = drivingCar;
    }

    public boolean isDrivingCar;


}
