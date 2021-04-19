package Atividade06;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Huffman {
	
	public static void main(String [] args) throws IOException {
		//Part 1: Read File
		ArrayList<TrieNode> symbols = new ArrayList<TrieNode>();
		String text = new String();
		boolean verificador = true;
		
        try{    
            FileInputStream fin=new FileInputStream(args[0]);   //args[0]
            int i=0;    
            
            while((i=fin.read())!=-1){
            	verificador = true;
            	text += (char)i;
             
            	for(int j=0; j<symbols.size(); j++) {
            		if(symbols.get(j).value == (char)i) {
            			symbols.get(j).quantity++;
            			verificador = false;
            			break;
            		}
            	}
            	if(verificador) {
            		symbols.add(new TrieNode((char)i, 1));  
            	}        
            }
            
            fin.close();
            
        }catch(Exception e){System.out.println(e);}
        if(text.length() == 0) {
        	System.out.println("Digite um texto válido");
        	return;
        }
        
        System.out.println("Text: " + text);
        
        //Part 2: Trie
        TrieSet tries = new TrieSet();
        for(int i=0; i<symbols.size(); i++) { //Criar root tries
        	tries.list.add(new Trie(symbols.get(i)));
        }
        
        tries.compact();
        System.out.println(tries.toString());
        
        //Part 3: Hash Mapping
        CodeTable encoding = new CodeTable();
        encoding.fill(tries.list.peek());
        System.out.println(encoding + "\n");
        
        //Part 4: write encrypted string
		BinaryNumber encrypted_sequence = encoding.getEncryptedSequence(text);
        System.out.println("Encrypted Message: " + encrypted_sequence.toString());
        
        //Part 5: Decode
        String decrypted_string = encoding.getDecryptedMessage(encrypted_sequence);
        System.out.println("Decrypted Message: " + decrypted_string);
	}
}











