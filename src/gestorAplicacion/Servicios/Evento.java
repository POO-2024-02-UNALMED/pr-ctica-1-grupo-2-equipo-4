package gestorAplicacion.Servicios;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import gestorAplicacion.Servicios.Asiento;

import gestorAplicacion.personal.Artista;
import gestorAplicacion.personal.Cliente;

public class Evento {
    private String nombre;
    private String descripcion;
    private Artista artista;
    private Boolean consumoMinimo;
    private double precio;
    private List<Asiento> asientos;  


    // Lista estática de eventos disponibles
    private static List<Evento> eventosDisponibles = new ArrayList<>();



    public Evento(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public static void inicializarEventos() {
        // Agregar algunos eventos por defecto
        eventosDisponibles.add(new Evento("Concierto de Jazz", "Un espectáculo relajante de Jazz.", 50.0));
        eventosDisponibles.add(new Evento("Show de Magia", "Magia y misterio en vivo.", 40.0));
        eventosDisponibles.add(new Evento("Comedia Stand-Up", "Una noche llena de risas.", 30.0));
    }

    public static void mostrarEventos() {
        if(eventosDisponibles.isEmpty()){
            System.out.println("No hay eventos disponibles en este momento");
            return;
        }
        for (int i = 0; i < eventosDisponibles.size(); i++) {
            Evento evento = eventosDisponibles.get(i);
            System.out.println((i + 1) + ". " + evento.nombre + " - " + evento.descripcion + " ($" + evento.precio + ")");
        }
    }

    public static Evento getEventoPorIndice(int indice) {
        if (indice > 0 && indice <= eventosDisponibles.size()) {
            return eventosDisponibles.get(indice - 1);
        } else {
            System.out.println("Opción inválida. Seleccionando el primer evento por defecto.");
            return eventosDisponibles.get(0);
        }
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
            asientos.add(new Asiento(Asiento.ZonaAsiento.Palco, 1, 200.0));
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

    public static void mostrarEventos(List<Evento> eventos) {
        System.out.println("\nEventos disponibles:");
        for (int i = 0; i < eventos.size(); i++) {
            Evento evento = eventos.get(i);
            System.out.println((i + 1) + ". " + evento.getNombre());
        }
    }

    public Asiento asignarAsiento(Asiento.ZonaAsiento zona) {
        for (Asiento asiento : asientos) {
            if (asiento.getZona() == zona && asiento.esDisponible()) {
                asiento.reservarAsiento();
                return asiento;
            }
        }
        return null; // Si no hay asientos disponibles en esa zona
    }

        // Calcular precio con descuento basado en la suscripción del cliente
    public static double calcularPrecioConDescuento(Cliente cliente, Evento evento) {
        float descuento = cliente.getSuscripcion().getDescuento();
        double precioOriginal = evento.precio;
        double precioConDescuento = precioOriginal - (precioOriginal * descuento);
        System.out.printf("\nPrecio original: %.2f\nDescuento aplicado: %.2f%%\nPrecio final: %.2f\n",
                precioOriginal, descuento * 100, precioConDescuento);
        return precioConDescuento;
    }

    // Verificar si el cliente tiene consumo mínimo para eventos
    public static void verificarConsumoObligatorio(Cliente cliente) {
        if (cliente.getSuscripcion().getTipoSuscripcion().equalsIgnoreCase("Primera vez")) {
            System.out.println("\nComo cliente 'Primera vez', deberá realizar un consumo mínimo en el bar antes del evento.");
        }
    }

    public double calcularPrecioZona(Asiento.ZonaAsiento zona) {
        double precio = 0.0;
    
        switch (zona) {
            case Palco:
                precio = 200.0; // Precio para la zona de Palco
                break;
            case Balcon:
                precio = 150.0; // Precio para la zona de Balcón
                break;
            case Centro:
                precio = 100.0; // Precio para la zona de Centro
                break;
            case Atras:
                precio = 50.0; // Precio para la zona de Atrás
                break;
            default:
                System.out.println("Zona desconocida.");
                break;
        }
    
        System.out.println("El precio para la zona " + zona + " es: " + precio);
        return precio;
    }



    //Metodo obtener asiento por zona
    public Asiento obtenerAsientoPorZona(Asiento.ZonaAsiento zona) {
        for (Asiento asiento : asientos) {
            if (asiento.getZona() == zona && asiento.esDisponible()) {
                return asiento; // Retorna el primer asiento disponible en la zona
            }
        }
        return null; // Retorna null si no hay asientos disponibles en la zona
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
        return precio * (1- descuento);
    }

    //Metodo para poner monto minimo al evento
    public boolean verificarConsumoMinimo(double monto) {
        return !consumoMinimo || monto >= 0.0;
    }
    

//Getters y Setters


    // Getter de nombre del evento
    public String getNombre() {
        return nombre;
    }

    // Getter de precio base
    public double getPrecio() {
        return precio;
    }

    // Getter de tipo de evento
    public String getDescripcion() {
        return descripcion;
    }

    // Getter de asientos disponibles
    public List<Asiento> getAsientos() {
        return asientos;
    }


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
    
    public void setAsientos(List<Asiento> asientos) {
        this.asientos = asientos;
    }
    
    public void setNombreEvento(String nombre) {
        this.nombre = nombre;
    }
    
}