package gestorAplicacion.Servicios;
public class RegistroJuego{

    //Atributos
    private final int fichasInicio;
    private int fichasFinal;
    private int partidasGanadas;
    private int partidasJugadas;
    private int rachaVictorias;
    private float porcentajeVictorias;

    //Constructor vacios
    public RegistroJuego() {
        this.partidasJugadas = 0;
        this.partidasGanadas = 0;
        this.fichasFinal = 0;
        this.fichasInicio = 0;
        this.porcentajeVictorias = 0;
    }
    //Constructor con parametro
    public RegistroJuego(int fichasInicio) {
        this.fichasInicio = fichasInicio;
    }
    //Getters y setters
    public int getFichasInicio() {
        return this.fichasInicio;
    }

    public int getFichasFinal() {
        return this.fichasFinal;
    }

    public void setFichasFinal(int fichasFinal) {
        this.fichasFinal = fichasFinal;
    }

    public int getPartidasGanadas() {
        return this.partidasGanadas;
    }

    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public float getPorcentajeVictorias() {
        return this.porcentajeVictorias;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas(int partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }
    //Metodo para calcular el porcentaje de victorias
    public void calcularPorcentajeVictorias() {
        if (partidasJugadas != 0) {
            this.porcentajeVictorias = ((float)partidasGanadas / partidasJugadas);
        }
    }
    //Metodo para cada partida que se juegue 
    public void incrementarPartidasJugadas(boolean ganada) {
            partidasJugadas++;
            if (ganada) {
                partidasGanadas++;
                rachaVictorias++;
            } else {
                rachaVictorias = 0; // Reiniciar la racha en caso de derrota
            }
            calcularPorcentajeVictorias();
        }
        

    // Método para incrementar la racha de victorias
    public void incrementarRacha() {
    rachaVictorias++;
    }
     // Método para reiniciar la racha de victorias
    public void reiniciarRacha() {
    rachaVictorias = 0;
    }
    
    // Getter para la racha de victorias
    public int getRachaVictorias() {
    return rachaVictorias;
    }
}