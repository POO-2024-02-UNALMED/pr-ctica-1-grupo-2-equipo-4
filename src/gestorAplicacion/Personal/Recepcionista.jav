package gestorAplicacion.personal;
import java.util.Arraylist;

public class Recepcionista extends Empleado{
    Private Arraylist<Habitacion> habitaciones;

    public Recepcionista(String rol, String puesto, Arraylist<Habitacion> habitaciones) {
        super(rol, puesto);
        this. habitaciones = habitaciones
    }

    public Boolean verificarEdad(){

    }

    public Bebida pedirBebidaBienvenida(){

    }

    public int cambiarFichas(){

    }

    public String crearListaHabitaciones(){

    }


    public Arraylist<Habitacion> getHabitaciones() {
        return this.habitaciones;
    }

    public void setHabitaciones(Arraylist<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

}