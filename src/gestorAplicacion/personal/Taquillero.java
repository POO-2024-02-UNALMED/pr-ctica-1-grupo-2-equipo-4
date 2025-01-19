package gestorAplicacion.personal;

import gestorAplicacion.Servicios.Evento;
import java.util.ArrayList;

public class Taquillero extends Empleado{
    private ArrayList<Evento> eventos;

    public Taquillero(String rol, String puesto, ArrayList<Evento> eventos) {
        super(rol, puesto);
        this.eventos = eventos;
    }

    @Override
    public String generarSaludo (String nombre, String rol){
        return "Hola, "+ nombre+ "soy un " + rol;
    }

    //public Evento escogerEvento(){}
    //public String mostrarPuestosDisponibles(){}

    public ArrayList<Evento> getEventos() {
        return this.eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

}