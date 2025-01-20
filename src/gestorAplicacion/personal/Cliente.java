
package gestorAplicacion.personal;

import java.util.ArrayList;
import gestorAplicacion.Servicios.RegistroJuego;
import gestorAplicacion.Servicios.Cuenta;
import gestorAplicacion.Servicios.Suscripcion;
import gestorAplicacion.Servicios.Bebida;

public class Cliente { 
    //Atributos
    private String nombreCliente;
    private int edadCliente;
    private long id;
    private float saldo;
    private int fichas;
    private int numeroVisitas;
    private Suscripcion suscripcion;
	private boolean fidelidadBar;
    private int propinasBar;
    private Bebida bebidaFavorita;
    private boolean fidelidadArtista;
    private int propinasArtista;
    private ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
    private RegistroJuego registroJuego;

    // Constructor vacío
    public Cliente() {
    }

    // Constructor con parámetros
    public Cliente(String nombreCliente, int edadCliente, long id, float saldo) {
        this.nombreCliente = nombreCliente;
        this.edadCliente = edadCliente;
        this.id = id;
        this.saldo = saldo;
    }

    // Método para dar propina al bar
    public void darPropinaBar(int propina) {
        this.saldo -= propina;
        this.propinasBar += 1;

        // Verificar si tiene fidelidad por haber dado 3 o más propinas
        if (this.propinasBar >= 3) {
            this.fidelidadBar = true;
        }
    }

    // Obtener descuento por fidelidad en el bar (5% si ha dado 3 o más propinas)
    public double obtenerDescuentoPorFidelidadBar() {
        return fidelidadBar ? 0.05 : 0.0; // 5% de descuento si tiene fidelidad en el bar
    }

    // Método para pagar una cuenta individual
    public void pagarCuenta(Cuenta cuenta) {
        if (!cuenta.isPagada()) {
            // Sumar el total de las cuentas (precios después de los descuentos)
            double totalCuenta = 0;
            for (Double precio : cuenta.getPrecios()) {
                totalCuenta += precio;
            }

            // Verificar si tiene saldo suficiente
            if (this.saldo >= totalCuenta) {
                // Deduzco el saldo
                this.saldo -= totalCuenta;
                // Cambio el estado de la cuenta a pagada
                cuenta.setPagada(true);
                System.out.println("Cuenta pagada por el cliente " + this.nombreCliente + " por un total de $" + totalCuenta);
            } else {
                System.out.println("Saldo insuficiente para pagar la cuenta.");
            }
        }
    }

    // Método para pagar todas las cuentas del cliente
    public void pagarCuentas() {
        // Iterar sobre todas las cuentas del cliente y pagar cada una
        for (Cuenta cuenta : cuentas) {
            pagarCuenta(cuenta);  // Llamamos al método pagarCuenta para cada cuenta
        }
    }
    // Getters y Setters
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getEdadCliente() {
        return edadCliente;
    }

    public void setEdadCliente(int edadCliente) {
        this.edadCliente = edadCliente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getNumeroVisitas() {
        return numeroVisitas;
    }

    public void setNumeroVisitas(int numeroVisitas) {
        this.numeroVisitas = numeroVisitas;
    }

    public Suscripcion getSuscripcion() { 
        return suscripcion; 
    }

    public void setSuscripcion(Suscripcion suscripcion){ 
        this.suscripcion = suscripcion;
    }


    public boolean getfidelidadArtista(){
        return fidelidadArtista;
    }

    public void setfidelidadArista (boolean fidelidadArtista){
        this.fidelidadArtista = fidelidadArtista;
    }

    public boolean getfidelidadBar(){
        return fidelidadBar;
    }

    public void setfidelidadBar(boolean fidelidadBar){
        this.fidelidadBar = fidelidadBar;
    }

    public Bebida getBebidaFavorita() {
        return this.bebidaFavorita;
    }

    public void setBebidaFavorita(Bebida bebidaFavorita) {
        this.bebidaFavorita = bebidaFavorita;
    }


    public int getFichas (){
        return fichas;
    }

    public void setFichas (int fichas){
        this.fichas = fichas;
    }


    public ArrayList<Cuenta> getCuentas() {
        return this.cuentas;
    }

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public RegistroJuego getRegistroJuego (){
        return this.registroJuego;
    }

    public void setregistroJuego (RegistroJuego registroJuego){
        this.registroJuego = registroJuego;
    }
}