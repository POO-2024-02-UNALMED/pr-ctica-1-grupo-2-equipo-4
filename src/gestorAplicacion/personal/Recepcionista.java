package gestorAplicacion.personal;

import gestorAplicacion.Servicios.Auto;
import gestorAplicacion.Servicios.Suscripcion;
import java.util.ArrayList;
import java.util.Scanner;

public class Recepcionista extends Empleado{
    private static ArrayList<Empleado> empleados = new ArrayList<>();
    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public Recepcionista(String rol, String puesto, ArrayList<Empleado> empleados) {
        super(rol, puesto);
    }


    public Cliente registrarCliente(int edad, float saldo, long identificacion, String nombre, Auto auto, int numeroVisitas, float dinero){
        numeroVisitas++;

        for (Cliente cliente : Recepcionista.clientes){
            if (cliente.getId() == identificacion){
                cliente.setAuto(auto);
                cliente.setSaldo(saldo);
                cliente.setSuscripcion(new Suscripcion(numeroVisitas));
                return cliente;
            }
        }
        if (edad < 18){
            System.out.println("no es mayor de edad, no puede entrar al casino");
            return null;
        }
        
        Cliente clienteNuevo = new Cliente(nombre, edad, identificacion, saldo, auto, new Suscripcion(numeroVisitas));
        Recepcionista.clientes.add(clienteNuevo);
        cambiarFichas(clienteNuevo);

        return clienteNuevo;
        
    }

    @Override
    public String generarSaludo (String nombre, String rol){
        return ("Hola, "+ nombre+ "soy un " + rol);
    }
    //public Boolean verificarEdad(){}

    //public Bebida pedirBebidaBienvenida(){}

    public void cambiarFichas(Cliente cliente) {
        Scanner scanner = new Scanner(System.in); // Crear un único Scanner
        boolean noValido = true;
        float dinero = 0;
    
        while (noValido) {
            System.out.println("¿Cuánto dinero quieres cambiar por fichas? (1 ficha por cada 1000 pesos)");
            String entrada = scanner.nextLine(); // Leer la entrada del usuario
            
            // Validar que la entrada es un número positivo dentro del saldo del cliente
            if (entrada.matches("\\d+(\\.\\d+)?")) {
                dinero = Float.parseFloat(entrada);
    
                if (dinero > 0 && dinero <= cliente.getSaldo()) {
                    noValido = false; // Entrada válida, salir del bucle
                } else {
                    System.out.println("El monto ingresado no es válido. Ingrese un valor entre 0 y " + cliente.getSaldo() + " pesos.");
                }
            } else {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    
        // Calcular fichas y cambio restante
        int fichas = (int) dinero / 1000;
        float cambio = dinero % 1000;
    
        // Actualizar saldo y fichas del cliente
        cliente.setSaldo(cliente.getSaldo() - dinero + cambio);
        cliente.setFichas(cliente.getFichas() + fichas);
    
        // Mostrar confirmación
        System.out.println("Has cambiado " + dinero + " pesos por " + fichas + " fichas.");
        if (cambio > 0) {
            System.out.println("Se han devuelto " + cambio + " pesos como cambio.");
        }
    }
    
    

    //public String crearListaHabitaciones(){}

    public static ArrayList<Cliente> getClientes(){
        return Recepcionista.clientes;
    }
}