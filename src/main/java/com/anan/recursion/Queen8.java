package com.anan.recursion;

/**
 * @author don
 * @create 2020-06-07 15:33
 */
public class Queen8 {
private int count;
    private int[] queen;

    public Queen8() {
        queen = new int[8];
    }

    public void start(){
        setQueen(1);
    }

    private void setQueen(int n){

        if(n==1){
            for (int i =0 ;i<8;i++){
                queen[n-1] = i;
                setQueen(n+1);
            }
        }else if(n<=8&& n>1){
            flag1:
            for (int i = 0;i<8;i++){
                queen[n-1] = i;
                for (int j =0;j<n-1;j++){
                    if(queen[j] == queen[n-1])continue flag1;
                    int number = queen[n-1] - queen[j];
                    if(number == n-1-j || number == j-n+1)continue flag1;
                }
                setQueen(n+1);
            }
        }else{
            for (int i = 0 ;i<queen.length ;i++){
                System.out.print(queen[i]+" ");
            }
            count++;
            System.out.println("这是第" + count + "种摆法!");
            System.out.println("");
        }
    }
}
