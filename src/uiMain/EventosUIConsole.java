package uiMain;

import java.util.List;
import java.util.Scanner;

import gestorAplicacion.Servicios.Evento;
import gestorAplicacion.personal.Cliente;

public class EventosUIConsole implements EventosUI {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void MostrarBienvenida(Cliente cliente){

        System.out.println("¡Bienvenido/a "+ cliente.getNombreCliente() + "!");

    }
    
    @Override
    public void MostrarEventosDisponibles(List<Evento> eventos){
        System.out.println("\nEventos disponibles:");
    }

    @Override
    public void MostrarPremioEspecial() {
        System.out.println("¡Felicidades! Has ganado un premio especial: un asiento en palco y una bebida gratis.");
    }
    
}
