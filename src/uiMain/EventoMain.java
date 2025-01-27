package uiMain;

import gestorAplicacion.Servicios.*;
import gestorAplicacion.Servicios.Asiento.ZonaAsiento;
import gestorAplicacion.personal.Cliente;
import gestorAplicacion.personal.Recepcionista;
import gestorAplicacion.personal.Valet;

import java.util.List;


public class EventoMain {
    public static void funcionalidadEvento() {

        //Recepcionista
       // Recepcionista recepcionista = new Recepcionista("Recepcionista", "Eventos");

        //Cliente de prueba
       // Cliente cliente = new Cliente("Jose", 20, 56789, 300000);
       // cliente.setSuscripcion(new Suscripcion(6));
       // cliente.setFidelidadBar(true);
        

        EventosUIConsole consola = new EventosUIConsole();

        //Interaccion1
    System.out.println(" ");        
    System.out.println("===¡Bienvenido al área de eventos del casino!===");
    System.out.println(" "); 
    System.out.println("Por favor, deme su identificación nuevamente para confirmar su registro.");

    long id = consola.pedirID(); // Método para solicitar la identificación
    Cliente cliente = Recepcionista.identificarCliente(id); // Método para buscar al cliente

    if (cliente != null) {
        // Mostrar bienvenida personalizada
        System.out.println(" ");  
        System.out.println("Hola " + cliente.getNombreCliente() + "!");

        // Leer la suscripción del cliente y mostrarla
        System.out.println("Su suscripción actual es: " + cliente.getSuscripcion().getTipoSuscripcion());

        // Mostrar eventos disponibles
        Evento.inicializarEventos();
        System.out.println(" ");   
        System.out.println("Estos son los eventos disponibles:");
        System.out.println(" ");
        Evento.mostrarEventos(); // Método estático en Evento que lista los eventos actuales

        // Solicitar al cliente que elija un evento
        System.out.println(" ");  
        System.out.println("Por favor, elija un evento ingresando su número correspondiente (1, 2 o 3):");
        int opcionEvento = consola.pedirEvento(); // Método que solicita al cliente elegir un evento
        Evento eventoSeleccionado = Evento.getEventoPorIndice(opcionEvento); // Obtener el evento elegido

        //Inicializacion de asientos
        eventoSeleccionado.inicializarAsientos();
        System.out.println(" ");
        System.out.println("Aqui tienes los asientos disponibles: ");
        System.out.println(" ");

        eventoSeleccionado.mostrarZonasAsientos();

        Asiento.ZonaAsiento zonaSeleccionada = consola.pedirZonaAsiento(); // Solicitar elección de zona de asiento
        

        // Confirmar la selección y
        Recepcionista.procesarSeleccionEvento(cliente, eventoSeleccionado, zonaSeleccionada);
    } else {
        // Mensaje en caso de que no se encuentre registro
        System.out.println("No se encontró ningún registro para esta identificación. Por favor, regístrese primero o ingrese un ID valida.");
    }

}
}