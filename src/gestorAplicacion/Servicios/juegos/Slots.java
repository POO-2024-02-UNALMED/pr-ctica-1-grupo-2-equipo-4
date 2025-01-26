package gestorAplicacion.Servicios.juegos;

import gestorAplicacion.Servicios.RegistroJuego;
import gestorAplicacion.personal.Animador;
import gestorAplicacion.personal.Cliente;
import java.util.Random;

public class Slots extends Juego {

    // Atributos
    private static final String[] SIMBOLOS = {"♠️", "♥", "♣", "♦️"};

    // Constructor
    public Slots(int apuesta) {
        super(apuesta, 1.5f); // Establecemos una apuesta inicial y un riesgo básico
    }

    // Método que selecciona aleatoriamente un símbolo para cada rueda
    private String tirarRueda() {
        Random rand = new Random();
        return SIMBOLOS[rand.nextInt(SIMBOLOS.length)];
    }

    // Método para calcular el multiplicador basado en el símbolo
    private float obtenerMultiplicador(String simbolo) {
        switch (simbolo) {
            case "♠️": return 1.5f;
            case "♥": return 2.0f;
            case "♣": return 3.0f;
            case "♦️": return 8.0f;
            default: return 1.0f;
        }
    }

    @Override
    public void jugar(Cliente cliente, Animador animador) {
        if (cliente.getRegistroJuego() == null) {
            cliente.setRegistroJuego(new RegistroJuego(cliente.getFichas()));
        }

        animador.generarSaludo(cliente.getNombreCliente(), animador.getRol());
        animador.manejarSuscripcion(cliente);
        animador.entregarFichas(cliente);

        // Tirar las tres ruedas
        String rueda1 = tirarRueda();
        String rueda2 = tirarRueda();
        String rueda3 = tirarRueda();

        // Mostrar el resultado de las ruedas
        System.out.println("Rueda 1: " + rueda1);
        System.out.println("Rueda 2: " + rueda2);
        System.out.println("Rueda 3: " + rueda3);

        // Comprobar si el jugador ha ganado
        if (rueda1.equals(rueda2) && rueda2.equals(rueda3)) {
            float multiplicador = obtenerMultiplicador(rueda1);
            float ganancia = getApuesta() * multiplicador;
            cliente.setFichas(cliente.getFichas() + (int) ganancia);
            System.out.println("¡Ganaste! Multiplicador: " + multiplicador + ". Ganancia: " + ganancia + " fichas.");

            // Llamada al método otorgarRecompensa
            animador.otorgarRecompensa(cliente, true);

            // Premio especial solo si todas las ruedas son diamantes
            if (rueda1.equals("♦️") && rueda2.equals("♦️") && rueda3.equals("♦️")) {
                System.out.println("¡Premio especial por Diamantes! ¡Felicidades!");
            }
        } else {
            System.out.println("Lo siento, no ganaste. Mejor suerte la próxima vez.");
            cliente.setFichas(cliente.getFichas() - getApuesta());
            animador.otorgarRecompensa(cliente, false);
        }
    }
}
