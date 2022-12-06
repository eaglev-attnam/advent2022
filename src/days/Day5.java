package days;

import java.util.*;
import java.util.stream.Collectors;

public class Day5 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 5;
	}
	
	@Override
	public Object part1(List<String> input) {
		return runCrane(new CM9000(), input);
	}

	@Override
	public Object part2(List<String> input) {
		return runCrane(new CM9001(), input);
	}

	private String runCrane(Crane crane, List<String> input) {
		List<LinkedList<Character>> dq = new ArrayList<>();
		int i = 0;
		String s = input.get(i);
		while(!s.startsWith(" 1")) {
			for(int j = 0; (j*4)+1 < s.length(); j++) {
				if(dq.size() <= j) {
					dq.add(new LinkedList<>());
				}
				char c = s.charAt((4*j) + 1);
				if(c != ' ') {
					dq.get(j).addLast(c);
				}
			}
			i++;
			s = input.get(i);
		}
		i += 2;
		while(i < input.size()) {
			s = input.get(i);
			List<Integer> parsed = Arrays.stream(s.split("(move | from | to )")).filter(str -> !str.isEmpty()).map(Integer::parseInt).collect(Collectors.toList());
			dq = crane.move(dq, parsed.get(0), parsed.get(1)-1, parsed.get(2)-1);
			i++;
		}
		s = "";
		for(LinkedList<Character> ll : dq) {
			s += ll.peek();
		}
		return s;
	}

	private interface Crane {
		List<LinkedList<Character>> move(List<LinkedList<Character>> in, int n, int from, int to);
	}

	private class CM9000 implements Crane {
		@Override
		public List<LinkedList<Character>> move(List<LinkedList<Character>> in, int n, int from, int to) {
			for(int j = 0; j < n; j++) {
				in.get(to).push(in.get(from).pop());
			}
			return in;
		}
	}

	private class CM9001 implements Crane {
		@Override
		public List<LinkedList<Character>> move(List<LinkedList<Character>> in, int n, int from, int to) {
			LinkedList<Character> tmp = new LinkedList<>();
			for(int j = 0; j < n; j++) {
				tmp.push(in.get(from).pop());
			}
			while(!tmp.isEmpty()) {
				in.get(to).push(tmp.pop());
			}
			return in;
		}
	}
}
