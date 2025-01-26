package basedatos;

import java.io.*;

public class Serializador {

    /**
     * Método para serializar un objeto y guardarlo en un archivo.
     * 
     * @param objeto        El objeto que será serializado.
     * @param rutaArchivo   Ruta del archivo donde se guardará el objeto.
     */
    public static void serializar(Object objeto, String rutaArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(objeto);
            System.out.println("Objeto serializado y guardado en: " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("Error al serializar el objeto: " + e.getMessage());
        }
    }
}
