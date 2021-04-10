package exceptions;

public class InsuficientAgeException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public InsuficientAgeException(String idT) {
		super("Esta persona no puede entrar ya que es menor de edad");
	}
}
