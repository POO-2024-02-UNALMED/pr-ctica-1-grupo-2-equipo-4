package gestorAplicacion.Servicios.juegos;

public class Carta {
    private int valor; // Valor de la carta (1-10)
    private String palo; // Palo de la carta (♥️, ♠️, ♦️, ♣️)

    public Carta(int valor, String palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public int getValor() {
        return valor;
    }

    public String getPalo() {
        return palo;
    }

    @Override
    public String toString() {
        return valor + " de " + palo; // Representación de la carta
    }
}
