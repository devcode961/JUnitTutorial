package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("When running MathUtils")
class MathUtilTest {

    private TestInfo info;

    private TestReporter report;

    @BeforeEach
    void init(TestInfo info, TestReporter report){
           this.info = info;
           this.report = report;
           report.publishEntry("Test report "+info.getDisplayName()+" "+info.getTestMethod());
    }

    @Test
    @Tag("Math")
    void add() {
        assertEquals(5, MathUtil.add(2, 3));
    }

    @Test
    @Tag("Math")
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
    @DisplayName("This is test method for testing a number for primality")
    void isPrime() {
        assertTrue(MathUtil.isPrime(5));
    }

    @Test
    void test_Divide_By_Zero(){
        //Assumptions are another way to have programmatic control to whether the test should execute or not
        //There might be a case when we want a test to run only if the server is up. So we can write some condition
        //to determine if server is up or not and pass that value to our assumeTrue/assumeFalse condition.
        boolean isServerUp = false;
        Assumptions.assumeTrue(isServerUp);
        assertThrows(ArithmeticException.class, () -> MathUtil.divide(1, 0));
    }

    @Test
    @Disabled
    void test_Method_Disabled(){
        fail("This method should fail");
    }

    @Test
    void test_Multiply_Using_Assert_All(){

        //We can use asserAll to club together a group of assert statements.
           assertAll(
                   () -> assertEquals(4, MathUtil.multiple(2, 2)),
                   () -> assertEquals(0, MathUtil.multiple(2, 0)),
                   () -> assertEquals(-2, MathUtil.multiple(2, -1))
           );
    }

    //Here we can use @Nested annotation to group together tests written for similar functionality like
    // add method test like below:

    @Nested
    @DisplayName(" add method")
    class AddTest{

        @Test
        @DisplayName("for positive numbers ")
        void test_Positive(){
           assertEquals(2, MathUtil.add(1,1), "Should return correct sum");
        }

        @Test
        @DisplayName("for negative numbers ")
        void test_Negative(){
            //The string message in assertEquals will be computed every time whether the test passes or fails.
            //We need a way to optimize this behavior such that the message should be constructed and displayed only
            //if the test fails, so we can pass a supplier(a function that returns String) to assert method
            int expected = -2;
            int actual = MathUtil.add(-1, -1);
            //assertEquals(-2, MathUtil.add(-1,-1), "should return correct sum");
            assertEquals(expected, actual, () -> "should return " + expected +" but returned "+actual);
        }

        @Test
        void test_Zero(){
            assertEquals(0, MathUtil.add(-1,1));
        }
    }

    @Test
    @Disabled
    @RepeatedTest(3)
     void test_repeated(RepetitionInfo info){
            System.out.println(info.getCurrentRepetition());
            assertEquals(5, MathUtil.add(2, 3));
     }
}