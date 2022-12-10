package days;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day7 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 7;
	}
	
	@Override
	public Object part1(List<String> input) {
		Node root = generateFileSystem(input);
		List<Node> nodes = root.getDirsBelow(100_000L);
		return nodes.stream().map(Node::getSize).reduce(0L, Long::sum);
	}

	@Override
	public Object part2(List<String> input) {
		Node root = generateFileSystem(input);
		long left = 70_000_000 - root.getSize();
		long toDelete = 30_000_000 - left;
		return root.getClosestAbove(toDelete).getSize();
	}

	private Node generateFileSystem(List<String> input) {
		Node root = new Node(0L, null);
		Node current = root;
		for(String s : input) {
			String[] sp = s.split(" ");
			if("$".equals(sp[0])) {
				if("cd".equals(sp[1])) {
					if("/".equals(sp[2])) {
						current = root;
					} else if("..".equals(sp[2])) {
						current = current.parent;
					} else {
						if(!current.children.containsKey(sp[2])){
							Node n = new Node(0L, current);
							current.children.put(sp[2], n);
						}
						current = current.children.get(sp[2]);
					}
				}
			} else {
				if(!current.children.containsKey(sp[1])) {
					long size = 0;
					if(!"dir".equals(sp[0])) {
						size = Long.parseLong(sp[0]);
					}
					Node n = new Node(size, current);
					current.children.put(sp[1], n);
				}
			}
		}
		return root;
	}

	private class Node {
		long size;
		Long actualSize;
		Map<String, Node> children = new HashMap<>();
		Node parent;

		private Node(long size, Node parent) {
			this.size = size;
			this.parent = parent;
		}

		private boolean isDir() {
			return !children.isEmpty();
		}

		private long getSize() {
			if(actualSize == null) {
				actualSize = size + children.values().stream().map(Node::getSize).reduce(0L, Long::sum);
			}
			return actualSize;
		}

		private List<Node> getDirsBelow(long size) {
			List<Node> nodes = new ArrayList<>();
			if(isDir() && getSize() < size) {
				nodes.add(this);
			}
			nodes.addAll(children.values().stream().flatMap(n -> n.getDirsBelow(size).stream()).collect(Collectors.toList()));
			return nodes;
		}

		public Node getClosestAbove(long size) {
			Node best = this;
			for(Node c : children.values()) {
				if(c.isDir()) {
					Node subbest = c.getClosestAbove(size);
					if(subbest.getSize() > size && subbest.getSize() < best.getSize()) {
						best = subbest;
					}
				}
			}
			return best;
		}
	}
}
