package Atividade06;

public class Trie implements Comparable<Trie>{
	
	TrieNode root;
	
	public Trie(TrieNode value) {
		this.root = value;
	}

	public String toString() {
		return toString(root, "", 0);
	}

	public String toString(TrieNode current, String tabs, int level) {
		if (current == null) {
			return "";
		}
		String str = toString(current.right, tabs + "\t", level + 1);
		str += String.format("%s(%s)[freq: %d][level: %d]\n", tabs, current.value, current.quantity, level);
		str += toString(current.left, tabs + "\t", level + 1);
		return str;
	}

	@Override
	public int compareTo(Trie o) {
		return this.root.quantity - o.root.quantity;
	}
}
