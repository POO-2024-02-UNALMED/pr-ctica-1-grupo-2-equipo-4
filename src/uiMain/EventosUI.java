package uiMain;

import gestorAplicacion.Servicios.Asiento;
import gestorAplicacion.Servicios.Evento;
import gestorAplicacion.personal.Cliente;

import java.util.List;

public interface EventosUI {

    //Mostrar bienvenida
    long pedirID();

    int pedirEvento();

    int pedirZonaAsiento();

}
