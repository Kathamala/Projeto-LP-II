package Atividade06;

import java.util.ArrayList;

public class TrieSet {
	
	ArrayList<Trie> list;
	
	public TrieSet() {
		list = new ArrayList<Trie>();
	}
	
	public void compact() {
        while(list.size() > 1) {
        	sort();
        	TrieNode parent = new TrieNode(' ', list.get(0).root.quantity+list.get(1).root.quantity);
        	parent.setChilds(list.get(0).root, list.get(1).root);
        	
        	list.get(0).root = parent;
        	list.remove(1);
        }
	}
	
	private void sort() {
	    Trie temp;
	    for(int i=0; i < list.size()-1; i++) {
	    	for (int j = 0; j < list.size() - 1 - i; ++j ) {
	    		if(list.get(j).root.quantity > list.get(j+1).root.quantity) {
	    			temp = list.get(j+1);
	    			list.set(j+1, list.get(j));
	    			list.set(j, temp);
	    		}
	    	}
	    }
	}


	public String toString() {
		String str = "";
        for(int i=0; i<list.size(); i++) {
        	str += String.format("-Tree " + i + ": \n");
        	str += String.format("%s\n", list.get(i).toString());
        }
		return str;
	}
}
