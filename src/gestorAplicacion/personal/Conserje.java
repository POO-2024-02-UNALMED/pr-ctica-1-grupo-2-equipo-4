package gestorAplicacion.personal;

public class Conserje extends Empleado{

    public Conserje(String rol, String puesto) {
        super(rol, puesto);
    }

    @Override
    public String generarSaludo (String nombre, String rol){
        return "Hola, "+ nombre+ "soy un " + rol;
    }

    public void limpiarHabitacion(){

    }

    public void lavarRopa(){
        
    }
}