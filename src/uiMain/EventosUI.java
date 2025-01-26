package uiMain;

import gestorAplicacion.Servicios.Asiento;
import gestorAplicacion.Servicios.Evento;
import gestorAplicacion.personal.Cliente;

import java.util.List;

public interface EventosUI {

    //Mostrar bienvenida
    void mostrarBienvenida();

    //Mostrar eventos
    void mostrarEventosDisponibles(List<Evento> eventos);

    //Saludocliente
    void saludoCliente(Cliente cliente, List<Evento> eventos);

    
}
