package gestorAplicacion.Servicios;
import gestorAplicacion.personal.Artista;

public class Evento {
    private Artista artista;
    private Boolean consumoMinimo;
    private Boolean[][] asientos;


    public Artista getArtista() {
        return this.artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Boolean isConsumoMinimo() {
        return this.consumoMinimo;
    }

    public Boolean getConsumoMinimo() {
        return this.consumoMinimo;
    }

    public void setConsumoMinimo(Boolean consumoMinimo) {
        this.consumoMinimo = consumoMinimo;
    }

    public Boolean[][] getAsientos() {
        return this.asientos;
    }

    public void setAsientos(Boolean[][] asientos) {
        this.asientos = asientos;
    }

}