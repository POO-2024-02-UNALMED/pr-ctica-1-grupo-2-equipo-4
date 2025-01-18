
package gestorAplicacion.personal;

public class Cliente { 

    private String nombreCliente;
    private int edadCliente;
    private long id;
    private float saldo;
    private int fichas;
    private int numeroVisitas;
    private int partidasJugadas;
	private boolean fidelidadBar;
    private boolean fidelidadArtista;
    private int propinasBar;
    private int propinasArtista;

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

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas(int partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
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

    public int getFichas (){
        return fichas;
    }

    public void setFichas (int fichas){
        this.fichas = fichas;
    }

    //Metodo de dar propina al bar
    public void darPropinaBar(int propina) {
        this.saldo -= propina;
        this.propinasBar += 1;
        if this.propinasBar >= 3{
            this.fidelidadBar = true;
        }
    }

}
