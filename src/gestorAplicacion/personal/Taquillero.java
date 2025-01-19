package gestorAplicacion.personal;

public class Taquillero extends Empleado{
    private Arraylist<Evento> eventos;

    public Taquillero(String rol, String puesto, Arraylist<Evento> eventos) {
        super(rol, puesto);
        this.eventos = eventos;
    }

    public Evento escogerEvento(){

    }
    public String mostrarPuestosDisponibles(){

    }

    public Arraylist<Evento> getEventos() {
        return this.eventos;
    }

    public void setEventos(Arraylist<Evento> eventos) {
        this.eventos = eventos;
    }

}