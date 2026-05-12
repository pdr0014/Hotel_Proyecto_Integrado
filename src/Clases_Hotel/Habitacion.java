package Clases_Hotel;

public class Habitacion {

	private int numeroHabitacion=0;
	private String tipo="";
	private int precioNoche=0;
	private String estado="";
	
	public Habitacion (int numeroHabitacion,String tipo, int precioNoche, String estado ) 
	{
		this.numeroHabitacion=numeroHabitacion;
		this.tipo=tipo;
		this.precioNoche=precioNoche;
		this.estado=estado;
	}
	
	public int getnumeroHabitacion() {
		return numeroHabitacion;
	}

	public void setnumeroHabitacion(int numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}

	public String gettipo() {
		return tipo;
	}

	public void settipo(String tipo) {
		this.tipo = tipo;
	}

	public int getprecioNoche() {
		return precioNoche;
	}

	public void setprecioNoche(int precioNoche) {
		this.precioNoche = precioNoche;
	}

	public String getestado() {
		return estado;
	}

	public void setestado(String estado) {
		this.estado = estado;
	}

	//public String estadoHabitacion() //D para disponible O para ocupada M para mantenimiento
	{
		
	}
}
