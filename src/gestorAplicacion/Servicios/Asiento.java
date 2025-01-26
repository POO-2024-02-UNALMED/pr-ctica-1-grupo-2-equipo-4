package gestorAplicacion.Servicios;

public class Asiento {

    public enum ZonaAsiento {
        
        Palco,
        Balcon,
        Centro,
        Atras;
    }

    private ZonaAsiento zona;
    private int cantidad;
    private boolean reservado;
    private Double precio;



public Asiento(ZonaAsiento zona, int cantidad, double precio) {
    this.zona = zona;
    this.cantidad = cantidad;
    this.precio = precio;
    this.reservado = false; //Inicialmente no esta reservado
}

    // Getters y Setters
    public ZonaAsiento getZona() {
        return zona;
    }

    public void setZona(ZonaAsiento zona) {
        this.zona = zona;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isReservado() {
        return reservado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

// Metodo para reservar asiento
public boolean reservarAsiento(){
    if (!reservado){
        reservado = true;
        return true;
    } 
    else {
        System.out.println("El asiento ya está reservado.");
        return false;
    } 
}

// Metodo para liberar asiento o saber si ya estaba disponible
public void liberarAsiento(){
    if (reservado) {
        reservado = false;
        System.out.println("El asiento ha sido liberado");
    }
    else{
        System.out.println("El asiento ya se encontraba disponible");
    }
}

// Metodo para verificar si el asiento está disponible
public boolean esDisponible() {
    return !reservado;
}

@Override
public String toString() {
    return "Asiento{" +
            "zona='" + zona + '\'' +
            ", cantidad=" + cantidad +
            ", reservado=" + reservado +
            ", precio=" + precio +
            '}';
}

}

