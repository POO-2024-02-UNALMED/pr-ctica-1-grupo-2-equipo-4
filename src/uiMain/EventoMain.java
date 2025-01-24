package uiMain;

import gestorAplicacion.Servicios.*;
import gestorAplicacion.personal.Cliente;
import gestorAplicacion.personal.Recepcionista;
import java.util.List;


public class EventoMain {
    public static void funcionalidadEvento() {

        //Cliente de prueba
        Cliente cliente = new Cliente("Jose", 20, 56789, 300000);
        cliente.setSuscripcion(new Suscripcion(6));
        cliente.setFidelidadBar(true);
        

        Recepcionista recepcionista = new Recepcionista(null, null, null); 

        //Eventos
        Evento evento1 = new Evento("Magia en vivo", "Magia", null, null, 0);
        Evento evento2 = new Evento("Show de Comedia", "Comedia", null, null, 0);
        Evento evento3 = new Evento("Concierto", "Concierto", null, null, 0);
}
