package uiMain;

import gestorAplicacion.Servicios.RegistroJuego;
import gestorAplicacion.Servicios.juegos.Blackjack;
import gestorAplicacion.Servicios.juegos.Craps;
import gestorAplicacion.Servicios.juegos.Ruleta;
import gestorAplicacion.Servicios.juegos.Slots;
import gestorAplicacion.personal.Animador;
import gestorAplicacion.personal.Cliente;
import java.util.Scanner;

public class MainJuegos {

    public static void funcionalidadJugar(Cliente usuarioActual) {
        Scanner scanner = new Scanner(System.in);
        Animador animador = new Animador();

        boolean continuar = true;

        while (continuar) {
            // Mostrar opciones de juegos
            System.out.println("\nSeleccione un juego para jugar:");
            System.out.println("1. Blackjack");
            System.out.println("2. Ruleta");
            System.out.println("3. Craps");
            System.out.println("4. Slots");
            System.out.println("5. Mostrar estadísticas");
            System.out.println("0. Salir");

            System.out.print("Opción: ");
            int opcion = scanner.nextInt();

            if (opcion == 0) {
                System.out.println("Gracias por jugar. ¡Hasta pronto!");
                continuar = false;
                break;
            }

            if (opcion == 5) {
                RegistroJuego registro = usuarioActual.getRegistroJuego();
                System.out.println(registro.toString());
                continue;
            }

            System.out.print("Ingrese la cantidad de fichas que desea apostar: ");
            int apuesta = scanner.nextInt();

            if (apuesta <= 0) {
                System.out.println("La cantidad apostada debe ser mayor a 0.");
                continue;
            }

            if (apuesta > usuarioActual.getFichas()) {
                System.out.println("No tienes suficientes fichas para apostar esa cantidad.");
                continue;
            }

            // Lógica de selección del juego
            switch (opcion) {
                case 1 -> {
                    Blackjack blackjack = new Blackjack(apuesta);
                    blackjack.jugar(usuarioActual, animador);
                }
                case 2 -> {
                    Ruleta ruleta = new Ruleta(apuesta);
                    ruleta.jugar(usuarioActual, animador);
                }
                case 3 -> {
                    Craps craps = new Craps(apuesta);
                    craps.jugar(usuarioActual, animador);
                }
                case 4 -> {
                    Slots slots = new Slots(apuesta);
                    slots.jugar(usuarioActual, animador);
                }
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
