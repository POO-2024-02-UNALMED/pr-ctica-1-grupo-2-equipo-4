package gestorAplicacion.personal;

public class Artista extends Empleado{
    private String nombre;
    private String tipoEspectaculo;


    public Artista(String rol, String puesto, String tipoEspectaculo, String nombre) {
        super(rol, puesto);
        this.tipoEspectaculo = tipoEspectaculo;
        this.nombre = nombre;
    }
    public Artista(String nombre) {
        super("Artista", "Escenario"); // Valores predeterminados para rol y puesto
        this.nombre = nombre;
        this.tipoEspectaculo = "General"; // Valor predeterminado para tipoEspectaculo
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

    public String getNombre(){
        return nombre;
    }


}