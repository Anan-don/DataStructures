package com.anan.recursion;

/**
 * @author don
 * @create 2020-06-07 14:09
 */
public class Labyrinth {

    private static int[][] labyrinth;
    static{
        labyrinth = new int[8][7];
        for (int i = 0;i< 7;i++){
            labyrinth[0][i]=1;
            labyrinth[7][i]=1;
        }
        for (int j = 0 ;j<8;j++){
            labyrinth[j][0] = 1;
            labyrinth[j][6] = 1;
        }
        labyrinth[3][1] =1;
        labyrinth[3][2] =1;
        labyrinth[2][5] =1;
        labyrinth[3][4] =1;
    }
    public void start(int x,int y,int m,int n){
        labyrinth[x][y] = 2;
        if(x == m && y == n){
            for (int i = 0 ;i<labyrinth.length;i++){
                for (int j = 0 ;j<labyrinth[i].length;j++){
                    System.out.print(labyrinth[i][j]);
                }
                System.out.println("");
            }
        }else{
            if(labyrinth[x-1][y] == 0 ){
                start(x-1,y,m,n);
            }
            if(labyrinth[x][y+1] == 0 ){
                start(x,y+1,m,n);
            }
            if(labyrinth[x+1][y] == 0 ){
                start(x+1,y,m,n);
            }
            if(labyrinth[x][y-1] == 0 ){
                start(x,y-1,m,n);
            }
            labyrinth[x][y] = 3;
        }


    }


}
