package gestorAplicacion.Servicios.juegos;

public class Carta {
    // Atributo
    private String valor; 
    private String palo; // Palo de la carta (♥️, ♠️, ♦️, ♣️)
    //Constructor
    public Carta(String valor, String palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public String getValor() {
        return valor;
    }

    public String getPalo() {
        return palo;
    }

    @Override
    public String toString() {
        // Representación de la carta
        return valor + " de " + palo; 
    }
}
