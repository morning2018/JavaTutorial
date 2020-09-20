package com.learning.multithrad.thread.productsystem;

/**
 * 功能描述：
 *  奶酪生产系统
 * @author yt.wei
 * @date 2020/4/25 18:30
 * @version v0.0.1
 */
public class ProductSystem {
    private static final int MAX_MILK = 200000;
    private static final int MAX_FERMENTATION = 100000;
    /**
     * 最大10w份
     */
    private static final int MAX_CHEESE = 100000;

    MilkStorage milkStorage = new MilkStorage();
    FermentationStorage fermentationStorage = new FermentationStorage();
    CheeseStorage cheeseStorage = new CheeseStorage();

    private int supermarketCheese;

    private void prodMilk(){
        new Thread(new Runnable() {
            int totleMilk = 0;
            public void run() {
                while (totleMilk < MAX_MILK){
                    milkStorage.add();
                    totleMilk ++;
                }
                System.out.println(totleMilk+ "份发牛奶生产完成。");
                print();
            }
        }).start();
    }

    private void prodFermentation() {
        new Thread(new Runnable() {
            int totleFermentation = 0;
            public void run() {
                while (totleFermentation < MAX_FERMENTATION){
                    fermentationStorage.add();
                    totleFermentation ++;
                }
                System.out.println(totleFermentation+ "份发酵剂生产完成。");
                print();
            }
        }).start();
    }


    private void prodCheese() {
        new Thread(new Runnable() {
            int totleCheese = 0;
            public void run() {
                while (totleCheese < MAX_CHEESE){
                    if (fermentationStorage.getFermentationNum() <=0 || milkStorage.getMilkNum()<=1) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("等待生产奶酪");
                        continue;
                    }
                    if(cheeseStorage.getCheeseNum()>=1000){
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("仓库已满，等待运输");
                        continue;
                    }

                    cheeseStorage.add();
                    totleCheese ++;
                    // 消耗发1份酵剂
                    fermentationStorage.reduce(1);
                    // 消耗发2份牛奶
                    milkStorage.reduce(2);
                }
                System.out.println(totleCheese+ "份奶酪生产完成。");
                print();
            }
        }).start();
    }


    public void transport() {
        new Thread(new Runnable() {
            public void run() {
                while (supermarketCheese < MAX_CHEESE) {
                    if (cheeseStorage.getCheeseNum() < 100) {
                        System.out.println("仓库库存不够，等待生产");
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        continue;
                    }
                    cheeseStorage.reduce(100);
                    supermarketCheese = supermarketCheese + 100;

                }
                System.out.println(supermarketCheese+ "份奶酪进入超市完成。");
                print();
            }
        }).start();
    }

    private void print() {
        System.out.println("超市奶酪:"+ supermarketCheese);
        System.out.println("工厂奶酪:"+ cheeseStorage.getCheeseNum());
        System.out.println("工厂牛奶:"+ milkStorage.getMilkNum());
        System.out.println("工厂发酵剂:"+ fermentationStorage.getFermentationNum());
    }

    private void product() {
        prodFermentation();
        prodMilk();
        prodCheese();
        transport();
    }

    /**
      * 功能描述:
      *  生产系统
      * @author yt.wei
      * @date 2020/4/25 8:37
      * @version v0.0.1
      * @param args
      * @return void
      */
    public static void main(String[] args) {
        ProductSystem ps = new  ProductSystem();
        ps.product();
    }


}
