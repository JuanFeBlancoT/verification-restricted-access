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
			
			String menuMessage = "\n******** MENÚ ********\n"+
					"1) Registrar el ingreso de una nueva persona\n"+
					"2) Consultar cuantas personas han intentado ingresar\n"+
					"3) Salir del programa";
			
			System.out.println(menuMessage);
			//---
			try {
				
				optionSelected = Integer.parseInt(br.readLine());
			} catch (NumberFormatException | IOException e) {
				System.out.println("Opcion seleccionada inválida");
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
				System.out.println("Opcion seleccionada inválida");
			}
		}
	}//end mainMenu

	private static void verifyNewPerson() {
		int idTypeOption = -1;
		
		System.out.println("\nIngrese el tipo de identidficación:\n"+
							"1) Tarjeta de identitdad\n"+	
							"2) Cédula ciudadana\n"+	
							"3) Pasaporte\n"+	
							"4) Cédula de extranjeria\n");	
		//----
		try {
			idTypeOption = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("Opción inválida");
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
				System.out.println("Opción inválida");
		}
		
			System.out.println("Ingrese el número de identificación");
			//----
			try {
				long idNumberX = Long.parseLong(br.readLine());
				idNumber = ""+idNumberX;
			} catch (NumberFormatException | IOException e) {
				System.out.println("El valor ingresado no es un número");
				e.printStackTrace();
			}
			
			if(idNumber.length()<8) {
				System.out.println("Este número de cédula no es válido");
			}
			//----
	}//end verifyNewPerson
	
	
}
