package gestorAplicacion.Servicios.juegos;


public class Blacjack extends Juego{
    private int acumulado;
    public Blacjack (int apuesta, float riesgo){
        super(apuesta, riesgo);
        this.acumulado = 0;
    }
    public void jugar (Cliente cliente){
        cliente.fichas -= this.apuesta;
        
    }
}