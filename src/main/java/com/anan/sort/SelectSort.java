package com.anan.sort;

/**
 * @author don
 * @create 2020-06-07 18:18
 */
public class SelectSort {
    public static void main(String[] args){
        int[] numberArray = new int[10000];
        for (int i=0;i<10000;i++){
            numberArray[i] = (int) (Math.random()*10000+1);
        }
        for (int n :numberArray){
            System.out.print(n+" ");
        }
        System.out.println("");
        Long startTime = System.currentTimeMillis();
        //选择排序开始
        for (int i = 0;i<numberArray.length-1;i++){
            int min = i;
            for (int j = i+1 ;j<numberArray.length;j++){
                if (numberArray[j] < numberArray[min]){
                    min = j;
                }
            }
            if (min != i){
                int temp = numberArray[i];
                numberArray[i] = numberArray[min];
                numberArray[min] = temp;
            }
        }
        Long endTime = System.currentTimeMillis();
        for (int n:numberArray){
            System.out.print(n+" ");
        }
        System.out.println("");
        System.out.println("花费时间为"+(endTime - startTime));//326

    }
}
