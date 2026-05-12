package Clases_Hotel;

public class Cliente {

	private String nombre="";
	private String apellidos="";
	private String DNI="";
	private String email="";
	private int telefono=0;
	
	public Cliente (String nombre, String apellidos, String DNI, String email, int telefono) 
	{
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.DNI=DNI;
		this.email=email;
		this.telefono=telefono;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String DNI) {
		this.DNI = DNI;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefeno() {
		return telefono;
	}
	public void setTelefeno(int telefeno) {
		this.telefono = telefeno;
	}
	
	
	public void reservarHabitacion(Habitacion habitacion, Reserva reserva) {
        if (habitacion.getestado().equalsIgnoreCase("disponible")) {
            habitacion.setestado("ocupada");
            reserva.setestadoPago("pendiente");
            System.out.println("Reserva realizada con exito en la habitacion numero " + habitacion.getnumeroHabitacion());
        } else {
            System.out.println("La habitacion no esta disponible");
        }
    }

    public void cancelarReserva(Habitacion habitacion, Reserva reserva) {
        if (reserva.getestadoPago().equalsIgnoreCase("pendiente")) {
            reserva.setestadoPago("cancelada");
            habitacion.setestado("disponible");
            System.out.println("Reserva cancelada con exito");
        } else {
            System.out.println("No se puede cancelar, la reserva ya estaba cancelada o no existe");
        }
    }
	
	
	
	
	
}
