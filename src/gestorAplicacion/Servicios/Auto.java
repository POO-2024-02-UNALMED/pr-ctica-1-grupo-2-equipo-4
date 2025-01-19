package gestorAplicacion.Servicios;

public class Auto {
    private boolean estacionado;
    private String modelo;
    private String placa;
    private int[] espacioEstacionamiento = new int[2];

//public Void Estacionar(int columna, int fila){}


    public boolean isEstacionado() {
        return this.estacionado;
    }

    public boolean getEstacionado() {
        return this.estacionado;
    }

    public void setEstacionado(boolean estacionado) {
        this.estacionado = estacionado;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int[] getEspacioEstacionamiento() {
        return this.espacioEstacionamiento;
    }

    public void setEspacioEstacionamiento(int[] espacioEstacionamiento) {
        this.espacioEstacionamiento = espacioEstacionamiento;
    }

}