package uiMain;

import gestorAplicacion.Servicios.Bebida;
import gestorAplicacion.Servicios.Cuenta;
import gestorAplicacion.Servicios.Ingrediente;
import gestorAplicacion.personal.Bartender;
import gestorAplicacion.personal.Cliente;
import gestorAplicacion.personal.Empleado;
import java.util.ArrayList;

public class BarMain{
    public static void funcionalidadBar(Cliente cliente) {
        //Cliente cliente = new Cliente("juan", 19, 123456, 500000);
        //cliente.setSuscripcion(new Suscripcion(8));
        //cliente.setFidelidadBar(true);

        Bartender bartender = new Bartender(null, null);
        for (Empleado empleado : Empleado.getEmpleados()){
            if (empleado.getRol() == "bartender"){
                bartender = (Bartender) empleado;// ligadura dinamica!!!!
            }
        }

        BarUI consola = new BarUIConsole();

        // interaccion 1
        // Preguntar preferencias
        boolean alcohol = consola.pedirAlcohol();
        boolean acido = consola.pedirAcido();
        boolean amargo = consola.pedirAmargo();
        boolean dulce = consola.pedirDulce();

        // Generar menú según preferencias
        String menu = bartender.generarMenu(alcohol, dulce, amargo, acido,cliente.getBebidaFavorita(), cliente.getSuscripcion());
        System.out.println(menu);
        Bebida bebidaSeleccionada = consola.escogerMenu(bartender.getMenuActual());

        // interaccion 2
        // Preparar bebida y buscar ingredientes
        Bebida bebidaPreparada = bartender.prepararBebida(bebidaSeleccionada.getNombre(), cliente.getSuscripcion());
        System.out.println(bebidaPreparada.toString());

        // interaccion 3
        // Pedir propina
        double propina = consola.pedirPropina();

        // Generar factura
        String factura = new Cuenta().generarFacturaBar(bebidaSeleccionada, cliente, propina, bartender);
        System.out.println(factura);

    }
}