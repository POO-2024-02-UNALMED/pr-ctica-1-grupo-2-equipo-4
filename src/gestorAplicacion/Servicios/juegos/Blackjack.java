package gestorAplicacion.Servicios.juegos;
import gestorAplicacion.personal.Cliente;

public class Blackjack extends Juego{
    private int acumulado;

    public Blackjack (int apuesta, float riesgo){
        super(apuesta, riesgo);
        this.acumulado = 0;
    }
    public void jugar (Cliente cliente){
        cliente.fichas -= this.apuesta;
        
    }