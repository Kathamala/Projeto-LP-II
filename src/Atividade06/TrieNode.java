package Atividade06;

public class TrieNode {
	
	public char value;
	public int quantity;
	
	public TrieNode left;
	public TrieNode right;
	
	public TrieNode(char value, int quantity) {
		this.value = value;
		this.quantity = quantity;
	}

	public boolean isLeaf() {
		return left == null && right == null;
	}

	public void setChilds(TrieNode left, TrieNode right) {
		this.left = left;
		this.right = right;
	}

	public String toString() {
		return Integer.toString(value);
	}
}
