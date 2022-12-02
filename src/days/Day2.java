package days;

import java.util.List;

public class Day2 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 2;
	}
	
	@Override
	public Object part1(List<String> input) {
		int score = 0;
		for(String game : input) {
			String[] s = game.split(" ");
			int opp = s[0].charAt(0) - 'A';
			int me = s[1].charAt(0) - 'X';
			score += me + 1;
			if(me == opp) {
				score += 3;
			} else if((opp+1)%3 == me) {
				score += 6;
			}
		}
		return score;
	}

	@Override
	public Object part2(List<String> input) {
		int score = 0;
		for(String game : input) {
			String[] s = game.split(" ");
			int opp = s[0].charAt(0) - 'A';
			int res = s[1].charAt(0) - 'X';
			int me = (opp + res + 2) % 3;
			score += me + 1;
			if(me == opp) {
				score += 3;
			} else if((opp+1)%3 == me) {
				score += 6;
			}
		}
		return score;
	}
}
