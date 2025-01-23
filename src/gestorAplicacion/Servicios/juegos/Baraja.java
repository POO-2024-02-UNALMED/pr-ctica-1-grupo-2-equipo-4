package gestorAplicacion.Servicios.juegos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baraja {
    private List<Carta> cartas; // Usamos una lista simple

    public Baraja() {
        cartas = new ArrayList<>();
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] palos = {"♥", "♦", "♣", "♠"}; // Emoticonos de los palos

        for (String palo : palos) {
            for (String valor : valores) {
                cartas.add(new Carta(valor, palo)); // Crear cada carta
            }
        }
        Collections.shuffle(cartas); // Mezclar cartas
    }

    public Carta sacarCarta() {
        return cartas.remove(cartas.size() - 1); // Sacar la última carta
    }

    public void barajar() {
        Collections.shuffle(cartas); // Mezclar cartas nuevamente
    }

    public int cartasRestantes() {
        return cartas.size(); // Número de cartas restantes en la baraja
    }
}
