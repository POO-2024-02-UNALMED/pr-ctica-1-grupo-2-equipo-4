package uiMain;

import gestorAplicacion.Servicios.Asiento;
import gestorAplicacion.Servicios.Evento;
import gestorAplicacion.personal.Cliente;

import java.util.List;

public interface EventosUI {

    //Mostrar bienvenida
    void MostrarBienvenida(Cliente cliente);

    //Mostrar eventos
    void MostrarEventosDisponibles(List<Evento> eventos);

    //Mostrar si el cliente aplica para premio especial
    void MostrarPremioEspecial();

    //Cliente selecciona evento
    Evento SeleccionarEventos(List<Evento> Eventos);

    //Mostrar el precio con descuento
    void mostrarPrecioConDescuento(Evento evento, double precioConDescuento);

    //Mostrar los asientos disponibles
    void mostrarAsientosDisponibles(List<Asiento> asientos);

    //Permitir al cliente seleccionar un asiento
    Asiento seleccionarAsiento(List<Asiento> asientos);

    //Mostrar confirmación de reserva del asiento
    void mostrarConfirmacionReserva(Asiento asiento);

    // Mostrar mensaje de compensación
    void mostrarCompensacion();    
    
}
