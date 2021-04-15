package Atividade06;

import java.util.PriorityQueue;

public class TrieSet{
	
	PriorityQueue<Trie> list;
	
	public TrieSet() {
		list = new PriorityQueue<Trie>();
	}
	
	public void compact() {
        while(list.size() > 1) {
        	Trie tree1 = list.poll();
        	Trie tree2 = list.poll();
        	TrieNode parent = new TrieNode(' ', tree1.root.quantity+tree2.root.quantity);
        	parent.setChilds(tree1.root, tree2.root);
        	list.add(new Trie(parent));      	
        }
	}

	public String toString() {
		return list.toString();
	}
}
