package com.chen;

import com.chen.Supermarket.LittleSupermarket;
import com.chen.Supermarket.Merchandise;

import java.util.Scanner;

public class RunLittleSupperMarketAppMainV2 {
    public static void main(String[] args) {
        LittleSupermarket littleSupermarket = new LittleSupermarket("Shenzhen","Taobao", 200, 200);
        Merchandise[] all = littleSupermarket.merchandises;

        // 创建一个Scanner读取输入
        Scanner scanner = new Scanner(System.in);
        Merchandise m0 = all[0];
        while (true) {
            System.out.println("今日超市大特惠，所有商品第二件半价！选择要购买的商品索引：");
            int index = scanner.nextInt();
            if (index < 0) {
                System.out.println("欢迎再次光临！");
                break;
            }

            System.out.println("请输入要购买的数量：");
            int count = scanner.nextInt();

            Merchandise m = littleSupermarket.merchandises[index];
            System.out.println("用户选择的商品是超市里价值最高的：" +
                    m.isTheBiggestTotalValueOne(littleSupermarket));
            double totalCost = m.buyAndPrintLeft(count, true);

            boolean m0BiggerThan = m0.totalValueBiggerThan(m);
            System.out.println("m0的总价值比用户选择的要大：" + m0BiggerThan);

            System.out.println("商品总价为：" + totalCost);
        }

    }
}
