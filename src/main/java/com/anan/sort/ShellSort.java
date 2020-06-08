package com.anan.sort;

/**
 * @author don
 * @create 2020-06-07 19:03
 */
public class ShellSort {
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


        Long startTime = System.currentTimeMillis();
        //交换法希尔排序开始
        for (int group = numberArray.length/2;group >0;group /=2){
            for (int i =group ;i<numberArray.length;i++){
                for(int j = i-group;j>=0;j = j-group){
                    if(numberArray[j] > numberArray[j+group]){
                        int temp = numberArray[j];
                        numberArray[j] = numberArray[j+group];
                        numberArray[j+group] = temp;
                    }else break;//你可以尝试把else break去掉。效果爆炸！！
                }
            }
        }
        Long endTime = System.currentTimeMillis();
        for (int n:numberArray){
            System.out.print(n+" ");
        }
        System.out.println("");
        System.out.println("优化前花费时间为"+(endTime - startTime));//326


        startTime = System.currentTimeMillis();
        //移动法冒泡排序开始

        for (int group = numberArray2.length/2;group>0;group /=2){
            for (int i = group ;i<numberArray2.length;i++){
                int insertVal = numberArray2[i];
                int insertIndex = i - group;
                while (insertIndex >= 0 && insertVal < numberArray2[insertIndex]){
                    numberArray2[insertIndex+group] = numberArray2[insertIndex];
                    insertIndex -= group;
                }
                if(insertIndex+group != i){
                    numberArray2[insertIndex+group] = insertVal;
                }

            }
        }
        endTime = System.currentTimeMillis();
        for (int n:numberArray2){
            System.out.print(n+" ");
        }
        System.out.println("");
        System.out.println("优化后花费时间为"+(endTime - startTime));//259



    }

}
