package gestorAplicacion.personal;

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

    //Eventos, dar bienvenida

    public void darBienvenida(Cliente cliente){
        String nombreCliente = cliente.getNombreCliente();

        System.out.println("¡Bienvenido a los eventos del Casino, " + nombreCliente + "!");

     //Mostrar detalles iniciales del cliente (opcional)
     System.out.println("Suscripción actual: " + cliente.getSuscripcion().getTipoSuscripcion());
     System.out.println("Saldo disponible: $" + cliente.getSaldo());
 
     // Continuar al siguiente flujo: Mostrar eventos disponibles
     System.out.println("Permítame mostrarle los eventos disponibles...");       
    }

    //Mostrar eventos
    public void mostrarEventosDisponibles(List<Evento> eventos) {
        System.out.println("Eventos disponibles: ");
        for (int i = 0; i < eventos.size(); i++){
            Evento evento = eventos.get(i);
            System.out.println((i + 1) + ". " + evento.getNombreEvento() + " - Precio: $" + evento.getPrecioBase());
        }
    }

    //Verificar premio especial en evento
    public boolean verificarPremioEspecial(Cliente cliente){
        return cliente.verificarPremioEspecial();
    }

    public void asignarAsientoEspecial(Cliente cliente, Evento evento) {
        cliente.asignarAsientoEspecial(evento);
        System.out.println("Se ha asignado un asiento especial en el evento: " + evento.getNombreEvento());
    }
}