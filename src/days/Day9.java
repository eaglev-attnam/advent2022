package days;

import common.Coordinate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day9 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 9;
	}
	
	@Override
	public Object part1(List<String> input) {
		Coordinate head = new Coordinate(0,0);
		Coordinate tail = head;
		Set<Coordinate> tailCoords = new HashSet<>();
		tailCoords.add(tail);
		for(String s : input) {
			String[] ss = s.split(" ");
			int steps = Integer.parseInt(ss[1]);
			int dx = getDx(ss[0]);
			int dy = getDy(ss[0]);
			for(int i = 0; i < steps; i++) {
				head = new Coordinate(head.getX() + dx, head.getY() + dy);
				boolean moving = Math.abs(tail.getY() - head.getY()) >= 2 || Math.abs(tail.getX() - head.getX()) >= 2;
				if(moving) {
					int newTailY = tail.getY();
					int newTailX = tail.getX();
					if(head.getY() > tail.getY()) {
						newTailY++;
					} else if(head.getY() < tail.getY()) {
						newTailY--;
					}
					if(head.getX() > tail.getX()) {
						newTailX++;
					} else if(head.getX() < tail.getX()) {
						newTailX--;
					}
					tail = new Coordinate(newTailX, newTailY);
					tailCoords.add(tail);
				}
			}
		}
		return tailCoords.size();
	}

	@Override
	public Object part2(List<String> input) {
		List<Coordinate> rope = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			rope.add(new Coordinate(0,0));
		}
		Set<Coordinate> tailCoords = new HashSet<>();
		tailCoords.add(rope.get(9));
		for(String s : input) {
			String[] ss = s.split(" ");
			int steps = Integer.parseInt(ss[1]);
			int dx = getDx(ss[0]);
			int dy = getDy(ss[0]);
			for(int i = 0; i < steps; i++) {
				rope.set(0, new Coordinate(rope.get(0).getX() + dx, rope.get(0).getY() + dy));
				for(int k = 0; k < 9; k++) {
					boolean moving = Math.abs(rope.get(k+1).getY() - rope.get(k).getY()) >= 2 || Math.abs(rope.get(k+1).getX() - rope.get(k).getX()) >= 2;
					if(moving) {
						int newKnotY = rope.get(k+1).getY();
						int newKnotX = rope.get(k+1).getX();
						if(rope.get(k).getY() > rope.get(k+1).getY()) {
							newKnotY++;
						} else if(rope.get(k).getY() < rope.get(k+1).getY()) {
							newKnotY--;
						}
						if(rope.get(k).getX() > rope.get(k+1).getX()) {
							newKnotX++;
						} else if(rope.get(k).getX() < rope.get(k+1).getX()) {
							newKnotX--;
						}
						rope.set(k+1,new Coordinate(newKnotX, newKnotY));
					}
				}
				tailCoords.add(rope.get(9));
			}
		}
		return tailCoords.size();
	}

	private int getDx(String dir) {
		switch (dir.charAt(0)) {
			case 'L':
				return -1;
			case 'R':
				return 1;
			default:
				return 0;
		}
	}

	private int getDy(String dir) {
		switch (dir.charAt(0)) {
			case 'U':
				return -1;
			case 'D':
				return 1;
			default:
				return 0;
		}
	}
}
