package days;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day3 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 3;
	}
	
	@Override
	public Object part1(List<String> input) {
		int total = 0;
		for(String s : input) {
			String s1 = s.substring(0, s.length()/2);
			String s2 = s.substring(s.length()/2);
			Set<Character> cs = new HashSet<>();
			for(char c : s1.toCharArray()) {
				cs.add(c);
			}
			int n = 0;
			while(!cs.contains(s2.charAt(n))) {
				n++;
			}
			char cd = s2.charAt(n);
			if(cd >= 'a' && cd <= 'z') {
				total += cd - 'a' + 1;
			} else {
				total += cd - 'A' + 27;
			}
		}
		return total;
	}

	@Override
	public Object part2(List<String> input) {
		int total = 0;
		for(int i = 0; i < input.size(); i += 3) {
			String s0 = input.get(i);
			String s1 = input.get(i+1);
			String s2 = input.get(i+2);
			char c = s0.replaceAll("[^"+s1+"]","").replaceAll("[^"+s2+"]","").charAt(0);
			if(c >= 'a' && c <= 'z') {
				total += c - 'a' + 1;
			} else {
				total += c - 'A' + 27;
			}
		}
		return total;
	}
}
