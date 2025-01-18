package gestorAplicacion.Servicios;
import java.util.Objects;

public class Auto;{
    //Atributos
    private boolean estacionado;
    private String modeloAuto;
    private String placa;
    // Constructor vacio
    public Auto() {
    }
    // Constructor con parametros
    public Auto(boolean estacionado, String modeloAuto, String placa) {
        this.estacionado = estacionado;
        this.modeloAuto = modeloAuto;
        this.placa = placa;
    }
    // Getters y Setters
    public boolean getEstacionado() {
        return this.estacionado;
    }

    public void setEstacionado(boolean estacionado) {
        this.estacionado = estacionado;
    }

    public String getModeloAuto() {
        return this.modeloAuto;
    }

    public void setModeloAuto(String modeloAuto) {
        this.modeloAuto = modeloAuto;
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    // Metodo para estacionar el auto
    public void estacionar(Estacionamiento estacionamiento, Int fila, Int Columna)
    { 
     }    
}

