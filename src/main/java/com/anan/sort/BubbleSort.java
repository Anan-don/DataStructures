package com.anan.sort;

/**
 * @author don
 * @create 2020-06-07 17:52
 */
public class BubbleSort {
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

        //优化前
        Long startTime = System.currentTimeMillis();
        //冒泡排序开始
        for (int i = 0;i<numberArray.length-1;i++){
            for (int j = 0 ;j<numberArray.length-1-i;j++){
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
        //冒泡排序开始
        boolean flag = true;
        for (int i = 0;i<numberArray2.length-1;i++){
            for (int j = 0 ;j<numberArray2.length-1-i;j++){
                if (numberArray2[j] > numberArray2[j+1]){
                    int temp = numberArray2[j];
                    numberArray2[j] = numberArray2[j+1];
                    numberArray2[j+1] = temp;
                    flag = false;
                }
            }
            if (flag)break;
            flag = true;
        }
        endTime = System.currentTimeMillis();
        for (int n:numberArray2){
            System.out.print(n+" ");
        }
        System.out.println("");
        System.out.println("优化后花费时间为"+(endTime - startTime));//259
    }
}
