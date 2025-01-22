package gestorAplicacion.Servicios;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import gestorAplicacion.Servicios.Asiento;

import gestorAplicacion.personal.Artista;

public class Evento {
    private String nombreEvento;
    private String tipoEvento;
    private Artista artista;
    private Boolean consumoMinimo;
    private double precioBase;
    private List<Asiento> asientos;  

    public Evento(String nombreEvento, String tipoEvento, Artista artista, Boolean consumoMinimo, double precioBase, List<Asiento> asientos) {
        this.nombreEvento = nombreEvento;
        this.tipoEvento = tipoEvento;
        this.artista = artista;
        this.consumoMinimo = consumoMinimo;
        this.precioBase = precioBase;
        this.asientos = asientos; // Inicialización de asientos
    }

    //Metodo para obtener los asientos disponibles
    public List<Asiento> obtenerAsientosPorZona(String zona) {
        List<Asiento> asientosDisponibles = new ArrayList<>();
    for (Asiento asiento : asientos) {
        if (asiento.getZona().equalsIgnoreCase(zona) && !asiento.isReservado()) {
            asientosDisponibles.add(asiento);
        }
    }
    return asientosDisponibles;
    }

    // Obtener todos los asientos disponibles (sin zona especifica)
    public List<Asiento> obtenerTodosAsientosDisponibles() {
        return asientos.stream()
                .filter(asiento -> !asiento.isReservado())
                .collect(Collectors.toList());
    }

    //Aplicar descuento segun la suscripcion de cliente
    public double calcularDescuento(Suscripcion suscripcion){
        double descuento = suscripcion.getDescuento();
        return precioBase * (1- descuento);
    }

    //Metodo para poner monto minimo al evento
    public boolean verificarConsumoMinimo(double monto) {
        return !consumoMinimo || monto >= 0.0;
    }
    

//Getters y Setters
    public Artista getArtista() {
        return this.artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Boolean isConsumoMinimo() {
        return this.consumoMinimo;
    }

    public Boolean getConsumoMinimo() {
        return this.consumoMinimo;
    }

    public void setConsumoMinimo(Boolean consumoMinimo) {
        this.consumoMinimo = consumoMinimo;
    }

    public List<Asiento> getAsientos() {
        return this.asientos;
    }
    
    public void setAsientos(List<Asiento> asientos) {
        this.asientos = asientos;
    }
    public String getNombreEvento() {
        return nombreEvento;
    }
    
    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }
    
    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

}