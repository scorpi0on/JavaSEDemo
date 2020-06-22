package com.chen;

import com.chen.Supermarket.LittleSupermarket;
import com.chen.Supermarket.Merchandise;

import java.util.Scanner;

public class RunLittleSupperMarketAppMainExample {
    public static void main(String[] args) {
        LittleSupermarket littleSupermarket = new LittleSupermarket("Shenzhen","Taobao", 200, 200);
        Merchandise[] all = littleSupermarket.merchandises;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("今日超市大特惠，所有商品第二件半价！选择要购买的商品索引：");
            int index = scanner.nextInt();

            if (index < 0) {
                break;
            }

            if (index >= all.length) {
                System.out.println("商品索引超出界限");
                continue;
            }

            Merchandise m = all[index];
            Merchandise m0 = all[index];
            System.out.println("商品" + m.getName() + "售价为" + m.getSoldPrice() + "。请问购买几个？");
            int numToBuy = scanner.nextInt();

            double totalCost = m.buy(numToBuy);


            System.out.println("选购的商品总价为" + totalCost);
        }


    }
}
