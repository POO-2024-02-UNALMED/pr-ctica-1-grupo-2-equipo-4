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

    public Evento(String nombreEvento, String tipoEvento, Artista artista, Boolean consumoMinimo, double precioBase) {
        this.nombreEvento = nombreEvento;
        this.tipoEvento = tipoEvento;
        this.artista = artista;
        this.consumoMinimo = consumoMinimo;
        this.precioBase = precioBase;
        this.asientos = inicializarAsientos(); // Inicialización de asientos
    }

    //Inicializar asientos por zona

    private List<Asiento> inicializarAsientos(){
        List<Asiento> asientos = new ArrayList<>();

        int cantidadPrimeraFila = 10;
        int cantidadBalcon = 15;
        int cantidadCentro = 20;
        int cantidadAtras = 25;

        // Asientos de Primera Fila
        for (int i = 0; i < cantidadPrimeraFila; i++) {
            asientos.add(new Asiento(Asiento.ZonaAsiento.Primera_fila, 1, 200.0));
        }

        // Asientos de Balcon
        for (int i = 0; i < cantidadBalcon; i++) {
            asientos.add(new Asiento(Asiento.ZonaAsiento.Balcon, 1, 150.0));
        }

        // Asientos del Centro
        for (int i = 0; i < cantidadCentro; i++) {
            asientos.add(new Asiento(Asiento.ZonaAsiento.Centro, 1, 100.0));
        }

        // Asientos de Atras
        for (int i = 0; i < cantidadAtras; i++) {
            asientos.add(new Asiento(Asiento.ZonaAsiento.Atras, 1, 50.0));
        }

        return asientos;
    }

    //Metodo para obtener los asientos disponibles
    public List<Asiento> obtenerAsientosPorZona(String zona) {
        return asientos.stream()
                .filter(asiento -> asiento.getZona().toString().equalsIgnoreCase(zona) && !asiento.isReservado())
                .collect(Collectors.toList());
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