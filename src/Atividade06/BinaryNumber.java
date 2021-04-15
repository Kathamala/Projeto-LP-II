package Atividade06;

import java.util.ArrayList;

public class BinaryNumber {
	
	private ArrayList<Boolean> value;
	
	public BinaryNumber() {
		value = new ArrayList<Boolean>();
	}
	
	public void addDigit(boolean bool) {
		value.add(bool);
	}
	
	public void removeDigit() {
		value.remove(getSize()-1);
	}
	
	public int getSize() {
		return value.size();
	}
	
	public void setValue(ArrayList<Boolean> newValue){
		value = newValue;
	}
	
	public ArrayList<Boolean> getValue() {
		ArrayList<Boolean> list = new ArrayList<Boolean>();
        for(int i=0; i<value.size(); i++) {
        	if(value.get(i)) {
        		list.add(value.get(i));
        	} else {
        		list.add(value.get(i));
        	}
        }
		return list;		
	}
	
	public String toString() {
		String str = "";
        for(int i=0; i<value.size(); i++) {
        	if(value.get(i)) {
        		str += "1";
        	} else {
        		str += "0";
        	}
        }
		return str;		
	}
}
