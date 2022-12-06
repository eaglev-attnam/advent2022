package days;

import java.util.ArrayList;
import java.util.List;

public class Day1 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 1;
	}
	
	@Override
	public Object part1(List<String> input) {
		int max = 0;
		int current = 0;
		for(String s : input) {
			if(s.isEmpty()) {
				current = 0;
			} else {
				current += Integer.parseInt(s);
				if(current > max) {
					max = current;
				}
			}
		}
		return max;
	}

	@Override
	public Object part2(List<String> input) {
		List<Integer> elves = new ArrayList<>();
		int current = 0;
		for(String s : input) {
			if(s.isEmpty()) {
				elves.add(current);
				current = 0;
			} else {
				current += Integer.parseInt(s);
			}
		}
		elves.add(current);
		elves.sort(Integer::compareTo);
		int last = elves.size() - 1;
		return elves.get(last) + elves.get(last-1) + elves.get(last-2);
	}
}
