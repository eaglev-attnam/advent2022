package days;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day4 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 4;
	}
	
	@Override
	public Object part1(List<String> input) {
		int hits = 0;
		for(String s : input){
			List<Integer> vals = Arrays.stream(s.split("[-,]")).map(Integer::parseInt).collect(Collectors.toList());
			if(vals.get(0).equals(vals.get(2)) || vals.get(1).equals(vals.get(3)) || vals.get(0) > vals.get(2) == vals.get(1) < vals.get(3)) {
				hits++;
			}
		}
		return hits;
	}

	@Override
	public Object part2(List<String> input) {
		int hits = 0;
		for(String s : input){
			List<Integer> vals = Arrays.stream(s.split("[-,]")).map(Integer::parseInt).collect(Collectors.toList());
			if((vals.get(0) <= vals.get(3) || vals.get(1) <= vals.get(3)) && (vals.get(0) >= vals.get(2) || vals.get(1) >= vals.get(2))) {
				hits++;
			}
		}
		return hits;
	}
}
