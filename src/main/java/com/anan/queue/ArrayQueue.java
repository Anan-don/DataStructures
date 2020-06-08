package com.anan.queue;


/**
 * @author don
 * @create 2020-06-06 20:33
 */
public class ArrayQueue<T> {

    private T[] arrayQueue;
    private int size = 0;

    public ArrayQueue(){
        arrayQueue = (T[]) new Object[100];
    }

    public ArrayQueue(int number){
        arrayQueue = (T[]) new Object[number];
    }
    //判断队列是否满
    public boolean isFull(){
        if (size == arrayQueue.length){
            return true;
        }
        return false;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }
    public boolean addQueue(T t){
        if(isFull()){
            return false;
        }
        arrayQueue[size++] = t;
        return true;
    }
    public T getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列以空....");
        }
        T t = arrayQueue[0];
        for(int i =0 ;i<size;i++){
            arrayQueue[i] = arrayQueue[i+1];
        }
        size--;
        return t;
    }
    public T[] showQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列以空....");
        }
        T[] reArr = (T[]) new Object[size];
        for (int i = 0 ;i<size ;i++){
            reArr[i] = arrayQueue[i];
        }
        return reArr;
    }

}
