package model;

import java.time.LocalDate;
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
		attempts++;
		
		if(idType.equals(IDTYPETI)) {
			throw new InsuficientAgeException(idType);
		}
		
		int day = LocalDate.now().getDayOfMonth();
		
		if(idNumber.length()<7) {
		}else {
			
			String x = ""+idNumber.charAt(idNumber.length()-2);
			int num = Integer.parseInt(x);
			
			if((num%2 == 0 && 15%2 == 0) || (num%2 != 0 && 15%2 != 0) ) {
				System.out.println(day+": "+idNumber.charAt(idNumber.length()-2));
				throw new InvalidDateException(idNumber);
			}
		}
		
		Person people = new Person(idType, idNumber);
	}//addPerson

	
	//getters and setters
	public ArrayList<Person> getPeople() {
		return people;
	}

	public void setPeople(ArrayList<Person> people) {
		this.people = people;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
	
	
}
