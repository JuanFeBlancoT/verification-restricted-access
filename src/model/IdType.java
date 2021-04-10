package model;

public enum IdType {

	TI ("Tarjeta de identidad"),CC ("Tarjeta de identidad"),CE ("Tarjeta de identidad"),PP ("Tarjeta de identidad");
	
	private String idType;
	
	private IdType(String typ) {
		idType = typ;
	}
	
	public String getType() {
		return idType;
	}
}
