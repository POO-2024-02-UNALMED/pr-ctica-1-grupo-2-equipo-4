package gestorAplicacion.personal;

public class Artista extends Empleado{
    private String tipoEspectaculo;
    public Animador(String rol, String puesto, String tipoEspectaculo) {
        super(rol, puesto);
        this.tipoEspectaculo = tipoEspectaculo;
    }


}