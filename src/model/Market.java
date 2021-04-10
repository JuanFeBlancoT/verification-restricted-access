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

	public void addPerson(String idType, String idNumber, int day) throws InsuficientAgeException, InvalidDateException {
		attempts++;
		
		if(idType.equals(IDTYPETI)) {
			throw new InsuficientAgeException(idType);
		}
		
		if(idNumber.length()<7) {
		}else {
			
			String x = ""+idNumber.charAt(idNumber.length()-2);
			int num = Integer.parseInt(x);
			
			if((num%2 == 0 && day%2 == 0) || (num%2 != 0 && day%2 != 0) ) {
				throw new InvalidDateException(idNumber);
			}
		}
		
		Person person = new Person(idType, idNumber);
		people.add(person);
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
