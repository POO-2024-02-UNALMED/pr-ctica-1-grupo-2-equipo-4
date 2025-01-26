package uiMain;

import java.util.List;
import java.util.Scanner;

import gestorAplicacion.Servicios.Asiento;
import gestorAplicacion.Servicios.Evento;
import gestorAplicacion.personal.Cliente;

public class EventosUIConsole implements EventosUI {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void mostrarBienvenida(){
        System.out.println("¡Bienvenido/a a los eventos de Diamond Casino!");
    }
    
    @Override
    public void mostrarEventosDisponibles(List<Evento> eventos){
        System.out.println("Estos son los eventos disponibles:");
        for (int i = 0; i < eventos.size(); i++) {
            Evento evento = eventos.get(i);
            System.out.println((i + 1) + ". " + evento.getNombreEvento());
        }
    }

    @Override
    public void saludoCliente(Cliente cliente, List<Evento> eventos) {
        // Mostrar mensaje de bienvenida
        mostrarBienvenida();

        // Mostrar eventos disponibles
        mostrarEventosDisponibles(eventos);
    }
}
    


