package com.anan.sparsearray;

import java.io.*;

/**
 * @author don
 * @create 2020-06-06 19:34
 */
public class SparseArray {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //创建原始二维数组，记录棋盘落子情况，0表示无子，1表示白方落子，2表示黑方落子
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[4][5] = 2;
        //获取棋盘中落子的个数
        int sum = 0;
        //遍历二维数组，获取sum
        for(int i = 0 ; i<chessArr.length ;i++){
            for(int j = 0 ; j<chessArr[i].length ; j++){
                System.out.print(chessArr[i][j]);
                if(chessArr[i][j] !=0){
                    sum++;
                }
            }
            System.out.println();
        }
        //根据sum创建稀疏数组，保存棋盘信息
        int[][] sparseArr = new int[sum+1][3];
        sparseArr[0][0] = chessArr.length;
        sparseArr[0][1] = chessArr[0].length;
        sparseArr[0][2] = sum;
        //将二维数组中不同的数字用行号、列号、值的形式保存在稀疏数组中
        int number = 1;
        for(int i = 0 ;i<chessArr.length;i++){
            for (int j  =0 ;j<chessArr[i].length ;j++){
                if(chessArr[i][j] !=0){
                    sparseArr[number][0] = i;
                    sparseArr[number][1] = j;
                    sparseArr[number][2] = chessArr[i][j];
                    number++;
                }
            }
        }
        System.out.println("");
        //遍历稀疏数组
        for(int i = 0 ;i<sparseArr.length ;i++){
            for (int j = 0 ; j< 3;j++){
                System.out.print(sparseArr[i][j]);
            }
            System.out.println();
        }
        //保存稀疏数组到磁盘文件中
        File file = new File("src\\main\\java\\com\\anan\\sparsearray\\chese.data");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(sparseArr);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        sparseArr= (int[][]) ois.readObject();
        System.out.println("*****************");
        //遍历稀疏数组
        for(int i = 0 ;i<sparseArr.length ;i++){
            for (int j = 0 ; j< 3;j++){
                System.out.print(sparseArr[i][j]);
            }
            System.out.println();
        }
        //由稀疏数组获得二维数组
        int[][] chess2Arr = new int[sparseArr[0][0]][sparseArr[0][1]];
        for(int i =1;i<sparseArr.length;i++){
                chess2Arr[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        for (int i = 0 ;i<chess2Arr.length;i++){
            for (int j = 0 ;j <chess2Arr[i].length;j++){
                System.out.print(chess2Arr[i][j]);
            }
            System.out.println("");
        }

    }
}
