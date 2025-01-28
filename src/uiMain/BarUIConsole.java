package uiMain;

import gestorAplicacion.Servicios.Bebida;
import java.util.ArrayList;
import java.util.Scanner;

public class BarUIConsole implements BarUI {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public boolean pedirAlcohol() {
        System.out.println("¿Quieres una bebida alcohólica? (s/n)");
        String respuesta = scanner.nextLine().toLowerCase();
        return respuesta.equals("s");
    }


    @Override
    public boolean pedirAcido() {
        System.out.println("¿Quieres una bebida ácida? (s/n)");
        String respuesta = scanner.nextLine().toLowerCase();
        return respuesta.equals("s");
    }

    @Override
    public boolean pedirAmargo() {
        System.out.println("¿Quieres una bebida amarga? (s/n)");
        String respuesta = scanner.nextLine().toLowerCase();
        return respuesta.equals("s");
    }

    @Override
    public boolean pedirDulce() {
        System.out.println("¿Quieres una bebida dulce? (s/n)");
        String respuesta = scanner.nextLine().toLowerCase();
        return respuesta.equals("s");
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
