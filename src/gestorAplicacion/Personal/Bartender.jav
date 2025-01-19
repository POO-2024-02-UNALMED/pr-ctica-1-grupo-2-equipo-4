package gestorAplicacion.personal;
import java.util.Arraylist;

public class Bartender extends Empleado{
    private ArrayList<Bebida> barra;

    public Bartender(String rol, String puesto, ArrayList<Bebida> barra) {
        super(rol, puesto);
        this.barra = barra;
    }

    public Bebida prepararBebida(){}

    public String generarMenu(boolean alcoholico, boolean dulce, boolean amargo, boolean acido, Bebida bebidaFavorita, Suscripcion suscripcion) {
        StringBuilder menu = new StringBuilder();
        menu.append("Menú personalizado (Descuento por suscripción: ").append(suscripcion.getDescuento() * 100).append("%):\n");
    
        int index = 1;
        for (Bebida bebida : barra) {
            boolean incluir = true;
    
            // Filtrar por características (dulce, amargo, ácido)
            if ((dulce && !bebida.isDulce()) || 
                (amargo && !bebida.isAmargo()) || 
                (acido && !bebida.isAcido())) {
                incluir = false;
            }
    
            // Si pasa los filtros, agregar al menú
            if (incluir) {
                String recomendacion = calcularRecomendacion(bebida, bebidaFavorita);
                int precioConDescuento = (int) (bebida.getPrecio() * (1 - suscripcion.getDescuento()));
                menu.append(String.format("%d. %s: Precio original: $%d | Precio con descuento: $%d (%s)\n", 
                                          index, bebida.getNombre(), bebida.getPrecio(), precioConDescuento, recomendacion));
                index++;
            }
        }
    
        return menu.toString();
    }    
}
