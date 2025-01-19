package uiMain;

import java.util.ArrayList;
import java.util.Scanner;
import gestorAplicacion.Servicios.Bebida;

public class BarUIConsole implements BarUI {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public boolean pedirAlcohol() {
        System.out.println("¿Quieres una bebida alcohólica? (sí/no)");
        String respuesta = scanner.nextLine().toLowerCase();
        return respuesta.equals("sí");
    }


    @Override
    public boolean pedirAcido() {
        System.out.println("¿Quieres una bebida ácida? (sí/no)");
        String respuesta = scanner.nextLine().toLowerCase();
        return respuesta.equals("sí");
    }

    @Override
    public boolean pedirAmargo() {
        System.out.println("¿Quieres una bebida amarga? (sí/no)");
        String respuesta = scanner.nextLine().toLowerCase();
        return respuesta.equals("sí");
    }

    @Override
    public boolean pedirDulce() {
        System.out.println("¿Quieres una bebida dulce? (sí/no)");
        String respuesta = scanner.nextLine().toLowerCase();
        return respuesta.equals("sí");
    }

    @Override
    public Bebida escogerMenu(ArrayList<Bebida> menuActual) {
        System.out.println("Selecciona una bebida (por número):");
        int seleccion = Integer.parseInt(scanner.nextLine()) - 1;
        return menuActual.get(seleccion);
    }

    @Override
    public double pedirPropina() {
        System.out.println("¿Cuánto deseas dejar de propina?");
        return Double.parseDouble(scanner.nextLine());
    }

}
