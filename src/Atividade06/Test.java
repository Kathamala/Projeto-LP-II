package Atividade06;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
	
	public static void main(String [] args) throws IOException {
		//Part 1: Read File
		ArrayList<Symbol> symbols = new ArrayList<Symbol>();
		String text = new String();
		boolean verificador = true;
		
        try{    
            FileInputStream fin=new FileInputStream("root/text_input.txt");   //args[0] 
            int i=0;    
            
            while((i=fin.read())!=-1){
            	verificador = true;
            	System.out.print((char)i);
            	text += (char)i;
             
            	for(int j=0; j<symbols.size(); j++) {
            		if(symbols.get(j).value == (char)i) {
            			symbols.get(j).quantity++;
            			verificador = false;
            			break;
            		}
            	}
            	if(verificador) {
            		symbols.add(new Symbol((char)i));  
            	}        
            }
            
            fin.close();
            
        }catch(Exception e){System.out.println(e);}
        
        //Part 2: Trie
        System.out.println();
        System.out.println("================================================");
        
        TrieSet tries = new TrieSet();
        for(int i=0; i<symbols.size(); i++) { //Criar root tries
        	tries.list.add(new Trie(new TrieNode(symbols.get(i).value, symbols.get(i).quantity)));
        }
        
        tries.compact();
        System.out.println(tries.toString());
        
        //Part 3: Hash Mapping
        CodeTable encoding = new CodeTable();
        encoding.fill(tries.list.get(0));
        
        //Part 4: write encrypted string
		BinaryNumber encrypted_sequence = encoding.getEncryptedSequence(text);
        System.out.println("Encrypted Message: " + encrypted_sequence);
        
        //Part 5: Decode
        String decrypted_string = encoding.getDecryptedMessage(encrypted_sequence);
        System.out.println("Decrypted Message: " + decrypted_string);
	}
}











