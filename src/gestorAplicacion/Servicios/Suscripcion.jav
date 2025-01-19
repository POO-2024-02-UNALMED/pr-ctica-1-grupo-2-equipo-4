package gestorAplicacion.Servicios;

public class Suscripcion{
    private String tipoSuscripcion;
    private float descuento;
    private int fichaCompensacion;

    public Suscripcion(int visitas){
        if (visitas == 1){
            this.tipoSuscripcion = "primera vez";
            this.descuento = 0.05;
            this.fichaCompensacion = 20;
        elif (visitas > 1) && (visitas < 4){
            this.tipoSuscripcion = "por defecto";
            this.descuento = 0;
            this.fichaCompensacion = 10;
        }
        elif (visitas > 3) && (visitas < 6){
            this.tipoSuscripcion = "Silver";
            this.descuento = 0.15;
            this.fichaCompensacion = 50;
        }
        elif (visitas > 5){
            this.tipoSuscripcion = "platinum";
            this.descuento = 0.25;
            this.fichaCompensacion = 100;
        }
    }
}