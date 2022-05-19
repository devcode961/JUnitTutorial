package com.vogella.junit.dynamictest;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

/* A word about Dynamic Tests in Junit5:

The standard tests annotated with @Test annotation are static tests which are fully specified at compile time. A DynamicTest is a test generated during runtime. These tests are generated by a factory method annotated with the @TestFactory annotation.

A @TestFactory method must return a Stream, Collection, Iterable, or Iterator of DynamicTest instances. Returning anything else will result in a JUnitException since the invalid return types cannot be detected at compile time. Apart from this, a @TestFactory method cannot be static or private.

The DynamicTests are executed differently than the standard @Tests and do not support lifecycle callbacks. Meaning, the @BeforeEach and the @AfterEach methods will not be called for the DynamicTests.
 */


class CalculatorDynamicTest {

    //Method with @TestActory annotation cannot be private or static.
    @TestFactory
    Stream<DynamicTest> dynamicTestForMultiplyOperation(){
        Calculator calculator = new Calculator();
        int [][] data = new int[][] {{1,2,2}, {5,3,15}, {121,4,484}};

        return Arrays.stream(data).map( entry -> {
            int value1 = entry[0];
            int value2 = entry[1];
            int expected = entry[2];
            return dynamicTest("Testing Multiply operation for "+value1 +" * "+value2, () -> assertEquals(expected, calculator.multiply(value1, value2)));
        });
    }
}