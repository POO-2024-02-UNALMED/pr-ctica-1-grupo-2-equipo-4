package gestorAplicacion.Servicios;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import gestorAplicacion.Servicios.Asiento;
import gestorAplicacion.Servicios.Asiento.ZonaAsiento;
import gestorAplicacion.personal.Artista;
import gestorAplicacion.personal.Cliente;

public class Evento {
    private String nombre;
    private String descripcion;
    private Artista artista;
    private Boolean consumoMinimo;
    private double precio;
    private Map<Asiento.ZonaAsiento, Integer> asientosDisponibles; // Mapa para gestionar asientos por zona


    // Lista estática de eventos disponibles
    private static List<Evento> eventosDisponibles = new ArrayList<>();
    private static List<Asiento> asientos = new ArrayList<>();



    public Evento(String nombre, String descripcion, Artista artista, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.artista = artista;
        this.precio = precio;
        this.asientosDisponibles = new HashMap<>();
    }

    public void inicializarAsientos() {
        // inicialización de asientos en las zonas
        asientos.add(new Asiento(ZonaAsiento.Palco, 25, 50)); // 10 asientos disponibles
        asientos.add(new Asiento(ZonaAsiento.Balcon, 20, 40));
        asientos.add(new Asiento(ZonaAsiento.Centro, 15, 25));
        asientos.add(new Asiento(ZonaAsiento.Atras, 10, 20));
    }

    public static void inicializarEventos() {

        Artista artista1 = new Artista("Lisa S.");
        Artista artista2 = new Artista("Merrit McKinney");
        Artista artista3 = new Artista("Franco Escamilla");


        // Agregar algunos eventos por defecto
        
        eventosDisponibles.add(new Evento("Concierto de Jazz", "Jazz relajante.", artista1, 50.0));
        eventosDisponibles.add(new Evento("Show de Magia", "Acto Ilusionismo.", artista2, 40.0));
        eventosDisponibles.add(new Evento("Comedia Stand-Up", "Una noche llena de risas.", artista3, 30.0));
    }

    public static void mostrarEventos() {
        if (eventosDisponibles.isEmpty()) {
            System.out.println("No hay eventos disponibles en este momento");
            return;
        }
        for (int i = 0; i < eventosDisponibles.size(); i++) {
            Evento evento = eventosDisponibles.get(i);
            String nombreArtista = evento.getArtista() != null ? evento.getArtista().getNombre() : "Artista no disponible";
            System.out.println((i + 1) + ". " + evento.getNombre() + " - " + evento.getDescripcion() + 
                               " | Artista: " + nombreArtista + " ($" + evento.getPrecio() + ")");
        }
    }

    public void mostrarZonasAsientos() {
        System.out.println("Zonas de asientos disponibles para el evento:");
        for (Map.Entry<Asiento.ZonaAsiento, Integer> entry : asientosDisponibles.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " asientos disponibles");
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