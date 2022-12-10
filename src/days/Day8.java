package days;

import java.util.List;

public class Day8 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 8;
	}
	
	@Override
	public Object part1(List<String> input) {
		int[][] trees = new int[input.size()][input.get(0).length()];
		for(int x = 0; x < input.get(0).length(); x++) {
			for(int y = 0; y < input.size(); y++) {
				trees[x][y] = Integer.parseInt(input.get(y).substring(x, x+1));
			}
		}

		boolean[][] visible = new boolean[input.size()][input.get(0).length()];

		// from left
		for(int x = 0; x < trees.length; x++) {
			int max = -1;
			for(int y = 0; y < trees[x].length && max < 9; y++) {
				if(trees[x][y] > max) {
					visible[x][y] = true;
					max = trees[x][y];
				}
			}
		}
		// from right
		for(int x = 0; x < trees.length; x++) {
			int max = -1;
			for(int y = trees[x].length - 1; y >= 0 && max < 9; y--) {
				if(trees[x][y] > max) {
					visible[x][y] = true;
					max = trees[x][y];
				}
			}
		}
		// from top
		for(int y = 0; y < trees[0].length; y++) {
			int max = -1;
			for (int x = 0; x < trees.length && max < 9; x++) {
				if(trees[x][y] > max) {
					visible[x][y] = true;
					max = trees[x][y];
				}
			}
		}
		// from bottom
		for(int y = 0; y < trees[0].length; y++) {
			int max = -1;
			for (int x = trees.length - 1; x >= 0 && max < 9; x--) {
				if(trees[x][y] > max) {
					visible[x][y] = true;
					max = trees[x][y];
				}
			}
		}

		int total = 0;
		for(int x = 0; x < trees.length; x++) {
			for(int y = 0; y < trees[x].length; y++) {
				if(visible[x][y]) {
					total++;
				}
			}
		}
		return total;
	}

	@Override
	public Object part2(List<String> input) {
		int[][] trees = new int[input.size()][input.get(0).length()];
		for(int x = 0; x < input.get(0).length(); x++) {
			for(int y = 0; y < input.size(); y++) {
				trees[x][y] = Integer.parseInt(input.get(y).substring(x, x+1));
			}
		}

		int bestview = 0;
		for(int x = 0; x < trees.length; x++) {
			for (int y = 0; y < trees[x].length; y++) {
				int w = 0;
				for(int d = 1; d <= x; d++) {
					w++;
					if(trees[x-d][y] >= trees[x][y]) {
						break;
					}
				}
				int e = 0;
				for(int d = 1; d < trees.length - x; d++) {
					e++;
					if(trees[x+d][y] >= trees[x][y]) {
						break;
					}
				}
				int n = 0;
				for(int d = 1; d <= y; d++) {
					n++;
					if(trees[x][y-d] >= trees[x][y]) {
						break;
					}
				}
				int s = 0;
				for(int d = 1; d < trees[0].length - y; d++) {
					s++;
					if(trees[x][y+d] >= trees[x][y]) {
						break;
					}
				}
				int view = n*e*s*w;
				if(view > bestview) {
					bestview = view;
				}
			}
		}
		return bestview;
	}
}
