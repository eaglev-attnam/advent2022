package days;

import java.util.List;

public class Day10 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 10;
	}
	
	@Override
	public Object part1(List<String> input) {
		int cycle = 0;
		long reg = 1;
		long total = 0;
		for(String s : input) {
			cycle++;
			if(cycle % 40 == 20) {
				total += cycle * reg;
			}
			String[] ss = s.split(" ");
			if(ss.length == 2) {
				cycle++;
				if(cycle % 40 == 20) {
					total += cycle * reg;
				}
				reg += Integer.parseInt(ss[1]);
			}
		}
		return total;
	}

	@Override
	public Object part2(List<String> input) {
		StringBuilder sb = new StringBuilder();
		int cycle = 0;
		long reg = 1;
		for(String s : input) {
			if(Math.abs(cycle%40 - reg) <= 1) {
				sb.append("#");
			} else {
				sb.append(".");
			}
			if(cycle % 40 == 39) {
				sb.append("\n");
			}
			cycle++;
			String[] ss = s.split(" ");
			if(ss.length == 2) {
				if(Math.abs(cycle%40 - reg) <= 1) {
					sb.append("#");
				} else {
					sb.append(".");
				}
				if(cycle % 40 == 39) {
					sb.append("\n");
				}
				reg += Integer.parseInt(ss[1]);
				cycle++;
			}
		}
		return sb.toString();
	}
}
