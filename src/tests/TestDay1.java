package tests;

import days.Day;
import days.Day1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDay1 {

    Day day = new Day1();

    @Test
    public void testPart1() {
        List<String> input = Arrays.asList("1000",
                "2000",
                "3000",
                "",
                "4000",
                "",
                "5000",
                "6000",
                "",
                "7000",
                "8000",
                "9000",
                "",
                "10000");
        Assertions.assertEquals(24000, day.part1(input));
    }

    @Test
    public void testPart2() {
        List<String> input = Arrays.asList("1000",
                "2000",
                "3000",
                "",
                "4000",
                "",
                "5000",
                "6000",
                "",
                "7000",
                "8000",
                "9000",
                "",
                "10000");
        Assertions.assertEquals(45000, day.part2(input));
    }
}