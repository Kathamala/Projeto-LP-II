package Atividade06;

public class Symbol {
	
	char value;
	int quantity;
	
	public Symbol(char value) {
		this.value = value;
		quantity = 1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Symbol other = (Symbol) obj;
		if (value != other.value)
			return false;
		return true;
	}
	
	public String toString() {
		return ("Value: " + value + "/ Quantity: " + quantity);
	}
}
