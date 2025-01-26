package uiMain;

import gestorAplicacion.Servicios.Bebida;
import java.util.ArrayList;

public interface BarUI{

    // Pregunta al cliente si quiere una bebida alcohólica
    boolean pedirAlcohol();

    // Pregunta al cliente si quiere una bebida ácida
    boolean pedirAcido();

    // Pregunta al cliente si quiere una bebida amarga
    boolean pedirAmargo();

    // Pregunta al cliente si quiere una bebida dulce
    boolean pedirDulce();

    // Muestra el menú de bebidas y devuelve la opción seleccionada
    Bebida escogerMenu(ArrayList<Bebida> menuActual);

    // Pregunta al cliente si desea dejar propina
    double pedirPropina();

  
}
