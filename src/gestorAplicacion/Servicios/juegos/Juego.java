package gestorAplicacion.Servicios.juegos;
import java.math.floor;
import gestorAplicacion.personal.Cliente;

public abstract class Juego{
    //Atributos
    private int apuesta;
    private float riesgo;
    //Constructor
    protected Juego (int apuesta, float riesgo){
        this.apuesta = apuesta;
        this.riesgo = riesgo;
    }
    //Getters y Setters
    public int getApuesta() {
        return apuesta;
    }
    public void setApuesta( int apuesta) {
        this.apuesta = apuesta;
    }
    public float getRiesgo() {
        return riesgo;
    }
    public void setRiesgo(float riesgo) {
        this.riesgo = riesgo;
    }
    // Metodo que devuelve la ganancia de las apuestas
    public void devolverApuesta (Cliente cliente){
        cliente.fichas += math.floor(this.apuesta * this.riesgo);
    }
    // Metodo abstracto que desarrolla el juego
    public abstract void jugar(Cliente cliente){
        // Implementación del juego
        cliente.fichas -= this.apuesta;
    }
}