package gestorAplicacion.Servicios.juegos;

import gestorAplicacion.personal.Cliente;
import gestorAplicacion.Servicios.RegistroJuego;
import gestorAplicacion.personal.Animador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Blackjack extends Juego {

    private Baraja baraja;
    private List<Carta> manoJugador;
    private List<Carta> manoCrupier;

    public Blackjack(int apuesta) {
        super(apuesta, 2.0f);  // Asignamos una apuesta inicial y riesgo de 2.0
        this.baraja = new Baraja();
        this.manoJugador = new ArrayList<>();
        this.manoCrupier = new ArrayList<>();
    }

    @Override
    public void jugar(Cliente cliente, Animador animador) {
        // Verificamos si el cliente ya tiene un registro de juego, y lo creamos si no lo tiene
        if (cliente.getRegistroJuego() == null) {
            cliente.setRegistroJuego(new RegistroJuego());
        }

        animador.generarSaludo(cliente);
        animador.manejarSuscripcion(cliente);

        // Preparar baraja y repartir cartas
        manoJugador.add(baraja.sacarCarta());
        manoJugador.add(baraja.sacarCarta());
        manoCrupier.add(baraja.sacarCarta());
        manoCrupier.add(baraja.sacarCarta());

        // Mostrar cartas iniciales
        System.out.println("Tus cartas: " + manoJugador);
        System.out.println("Carta del crupier: " + manoCrupier.get(0) + " (otra oculta)");

        // Caso especial: Blackjack
        if (calcularPuntaje(manoJugador) == 21) {
            System.out.println("¡Blackjack! Ganaste con las dos primeras cartas.");
            int premio = (int) (getApuesta() * 2.5);
            cliente.setFichas(cliente.getFichas() + premio); // Aumento de fichas por Blackjack
            animador.felicitarPremioEspecial(cliente);
            return;
        }

        // Lógica del juego principal
        boolean jugadorContinua = true;
        while (jugadorContinua) {
            System.out.println("¿Deseas pedir otra carta (s/n)?");
            String decision = new Scanner(System.in).nextLine();
            if (decision.equalsIgnoreCase("s")) {
                Carta nuevaCarta = baraja.sacarCarta();
                manoJugador.add(nuevaCarta);
                System.out.println("Recibiste: " + nuevaCarta);

                int puntaje = calcularPuntaje(manoJugador);
                if (puntaje > 21) {
                    System.out.println("Te pasaste de 21. ¡Perdiste!");
                    cliente.setFichas(cliente.getFichas() - getApuesta()); // Perdió la apuesta
                    return;
                }
            } else {
                jugadorContinua = false;
            }
        }

        // Turno del crupier
        while (calcularPuntaje(manoCrupier) < 17) {
            Carta nuevaCarta = baraja.sacarCarta();
            manoCrupier.add(nuevaCarta);
        }

        // Mostrar resultados
        int puntajeJugador = calcularPuntaje(manoJugador);
        int puntajeCrupier = calcularPuntaje(manoCrupier);
        System.out.println("Tu puntaje: " + puntajeJugador);
        System.out.println("Puntaje del crupier: " + puntajeCrupier);

        if (puntajeJugador > puntajeCrupier || puntajeCrupier > 21) {
            System.out.println("¡Ganaste!");
            cliente.setFichas(cliente.getFichas() + (getApuesta() * 2)); // El jugador recibe el doble de lo apostado
        } else {
            System.out.println("Perdiste.");
            cliente.setFichas(cliente.getFichas() - getApuesta()); // El jugador pierde lo apostado
        }
    }

    private int calcularPuntaje(List<Carta> mano) {
        int puntaje = 0;
        int ases = 0;
        for (Carta carta : mano) {
            String valor = carta.getValor();
            if (valor.equals("J") || valor.equals("Q") || valor.equals("K")) {
                puntaje += 10;
            } else if (valor.equals("A")) {
                ases++;
                puntaje += 11;
            } else {
                puntaje += Integer.parseInt(valor);
            }
        }

        // Ajustar los ases de 11 a 1 si es necesario
        while (puntaje > 21 && ases > 0) {
            puntaje -= 10;
            ases--;
        }

        return puntaje;
    }
}
