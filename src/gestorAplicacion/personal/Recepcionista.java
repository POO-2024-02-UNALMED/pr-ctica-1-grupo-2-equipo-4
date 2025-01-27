package gestorAplicacion.personal;

import gestorAplicacion.Servicios.Asiento;
import gestorAplicacion.Servicios.Auto;
import gestorAplicacion.Servicios.Evento;
import gestorAplicacion.Servicios.Suscripcion;
import java.util.ArrayList;
import java.util.List;

public class Recepcionista extends Empleado{
    private static ArrayList<Empleado> empleados = new ArrayList<>();
    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public Recepcionista(String rol, String puesto) {
        super(rol, puesto);
    }

//interaccion 2, funcionalidad Recepcion, verifica que el cliente sea mayor de edad y si tiene un perfil registrado en el casino, siendo asi
//crea o actualiza sus datos  y lo guarda en el registro, que es el arrayList de objetos de cliente
    public Cliente registrarCliente(int edad, float saldo, long identificacion, String nombre, Auto auto){
        int numeroVisitas = 1;

        for (Cliente cliente : Recepcionista.clientes){
            if (cliente.getId() == identificacion){
                cliente.setNumeroVisitas(cliente.getNumeroVisitas()+1);
                cliente.setAuto(auto);
                cliente.setSaldo(saldo);
                cliente.setSuscripcion(new Suscripcion(cliente.getNumeroVisitas()));
                return cliente;
            }
        }
        if (edad < 18){
            System.out.println("no es mayor de edad, no puede entrar al casino");
            return null;
        }
        
        Cliente clienteNuevo = new Cliente(nombre, edad, identificacion, saldo, auto, new Suscripcion(numeroVisitas));
        Recepcionista.clientes.add(clienteNuevo);

        return clienteNuevo;
        
    }

    @Override
    public String generarSaludo (String nombre, String rol){
        return ("Hola, "+ nombre+ "soy un " + rol);
    }

    //parte de la interaccion 2, funcionalidad recepcion, cambia el dinero indicado por fichas para el cliente
    public void cambiarFichas(Cliente cliente, float dinero){
        // Calcular fichas y cambio restante
        int fichas = (int) dinero / 1000;
        float cambio = dinero % 1000;
    
        // Actualizar saldo y fichas del cliente, se le devuelve el residuo de dinero que no se pueda cambiar
        cliente.setSaldo(cliente.getSaldo() - dinero + cambio);
        cliente.setFichas(cliente.getFichas() + fichas);
    }
    

    

    //public String crearListaHabitaciones(){}

    public static ArrayList<Cliente> getClientes(){
        return Recepcionista.clientes;
    }
    
    //Funcionalidad Eventos, Interaccion 1

    public static Cliente identificarCliente(long identificacion) {  
        for (Cliente cliente : getClientes()) { // Asegúrate de que 'getClientes()' devuelva la lista de clientes registrados
            if (cliente.getId() == identificacion) {
                return cliente;
            }
        }
        return null;
    }

    public static void procesarSeleccionEvento(Cliente cliente, Evento eventoSeleccionado) { //Metodo principal
        System.out.println("Ha seleccionado el evento: " + eventoSeleccionado.getNombre());


        // Verificar el tipo de suscripción del cliente
        if (cliente.getSuscripcion().getTipoSuscripcion().equalsIgnoreCase("Platinum")) {
            System.out.println("¡Felicidades! Como cliente Platinum, tiene derecho a:");
            System.out.println("- Un asiento en la zona de Palco completamente gratis.");
            System.out.println("- Una bebida especial gratis para disfrutar durante el evento.");

            // Asignar asiento de Palco
            Asiento asientoPalco = new Asiento(Asiento.ZonaAsiento.Palco, 1, 0.0); // Gratis
            asientoPalco.reservarAsiento();
            cliente.setAsiento(asientoPalco);

            System.out.println("Se le ha asignado un asiento en Palco: " + asientoPalco);
            System.out.println("¡Disfrute de su bebida especial durante el espectáculo!");
        } else {
            System.out.println("Gracias por visitar el área de eventos. Puede seleccionar un asiento de las zonas disponibles.");
        }

        

         // Asignar el evento al cliente
         cliente.setEvento(eventoSeleccionado);
         System.out.println("Su evento ha sido registrado exitosamente. ¡Disfrute del espectáculo!");

}
}