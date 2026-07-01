package com.cwa.junit.healthycoderapp.test;

import com.cwa.junit.healthycoderapp.BMICalculator;
import com.cwa.junit.healthycoderapp.Coder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;

public class BMICalculatorTest {

    @Test
    void should_ReturnTrue_When_DietRecommended() {

        // given
        double weight = 60.0;
        double height = 1.72;

        // when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);

        // then
        Assertions.assertFalse(recommended);
    }

    @Test
    void should_ReturnFalse_When_DietNotRecommended() {

        // given
        double weight = 50.0;
        double height = 1.92;

        // when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);

        // then
        Assertions.assertFalse(recommended);
    }

    @Test
    void should_ThrowArithmeticException_When_HeightZero() {

        // given
        double weight = 50.0;
        double height = 0.0;

        // when
        Executable executable = () -> BMICalculator.isDietRecommended(weight, height);

        // then
        Assertions.assertThrows(ArithmeticException.class, executable);
    }

    @Test
    void should_ReturnCoderWithWorstBMICoder_When_CoderListNotEmpty() {

        // given
        List<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.80, 60.0));
        coders.add(new Coder(1.82, 98.0));
        coders.add(new Coder(1.82, 64.7));

        // when
        Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

        // then
        // In JUnit 5/6, when a test contains multiple assertions, the recommended approach is to use assertAll().
        // Without assertAll(), execution stops at the first failed assertion.
        // With assertAll(), all assertions are executed and all failures are reported together.
        assertAll(
                () -> Assertions.assertEquals(1.82, coderWorstBMI.getHeight()),
                () -> Assertions.assertEquals(98.0, coderWorstBMI.getWeight())
        );
    }

    @Test
    void should_ReturnNullWorstBMICoder_When_CoderListEmpty() {

        // given
        List<Coder> coders = new ArrayList<>();

        // when
        Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

        // then
        Assertions.assertNull(coderWorstBMI);
    }

    @Test
    void should_ReturnCorrectBMIScoreArray_When_CoderListNotEmpty() {

        // given
        List<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.80, 60.0));
        coders.add(new Coder(1.82, 98.0));
        coders.add(new Coder(1.82, 64.7));
        double[] expected = { 18.52, 29.59, 19.53 };

        // when
        double[] bmiScores = BMICalculator.getBMIScores(coders);

        // then
        // Tests array equality
        Assertions.assertArrayEquals(expected, bmiScores);
    }

}
