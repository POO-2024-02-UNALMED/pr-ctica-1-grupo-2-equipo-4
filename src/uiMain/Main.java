package uiMain;

import gestorAplicacion.personal.Empleado;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear listas de entidades del casino
        
        ArrayList<Empleado> empleados = crearEmpleados();
       

        // Funcionalidad de Recepción
        System.out.println("===== Bienvenido al Casino =====");
        System.out.println("Primero debe registrarse en la recepción.");
        realizarRecepcion(scanner, cliente, empleados);

        boolean salir = false;

        // Menú principal
        while (!salir) {
            System.out.println("\n===== Menú Principal del Casino =====");
            System.out.println("1. Jugar");
            System.out.println("2. Bar");
            System.out.println("3. Eventos");
            System.out.println("4. Reservar habitacion");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    menuJuegos(scanner, clientes, ruletas, maquinasDeSlots);
                    break;

                case 2:
                    visitarBar(scanner, clientes, empleados, bar);
                    break;

                case 3:
                    gestionarEventos(scanner, clientes, empleados);
                    break;

                case 4:
                    gestionarHotel(scanner, clientes, hotel);
                    break;

                case 5:
                    System.out.println("Saliendo del casino. ¡Gracias por visitarnos!");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción del 1 al 5.");
            }
        }

        scanner.close();
    }

    // Métodos para inicializar el casino
    private static ArrayList<Cliente> crearClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Juan Pérez", 500));
        clientes.add(new Cliente("María Gómez", 1000));
        return clientes;
    }

    private static ArrayList<Empleado> crearEmpleados() {
        ArrayList<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado("Carlos López", "Recepcionista"));
        empleados.add(new Empleado("Ana Rodríguez", "Bartender"));
        return empleados;
    }


    // Métodos para funcionalidades
    private static void realizarRecepcion(Scanner scanner, ArrayList<Cliente> clientes, ArrayList<Empleado> empleados) {
        System.out.println("\n--- Recepción ---");
        System.out.print("Ingrese su nombre para registrarse: ");
        scanner.nextLine(); // Limpiar buffer
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el dinero inicial que desea cambiar por fichas: ");
        int dinero = scanner.nextInt();

        Cliente nuevoCliente = new Cliente(nombre, dinero);
        clientes.add(nuevoCliente);
        System.out.println("Cliente registrado exitosamente.");
    }

    private static void menuJuegos(Scanner scanner, ArrayList<Cliente> clientes, ArrayList<Ruleta> ruletas, ArrayList<MaquinaDeSlots> maquinas) {
        System.out.println("\n--- Juegos ---");
        System.out.println("1. Jugar a la Ruleta");
        System.out.println("2. Jugar en las Máquinas de Slots");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                jugarRuleta(scanner, clientes, ruletas);
                break;

            case 2:
                jugarSlots(scanner, clientes, maquinas);
                break;

            default:
                System.out.println("Opción inválida.");
        }
    }

    private static void jugarRuleta(Scanner scanner, ArrayList<Cliente> clientes, ArrayList<Ruleta> ruletas) {
        System.out.println("\n--- Jugar a la Ruleta ---");
        // Lógica para jugar a la ruleta
    }

    private static void jugarSlots(Scanner scanner, ArrayList<Cliente> clientes, ArrayList<MaquinaDeSlots> maquinas) {
        System.out.println("\n--- Jugar en las Máquinas de Slots ---");
        // Lógica para jugar en máquinas de slots
    }

    private static void visitarBar(Scanner scanner, ArrayList<Cliente> clientes, ArrayList<Empleado> empleados, Bar bar) {
        System.out.println("\n--- Visitar el Bar ---");
        // Lógica para el bar
    }

    private static void gestionarEventos(Scanner scanner, ArrayList<Cliente> clientes, ArrayList<Empleado> empleados) {
        System.out.println("\n--- Gestión de Eventos ---");
        // Lógica para gestionar eventos
    }

    private static void gestionarHotel(Scanner scanner, ArrayList<Cliente> clientes, Hotel hotel) {
        System.out.println("\n--- Gestión del Hotel ---");
        // Lógica para gestionar habitaciones, reservas, etc.
    }
}
