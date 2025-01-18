package gestorAplicacion.personal;

public class Artista extends Empleado{
    private String tipoEspectaculo;

    public Animador(String rol, String puesto, String tipoEspectaculo) {
        super(rol, puesto);
        this.tipoEspectaculo = tipoEspectaculo;
    }

    public String realizarPresentacion(String tipoEspectaculo){

    }

    public String getTipoEspectaculo() {
        return this.tipoEspectaculo;
    }

    public void setTipoEspectaculo(String tipoEspectaculo) {
        this.tipoEspectaculo = tipoEspectaculo;
    }


}