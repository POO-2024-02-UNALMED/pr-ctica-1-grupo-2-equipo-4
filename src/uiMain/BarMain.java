package uiMain;

import gestorAplicacion.Servicios.Bebida;
import gestorAplicacion.Servicios.Cuenta;
import gestorAplicacion.Servicios.Ingrediente;
import gestorAplicacion.Servicios.Suscripcion;
import gestorAplicacion.personal.Bartender;
import gestorAplicacion.personal.Cliente;
import java.util.ArrayList;

public class BarMain{
    public static void funcionalidadBar() {
        Cliente cliente = new Cliente("juan", 19, 123456, 500000);
        cliente.setSuscripcion(new Suscripcion(8));
        cliente.setFidelidadBar(true);

        ArrayList<Ingrediente> ingredientes = new ArrayList<>();
        Ingrediente ingrediente1 = new Ingrediente("agua", cliente.getSuscripcion());
        ingredientes.add(ingrediente1);

        Bebida bebidaAgua = new Bebida("agua", 2000, false, false, false, false, 2, ingredientes);
        ArrayList<Ingrediente> barraIngredientesBar = new ArrayList<>();
        ArrayList<Bebida> barraBebidasBar = new ArrayList<>();
        barraIngredientesBar.add(ingrediente1);
        barraBebidasBar.add(bebidaAgua);
        Bartender bartender = new Bartender("bartender","barra",barraBebidasBar,barraIngredientesBar);

        BarUI consola = new BarUIConsole();

        // Preguntar preferencias
        boolean alcohol = consola.pedirAlcohol();
        boolean acido = consola.pedirAcido();
        boolean amargo = consola.pedirAmargo();
        boolean dulce = consola.pedirDulce();

        // Generar menú según preferencias
        String menu = bartender.generarMenu(alcohol, dulce, amargo, acido,cliente.getBebidaFavorita(), cliente.getSuscripcion());
        System.out.println(menu);
        Bebida bebidaSeleccionada = consola.escogerMenu(bartender.getMenuActual());

        // Preparar bebida
        Bebida bebidaPreparada = bartender.prepararBebida(bebidaSeleccionada.getNombre(), cliente.getSuscripcion());
        System.out.println(bebidaPreparada.toString());

        // Pedir propina
        double propina = consola.pedirPropina();

        // Generar factura
        String factura = new Cuenta().generarFacturaBar(bebidaSeleccionada, cliente, propina, bartender);
        System.out.println(factura);

    }
}