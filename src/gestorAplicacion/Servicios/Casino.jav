package gestorAplicacion.Servicios;
import java.util.Arraylist;

public class Casino{
    private ArrayList<Auto> estacionamiento;
    private ArrayList<Habitacion> hotel;
    private ArrayList<Evento> teatro;


    public ArrayList<Auto> getEstacionamiento() {
        return this.estacionamiento;
    }

    public void setEstacionamiento(ArrayList<Auto> estacionamiento) {
        this.estacionamiento = estacionamiento;
    }

    public ArrayList<Habitacion> getHotel() {
        return this.hotel;
    }

    public void setHotel(ArrayList<Habitacion> hotel) {
        this.hotel = hotel;
    }

    public ArrayList<Evento> getTeatro() {
        return this.teatro;
    }

    public void setTeatro(ArrayList<Evento> teatro) {
        this.teatro = teatro;
    }

}