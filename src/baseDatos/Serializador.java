// Emanuel Palacio Perez
//No implementado, funciono una vez pero interfirio con el funcionamiento de la aplicacion

package baseDatos;

import java.io.*;

public class Serializador {
    public static final String BASE_PATH = "/workspaces/pr-ctica-1-grupo-2-equipo-4/src/baseDatos/temp/";

    /**
     * Método para serializar un objeto y guardarlo en un archivo.
     *
     * @param objeto        El objeto que será serializado.
     * @param rutaArchivo   Ruta del archivo donde se guardará el objeto.
     */
    public static void serializar(Object objeto, String rutaArchivo) {
        File directorio = new File(BASE_PATH);
        if (!directorio.exists()) {
            directorio.mkdirs(); // Crear los directorios si no existen
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(objeto);
            System.out.println("Objeto serializado y guardado en: " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("Error al serializar el objeto: " + e.getMessage());
        }
    }
}
