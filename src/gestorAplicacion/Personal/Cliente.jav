
package gestorAplicacion.personal;

public class Cliente { 

    private String nombreCliente;
    private int edadCliente;
    private long id;
    private float saldo;
    private int numeroVisitas;
    private int partidasJugadas;
	private boolean fidelidadBar;

    // Constructor vacío
    public Cliente() {
    }

    // Constructor con parámetros
    public Cliente(String nombreCliente, int edadCliente, long id, float saldo, int numeroVisitas, int partidasJugadas, boolean fidelidadBar) {
        this.nombreCliente = nombreCliente;
        this.edadCliente = edadCliente;
        this.id = id;
        this.saldo = saldo;
        this.numeroVisitas = numeroVisitas;
        this.partidasJugadas = partidasJugadas;
		this.fidelidadBar = fidelidadBar;
    }

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

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas(int partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }
}
