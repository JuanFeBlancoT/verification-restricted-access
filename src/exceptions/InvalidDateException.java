package exceptions;

public class InvalidDateException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public InvalidDateException(String number) {
		super("Esta persona no puede entrar ya que no es su día");
	}
}
