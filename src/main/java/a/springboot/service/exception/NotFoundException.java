package a.springboot.service.exception;

public class NotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4739199601622704695L;
	
	public NotFoundException() {
		super("Not Found!");
	}
	
	public NotFoundException(String message) {
		super(message);
	}

}
