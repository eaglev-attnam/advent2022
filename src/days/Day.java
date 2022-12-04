package days;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Day {
	
	public static final Day[] DAYS = new Day[] {
			new Day0(),
			new Day1(),
			new Day2(),
			new Day3(),
			new Day4()
	};
	
	protected abstract int getChallengeNumber();
	public abstract Object part1(List<String> input);
	public abstract Object part2(List<String> input);

	public Object part1() throws IOException {
		return part1(getInputFile(1));
	}
	public Object part2() throws IOException {
		return part2(getInputFile(sameInputFile() ? 1 : 2));
	}
	
	protected boolean sameInputFile() {
		return true;
	}
	
	protected List<String> getInputFile(int part) throws IOException {
		try (Stream<String> stream = Files.lines(Paths.get("resources/input" + getChallengeNumber() + "." + part))) {
			return stream.collect(Collectors.toList());
		}
	}
	
	public static Day getDay(int num) {
		return DAYS[num];
	}
	
	public static Day getLastDay() {
		return DAYS[DAYS.length - 1];
	}
}
