package uiMain;

import baseDatos.Deserializador;
import baseDatos.Serializador;
import gestorAplicacion.Servicios.Bebida;
import gestorAplicacion.Servicios.Ingrediente;
import gestorAplicacion.personal.Animador;
import gestorAplicacion.personal.Bartender;
import gestorAplicacion.personal.Cliente;
import gestorAplicacion.personal.Empleado;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InicializarObjBar();
        Scanner scanner = new Scanner(System.in);
        Animador animador = new Animador();

        // Crear listas de entidades del casino

        // ArrayList<Empleado> empleados = crearEmpleados();

        // Funcionalidad de Recepción
        System.out.println("===== Bienvenido al Casino =====");
        System.out.println("Primero debe registrarse en la recepción.");

        Cliente usuarioActual = RecepcionMain.funcionalidadRecepcion();

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
                case 1:// jugar
                    animador.entregarFichas(usuarioActual);
                    MainJuegos.funcionalidadJugar(usuarioActual);
                    break;

                case 2:// bar
                    BarMain.funcionalidadBar(usuarioActual);
                    break;

                case 3:// eventos
                       // Eventos(scanner, clientes, empleados);

                    break;

                case 4:// habiitacion
                       // Hotel(scanner, clientes, hotel);
                    break;

                case 5:// salir
                    System.out.println("Saliendo del casino. ¡Gracias por visitarnos!");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción del 1 al 5.");
            }
        }

        scanner.close();
    
    }

    public static void InicializarPersonas() {

    }
    public static void InicializarObjBar() {
        // Inicialización de ingredientes

        ArrayList<Ingrediente> barraIngredientesBar = new ArrayList<>();

        Ingrediente menta = new Ingrediente("hojas de menta");
        Ingrediente limon = new Ingrediente("zumo de limón");
        Ingrediente azucar = new Ingrediente("jarabe de azúcar");
        Ingrediente ron = new Ingrediente("ron blanco");
        Ingrediente coco = new Ingrediente("coco rallado");
        Ingrediente whisky = new Ingrediente("whisky");
        Ingrediente hielo = new Ingrediente("hielo");
        Ingrediente piña = new Ingrediente("zumo de piña");
        Ingrediente cerveza = new Ingrediente("malta");
        Ingrediente vermut = new Ingrediente("vermut");
        Ingrediente ginebra = new Ingrediente("ginebra");

        // Agregar ingredientes a la barra
        barraIngredientesBar.add(menta);
        barraIngredientesBar.add(limon);
        barraIngredientesBar.add(azucar);
        barraIngredientesBar.add(ron);
        barraIngredientesBar.add(coco);
        barraIngredientesBar.add(whisky);
        barraIngredientesBar.add(hielo);
        barraIngredientesBar.add(piña);
        barraIngredientesBar.add(cerveza);
        barraIngredientesBar.add(vermut);
        barraIngredientesBar.add(ginebra);

        // Inicialización de bebidas
        ArrayList<Bebida> barraBebidasBar = new ArrayList<>();
        ArrayList<Ingrediente> ingredientesMojito = new ArrayList<>();
        ingredientesMojito.add(menta);
        ingredientesMojito.add(limon);
        ingredientesMojito.add(azucar);
        ingredientesMojito.add(ron);
        ingredientesMojito.add(hielo);
        Bebida mojito = new Bebida("Mojito", 8000, true, false, false, false, 2, ingredientesMojito);
        barraBebidasBar.add(mojito);

        // Piña Colada
        ArrayList<Ingrediente> ingredientesPinaColada = new ArrayList<>();
        ingredientesPinaColada.add(coco);
        ingredientesPinaColada.add(piña);
        ingredientesPinaColada.add(ron);
        ingredientesPinaColada.add(hielo);
        Bebida pinaColada = new Bebida("Piña Colada", 9000, true, true, false, false, 3, ingredientesPinaColada);
        barraBebidasBar.add(pinaColada);

        // Whisky Sour
        ArrayList<Ingrediente> ingredientesWhiskySour = new ArrayList<>();
        ingredientesWhiskySour.add(whisky);
        ingredientesWhiskySour.add(limon);
        ingredientesWhiskySour.add(azucar);
        ingredientesWhiskySour.add(hielo);
        Bebida whiskySour = new Bebida("Whisky Sour", 10000, true, false, true, false, 4, ingredientesWhiskySour);
        barraBebidasBar.add(whiskySour);

        // Cerveza Artesanal
        ArrayList<Ingrediente> ingredientesCerveza = new ArrayList<>();
        ingredientesCerveza.add(cerveza);
        Bebida cervezaArtesanal = new Bebida("Cerveza Artesanal", 6000, false, false, false, true, 1, ingredientesCerveza);
        barraBebidasBar.add(cervezaArtesanal);

        // Martini
        ArrayList<Ingrediente> ingredientesMartini = new ArrayList<>();
        ingredientesMartini.add(ginebra);
        ingredientesMartini.add(vermut);
        ingredientesMartini.add(hielo);
        Bebida martini = new Bebida("Martini", 12000, false, false, true, false, 5, ingredientesMartini);
        barraBebidasBar.add(martini);

        // Inicialización del bartender
        Bartender bartender = new Bartender("Bartender", "Barra", barraBebidasBar, barraIngredientesBar);
        Empleado.getEmpleados().add(bartender);

        Serializador.serializar(barraBebidasBar, Serializador.BASE_PATH+"bebidas.dat");
        Serializador.serializar(barraIngredientesBar, Serializador.BASE_PATH+"ingredientes.dat");
        Serializador.serializar(bartender, Serializador.BASE_PATH+"bartender.dat");
    }

    public static void cargarDatos() {
        // Deserializar ingredientes
        List<Ingrediente> ingredientes = (List<Ingrediente>) Deserializador.deserializar("srs/baseDatos/temp/ingredientes.dat");
        if (ingredientes != null) {
            Bartender.setBarraDeIngredientes(ingredientes);
        } else {
            System.err.println("No se pudieron cargar los ingredientes.");
        }

        // Deserializar bebidas
        List<Bebida> bebidas = (List<Bebida>) Deserializador.deserializar("srs/baseDatos/temp/bebidas.dat");
        if (bebidas != null) {
            Bartender.setBarraDeBebidas(bebidas);
        } else {
            System.err.println("No se pudieron cargar las bebidas.");
        }

        // Deserializar bartender
        Bartender bartender = (Bartender) Deserializador.deserializar("srs/baseDatos/temp/bartender.dat");
        if (bartender != null) {
            System.out.println("Bartender cargado: " + bartender);
        } else {
            System.err.println("No se pudo cargar el bartender.");
        }
    }

    // Métodos para inicializar el casino
    /*
     * private static ArrayList<Cliente> crearClientes() {
     * ArrayList<Cliente> clientes = new ArrayList<>();
     * clientes.add(new Cliente("Juan Pérez", 500));
     * clientes.add(new Cliente("María Gómez", 1000));
     * return clientes;
     * }
     * 
     * private static ArrayList<Empleado> crearEmpleados() {
     * ArrayList<Empleado> empleados = new ArrayList<>();
     * empleados.add(new Empleado("Carlos López", "Recepcionista"));
     * empleados.add(new Empleado("Ana Rodríguez", "Bartender"));
     * return empleados;
     * }
     * 
     * 
     * // Métodos para funcionalidades
     * private static void realizarRecepcion(Scanner scanner, ArrayList<Cliente>
     * clientes, ArrayList<Empleado> empleados) {
     * System.out.println("\n--- Recepción ---");
     * System.out.print("Ingrese su nombre para registrarse: ");
     * scanner.nextLine(); // Limpiar buffer
     * String nombre = scanner.nextLine();
     * System.out.print("Ingrese el dinero inicial que desea cambiar por fichas: ");
     * int dinero = scanner.nextInt();
     * 
     * Cliente nuevoCliente = new Cliente(nombre, dinero);
     * clientes.add(nuevoCliente);
     * System.out.println("Cliente registrado exitosamente.");
     * }
     * 
     * private static void menuJuegos(Scanner scanner, ArrayList<Cliente> clientes,
     * ArrayList<Ruleta> ruletas, ArrayList<MaquinaDeSlots> maquinas) {
     * System.out.println("\n--- Juegos ---");
     * System.out.println("1. Jugar a la Ruleta");
     * System.out.println("2. Jugar en las Máquinas de Slots");
     * System.out.print("Seleccione una opción: ");
     * int opcion = scanner.nextInt();
     * 
     * switch (opcion) {
     * case 1:
     * jugarRuleta(scanner, clientes, ruletas);
     * break;
     * 
     * case 2:
     * jugarSlots(scanner, clientes, maquinas);
     * break;
     * 
     * default:
     * System.out.println("Opción inválida.");
     * }
     * }
     * 
     * private static void jugarRuleta(Scanner scanner, ArrayList<Cliente> clientes,
     * ArrayList<Ruleta> ruletas) {
     * System.out.println("\n--- Jugar a la Ruleta ---");
     * // Lógica para jugar a la ruleta
     * }
     * 
     * private static void jugarSlots(Scanner scanner, ArrayList<Cliente> clientes,
     * ArrayList<MaquinaDeSlots> maquinas) {
     * System.out.println("\n--- Jugar en las Máquinas de Slots ---");
     * // Lógica para jugar en máquinas de slots
     * }
     * 
     * private static void visitarBar(Scanner scanner, ArrayList<Cliente> clientes,
     * ArrayList<Empleado> empleados, Bar bar) {
     * System.out.println("\n--- Visitar el Bar ---");
     * // Lógica para el bar
     * }
     * 
     * private static void gestionarEventos(Scanner scanner, ArrayList<Cliente>
     * clientes, ArrayList<Empleado> empleados) {
     * System.out.println("\n--- Gestión de Eventos ---");
     * // Lógica para gestionar eventos
     * }
     * 
     * private static void gestionarHotel(Scanner scanner, ArrayList<Cliente>
     * clientes, Hotel hotel) {
     * System.out.println("\n--- Gestión del Hotel ---");
     * // Lógica para gestionar habitaciones, reservas, etc.
     * }
     * 
     */
}