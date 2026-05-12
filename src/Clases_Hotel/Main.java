package Clases_Hotel;

public class Main {
    public static void main(String[] args) {

        // Crear un cliente
        Cliente cliente = new Cliente("Ana", "Garcia Lopez", "12345678A", "ana@email.com", 612345678);

        // Crear una habitacion
        Habitacion habitacion = new Habitacion();
        habitacion.setnumeroHabitacion(101);
        habitacion.settipo("doble");
        habitacion.setprecioNoche(80);
        habitacion.setestado("disponible");

        // Crear una reserva
        Reserva reserva = new Reserva();
        reserva.setID_reserva(1);
        reserva.setfechaEntrada(12052026);
        reserva.setfechaSalida(12052026);

        // Probar reservarHabitacion
        System.out.println("--- RESERVAR HABITACION ---");
        cliente.reservarHabitacion(habitacion, reserva);

        // Intentar reservar de nuevo (ya ocupada)
        System.out.println("\n--- INTENTAR RESERVAR DE NUEVO ---");
        cliente.reservarHabitacion(habitacion, reserva);

        // Probar cancelarReserva
        System.out.println("\n--- CANCELAR RESERVA ---");
        cliente.cancelarReserva(habitacion, reserva);

        // Intentar cancelar de nuevo (ya cancelada)
        System.out.println("\n--- INTENTAR CANCELAR DE NUEVO ---");
        cliente.cancelarReserva(habitacion, reserva);
    }
}