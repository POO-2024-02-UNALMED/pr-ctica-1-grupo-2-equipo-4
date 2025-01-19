package gestorAplicacion.personal;

import gestorAplicacion.Servicios.Habitacion;
import java.util.ArrayList;

public class Recepcionista extends Empleado{
    private ArrayList<Habitacion> habitaciones;

    public Recepcionista(String rol, String puesto, ArrayList<Habitacion> habitaciones) {
        super(rol, puesto);
        this.habitaciones = habitaciones;
    }

    @Override
    public String generarSaludo (String nombre, String rol){
        return "Hola, "+ nombre+ "soy un " + rol;
    }
    //public Boolean verificarEdad(){}

    //public Bebida pedirBebidaBienvenida(){}

    //public int cambiarFichas(){}

    //public String crearListaHabitaciones(){}


    public ArrayList<Habitacion> getHabitaciones() {
        return this.habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

}