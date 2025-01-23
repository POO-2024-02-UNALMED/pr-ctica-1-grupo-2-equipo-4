package gestorAplicacion.personal;

import gestorAplicacion.Servicios.Auto;
import gestorAplicacion.Servicios.Casino;

public class Valet extends Empleado {

    public Valet(String rol, String puesto) {
        super(rol, puesto);
    }

    @Override
    public String generarSaludo(String nombre, String rol) {
        return "Hola, " + nombre + ", soy un " + rol;
    }

    public static Cliente identificarCliente(long identificacion){
        for (Cliente cliente : Recepcionista.getClientes()) {
            if (cliente.getId() == identificacion) {
                System.out.println("encontrado registro para " + cliente.getNombreCliente());
                return cliente;
            }
        }
        return null;
    }

    public Auto estacionarRegistrarAuto(String modelo, String placa, int columna, int fila, long identificacion) {
        
        Auto auto = new Auto();
        Cliente cliente = identificarCliente(identificacion);
        auto.setCliente(cliente);

            
        // Verifica si la posición indicada es válida
        if (columna < 0 || fila < 0 || 
            columna >= Casino.getEstacionamiento().size() || 
            fila >= Casino.getEstacionamiento().get(0).size()) {
            System.out.println("La posición indicada esta fuera de los límites del estacionamiento.");
            return null;
        }

        // Verifica si el espacio está disponible
        if (Casino.getEstacionamiento().get(fila).get(columna) != null) {
            System.out.println("El espacio seleccionado ya esta ocupado o es restringido. Por favor, elija otro.");
            return null;
        }

        // Crea el auto y lo registra en el espacio
        auto.setModelo(modelo);
        auto.setPlaca(placa);
        Casino.getEstacionamiento().get(fila).set(columna, auto);
        int[] espacio = {fila, columna};
        auto.setEspacioEstacionamiento(espacio);
        
        
        
        if (auto.getCliente() != null) {
            if (auto.getCliente().getSuscripcion().getTipoSuscripcion().equalsIgnoreCase("platinum") && fila > 2) {
                compensarFichas(auto.getCliente().getSuscripcion(), auto.getCliente());
                System.out.println("El cliente ha recibido " + auto.getCliente().getSuscripcion().getFichaCompensacion() + " fichas de compensación por escoger un espacio menor al de su suscripcion.");
            }
        }

        // Devuelve el objeto Auto registrado
        return auto;
    }
}
    // public Auto devolverAuto() {}
