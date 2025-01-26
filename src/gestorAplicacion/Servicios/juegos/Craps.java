package gestorAplicacion.Servicios.juegos;

import gestorAplicacion.Servicios.RegistroJuego;
import gestorAplicacion.personal.Animador;
import gestorAplicacion.personal.Cliente;
import java.util.Random;

public class Craps extends Juego {

    public Craps(int apuesta) {
        super(apuesta, 2.0f); // Riesgo inicial ajustado a 2x
    }

    @Override
    public void jugar(Cliente cliente, Animador animador) {
        // Verificar y crear el registro de juego si no existe
        if (cliente.getRegistroJuego() == null) {
            cliente.setRegistroJuego(new RegistroJuego());
        }

        // Inicio del juego
        System.out.println(animador.generarSaludo(cliente.getNombreCliente(), animador.getRol()));
        animador.manejarSuscripcion(cliente);
        animador.entregarFichas(cliente);

        System.out.println("¡Comienza el juego de Craps!");
        Random random = new Random();
        float riesgoActual = getRiesgo(); // Riesgo dinámico que aumenta con cada ronda

        // Lógica del primer tiro
        int primerTiro = random.nextInt(6) + 1 + random.nextInt(6) + 1; // Sumar dos dados
        System.out.println("Primer tiro: " + primerTiro);

        if (primerTiro == 7) {
            System.out.println("¡Felicidades! Premio especial por sacar un 7 en el primer tiro.");
            animador.otorgarRecompensa(cliente, true); // Gestionar el premio especial
            return;
        } else if (primerTiro == 11) {
            System.out.println("¡Felicidades! Ganaste en el primer tiro.");
            cliente.setFichas(cliente.getFichas() + Math.round(getApuesta() * riesgoActual));
            animador.otorgarRecompensa(cliente, true);
            return;
        } else if (primerTiro == 2 || primerTiro == 3 || primerTiro == 12) {
            System.out.println("Craps. Perdiste en el primer tiro.");
            cliente.setFichas(cliente.getFichas() - getApuesta());
            animador.otorgarRecompensa(cliente, false);
            return;
        }

        // Lógica del juego después del primer tiro
        int punto = primerTiro;
        System.out.println("Tu punto es: " + punto + ". Debes volver a sacar " + punto + " antes de que salga un 7.");

        while (true) {
            int nuevoTiro = random.nextInt(6) + 1 + random.nextInt(6) + 1;
            System.out.println("Nuevo tiro: " + nuevoTiro);

            if (nuevoTiro == punto) {
                System.out.println("¡Felicidades! Ganaste al volver a sacar tu punto.");
                cliente.setFichas(cliente.getFichas() + Math.round(getApuesta() * riesgoActual));
                animador.otorgarRecompensa(cliente, true);
                return;
            } else if (nuevoTiro == 7) {
                System.out.println("Salió un 7. Perdiste.");
                cliente.setFichas(cliente.getFichas() - getApuesta());
                animador.otorgarRecompensa(cliente, false);
                return;
            }

            // Aumentar el riesgo con cada ronda adicional
            riesgoActual += 0.5f;
            System.out.println("El riesgo actual ha aumentado a: " + riesgoActual + "x");
        }
    }
}




