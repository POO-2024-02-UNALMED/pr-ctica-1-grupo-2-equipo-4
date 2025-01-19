package gestorAplicacion.personal;

public class Valet extends Empleado{

    public Valet(String rol, String puesto) {
        super(rol, puesto);
    }

    @Override
    public String generarSaludo (String nombre, String rol){
        return "Hola, "+ nombre+ "soy un " + rol;
    }

    //public Auto estacionarRegistrarAuto(){}

    //public Auto devolverAuto(){}
}