package gestorAplicacion.Servicios.juegos;

import gestorAplicacion.Servicios.RegistroJuego;
import gestorAplicacion.personal.Animador;
import gestorAplicacion.personal.Cliente;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Blackjack extends Juego {

    private List<String> baraja;
    private List<String> manoJugador;
    private List<String> manoCrupier;

    public Blackjack(int apuesta) {
        super(apuesta, 2.0f); // Asignamos una apuesta inicial y riesgo de 2.0
        inicializarBaraja();
        this.manoJugador = new ArrayList<>();
        this.manoCrupier = new ArrayList<>();
    }

    // Inicializa y mezcla la baraja
    private void inicializarBaraja() {
        baraja = new ArrayList<>();
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] palos = {"corazones", "diamantes", "treboles", "picas"};

        for (String palo : palos) {
            for (String valor : valores) {
                baraja.add(valor + " de " + palo);
            }
        }
        Collections.shuffle(baraja); // Mezclar la baraja
    }

    // Extrae la última carta de la baraja
    private String sacarCarta() {
        return baraja.remove(baraja.size() - 1);
    }

    @Override
public void jugar(Cliente cliente, Animador animador) {
    if (cliente.getRegistroJuego() == null) {
        cliente.setRegistroJuego(new RegistroJuego(cliente.getFichas()));
    }

    animador.generarSaludo(cliente.getNombreCliente(), animador.getRol());
    animador.manejarSuscripcion(cliente);

    // Repartir cartas iniciales
    manoJugador.add(sacarCarta());
    manoJugador.add(sacarCarta());
    manoCrupier.add(sacarCarta());
    manoCrupier.add(sacarCarta());

    // Mostrar cartas iniciales
    System.out.println("Tus cartas: " + manoJugador);
    System.out.println("Carta del crupier: " + manoCrupier.get(0) + " (otra oculta)");

    if (calcularPuntaje(manoJugador) == 21) {
        System.out.println("¡Blackjack! Ganaste con las dos primeras cartas.");
        cliente.setFichas(cliente.getFichas() + (int) (this.apuesta * 2.5));
        // Llamada al método otorgarRecompensa
        animador.otorgarRecompensa(cliente, true);
        return;
    }

    boolean jugadorContinua = true;
    while (jugadorContinua) {
        System.out.println("¿Deseas pedir otra carta (s/n)?");
        String decision = new Scanner(System.in).nextLine();
        if (decision.equalsIgnoreCase("s")) {
            String nuevaCarta = sacarCarta();
            manoJugador.add(nuevaCarta);
            System.out.println("Recibiste: " + nuevaCarta);

            int puntaje = calcularPuntaje(manoJugador);
            if (puntaje > 21) {
                System.out.println("Te pasaste de 21. ¡Perdiste!");
                cliente.setFichas(cliente.getFichas() - this.apuesta);
                // Llamada al método otorgarRecompensa
                animador.otorgarRecompensa(cliente, false);
                return;
            }
        } else {
            jugadorContinua = false;
        }
    }

    while (calcularPuntaje(manoCrupier) < 17) {
        manoCrupier.add(sacarCarta());
    }

    mostrarResultados(cliente, animador);
}

private void mostrarResultados(Cliente cliente, Animador animador) {
    int puntajeJugador = calcularPuntaje(manoJugador);
    int puntajeCrupier = calcularPuntaje(manoCrupier);
    boolean ganoJugador = false;

    System.out.println("Tu puntaje: " + puntajeJugador);
    System.out.println("Puntaje del crupier: " + puntajeCrupier);

    if (puntajeJugador > puntajeCrupier || puntajeCrupier > 21) {
        System.out.println("¡Ganaste!");
        cliente.setFichas(cliente.getFichas() + (this.apuesta * 2));
        ganoJugador = true;

    } else {
        System.out.println("Perdiste.");
        cliente.setFichas(cliente.getFichas() - this.apuesta);
    }
    animador.otorgarRecompensa(cliente, ganoJugador);
    System.out.println("¡Gracias por jugar a Blackjack!");
        System.out.println("Tus fichas actuales: " + cliente.getFichas());
}


    private int calcularPuntaje(List<String> mano) {
        int puntaje = 0;
        int ases = 0;

        for (String carta : mano) {
            String valor = carta.split(" ")[0];
            if (valor.equals("J") || valor.equals("Q") || valor.equals("K")) {
                puntaje += 10;
            } else if (valor.equals("A")) {
                ases++;
                puntaje += 11;
            } else {
                puntaje += Integer.parseInt(valor);
            }
        }

        while (puntaje > 21 && ases > 0) {
            puntaje -= 10;
            ases--;
        }

        return puntaje;
    }
}
