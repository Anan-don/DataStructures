package com.anan.linkedlist;

/**
 * 约瑟夫小游戏，游戏规则：
 * @author don
 * @create 2020-06-07 9:40
 */
public class Josephu {

    private Node first;
    private Node temp;

    public Josephu(int n){
        if(n < 2){
            throw new RuntimeException("约瑟夫游戏人数必须大于两个人！");
        }
        for(int i = 1 ;i<=n ;i++){
            if(i == 1){
                Node node = new Node(1);
                first = node;
                temp = node;
            }else{
                Node node = new Node(i);
                temp.next =node;
                temp = node;
            }
        }
        temp.next = first;
    }

    @Override
    public String toString() {
        temp = first;
        for (int i =0 ;i <10;i++){
            System.out.println(temp.number);
            temp=temp.next;
        }
        return "";
    }

    public void start(int k,int m){
        temp = first;
        for (int i = 2; i<=k;i++){
            temp = temp.next;
        }
        remove(temp,m);
    }

    public void remove(Node node,int m){
        if(node.next == node){
            System.out.println(node.number);
        }else{
            for(int i = 1 ;i<m ;i++){
                temp = node;
                node = node.next;
            }
            System.out.print(node.number+"-->");
            temp.next = node.next;
            remove(node.next,m);
        }
    }





    public class Node{

        public int number;
        public Node next;

        public Node(int number){
            this.number = number;
            next = null;
        }
    }
}
