package com.anan.hashtable;

import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author don
 * @create 2020-06-08 9:21
 */
public class MyHashTable<K,V> {

    private int length;//底层数组的长度
    private  Node<K,V>[] nodes; //底层使用数组存储数据

    public MyHashTable(){
        length = 10;
        nodes = new Node[length];
    }
    public MyHashTable(int capacity){
        length = capacity;
        nodes = new Node[length];
    }
    public V add(K key,V value){
        int area = hashFunction(hash(key));
        if(nodes[area]==null){
            Node<K,V> node = new Node<>(hash(key),key,value,null);
            nodes[area] = node;
        }else{
            boolean flag1 = true;
            Node<K,V> temp = nodes[area];
            do{
                if(temp.key.equals(key)){
                    temp.setValue(value);
                    flag1 = false;
                    break;
                }
                temp = temp.next;
            }while (temp != null);
            if(flag1){
                Node<K,V> node = new Node<>(hash(key),key,value,nodes[area]);
                nodes[area] = node;
            }
        }
        return value;
    }
    public V get(K key){
        int area = hashFunction(hash(key));
        if(nodes[area] == null){
            return null;
        }else{
            Node<K,V> temp = nodes[area];
            do{
               if(temp.getHash() == hash(key) && temp.getKey().equals(key)){
                   return temp.getValue();
               }
               temp = temp.next;
            }while (temp != null);
            return null;
        }
    }
    public V remove(K key){
        int area = hashFunction(hash(key));
        if(nodes[area] == null){
            return null;
        }else{
            Node<K,V> temp = nodes[area];
            if (temp.getHash() == hash(key)&& temp.getKey().equals(key)){
                nodes[area] = temp.getNext();
                return temp.getValue();
            }
            Node<K,V> prvNode = temp;
            temp = temp.next;
            do{
                if(temp.getHash() == hash(key) && temp.getKey().equals(key)){
                    prvNode.setNext(temp.getNext());
                    return temp.getValue();
                }
                prvNode = temp;
                temp = temp.next;
            }while (temp != null);
            return null;
        }
    }

    public void clear(){
        nodes = new Node[length];
    }

    @Override
    public String toString() {
        return "MyHashTable{" +
                "length=" + length +
                ", nodes=" + Arrays.toString(nodes) +
                '}';
    }

    private int hash(K key){
        return key.hashCode();
    }
    private int hashFunction(int hash){
        return hash%length;
    }


    class Node<K,V>{
        private final int hash;
        private final K key;
        private V value;
        private Node<K,V> next;

        public Node(int hash,K key,V value,Node<K,V> next){
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "hash=" + hash +
                    ", key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }

        public void setValue(V value) {
            this.value = value;
        }

        public int getHash() {
            return hash;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }
    }
}
