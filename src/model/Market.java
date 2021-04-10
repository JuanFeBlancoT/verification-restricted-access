package model;

import java.io.IOException;
import java.util.ArrayList;

import exceptions.InsuficientAgeException;
import exceptions.InvalidDateException;

public class Market {
	
	private static final String IDTYPETI = "TI";
	
	private ArrayList<Person> people;
	private int attempts;
	
	public Market() {
		attempts = 0;
		people = new ArrayList<>();
	}

	public void addPerson(String idType, String idNumber) throws InsuficientAgeException, InvalidDateException {
	
		if(idType.equals(IDTYPETI)) {
			throw new InsuficientAgeException(idType);
		}
		if(idNumber.length()<7) {
		}else {
			
			String x = ""+idNumber.charAt(idNumber.length()-2);
			int num = Integer.parseInt(x);
			
			System.out.println(x);
			if(num==1) {
				System.out.println(idNumber.length()+": "+idNumber.charAt(idNumber.length()-2));
				throw new InvalidDateException(idNumber);
			}
		}
		
		
	}//addPerson
	
	
}
