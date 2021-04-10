package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.InsuficientAgeException;
import exceptions.InvalidDateException;

class TestMarket {
	Market market = new Market();
	int day;
	
	public void setStage1() {
		day = 10;
		market.getPeople().clear();
	}
	
	public void setStage2() {
		day = 15;
		market.getPeople().clear();
	}

	@Test
	public void testAddPerson() {
		setStage1();
		String idType;
		String idNumber;
		
		idType = "CC";
		idNumber = "1005745733";
		
		try {
			market.addPerson(idType, idNumber, day);
			assertTrue(market.getPeople().size()==1);
			
		} catch (InsuficientAgeException | InvalidDateException e) {
			fail("The person is underage or it has an invalid id according to the day");
		}
		
		//case 2
		setStage1();
		idType = "CE";
		idNumber = "1005745733";
		
		try {
			market.addPerson(idType, idNumber, day);
			assertTrue(market.getPeople().size()==1);
			
		} catch (InsuficientAgeException | InvalidDateException e) {
			fail("The person is underage or it has an invalid id according to the day");
		}
		
		
		//case 3
		setStage1();
		idType = "PP";
		idNumber = "1005745733";
		
		try {
			market.addPerson(idType, idNumber, day);
			assertTrue(market.getPeople().size()==1);
			
		} catch (InsuficientAgeException | InvalidDateException e) {
			fail("The person is underage or it has an invalid id according to the day");
		}
		
		//case 4
		setStage2();
		
		idType = "CC";
		idNumber = "1005745743";
		
		try {
			market.addPerson(idType, idNumber, day);
			assertTrue(market.getPeople().size()==1);
			
		} catch (InsuficientAgeException | InvalidDateException e) {
			fail("The person is underage or it has an invalid id according to the day");
		}
		
		//case 5
		setStage2();
		idType = "CE";
		idNumber = "1005745743";
		
		try {
			market.addPerson(idType, idNumber, day);
			assertTrue(market.getPeople().size()==1);
			
		} catch (InsuficientAgeException | InvalidDateException e) {
			fail("The person is underage or it has an invalid id according to the day");
		}
		
		
		//case 6
		setStage2();
		idType = "PP";
		idNumber = "1005745743";
		
		try {
			market.addPerson(idType, idNumber, day);
			assertTrue(market.getPeople().size()==1);
			
		} catch (InsuficientAgeException | InvalidDateException e) {
			fail("The person is underage or it has an invalid id according to the day");
		}
	}//testAddPerson
	
	@Test
	public void testInsuficientAgeException() {
		setStage1();
		String idType = "CE";
		String idNumber = "1005745724";
		
		try {
			market.addPerson(idType, idNumber, day);			
		} catch (InsuficientAgeException e) {
			assertTrue(true);
			assertTrue(market.getPeople().size()==0);
		}catch(InvalidDateException e) {
			
		}
	}
	
	@Test
	public void testInvalidDateException() {
		//case 1
		
		setStage1();
		String idType;
		String idNumber;
		
		idType = "CE";
		idNumber = "1005745724";
		
		try {
			market.addPerson(idType, idNumber, day);
			
		} catch (InsuficientAgeException e) {
			
		}catch(InvalidDateException e) {
			assertTrue(true);
			assertTrue(market.getPeople().size()==0);
		}
		
		//case 2
		idType = "CE";
		idNumber = "1005745733";
		
		try {
			market.addPerson(idType, idNumber, day);
			
		} catch (InsuficientAgeException e) {
			
		}catch(InvalidDateException e) {
			assertTrue(true);
			assertTrue(market.getPeople().size()==0);
		}
	}
	
}
