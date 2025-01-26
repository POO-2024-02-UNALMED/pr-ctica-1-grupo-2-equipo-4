package basedatos;

import java.io.*;

public class Deserializador {

    /**
     * Método para deserializar un objeto desde un archivo.
     * 
     * @param rutaArchivo   Ruta del archivo donde está guardado el objeto.
     * @return El objeto deserializado o null si ocurre un error.
     */
    public static Object deserializar(String rutaArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            return ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + rutaArchivo + ". Se creará uno nuevo si es necesario.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al deserializar el objeto: " + e.getMessage());
        }
        return null;
    }
}
