package tests;

import days.Day;
import days.Day6;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TestDay6 {

    Day day = new Day6();

    @Test
    public void testPart1() {
        List<String> input = Arrays.asList("mjqjpqmgbljsphdztnvjfqwrcgsmlb");
        Assertions.assertEquals(7, day.part1(input));
        input = Arrays.asList("bvwbjplbgvbhsrlpgdmjqwftvncz");
        Assertions.assertEquals(5, day.part1(input));
        input = Arrays.asList("nppdvjthqldpwncqszvftbrmjlhg");
        Assertions.assertEquals(6, day.part1(input));
        input = Arrays.asList("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg");
        Assertions.assertEquals(10, day.part1(input));
        input = Arrays.asList("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw");
        Assertions.assertEquals(11, day.part1(input));
    }

    @Test
    public void testPart2() {
        List<String> input = Arrays.asList("mjqjpqmgbljsphdztnvjfqwrcgsmlb");
        Assertions.assertEquals(19, day.part2(input));
        input = Arrays.asList("bvwbjplbgvbhsrlpgdmjqwftvncz");
        Assertions.assertEquals(23, day.part2(input));
        input = Arrays.asList("nppdvjthqldpwncqszvftbrmjlhg");
        Assertions.assertEquals(23, day.part2(input));
        input = Arrays.asList("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg");
        Assertions.assertEquals(29, day.part2(input));
        input = Arrays.asList("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw");
        Assertions.assertEquals(26, day.part2(input));
    }
}