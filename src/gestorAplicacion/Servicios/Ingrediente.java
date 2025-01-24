package gestorAplicacion.Servicios;

public class Ingrediente {
    private String nombre;
    private String calidad;

    public Ingrediente(String nombre, Suscripcion suscripcion) { 
        this.nombre = nombre;
        this.calidad = suscripcion.getCalidadIngredientes();
    }

    public Ingrediente(String nombre) { 
        this.nombre = nombre;
        this.calidad = "alta";
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalidad() {
        return this.calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

}