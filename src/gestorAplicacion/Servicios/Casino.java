package gestorAplicacion.Servicios;

import java.util.ArrayList;

public class Casino{
    private static ArrayList<ArrayList<Auto>> estacionamiento;
    private ArrayList<Habitacion> hotel;
    private ArrayList<Evento> teatro;


    public static String mostrarEspaciosEstacionamiento(Suscripcion suscripcion) {
        StringBuilder tabla = new StringBuilder(); // Utilizamos StringBuilder para construir la tabla
    
        if (Casino.estacionamiento == null || Casino.estacionamiento.isEmpty()) {
            return "El estacionamiento está vacío o no ha sido inicializado.";
        }
    
        // Encabezados de columna
        tabla.append("    "); // Espacio para las filas
        for (int col = 0; col < estacionamiento.get(0).size(); col++) {
            tabla.append(col).append("   "); // Números de columnas
        }
        tabla.append("\n");
    
        // Contenido de la tabla
        for (int fila = 0; fila < estacionamiento.size(); fila++) {
            tabla.append(fila).append(" | "); // Número de fila
            for (int columna = 0; columna < estacionamiento.get(fila).size(); columna++) {
                if (!"platinum".equals(suscripcion.getTipoSuscripcion()) && fila < 2) {
                    // Restricción para las dos primeras filas
                    tabla.append("X   "); // Espacio restringido
                } else {
                    // Verificar si el espacio está ocupado
                    if (estacionamiento.get(fila).get(columna) != null) {
                        tabla.append("X   "); // Espacio ocupado
                    } else {
                        tabla.append("O   "); // Espacio disponible
                    }
                }
            }
            tabla.append("\n"); // Salto de línea para la siguiente fila
        }
    
        return tabla.toString();
    }
    
    
    public static ArrayList<ArrayList<Auto>> getEstacionamiento() {
        return Casino.estacionamiento;
    }

    public static void setEstacionamiento(ArrayList<ArrayList<Auto>> estacionamiento) {
        Casino.estacionamiento = estacionamiento;
    }

    public ArrayList<Habitacion> getHotel() {
        return this.hotel;
    }

    public void setHotel(ArrayList<Habitacion> hotel) {
        this.hotel = hotel;
    }

    public ArrayList<Evento> getTeatro() {
        return this.teatro;
    }

    public void setTeatro(ArrayList<Evento> teatro) {
        this.teatro = teatro;
    }




}