package gestorAplicacion.Servicios;

public class Habitacion {
    // Atributos
    private boolean ocupada;
    private int NumeroCamas;
    private int NumeroNoches;
    private String tipoHabitacion;
    private boolean habitacionLimpia;
    // Constructor vacio
    public Habitacion() {
    }
    // Constructor con argumentos
    public Habitacion(boolean ocupada, int NumeroCamas, int NumeroNoches, String tipoHabitacion, boolean habitacionLimpia) {
        this.ocupada = ocupada;
        this.NumeroCamas = NumeroCamas;
        this.NumeroNoches = NumeroNoches;
        this.tipoHabitacion = tipoHabitacion;
        this.habitacionLimpia = habitacionLimpia;
    }
    
     // Getters y Setters
    public boolean getOcupada() {
        return this.ocupada;
    }

    public void setOcupada(boolean ocuapada) {
        this.ocupada = ocuapada;
    }

    public int getNumeroCamas() {
        return this.NumeroCamas;
    }

    public void setNumeroCamas(int NumeroCamas) {
        this.NumeroCamas = NumeroCamas;
    }

    public int getNumeroNoches() {
        return this.NumeroNoches;
    }

    public void setNumeroNoches(int NumeroNoches) {
        this.NumeroNoches = NumeroNoches;
    }

    public String getTipoHabitacion() {
        return this.tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public boolean isHabitacionLimpia() {
        return this.habitacionLimpia;
    }

    public boolean getHabitacionLimpia() {
        return this.habitacionLimpia;
    }

    public void setHabitacionLimpia(boolean habitacionLimpia) {
        this.habitacionLimpia = habitacionLimpia;
    }
}
