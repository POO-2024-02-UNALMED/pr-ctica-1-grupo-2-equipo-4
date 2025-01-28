package uiMain;

import baseDatos.Serializador;
import gestorAplicacion.Servicios.Bebida;
import gestorAplicacion.Servicios.Ingrediente;
import gestorAplicacion.Servicios.Suscripcion;
import gestorAplicacion.personal.Animador;
import gestorAplicacion.personal.Bartender;
import gestorAplicacion.personal.Cliente;
import gestorAplicacion.personal.Empleado;
import gestorAplicacion.personal.Recepcionista;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InicializarObjBar();
        InicializarClientes();
        System.out.println(Recepcionista.getClientes());

        Scanner scanner = new Scanner(System.in);
        Animador animador = new Animador();

        // Crear listas de entidades del casino

        // ArrayList<Empleado> empleados = crearEmpleados();

        // Funcionalidad de Recepción, Emanuel Palacio Perez
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
                case 1:// Funcionalidad jugar
                    String suscripcion = usuarioActual.getSuscripcion().getTipoSuscripcion();
                    if (suscripcion.equalsIgnoreCase("vetado")){
                        break;
                    }
                    animador.entregarFichas(usuarioActual);
                    MainJuegos.funcionalidadJugar(usuarioActual);
                    break;

                case 2:// Funcionalidad bar, Emanuel Palacio Perez
                    BarMain.funcionalidadBar(usuarioActual);
                    break;

                case 3://Funcionalidad eventos
                    EventoMain.funcionalidadEvento();

                    break;

                case 4:// habitacion
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

    public static void guardarDatos(){
        for (Empleado empleado: Empleado.getEmpleados()){
            Serializador.serializar(empleado, Serializador.BASE_PATH+"empleado.dat");
        }
    }
    public static void InicializarClientes() {
        // Inicialización de clientes
        Cliente clientePlat = new Cliente("james", 45, 1000000, new Suscripcion(6));
        Cliente clienteSilver = new Cliente("samanta", 37, 1000000, new Suscripcion(4));
        Cliente clientePorDefecto = new Cliente("jose", 29, 1000000, new Suscripcion(2));
        clienteSilver.setFidelidadBar(true);
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
        Bebida pinaColada = new Bebida("Piña Colada", 9000, true, true, false, true, 3, ingredientesPinaColada);
        barraBebidasBar.add(pinaColada);

        // Whisky Sour
        ArrayList<Ingrediente> ingredientesWhiskySour = new ArrayList<>();
        ingredientesWhiskySour.add(whisky);
        ingredientesWhiskySour.add(limon);
        ingredientesWhiskySour.add(azucar);
        ingredientesWhiskySour.add(hielo);
        Bebida whiskySour = new Bebida("Whisky Sour", 10000, true, false, true, true, 4, ingredientesWhiskySour);
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
        Bebida martini = new Bebida("Martini", 12000, false, false, true, true, 5, ingredientesMartini);
        barraBebidasBar.add(martini);

        // Inicialización del bartender
        Bartender bartender = new Bartender("Bartender", "Barra");
        Bartender.setBarraDeBebidas(barraBebidasBar);
        Bartender.setBarraDeIngredientes(barraIngredientesBar);

    }
        /* Serializador.serializar(barraBebidasBar, Serializador.BASE_PATH+"bebidas.dat");
        Serializador.serializar(barraIngredientesBar, Serializador.BASE_PATH+"ingredientes.dat");
        Serializador.serializar(bartender, Serializador.BASE_PATH+"bartender.dat");
    }

    public static void cargarDatos() {
        // Deserializar ingredientes
        List<Ingrediente> ingredientes = (List<Ingrediente>) Deserializador.deserializar(Serializador.BASE_PATH+"ingredientes.dat");
        if (ingredientes != null) {
            Bartender.setBarraDeIngredientes(ingredientes);
            System.out.println(Bartender.getBarraDeIngredientes());
        } else { 
            System.err.println("No se pudieron cargar los ingredientes.");
        }

        // Deserializar bebidas
        List<Bebida> bebidas = (List<Bebida>) Deserializador.deserializar(Serializador.BASE_PATH+"bebidas.dat");
        if (bebidas != null) {
            Bartender.setBarraDeBebidas(bebidas);
        } else {
            System.err.println("No se pudieron cargar las bebidas.");
        }

        // Deserializar bartender
        Bartender bartender = (Bartender) Deserializador.deserializar(Serializador.BASE_PATH+"bartender.dat");
        if (bartender != null) {
            Empleado.getEmpleados().add(bartender);
        } else {
            System.err.println("No se pudo cargar el bartender.");
        }

        ArrayList<Empleado> empleados = (ArrayList<Empleado>) Deserializador.deserializar(Serializador.BASE_PATH+"empleados.dat");
        if (bartender != null) {
            Empleado.setEmpleados(empleados);;
        } else {
            System.err.println("No se pudo cargar los empleados.");
        }
    } */
    
}