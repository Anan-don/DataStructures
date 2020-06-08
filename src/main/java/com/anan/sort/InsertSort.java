package com.anan.sort;

/**
 * @author don
 * @create 2020-06-07 18:29
 */
public class InsertSort {
    public static void main(String[] args){

        int[] numberArray = new int[10000];
        int[] numberArray2 = new int[10000];

        for (int i=0;i<10000;i++){
            numberArray[i] = (int) (Math.random()*10000+1);
            numberArray2[i] = numberArray[i];
        }
        for (int n :numberArray){
            System.out.print(n+" ");
        }
        System.out.println("");
        //交换法
        //优化前
        Long startTime = System.currentTimeMillis();
        //插入排序开始,从小到大
        for (int i = 1;i<numberArray.length;i++){
            for (int j = i-1 ;j>=0;j--){
                if (numberArray[j] > numberArray[j+1]){
                    int temp = numberArray[j];
                    numberArray[j] = numberArray[j+1];
                    numberArray[j+1] = temp;
                }
            }
        }
        Long endTime = System.currentTimeMillis();
        for (int n:numberArray){
            System.out.print(n+" ");
        }
        System.out.println("");
        System.out.println("优化前花费时间为"+(endTime - startTime));//326

        //优化后
        startTime = System.currentTimeMillis();
        //插入排序开始,从小到大
        for (int i = 1;i<numberArray2.length;i++){
            for (int j = i-1 ;j>=0;j--){
                if (numberArray2[j] > numberArray2[j+1]){
                    int temp = numberArray2[j];
                    numberArray2[j] = numberArray2[j+1];
                    numberArray2[j+1] = temp;
                }else break;
            }
        }
        endTime = System.currentTimeMillis();
        for (int n:numberArray2){
            System.out.print(n+" ");
        }
        System.out.println("");
        System.out.println("优化后花费时间为"+(endTime - startTime));//259


        //此处省略交换法
    }
}
