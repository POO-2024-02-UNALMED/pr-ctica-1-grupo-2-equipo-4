package gestorAplicacion.personal;
import java.util.Arraylist;

public class Animador extends Empleado{

    public Animador(String rol, String puesto) {
        super(rol, puesto);
    }

    public comentarJuego(Boolean resultadoRonda) {
        if(resultadoRonda == true) {
            return "ganaste, sigue asi!!!"
        }
        elif(resultadoRonda == false) {
            return "perdiste, animo, la siguiente sera mejor"
        }
    }
    public entregarPremio(Boolean partidaGanada, Boolean premioEspecial) {

    }

    public pedirBebida(Bebida bebidaFavorita, Suscripcion suscripcion, Arraylist<Bebida> Bebidas) {}
}