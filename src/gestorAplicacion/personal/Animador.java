package gestorAplicacion.personal;

import gestorAplicacion.Servicios.Suscripcion;
import gestorAplicacion.Servicios.juegos.Blackjack;
import gestorAplicacion.personal.Cliente;


public class Animador extends Empleado {

    public Animador(String puesto) {
        super("Animador", puesto);
    }

    // Genera un saludo personalizado para el cliente
    @Override
    public String generarSaludo(String nombreCliente, String rol) {
        return "¡Bienvenido, " + nombreCliente + "! Soy tu "+ rol + ". ¡Disfruta del juego y mucha suerte!";
    }

    // Método para determinar fichas adicionales según la suscripción
    public int calcularBonificacion(Suscripcion suscripcion) {
        switch (suscripcion) {// solo necesita devolver el atributo de suscripcion fichasCompensacion, puedes usar return Suscripcion.getFichasCompensacion() 
            case BASICA:      // igual me parece muy bien lo del switch, lo podemos usar mas
                return 10;
            case ESTANDAR:
                return 20;
            case PREMIUM:
                return 50;
            default:
                return 0;
        }
    }

    // Comentarios dinámicos durante el juego
    public String comentarJuego(Cliente cliente, int rachaVictorias, boolean premioEspecial) {
        if (premioEspecial) {
            return "¡Increíble, " + cliente.getNombreCliente() + "! ¡Has ganado el premio especial!\n" +
                    "¡Recibes 100 fichas adicionales como recompensa!";
        } else if (rachaVictorias >= 3) {
            return "¡" + cliente.getNombreCliente() + " está en racha con " + rachaVictorias + " victorias consecutivas!";
        } else {
            return "¡Sigue así, " + cliente.getNombreCliente() + ", puedes ganar esta partida!";
        }
    }

    // Recompensa o penalización al finalizar el juego
    public void otorgarRecompensa(Cliente cliente, int partidasGanadas, boolean victoriaTotal) {
        if (victoriaTotal) {
            cliente.setSuscripcion(Suscripcion.VETADO);
            System.out.println("¡Has sido vetado por una tasa de victorias del 100%! Ya no puedes jugar en este casino.");
        } else if (partidasGanadas >= 15) {
            cliente.setSuscripcion(Suscripcion.GANADOR_USUAL);
            System.out.println("¡Felicitaciones, " + cliente.getNombre() + "! Tu suscripción ha sido actualizada a GANADOR USUAL.");
        } else if (partidasGanadas >= 10) {
            System.out.println("¡Felicidades por 10 victorias! Disfruta una bebida exclusiva del bar por cortesía del casino.");
        } else {
            cliente.incrementarFichas(5); // Consolación por perder
            System.out.println("¡No te desanimes, " + cliente.getNombre() + "! Recibes 5 fichas como consolación.");
        }
    }
}

    //public entregarPremio(Boolean partidaGanada, Boolean premioEspecial) {}

    //public pedirBebida(Bebida bebidaFavorita, Suscripcion suscripcion, Arraylist<Bebida> Bebidas) {}
