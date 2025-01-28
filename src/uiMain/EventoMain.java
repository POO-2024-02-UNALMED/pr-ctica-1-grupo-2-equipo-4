//Funcionalidad eventos
//Juan José Gomez
package uiMain;

import gestorAplicacion.Servicios.*;
import gestorAplicacion.personal.Cliente;
import gestorAplicacion.personal.Recepcionista;


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
        System.out.println("--------------------- DATOS USUARIO --------------------- ");  
        System.out.println("Hola " + cliente.getNombreCliente() + "!");

        // Leer la suscripción del cliente y mostrarla
        System.out.println("Su suscripción actual es: " + cliente.getSuscripcion().getTipoSuscripcion());
        System.out.println("Su saldo actual es: " + cliente.getFichas());

        if (cliente.getSuscripcion().getTipoSuscripcion().equalsIgnoreCase("Platinum")){
            System.out.println("Como miembro Platinum, se le ha asignado automáticamente un asiento en Primera Fila.");
            System.out.println("Además, recibirá una bebida especial gratuita durante el espectáculo.");
        }

        // Mostrar eventos disponibles
        Evento.inicializarEventos();
        System.out.println(" ");   
        System.out.println("Estos son los eventos disponibles:");
        System.out.println(" ");
        System.out.println("------------------------------- EVENTOS -------------------------------");
        Evento.mostrarEventos(); // Método estático en Evento que lista los eventos actuales
        System.out.println("-----------------------------------------------------------------------");

        // Solicitar al cliente que elija un evento
        System.out.println(" ");  
        int opcionEvento = consola.pedirEvento(); // Método que solicita al cliente elegir un evento
        Evento eventoSeleccionado = Evento.getEventoPorIndice(opcionEvento); // Obtener el evento elegido


            // Aplicar descuento según la suscripción del cliente
            float descuento = cliente.getSuscripcion().getDescuento();
            int costoOriginal = eventoSeleccionado.getPrecio();
            int costoConDescuento = (int) Math.floor(costoOriginal * (1 - descuento));

            System.out.println("-------- Descuento por suscripción --------");
            System.out.println(" ");
            System.out.println("El costo original del evento \"" + eventoSeleccionado.getNombre() + "\" es de " + costoOriginal + " fichas.");
            System.out.println("Como miembro \"" + cliente.getSuscripcion().getTipoSuscripcion() + "\", recibe un descuento del " + (descuento * 100) + "%.");
            System.out.println("El costo final con descuento es de " + costoConDescuento + " fichas.");
            cliente.setFichas(cliente.getFichas() - costoConDescuento);
            System.out.print("Su nuevo saldo es: " + cliente.getFichas());
            System.out.println(" ");
            System.out.println("----------------------------------");

        //Inicializacion de asientos
        eventoSeleccionado.inicializarAsientos();

        Asiento.ZonaAsiento zonaSeleccionada;
        if (cliente.getSuscripcion().getTipoSuscripcion().equalsIgnoreCase("Platinum")) {
        zonaSeleccionada = Asiento.ZonaAsiento.Palco; 
        } else {

            System.out.println(" ");
            System.out.println("Aqui tienes los asientos disponibles: ");
            System.out.println(" ");
    
            eventoSeleccionado.mostrarZonasAsientos();
            zonaSeleccionada = consola.pedirZonaAsiento(); // Solicitar elección de zona de asiento
            
        }
    
        // Confirmar la selección y aplicar lógica especial si corresponde
        Recepcionista.procesarSeleccionEvento(cliente, eventoSeleccionado, zonaSeleccionada, costoConDescuento);
    } else {
        // Mensaje en caso de que no se encuentre registro
        System.out.println("No se encontró ningún registro para esta identificación. Por favor, regístrese primero o ingrese un ID valida.");
    }

}
}