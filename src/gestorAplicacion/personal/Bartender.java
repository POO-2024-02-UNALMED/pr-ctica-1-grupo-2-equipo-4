package gestorAplicacion.personal;

import gestorAplicacion.Servicios.Bebida;
import gestorAplicacion.Servicios.Cuenta;
import gestorAplicacion.Servicios.Ingrediente;
import gestorAplicacion.Servicios.Suscripcion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bartender extends Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    private static List<Bebida> barraDeBebidas; 
    private static List<Ingrediente> barraDeIngredientes; 
    private ArrayList<Bebida> menuActual;

    public Bartender(String rol, String puesto, List<Bebida> barraDeBebidas, List<Ingrediente> barraDeIngredientes) {
        super(rol, puesto);
        Bartender.barraDeBebidas = barraDeBebidas;
        Bartender.barraDeIngredientes = barraDeIngredientes;
        this.menuActual = new ArrayList<>();
    }

    public Bartender(String rol, String puesto){
        super(rol, puesto);
        this.menuActual = new ArrayList<>();
    }

    @Override
    public String generarSaludo (String nombre, String rol){
        return "Hola, "+ nombre+ "soy un " + rol;
    }

    public Bebida prepararBebidaBienvenida(Cliente cliente){
        Bebida bebidaBase = evaluarBebidaFavorita(cliente.getCuentas());
        
        if (bebidaBase == null) {
            bebidaBase = barraDeBebidas.stream()
                .max((b1, b2) -> Integer.compare(b1.getFavorito(), b2.getFavorito()))
                .orElse(null); // Manejar caso en que la barra esté vacía
        }

        ArrayList<Ingrediente> ingredientesPreparados = new ArrayList<>();
        for (Ingrediente ingredienteBase : bebidaBase.getIngredientes()) {
            for (Ingrediente barraIngrediente : barraDeIngredientes) {
                if (barraIngrediente.getNombre().equalsIgnoreCase(ingredienteBase.getNombre())) {
                    ingredientesPreparados.add(new Ingrediente(barraIngrediente.getNombre(), cliente.getSuscripcion()));
                }
            }
        }

        Bebida bebidaBienvenida = new Bebida(
            bebidaBase.getNombre(),
            bebidaBase.getPrecio(),
            bebidaBase.isDulce(),
            bebidaBase.isAmargo(),
            bebidaBase.isAcido(),
            bebidaBase.isAlcoholico(),
            bebidaBase.getFavorito(),
            ingredientesPreparados
        );
        //System.out.println(bebidaBienvenida.toString()); pongamos esto en el main
        
        return bebidaBienvenida;


    }


    public Bebida prepararBebida(String nombreBebida, Suscripcion suscripcion) {
        Bebida bebidaBase = null;
        for (Bebida bebida : barraDeBebidas) {
            if (bebida.getNombre().equalsIgnoreCase(nombreBebida)) {
                bebidaBase = bebida;
                break;
            }
        }

        if (bebidaBase == null) {
            throw new IllegalArgumentException("La bebida solicitada no está disponible en la barra.");
        }

        ArrayList<Ingrediente> ingredientesPreparados = new ArrayList<>();
        for (Ingrediente ingredienteBase : bebidaBase.getIngredientes()) {
            boolean encontrado = false;
            for (Ingrediente barraIngrediente : barraDeIngredientes) {
                if (barraIngrediente.getNombre().equalsIgnoreCase(ingredienteBase.getNombre())) {
                    ingredientesPreparados.add(new Ingrediente(barraIngrediente.getNombre(), suscripcion));
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                throw new IllegalStateException("No se encontraron todos los ingredientes necesarios para la bebida: " + ingredienteBase.getNombre());
            }
        }

        return new Bebida(
            bebidaBase.getNombre(),
            bebidaBase.getPrecio(),
            bebidaBase.isDulce(),
            bebidaBase.isAmargo(),
            bebidaBase.isAcido(),
            bebidaBase.isAlcoholico(),
            bebidaBase.getFavorito(),
            ingredientesPreparados
        );
    }

    public String generarMenu(boolean alcoholico, boolean dulce, boolean amargo, boolean acido, Bebida bebidaFavorita, Suscripcion suscripcion) {
        StringBuilder menu = new StringBuilder();
        this.menuActual = new ArrayList<>();
        menu.append("Menú personalizado (Descuento por suscripción: ").append(suscripcion.getDescuento() * 100).append("%):\n");
    
        int index = 1;
        boolean hayOpciones = false;
    
        for (Bebida bebida : barraDeBebidas) {
            System.out.println(bebida.getNombre());
            boolean incluir = true;
    
            // Filtrar por características
            if ((dulce && !bebida.isDulce()) || 
                (amargo && !bebida.isAmargo()) || 
                (acido && !bebida.isAcido())) {
                incluir = false;
            }
    
            if (alcoholico && !bebida.isAlcoholico()) {
                incluir = false;
            }
    
            // Si la bebida cumple con los filtros, agregarla al menú
            if (incluir && bebida != null) {
                hayOpciones = true;
                String recomendacion = calcularRecomendacion(bebida, bebidaFavorita);
                int precioConDescuento = (int) (bebida.getPrecio() * (1 - suscripcion.getDescuento()));
                menu.append(String.format("%d. %s: Precio original: $%d | Precio con descuento: $%d (%s)\n", 
                                          index, bebida.getNombre(), bebida.getPrecio(), precioConDescuento, recomendacion));
                menuActual.add(bebida);
                
                index++;
            }
        }
    
        if (!hayOpciones) {
            menu.append("No hay opciones disponibles con los filtros seleccionados.\n");
        }
    
        return menu.toString();
    }

    private String calcularRecomendacion(Bebida bebida, Bebida bebidaFavorita) {
        if (bebidaFavorita != null && bebida.getNombre().equals(bebidaFavorita.getNombre())) {
            return "bebida favorita";
        } else if (bebida.getFavorito() > 3) { // Puedes ajustar el umbral
            return "recomendada";
        } else if (bebida.getFavorito() >= 0) {
            return "Neutral";
        } else {
            return "no recomendada";
        }
    }

    // Método para evaluar la bebida favorita del cliente basada en las cuentas
    public Bebida evaluarBebidaFavorita(ArrayList<Cuenta> cuentas) {
        ArrayList<String> descripciones = new ArrayList<>();
        
        // Recopilar todas las descripciones de bebidas de las cuentas
        for (Cuenta cuenta : cuentas) {
            for (String descripcion : cuenta.getDescripciones()) {
                descripciones.add(descripcion);
            }
        }

        // Buscar la bebida más repetida
        String bebidaFavoritaNombre = encontrarBebidaMasRepetida(descripciones);
        
        // Buscar la bebida en la barra de bebidas
        return buscarBebidaEnBarra(bebidaFavoritaNombre);
    }

    // Método para encontrar la bebida más repetida en las descripciones
    private String encontrarBebidaMasRepetida(List<String> descripciones) {
        String bebidaFavorita = "";
        int maxRepeticiones = 0;
        
        for (String descripcion : descripciones) {
            int repeticiones = 0;
            for (String descripcionComparar : descripciones) {
                if (descripcion.equals(descripcionComparar)) {
                    repeticiones++;
                }
            }
            
            // Actualizar la bebida favorita si hay más repeticiones
            if (repeticiones > maxRepeticiones) {
                maxRepeticiones = repeticiones;
                bebidaFavorita = descripcion;
            }
        }
        
        return bebidaFavorita;
    }

    // Método para buscar una bebida en la barra de bebidas
    private Bebida buscarBebidaEnBarra(String nombreBebida) {
        for (Bebida bebida : barraDeBebidas) {
            if (bebida.getNombre().equalsIgnoreCase(nombreBebida)) {
                return bebida;  // Si se encuentra, devuelve la bebida
            }
        }
        return null;  // Si no se encuentra, devuelve null
    }


    public static List<Bebida> getBarraDeBebidas() {
        return barraDeBebidas;
    }

    public static void setBarraDeBebidas(List<Bebida> barraDeBebidas) {
        Bartender.barraDeBebidas = barraDeBebidas;
    }

    public static List<Ingrediente> getBarraDeIngredientes() {
        return barraDeIngredientes;
    }

    public static void setBarraDeIngredientes(List<Ingrediente> barraDeIngredientes) {
        Bartender.barraDeIngredientes = barraDeIngredientes;
    }

    public ArrayList<Bebida> getMenuActual() {
        return this.menuActual;
    }

    public void setMenuActual(ArrayList<Bebida> menuActual) {
        this.menuActual = menuActual;
    }
    
}
