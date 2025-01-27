package gestorAplicacion.Servicios;
import java.io.Serializable;
import java.util.ArrayList;

public class Bebida implements Serializable{
        // Atributos
        private String nombre;
        private int precio;
        private boolean dulce;
        private boolean amargo;
        private boolean acido;
        private boolean alcoholico;
        private int favorito;
        private ArrayList<Ingrediente> ingredientes;
    
    // Constructor vacio  
    public Bebida() {
    }
    // Constructor con parametros
    public Bebida(String nombre, int precio, boolean dulce, boolean amargo, boolean acido, boolean alcoholico, int favorito, ArrayList<Ingrediente> ingredientes) {
        this.nombre = nombre;
        this.precio = precio;
        this.dulce = dulce;
        this.amargo = amargo;
        this.acido = acido;
        this.alcoholico = alcoholico;
        this.favorito = favorito;
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        StringBuilder descripcion = new StringBuilder();
        descripcion.append("Bebida: ").append(nombre).append("\n");
        descripcion.append("Sabores: ");
        if (dulce) descripcion.append("Dulce ");
        if (amargo) descripcion.append("Amargo ");
        if (acido) descripcion.append("Acido ");
        if (alcoholico) descripcion.append("Alcoholico ");
        descripcion.append("\n");
        descripcion.append("Ingredientes: ");
        for (Ingrediente ingrediente : this.ingredientes) {
            descripcion.append(ingrediente.getNombre()).append(" (").append(ingrediente.getCalidad()).append("), ");
        }
        if (!ingredientes.isEmpty()) {
            descripcion.setLength(descripcion.length() - 2); // Elimina la última coma y espacio
        }
        return descripcion.toString();
    }


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

    public boolean isAlcoholico() {
        return this.alcoholico;
    }

    public boolean getAlcoholico() {
        return this.alcoholico;
    }

    public void setAlcoholico(boolean alcoholico) {
        this.alcoholico = alcoholico;
    }

    public int getFavorito() {
        return this.favorito;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
    }


    public ArrayList<Ingrediente> getIngredientes() {
        return this.ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

}
