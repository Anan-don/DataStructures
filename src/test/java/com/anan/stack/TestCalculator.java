package com.anan.stack;

import org.junit.Test;

import java.util.Collection;

/**
 * @author don
 * @create 2020-06-07 13:07
 */
public class TestCalculator {
    @Test
    public void test(){
        Calculator calculator = new Calculator();
        int calculate = calculator.calculate("5+2*3+4/2");
        System.out.println(calculate);
    }
}
