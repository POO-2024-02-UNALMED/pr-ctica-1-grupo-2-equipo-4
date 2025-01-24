package gestorAplicacion.Servicios;

import java.util.ArrayList;

public class Casino{
    private static ArrayList<ArrayList<Auto>> estacionamiento;
    private ArrayList<Habitacion> hotel;
    private ArrayList<Evento> teatro;

    // usa el atributo de estacionamiento para crear la matriz que sera usada en consola para mostrar los espacios disponibles para estacionar
    // el auto, usa la suscripcion para determinar espacios exclusivos disponibles
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
    
        String tipoSub = "no existe";
        if (suscripcion != null){
            tipoSub = suscripcion.getTipoSuscripcion();
        }
        // Contenido de la tabla
        for (int fila = 0; fila < estacionamiento.size(); fila++) {
            tabla.append(fila).append(" | "); // Número de fila
            for (int columna = 0; columna < estacionamiento.get(fila).size(); columna++) {
                if (!"platinum".equals(tipoSub) && fila < 2) {
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

    public static void inicializarEstacionamiento(int filas, int columnas) {
        // Crear la matriz bidimensional de ArrayList
        ArrayList<ArrayList<Auto>> estacionamientor = new ArrayList<>();

        for (int i = 0; i < filas; i++) {
            ArrayList<Auto> fila = new ArrayList<>();
            for (int j = 0; j < columnas; j++) {
                // Insertar `null` por defecto en cada posición para espacios vacíos
                fila.add(null);
            }
            estacionamientor.add(fila);
        }

        // Crear algunos autos de ejemplo y asignarlos a posiciones específicas
        Auto auto1 = new Auto("Toyota", "ABC123");
        Auto auto2 = new Auto("Honda", "DEF456");
        Auto auto3 = new Auto("Ford", "GHI789");

        // Asignar autos a posiciones específicas
        estacionamientor.get(0).set(0, auto1); // Auto en la fila 0, columna 0
        estacionamientor.get(1).set(1, auto2); // Auto en la fila 1, columna 1
        estacionamientor.get(2).set(2, auto3); // Auto en la fila 2, columna 2

        // Establecer el estacionamiento en la clase Casino
        Casino.setEstacionamiento(estacionamientor);

        // Confirmar que se inicializó correctamente
        System.out.println("Estacionamiento inicializado con éxito.");
    }


}