package gestorAplicacion.personal;

import gestorAplicacion.Servicios.Suscripcion;
import java.util.ArrayList;

public abstract class Empleado {
    private String rol;
    private String puesto;
    private static ArrayList<Empleado> empleados = new ArrayList<>();

    protected Empleado(String rol, String puesto) {
        this.rol = rol;
        this.puesto = puesto;
        empleados.add(this);
    }

    public void compensarFichas(Suscripcion suscripcion, Cliente cliente) {
        int fichasCompensacion = suscripcion.getFichaCompensacion(); // Obtiene la cantidad de fichas de compensación
        cliente.setFichas(cliente.getFichas() + fichasCompensacion); // Actualiza las fichas del cliente
    }
    
    

    public abstract String generarSaludo(String nombre, String rol);

    public String getRol() {
        return this.rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPuesto() {
        return this.puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public static ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public static void setEmpleados(ArrayList<Empleado> empleados) {
        Empleado.empleados = empleados;
    }
}
