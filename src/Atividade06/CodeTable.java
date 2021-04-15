package Atividade06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CodeTable {
	
	public Map<Character, ArrayList<Boolean>> mappingCB;
	public Map<ArrayList<Boolean>, Character> mappingBC;
	
	public CodeTable() {
		mappingCB = new HashMap<Character, ArrayList<Boolean>>();
		mappingBC = new HashMap<ArrayList<Boolean>, Character>();
	}

	public void fill(Trie tree) { //Preenche a tabela de códigos com dados da Trie.
		fill(tree.root, new BinaryNumber());
		return;
	}
	
	private void fill(TrieNode node, BinaryNumber currentBinary) {	
		if(node.isLeaf()) {
			mappingCB.put(node.value, currentBinary.getValue());
			mappingBC.put(currentBinary.getValue(), node.value);
		}else {
			currentBinary.addDigit(false);
			fill(node.left, currentBinary);
			currentBinary.removeDigit();
			
			currentBinary.addDigit(true);
			fill(node.right, currentBinary);
			currentBinary.removeDigit();
		}
	}
	
	public ArrayList<Boolean> get(char key) {
		return mappingCB.get(key);
	}

	public char get(ArrayList<Boolean> key) {
		return mappingBC.get(key);
	}

	public String toString() {
		return mappingCB.toString();
	}
}
