package com.anan.hashtable;

import com.anan.hashtable.MyHashTable;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author don
 * @create 2020-06-08 10:47
 */
public class TestMyHashTable {
    @Test
    public void test(){
        MyHashTable<String, String> ssht = new MyHashTable<>(5);
        System.out.println(ssht.toString());
        ssht.add("yao","dahai");
        System.out.println(ssht.toString());
        ssht.add("wang","jiannan");
        System.out.println(ssht.toString());
        System.out.println(ssht.get("yao"));
        ssht.remove("yao");
        System.out.println(ssht.toString());
        ssht.clear();
        System.out.println(ssht.toString());
    }
}
