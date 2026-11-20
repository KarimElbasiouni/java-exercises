package com.amigoscode._8_testing._1_firsttest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Exercise: Your First Unit Tests
 *
 * In this exercise you will write your first JUnit 5 tests for the Calculator class.
 * Complete each TODO to practice basic assertions and test lifecycle annotations.
 */
class CalculatorTest {

    // TODO: 1 - Declare a Calculator field and use @BeforeEach to create a fresh
    //  Calculator instance before each test. This ensures tests are independent.
    //  Hint: Write a setUp() method annotated with @BeforeEach that assigns
    //  a new Calculator() to your field.
    private static Calculator underTest;

    @BeforeEach
    void setUp() {
        underTest = new Calculator();
    }
    // TODO: 2 - Write a test for the add method using assertEquals.
    //  Annotate it with @Test and @DisplayName("2 + 3 should equal 5").
    //  Call calculator.add(2, 3) and assert the result equals 5.
    @Test
    @DisplayName("2 + 3 should equal 5")
    void canAddTwoIntegers(){
        int actual = underTest.add(2,3);
        assertThat(actual).isEqualTo(5);
    }

    // TODO: 3 - Write a test for the subtract method.
    //  Annotate with @Test and @DisplayName.
    //  Test that calculator.subtract(10, 4) equals 6.
    @Test
    @DisplayName("10 - 4 should equal 6")
    void canSubtractTwoIntegers(){
        int actual = underTest.subtract(10,4);
        assertThat(actual).isEqualTo(6);
    }

    // TODO: 4 - Write a test for the multiply method.
    //  Annotate with @Test and @DisplayName.
    //  Test that calculator.multiply(3, 7) equals 21.
    @Test
    @DisplayName("3 x 7 should equal 21")
    void canMultiplyTwoIntegers(){
        int actual = underTest.multiply(3,7);
        assertThat(actual).isEqualTo(21);
    }

    // TODO: 5 - Write a test that verifies dividing by zero throws ArithmeticException.
    //  Use assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0)).
    //  Add a @DisplayName annotation.
    @Test
    @DisplayName("10 / 4 should throw Arithmetic Exception")
    void throwsArithmeticExceptionWhenDividingByZero(){
        assertThrows(ArithmeticException.class, ()-> underTest.divide(10, 0));
    }

    // TODO: 6 - Write a test using assertNotEquals.
    //  Verify that calculator.add(2, 2) is NOT equal to 5.
    //  Add a @DisplayName annotation.
    @Test
    @DisplayName("2 + 2 is not equal to 5")
    void canAddTwoIntegersThatAreNotEqualTo5(){
        assertThat(underTest.add(2,2)).isNotEqualTo(5);
    }

    // TODO: 7 - Add @DisplayName annotations to ALL of your tests above (if not done already).
    //  Make the display names descriptive, e.g., "Adding 2 and 3 should return 5".
    //  Then write one more test: verify that calculator.divide(10, 2) equals 5.
    @Test
    @DisplayName("Dividing 10 by 2 gives 5")
    void canDivideAnIntegerByANonZeroValue(){
        assertThat(underTest.divide(10,2)).isEqualTo(5);
    }
}
