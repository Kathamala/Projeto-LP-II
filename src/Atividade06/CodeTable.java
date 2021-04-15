package Atividade06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CodeTable {
	
	private Map<Character, ArrayList<Boolean>> mappingCB;
	private Map<ArrayList<Boolean>, Character> mappingBC;
	
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
			if(currentBinary.getSize() == 0) {
				currentBinary.addDigit(false);
			}
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
	
	public BinaryNumber getEncryptedSequence(String text) {
        BinaryNumber encrypted_sequence = new BinaryNumber();
        for(int i=0; i<text.length(); i++) {
        	encrypted_sequence.addSequence(mappingCB.get(text.charAt(i)));
        }
        
        return encrypted_sequence;
	}
	
	public String getDecryptedMessage(BinaryNumber encrypted_sequence) {
        BinaryNumber current = new BinaryNumber();
        String decrypted_string = new String();
        
        for(int i=0; i<encrypted_sequence.getSize(); i++) {
        	current.addDigit(encrypted_sequence.get(i));
        	if(mappingBC.get(current.getValue()) != null) {
        		decrypted_string += mappingBC.get(current.getValue());
        		current.erase();
        	}
        }      

        return decrypted_string;
	}
	
	public String toString() {
		return mappingCB.toString();
	}
}
