package tests;

import days.Day;
import days.Day5;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TestDay5 {

    Day day = new Day5();

    @Test
    public void testPart1() {
        List<String> input = Arrays.asList("    [D]    ",
                "[N] [C]    ",
                "[Z] [M] [P]",
                " 1   2   3 ",
                "",
                "move 1 from 2 to 1",
                "move 3 from 1 to 3",
                "move 2 from 2 to 1",
                "move 1 from 1 to 2");
        Assertions.assertEquals("CMZ", day.part1(input));
    }

    @Test
    public void testPart2() {
        List<String> input = Arrays.asList("    [D]    ",
                "[N] [C]    ",
                "[Z] [M] [P]",
                " 1   2   3 ",
                "",
                "move 1 from 2 to 1",
                "move 3 from 1 to 3",
                "move 2 from 2 to 1",
                "move 1 from 1 to 2");
        Assertions.assertEquals("MCD", day.part2(input));
    }
}