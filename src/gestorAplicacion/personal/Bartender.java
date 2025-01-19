package gestorAplicacion.personal;

import gestorAplicacion.Servicios.*;
import java.util.ArrayList;
import java.util.List;

public class Bartender extends Empleado {
    private List<Bebida> barraDeBebidas; 
    private List<Ingrediente> barraDeIngredientes; 
    private ArrayList<Bebida> menuActual;

    public Bartender(String rol, String puesto, List<Bebida> barraDeBebidas, List<Ingrediente> barraDeIngredientes) {
        super(rol, puesto);
        this.barraDeBebidas = barraDeBebidas;
        this.barraDeIngredientes = barraDeIngredientes;
        this.menuActual = new ArrayList<Bebida>();
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

        List<Ingrediente> ingredientesPreparados = new ArrayList<>();
        for (Ingrediente ingredienteBase : bebidaBase.getIngredientes()) {
            boolean encontrado = false;
            for (Ingrediente barraIngrediente : this.barraDeIngredientes) {
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
            bebidaBase.getAccessoSuscripcion(),
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
        menu.append("Menú personalizado (Descuento por suscripción: ").append(suscripcion.getDescuento() * 100).append("%):\n");
    
        int index = 1;
        boolean hayOpciones = false;
    
        for (Bebida bebida : this.barraDeBebidas) {
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
            if (incluir) {
                hayOpciones = true;
                String recomendacion = calcularRecomendacion(bebida, bebidaFavorita);
                int precioConDescuento = (int) (bebida.getPrecio() * (1 - suscripcion.getDescuento()));
                menu.append(String.format("%d. %s: Precio original: $%d | Precio con descuento: $%d (%s)\n", 
                                          index, bebida.getNombre(), bebida.getPrecio(), precioConDescuento, recomendacion));
                menuActual.append(bebida);
                
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
            return "recomendada";
        } else if (bebida.getFavorito() > 7) { // Puedes ajustar el umbral
            return "recomendada";
        } else if (bebida.getFavorito() >= 4) {
            return "Neutral";
        } else {
            return "no recomendada";
        }
    }

    // Método para evaluar la bebida favorita del cliente basada en las cuentas
    public Bebida evaluarBebidaFavorita(ArrayList<Cuenta> cuentas) {
        List<String> descripciones = new ArrayList<>();
        
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


    public List<Bebida> getBarraDeBebidas() {
        return this.barraDeBebidas;
    }

    public void setBarraDeBebidas(List<Bebida> barraDeBebidas) {
        this.barraDeBebidas = barraDeBebidas;
    }

    public List<Ingrediente> getBarraDeIngredientes() {
        return this.barraDeIngredientes;
    }

    public void setBarraDeIngredientes(List<Ingrediente> barraDeIngredientes) {
        this.barraDeIngredientes = barraDeIngredientes;
    }

    public ArrayListList<Bebida> getMenuActual() {
        return this.menuActual;
    }

    public void setMenuActual(ArrayListList<Bebida> menuActual) {
        this.menuActual = menuActual;
    }
    
}
