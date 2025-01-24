package gestorAplicacion.personal;

import gestorAplicacion.Servicios.RegistroJuego;
import gestorAplicacion.Servicios.Suscripcion;

public class Animador extends Empleado {

    // Constructor
    public Animador(String puesto) {
        super("Animador", puesto); // Establece el rol fijo como "Animador"
    }

    // Generar saludo personalizado
    @Override
    public String generarSaludo(String nombreCliente, String Rol) {
        return "¡Hola " + nombreCliente + "! Soy tu " + Rol + ". ¡Vamos a divertirnos!";
    }

    // Manejar la suscripción del cliente
    public void manejarSuscripcion(Cliente cliente) {
        Suscripcion suscripcion = cliente.getSuscripcion();
        if (suscripcion == null) {
            System.out.println("No tienes una suscripción activa. ¿Deseas adquirir una?");
        } else {
            System.out.println("Tu suscripción actual es: " + suscripcion.getTipoSuscripcion());
        }
    }

    // Método para entregar fichas al cliente según su suscripción
    public void entregarFichas(Cliente cliente) {
        Suscripcion suscripcion = cliente.getSuscripcion();
        if (suscripcion != null) {
            int fichasCompensacion = suscripcion.getFichaCompensacion();
            cliente.setFichas(cliente.getFichas() + fichasCompensacion);
            System.out.println("Se han entregado " + fichasCompensacion + " fichas a " + cliente.getNombreCliente() + 
                               " como parte de su suscripción " + suscripcion.getTipoSuscripcion() + ".");
        } else {
            System.out.println("No se pueden entregar fichas porque el cliente no tiene una suscripción activa.");
        }
    }
    // Metodo para el final de cada partida.

    public void otorgarRecompensa(Cliente cliente, boolean partidaGanada) {

    RegistroJuego registroJuego = cliente.getRegistroJuego();

    registroJuego.incrementarPartidasJugadas(partidaGanada);
    
    int racha = registroJuego.getRachaVictorias();  
    int partidasJugadas = registroJuego.getPartidasJugadas();
    float porcentajeVictorias = registroJuego.getPorcentajeVictorias(); 

    // Verificar si tiene una racha de 3 victorias consecutivas
    if (racha >= 3) {
        System.out.println("¡Felicidades " + cliente.getNombreCliente() + ", tienes una racha de " + racha + " victorias!");
    }

    // Si el cliente ha jugado más de 10 partidas y tiene un porcentaje de victorias del 100% se echa del casino
    if (partidasJugadas > 10 && porcentajeVictorias == 1.0) {
        System.out.println("¡Increíble " + cliente.getNombreCliente() + "! Has jugado más de 10 partidas y tienes un 100% de victorias.");
        // Cambiar su suscripción a "Vetado" 
        cliente.getSuscripcion().setTipoSuscripcion("Vetado");
        System.out.println("Tu suscripción ahora es 'Vetado'.");
    }
}



    //public entregarPremio(Boolean partidaGanada, Boolean premioEspecial) {}

    //public pedirBebida(Bebida bebidaFavorita, Suscripcion suscripcion, Arraylist<Bebida> Bebidas) {}
}