package gestorAplicacion.personal;

public class Artista extends Empleado{
    private String tipoEspectaculo;

    public Artista(String rol, String puesto, String tipoEspectaculo) {
        super(rol, puesto);
        this.tipoEspectaculo = tipoEspectaculo;
    }

    @Override
    public String generarSaludo (String nombre, String rol){
        return "Hola, "+ nombre+ "soy un " + rol;
    }

    //public String realizarPresentacion(String tipoEspectaculo){}

    public String getTipoEspectaculo() {
        return this.tipoEspectaculo;
    }

    public void setTipoEspectaculo(String tipoEspectaculo) {
        this.tipoEspectaculo = tipoEspectaculo;
    }


}