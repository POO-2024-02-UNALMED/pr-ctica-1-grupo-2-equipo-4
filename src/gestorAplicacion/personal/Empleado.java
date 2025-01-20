package gestorAplicacion.personal;

public abstract class Empleado {
    private String rol;
    private String puesto;
    private static ArrayList<Empleado> empleados = new ArrayList<Empleado>();

    protected Empleado(String rol, String puesto) {
        this.rol = rol;
        this.puesto = puesto;
        empleados.add(this);
    }

    public int compensarFichas(Suscripcion suscripcion, Cliente cliente){
        cliente.fichas = cliente.fichas+suscripcion.fichasCompensacion;
        return "Recibe"+suscripcion.fichasCompensacion+ "fichas como compensacion";
    }

    public abstract String generarSaludo(String nombre, String rol){

    }

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

}
