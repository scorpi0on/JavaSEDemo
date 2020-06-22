package com.chen.Supermarket;

public class Merchandise {

    private String name;
    private String id;
    private int count;
    private double soldPrice;
    private double purchasePrice;

    public Merchandise(String name, String id, int count, double soldPrice, double purchasePrice) {
        this.name = name;
        this.id = id;
        this.count = count;
        this.soldPrice = soldPrice;
        this.purchasePrice = purchasePrice;
    }

    public Merchandise(String name, String id, int count, double purchasePrice) {
        this(name, id, count,purchasePrice * 10, purchasePrice);
    }

    public String ge1tName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(double soldPrice) {
        this.soldPrice = soldPrice;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double calculateProfit(){
        return this.getSoldPrice() - getPurchasePrice();
    }

    public void describe(){
        System.out.println(this.name + ", id is " + id + ", soldPrice is " + this.soldPrice + "Rest Pcs is " + this.count );
    }

    public void SetCount(int i) {
    }

    public double buy(){
        return this.buy(1);
    }

    public double buy(int count){
        double totalCost = this.soldPrice * count;
        return totalCost;
    }

    public double buy(int countToBuy, boolean isVIP){
        if (this.count < countToBuy){
            System.out.println("Not enough.");
            return -1;
        }
        System.out.println("Merchandise sold Pice is " + this.soldPrice);
        int fullPriceCount = countToBuy / 2 + countToBuy % 2;
        int halfPriceCount = countToBuy - fullPriceCount;

        double totalCost = fullPriceCount * this.soldPrice + (halfPriceCount * this.soldPrice / 2);

        count -= countToBuy;

        if (isVIP) {
            totalCost -= totalCost * 0.8;
        } else {
            totalCost -= totalCost;
        }

        return totalCost;
    }

    public boolean isTheBiggestTotalValueOne(LittleSupermarket littleSuperMarket) {
        double totalValue = count * purchasePrice;
        for (int i = 0; i < littleSuperMarket.merchandises.length; i++) {
            Merchandise m = littleSuperMarket.merchandises[i];
            double newTotalValue = m.count * m.purchasePrice;
            if (totalValue < newTotalValue) {
                // 执行到return的时候，方法直接结束，不管是不是在循环中，是在第几层循环中。
                return false;
            }
        }
        return true;
    }

    public double buyAndPrintLeft(int countToBuy, boolean printLeft) {
        if (count < countToBuy) {
            System.out.println("商品库存不够");
            if (printLeft) {
                System.out.println("商品剩余库存为" + count);
            }
            return -1;
        }

        System.out.println("商品单价为" + soldPrice);

        int fullPriceCount = countToBuy / 2 + countToBuy % 2;
        int halfPriceCount = countToBuy - fullPriceCount;
        double totalCost = soldPrice * fullPriceCount + halfPriceCount * soldPrice / 2;

        count -= countToBuy;

        if (printLeft) {
            System.out.println("商品剩余库存为：" + count);
        }

        return totalCost;
    }

    public boolean totalValueBiggerThan(Merchandise merchandiseV2) {
        return count * purchasePrice > merchandiseV2.purchasePrice * merchandiseV2.count;
    }

    public String getName() {
        return this.name;
    }
}
