package gestorAplicacion.Servicios.juegos;

import gestorAplicacion.Servicios.RegistroJuego;
import gestorAplicacion.personal.Animador;
import gestorAplicacion.personal.Cliente;
import java.util.Random;
import java.util.Scanner;

public class Ruleta extends Juego {

    private static final float RIESGO_COLOR = 2.0f; // Riesgo por apostar al color
    private static final float RIESGO_NUMERO = 35.0f; // Riesgo por apostar al número

    public Ruleta(int apuesta) {
        super(apuesta, 0); // El riesgo inicial dependerá de la elección del jugador
    }

    @Override
    public void jugar(Cliente cliente, Animador animador) {
        if (cliente.getRegistroJuego() == null) {
            cliente.setRegistroJuego(new RegistroJuego());
        }

        // Inicio del juego
        System.out.println(animador.generarSaludo(cliente.getNombreCliente(), animador.getRol()));
        animador.manejarSuscripcion(cliente);
        animador.entregarFichas(cliente);

        System.out.println("¡Bienvenido a la Ruleta!");
        System.out.println("Opciones de apuesta:");
        System.out.println("1. Apostar por color (rojo o negro) - Riesgo: x" + RIESGO_COLOR);
        System.out.println("2. Apostar por número (0-36) - Riesgo: x" + RIESGO_NUMERO);

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int eleccion;

        // Lógica de elección del jugador
        do {
            System.out.print("Elige tu tipo de apuesta (1 para color, 2 para número): ");
            eleccion = scanner.nextInt();
        } while (eleccion != 1 && eleccion != 2);

        if (eleccion == 1) {
            setRiesgo(RIESGO_COLOR);
            System.out.print("Elige un color (1 para rojo, 2 para negro): ");
            int colorElegido = scanner.nextInt();
            boolean esRojo = random.nextBoolean(); // Simula el color aleatorio de la ruleta

            System.out.println("Girando la ruleta...");
            System.out.println("El color que salió es: " + (esRojo ? "Rojo" : "Negro"));

            if ((colorElegido == 1 && esRojo) || (colorElegido == 2 && !esRojo)) {
                System.out.println("¡Felicidades! Ganaste apostando al color.");
                cliente.setFichas(cliente.getFichas() + (int) (getApuesta() * getRiesgo()));
                animador.otorgarRecompensa(cliente, true);
            } else {
                System.out.println("Lo siento, perdiste.");
                cliente.setFichas(cliente.getFichas() - getApuesta());
                animador.otorgarRecompensa(cliente, false);
            }
        } else if (eleccion == 2) {
            setRiesgo(RIESGO_NUMERO);
            System.out.print("Elige un número entre 0 y 36: ");
            int numeroElegido = scanner.nextInt();
            int numeroGanador = random.nextInt(37); // Gira la ruleta y genera el número ganador

            System.out.println("Girando la ruleta...");
            System.out.println("El número que salió es: " + numeroGanador);

            if (numeroElegido == numeroGanador) {
                System.out.println("¡Increíble! Ganaste apostando al número.");
                cliente.setFichas(cliente.getFichas() + (int) (getApuesta() * getRiesgo()));
                animador.otorgarRecompensa(cliente, true);
            } else {
                System.out.println("Lo siento, perdiste.");
                cliente.setFichas(cliente.getFichas() - getApuesta());
                animador.otorgarRecompensa(cliente, false);
            }
        }

        // Fin del juego
        System.out.println("¡Gracias por jugar a la Ruleta!");
        System.out.println("Tus fichas actuales: " + cliente.getFichas());
    }
}
