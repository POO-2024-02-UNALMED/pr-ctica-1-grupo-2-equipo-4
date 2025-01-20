package gestorAplicacion.Servicios.juegos;
import gestorAplicacion.personal.Cliente;
public abstract class Juego{
    //Atributos
    int apuesta;
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
    public void setApuesta(int apuesta) {
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
        //Fichas del cliente
        int fichasGenerales = cliente.getFichas();
        //Fichas ganadas en la apuesta
        int fichasGanadas = (int) Math.floor(this.apuesta * this.riesgo);
        //Actualizacion de las fichas del cliente
        cliente.setFichas(fichasGenerales + fichasGanadas);
    }
    // Metodo abstracto que desarrolla el juego
    public abstract void jugar(Cliente cliente);
}