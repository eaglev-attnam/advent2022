package tests;

import days.Day;
import days.Day4;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TestDay4 {

    Day day = new Day4();

    @Test
    public void testPart1() {
        List<String> input = Arrays.asList("2-4,6-8",
                "2-3,4-5",
                "5-7,7-9",
                "2-8,3-7",
                "6-6,4-6",
                "2-6,4-8");
        Assertions.assertEquals(2, day.part1(input));
    }

    @Test
    public void testPart2() {
        List<String> input = Arrays.asList("2-4,6-8",
                "2-3,4-5",
                "5-7,7-9",
                "2-8,3-7",
                "6-6,4-6",
                "2-6,4-8");
        Assertions.assertEquals(4, day.part2(input));
    }
}