package uiMain;

import java.util.Scanner;

import gestorAplicacion.Servicios.Asiento;



public class EventosUIConsole implements EventosUI {

    private static Scanner scanner = new Scanner(System.in);

    @Override
    public long pedirID() {
        System.out.println("Ingrese su identificación:");
        while (!scanner.hasNextLong()) {
            System.out.println("Entrada inválida. Por favor, ingrese un número válido:");
            scanner.next();
        }
        return scanner.nextLong();
    }
    
    @Override
    public int pedirEvento() {
        System.out.println("Ingrese el número del evento que desea asistir:");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, ingrese un número entero válido:");
            scanner.next();
        }
        return scanner.nextInt();
    }

    @Override
    public Asiento.ZonaAsiento pedirZonaAsiento() {
        System.out.println("Por favor, elija la zona de asiento:");
        System.out.println("1. Primera Fila");
        System.out.println("2. Balcón");
        System.out.println("3. Centro");
        System.out.println("4. Atrás");

        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();

        // Devolver la zona de asiento según la opción
        switch (opcion) {
            case 1:
                return Asiento.ZonaAsiento.Palco;
            case 2:
                return Asiento.ZonaAsiento.Balcon;
            case 3:
                return Asiento.ZonaAsiento.Centro;
            case 4:
                return Asiento.ZonaAsiento.Atras;
            default:
                System.out.println("Opción no válida. Se asignará la zona Centro.");
                return Asiento.ZonaAsiento.Centro;
        }

}

    @Override
    public int pedirAsiento() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pedirAsiento'");
    }
}
    


