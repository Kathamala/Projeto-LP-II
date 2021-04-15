package Atividade06;

public class Symbol {
	
	public char value;
	public int quantity;
	
	public Symbol(char value) {
		this.value = value;
		quantity = 1;
	}
	
	public String toString() {
		return ("Value: " + value + "/ Quantity: " + quantity);
	}
}
