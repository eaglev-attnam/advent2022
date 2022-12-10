package tests;

import days.Day;
import days.Day8;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TestDay8 {

    Day day = new Day8();

    @Test
    public void testPart1() {
        List<String> input = Arrays.asList("30373",
                "25512",
                "65332",
                "33549",
                "35390");
        Assertions.assertEquals(21, day.part1(input));
    }

    @Test
    public void testPart2() {
        List<String> input = Arrays.asList("30373",
                "25512",
                "65332",
                "33549",
                "35390");
        Assertions.assertEquals(8, day.part2(input));
    }
}