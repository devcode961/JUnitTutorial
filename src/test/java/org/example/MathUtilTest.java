package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilTest {

    @Test
    void add() {
        assertEquals(5, MathUtil.add(2, 3));
    }

    @Test
    void multiple() {
        assertEquals(6, MathUtil.multiple(2, 3));
    }

    @Test
    void isEven() {
        assertTrue(MathUtil.isEven(8));
    }

    @Test
    void divide() {
        assertEquals(8, MathUtil.divide(16, 2));
    }

    @Test
    void isPrime() {
        assertTrue(MathUtil.isPrime(5));
    }

    @Test
    void test_Divide_By_Zero(){
        assertThrows(ArithmeticException.class, () -> MathUtil.divide(1, 0));
    }
}