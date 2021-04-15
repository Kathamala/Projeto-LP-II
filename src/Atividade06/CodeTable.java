package Atividade06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CodeTable {
	
	public Map<Character, ArrayList<Boolean>> mapping;
	
	public CodeTable() {
		mapping = new HashMap<Character, ArrayList<Boolean>>();
	}

	public void fill(Trie tree) { //Preenche a tabela de códigos com dados da Trie.
		fill(tree.root, new BinaryNumber());
		return;
	}
	
	private void fill(TrieNode node, BinaryNumber currentBinary) {	
		if(node.isLeaf()) {
			mapping.put(node.value, currentBinary.getValue());
			System.out.print(mapping+"\n");
		}else {
			currentBinary.addDigit(false);
			fill(node.left, currentBinary);
			currentBinary.removeDigit();
			
			currentBinary.addDigit(true);
			fill(node.right, currentBinary);
			currentBinary.removeDigit();
		}
	}

	public String toString() {
		return mapping.toString();
	}
}
