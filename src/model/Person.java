package model;

public class Person {

	private IdType idType; 			//The type of the id which can be TI, CC, PP or CE
	private String idNumber; 			//Number of identification
	
	public Person(String idType, String idNumber) {
		
		this.idNumber = idNumber;
		this.idType = IdType.valueOf(idType);
	}
	
	//Getters and setters	
	public String getType() {
		return idType.getType();
	}

	public void setType(IdType type) {
		this.idType = type;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	
}
