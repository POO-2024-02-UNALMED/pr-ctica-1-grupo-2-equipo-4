package uiMain;

import gestorAplicacion.Servicios.Auto;
import gestorAplicacion.Servicios.Casino;
import gestorAplicacion.personal.Valet;
import gestorAplicacion.personal.Cliente;

public class RecepcionMain {
    public static void funcionalidadRecepcion(){
        RecepcionUI consola = new RecepcionUIConsole();

        Valet valet = new Valet("Valet", "Estacionamiento");
        // Preguntar preferencias
        Auto auto = null;
        long id = consola.pedirID();
        Cliente clienteOld = Valet.identificarCliente(id); 
        String modelo = consola.pedirModelo();
        String placa = consola.pedirPlaca();
        System.out.println(Casino.mostrarEspaciosEstacionamiento(clienteOld.getSuscripcion()));

        while(auto == null){
            int columna = consola.pedirColumna();
            int fila = consola.pedirFila();
            auto = valet.estacionarRegistrarAuto( modelo, placa, columna, fila, id);
        }
        
        // Pedir datos cliente
        int edad = consola.pedirEdad();
        float saldo = consola.pedirSaldo();
    

            
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
