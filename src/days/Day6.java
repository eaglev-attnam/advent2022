package days;

import java.util.List;

public class Day6 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 6;
	}
	
	@Override
	public Object part1(List<String> input) {
		int i = 0;
		while(input.get(0).substring(i, i+4).matches(".*(.).*\\1.*")) {
			i++;
		}
		return i+4;
	}

	@Override
	public Object part2(List<String> input) {
		int i = 0;
		while(input.get(0).substring(i, i+14).matches(".*(.).*\\1.*")) {
			i++;
		}
		return i+14;
	}
}
