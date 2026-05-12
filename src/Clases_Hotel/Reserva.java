package Clases_Hotel;

public class Reserva {
	
	private int ID_reserva=0;
	private int fechaEntrada=0;
	private int fechaSalida=0;
	private String estadoPago="";
	
	public Reserva (int ID_reserva, int fechaEntrada, int fechaSalida, String estadoPago) 
	{
		this.ID_reserva=ID_reserva;
		this.fechaEntrada=fechaEntrada;
		this.fechaSalida=fechaSalida;
		this.estadoPago=estadoPago;
	}
	
	public int getID_reserva() {
		return ID_reserva;
	}

	public void setID_reserva(int iD_reserva) {
		ID_reserva = iD_reserva;
	}

	public int getfechaEntrada() {
		return fechaEntrada;
	}

	public void setfechaEntrada(int fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public int getfechaSalida() {
		return fechaSalida;
	}

	public void setfechaSalida(int fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getestadoPago() {
		return estadoPago;
	}

	public void setestadoPago(String estadoPago) {
		this.estadoPago = estadoPago;
	}

	// public Arraylist<> listaRegistros()
	{
		
	}
	
	
	// public boolean cambiarDia() 
	{
		
	}
	
	// public boolean cambiarHora() 
	{
		
	}
	
	// public boolean cambiarHabitacion() 
	{
		
	}
	
	
	//si no hay ninguna reserva no sale nada
}
