package tests;

import days.Day;
import days.Day2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TestDay2 {

    Day day = new Day2();

    @Test
    public void testPart1() {
        List<String> input = Arrays.asList(
                "A Y",
                "B X",
                "C Z");
        Assertions.assertEquals(15, day.part1(input));
    }

    @Test
    public void testPart2() {
        List<String> input = Arrays.asList(
                "A Y",
                "B X",
                "C Z");
        Assertions.assertEquals(12, day.part2(input));
    }
}