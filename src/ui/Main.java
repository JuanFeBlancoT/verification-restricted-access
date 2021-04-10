package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import exceptions.InsuficientAgeException;
import exceptions.InvalidDateException;
import model.Market;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Market market = new Market();
	private static String idType;
	private static String idNumber;
	
	public static void main(String[] args) {
		mainMenu();
	}
	
	public Main() {
		
	}
	
	public static void mainMenu() {
		
		int optionSelected = 1;
		boolean running = true;	
		
		while(running) {
			
			String menuMessage = "\n******** MEN� ********\n"+
					"1) Registrar el ingreso de una nueva persona\n"+
					"2) Consultar cuantas personas han intentado ingresar\n"+
					"3) Salir del programa";
			
			System.out.println(menuMessage);
			//---
			try {
				
				optionSelected = Integer.parseInt(br.readLine());
			} catch (NumberFormatException | IOException e) {
				System.out.println("Opcion seleccionada inv�lida");
				e.printStackTrace();
			}
			//---
			
			switch(optionSelected) {
			case 1:
				verifyNewPerson();
				try {
					market.addPerson(idType, idNumber);
				} catch (InsuficientAgeException | InvalidDateException e) {
					System.out.println(e.toString());
					//e.printStackTrace();
				}
				
				break;
			case 2:
				System.out.println("La cantidad de las personas que han intentado ingresar al mercado son: " + market.getAttempts());
				break;
			case 3:
				running = false;
				break;
				default:
				System.out.println("Opcion seleccionada inv�lida");
			}
		}
	}//end mainMenu

	private static void verifyNewPerson() {
		int idTypeOption = -1;
		
		System.out.println("\nIngrese el tipo de identidficaci�n:\n"+
							"1) Tarjeta de identitdad\n"+	
							"2) C�dula ciudadana\n"+	
							"3) Pasaporte\n"+	
							"4) C�dula de extranjeria\n");	
		//----
		try {
			idTypeOption = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("Opci�n inv�lida");
			e.printStackTrace();
		}
		//----
		switch(idTypeOption) {
		case 1:
			idType = "TI";
			break;
		case 2:
			idType = "CC";
			break;
		case 3:
			idType = "PP";
			break;
		case 4:
			idType = "CE";
			break;
			default:
				System.out.println("Opci�n inv�lida");
		}
		
			System.out.println("Ingrese el n�mero de identificaci�n");
			//----
			try {
				long idNumberX = Long.parseLong(br.readLine());
				idNumber = ""+idNumberX;
			} catch (NumberFormatException | IOException e) {
				System.out.println("El valor ingresado no es un n�mero");
				e.printStackTrace();
			}
			
			if(idNumber.length()<8) {
				System.out.println("Este n�mero de c�dula no es v�lido");
			}
			//----
	}//end verifyNewPerson
	
	
}
