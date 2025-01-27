package uiMain;

import java.util.Scanner;



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

    public int pedirZonaAsiento() {
        System.out.println("Seleccione la zona de asiento:");
        System.out.println("1. Palco\n2. Balcón\n3. Centro\n4. Atrás");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, seleccione una opción válida (1-4):");
            scanner.next();
        }
        int opcion = scanner.nextInt();
        while (opcion < 1 || opcion > 4) {
            System.out.println("Opción fuera de rango. Seleccione una opción válida (1-4):");
            opcion = scanner.nextInt();
        }
        return opcion;
    }
}
    


