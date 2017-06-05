package Models;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {
	private Date FechaEntrada;
	private Date FechaBajada;
	private float Total;
	
	
	public Cliente(Date fechaBajada, Date fechaEntrada, float total) {
		super();
		FechaEntrada = fechaEntrada;
		FechaBajada = fechaBajada;
		Total = total;
	}
	
	public Date getFechaEntrada() {
		return FechaEntrada;
	}
	public void setFechaEntrada(Date fechaEntrada) {
		FechaEntrada = fechaEntrada;
	}
	public Date getFechaBajada() {
		return FechaBajada;
	}
	public void setFechaBajada(Date fechaBajada) {
		FechaBajada = fechaBajada;
	}
	public float getTotal() {
		return Total;
	}
	public void setTotal(float total) {
		Total = total;
	}
	
	@Override
	public String toString(){
		return "[Cliente: Fecha de Entrada: "+FechaEntrada+", Fecha de Salida: "+ FechaBajada +", Total: "+Total+" Eur"; 
	}
	
}
