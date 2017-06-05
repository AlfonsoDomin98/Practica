package Exceptions;

public class ListSizeOverflownException extends RuntimeException {
	/**
	 * PARA LANZAR LA EXCEPCION THROW NEW NOMBRE_EXCEPCION();
	 * 
	 */
	public ListSizeOverflownException(){
		super("[ERROR]: HA SOBREPASADO EL TAMAÑO LIMITE");
	}
}
