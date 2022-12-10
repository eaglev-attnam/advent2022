package tests;

import days.Day;
import days.Day9;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TestDay9 {

    Day day = new Day9();

    @Test
    public void testPart1() {
        List<String> input = Arrays.asList("R 4",
                "U 4",
                "L 3",
                "D 1",
                "R 4",
                "D 1",
                "L 5",
                "R 2");
        Assertions.assertEquals(13, day.part1(input));
    }

    @Test
    public void testPart2() {
        List<String> input = Arrays.asList("R 4",
                "U 4",
                "L 3",
                "D 1",
                "R 4",
                "D 1",
                "L 5",
                "R 2");
        Assertions.assertEquals(1, day.part2(input));
        input = Arrays.asList("R 5",
                "U 8",
                "L 8",
                "D 3",
                "R 17",
                "D 10",
                "L 25",
                "U 20");
        Assertions.assertEquals(36, day.part2(input));
    }
}