package gestorAplicacion.Servicios;

public class Bebida {
    // Constructor vacio  
    public Bebida() {
    }
    // Constructor con parametros
    public Bebida(String nombre, int precio, String accessoSuscripcion, boolean dulce, boolean amargo, boolean acido, int favorito) {
        this.nombre = nombre;
        this.precio = precio;
        this.accessoSuscripcion = accessoSuscripcion;
        this.dulce = dulce;
        this.amargo = amargo;
        this.acido = acido;
        this.favorito = favorito;
    }
    // Atributos
    private String nombre;
    private int precio;
    private  String accessoSuscripcion;
    private boolean dulce;
    private boolean amargo;
    private boolean acido;
    private int favorito;


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return this.precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getAccessoSuscripcion() {
        return this.accessoSuscripcion;
    }

    public void setAccessoSuscripcion(String accessoSuscripcion) {
        this.accessoSuscripcion = accessoSuscripcion;
    }

    public boolean isDulce() {
        return this.dulce;
    }

    public boolean getDulce() {
        return this.dulce;
    }

    public void setDulce(boolean dulce) {
        this.dulce = dulce;
    }

    public boolean isAmargo() {
        return this.amargo;
    }

    public boolean getAmargo() {
        return this.amargo;
    }

    public void setAmargo(boolean amargo) {
        this.amargo = amargo;
    }

    public boolean isAcido() {
        return this.acido;
    }

    public boolean getAcido() {
        return this.acido;
    }

    public void setAcido(boolean acido) {
        this.acido = acido;
    }

    public int getFavorito() {
        return this.favorito;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
    }

    public Bebida nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Bebida precio(int precio) {
        setPrecio(precio);
        return this;
    }

    public Bebida accessoSuscripcion(String accessoSuscripcion) {
        setAccessoSuscripcion(accessoSuscripcion);
        return this;
    }

    public Bebida dulce(boolean dulce) {
        setDulce(dulce);
        return this;
    }

    public Bebida amargo(boolean amargo) {
        setAmargo(amargo);
        return this;
    }

    public Bebida acido(boolean acido) {
        setAcido(acido);
        return this;
    }

    public Bebida favorito(int favorito) {
        setFavorito(favorito);
        return this;
    }
}
