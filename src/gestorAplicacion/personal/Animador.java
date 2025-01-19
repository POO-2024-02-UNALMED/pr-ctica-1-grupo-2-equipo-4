package gestorAplicacion.personal;

public class Animador extends Empleado{

    public Animador(String rol, String puesto) {
        super(rol, puesto);
    }

    public String comentarJuego(Boolean resultadoRonda) {
        if(resultadoRonda == true) {
            return "ganaste, sigue asi!!!";
        }
        else if(resultadoRonda == false) {
            return "perdiste, animo, la siguiente sera mejor";
        }
        return "No hay resultado";
    }

    public String generarSaludo (String nombre, String rol){
        return "Hola, "+ nombre+ "soy un " + rol;
    }

    //public entregarPremio(Boolean partidaGanada, Boolean premioEspecial) {}

    //public pedirBebida(Bebida bebidaFavorita, Suscripcion suscripcion, Arraylist<Bebida> Bebidas) {}
}