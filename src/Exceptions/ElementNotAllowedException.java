package Exceptions;

public class ElementNotAllowedException extends NullPointerException {
	/**
	 * PARA LANZAR LA EXCEPCION THROW NEW NOMBRE_EXCEPCION();
	 * 
	 */
	public  ElementNotAllowedException(){
		super("[ERROR]:HA INTRODUCIDO UN VALOR NULO ");
	}
	
}
