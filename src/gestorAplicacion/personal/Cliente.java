
package gestorAplicacion.personal;

import gestorAplicacion.Servicios.Asiento;
import gestorAplicacion.Servicios.Asiento.ZonaAsiento;
import gestorAplicacion.Servicios.Auto;
import gestorAplicacion.Servicios.Bebida;
import gestorAplicacion.Servicios.Cuenta;
import gestorAplicacion.Servicios.Evento;
import gestorAplicacion.Servicios.RegistroJuego;
import gestorAplicacion.Servicios.Suscripcion;
import java.util.ArrayList;

public class Cliente { 
    //Atributos
    private String nombreCliente;
    private int edadCliente;
    private long id;
    private float saldo;
    private Auto auto;
    private int fichas;
    private int numeroVisitas;
    private Suscripcion suscripcion;
	private boolean fidelidadBar;
    private int propinasBar;
    private Bebida bebidaFavorita;
    private boolean fidelidadArtista;
    private int propinasArtista;
    private ArrayList<Cuenta> cuentas = new ArrayList<>();
    private RegistroJuego registroJuego;
    private Asiento asientoAsignado;

    
            // Constructor vacío
            public Cliente() {
            }
        
            public Cliente(String nombreCliente, int edadCliente, long id, float saldo) {
                this.nombreCliente = nombreCliente;
                this.edadCliente = edadCliente;
                this.id = id;
                this.saldo = saldo;
                this.suscripcion = new Suscripcion(numeroVisitas); //Se inicializa segun el numero de visitas
            }
            // Constructor con parámetros
            public Cliente(String nombreCliente, int edadCliente, long id, float saldo, Auto auto, Suscripcion suscripcion) {
                this.nombreCliente = nombreCliente;
                this.edadCliente = edadCliente;
                this.id = id;
                this.saldo = saldo;
                this.auto = auto;
                this.suscripcion = suscripcion;
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
        
        
            //EVENTOS
            //Metodo para saber si el cliente aplica para el premio especial segun suscripcion si es Silver o Platinum
            public boolean verificarPremioEspecial(){
                return suscripcion.getTipoSuscripcion().equals("Platinum") || 
                suscripcion.getTipoSuscripcion().equals("Silver");
            }
        
            //metodo para obtener asientos de evento
                //public List<Asiento> obtenerAsientosDisponibles(List<Asiento> asientos) {
                //return asientos.stream()
                        //.filter(asiento -> {
                            //if (asiento.getZona().equalsIgnoreCase("primera fila") && !suscripcion.getTipoSuscripcion().equals("Platinum")) {
                                //return false; // Si el asiento está en "primera fila", el cliente solo puede acceder si tiene una suscripción Platinum
                            //}
                            //if (asiento.getZona().equalsIgnoreCase("balcón") && suscripcion.getTipoSuscripcion().equals("por defecto")) {
                                //return false; // Suscripcion "Por defecto" no puede acceder al balcón
                            //}
                            //return !asiento.isReservado(); // Filtrar solo asientos no reservados
                        //})
                        //.toList();
            //}
            
            //Asignar asiento especial a cliente
        
    
    public void asignarAsientoEspecial(Evento evento) {
        // Obtener un asiento disponible en la zona de Balcón
        Asiento asientoEspecial = evento.obtenerAsientoPorZona(ZonaAsiento.Palco);

        if (asientoEspecial != null && asientoEspecial.esDisponible()) {
            // Asignar el asiento al cliente y marcarlo como reservado
            this.asientoAsignado = asientoEspecial;
            asientoEspecial.reservarAsiento();

            System.out.println("Se ha asignado el asiento especial: " +
                    asientoEspecial.getZona() + " (Precio: " + asientoEspecial.getPrecio() + ")");
        } else {
            System.out.println("No hay asientos disponibles en la zona de Palco.");
        }
    }

        public void otorgarFichasCompensacion(Asiento asientoSeleccionado){
            int nivelMaximo = determinarNivelMaximoPorSuscripcion();

            int nivelAsiento = determinarNivelPorZona(asientoSeleccionado.getZona());

        }

        private int determinarNivelMaximoPorSuscripcion() {
            switch (this.suscripcion.getTipoSuscripcion()) {
                case "Platinum":
                    return 4; //Tiene acceso a Palco
                case "Silver":
                    return 3; //Tiene acceso a Balcón
                case "por defecto":
                    return 2; //Tiene acceso a Centro
                case "primera vez":
                    return 1; //Tiene acceso a Atrás
                default:
                    return 1; //Nivel más bajo por defecto
            }
        }

            // Método para determinar el nivel de un asiento según su zona
        private int determinarNivelPorZona(Asiento.ZonaAsiento zona) {
            switch (zona) {
                case Palco:
                    return 4;
                case Balcon:
                    return 3;
                case Centro:
                    return 2;
                case Atras:
                    return 1;
                default:
                    return 1; // Nivel más bajo por defecto
        }
    }
    

    // Getters y Setters

    public String getNombreCliente() {
        return this.nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getEdadCliente() {
        return this.edadCliente;
    }

    public void setEdadCliente(int edadCliente) {
        this.edadCliente = edadCliente;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getSaldo() {
        return this.saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Auto getAuto() {
        return this.auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public int getFichas() {
        return this.fichas;
    }

    public void setFichas(int fichas) {
        this.fichas = fichas;
    }

    public int getNumeroVisitas() {
        return this.numeroVisitas;
    }

    public void setNumeroVisitas(int numeroVisitas) {
        this.numeroVisitas = numeroVisitas;
    }

    public Suscripcion getSuscripcion() {
        return this.suscripcion;
    }

    public void setSuscripcion(Suscripcion suscripcion) {
        this.suscripcion = suscripcion;
    }

    public boolean isFidelidadBar() {
        return this.fidelidadBar;
    }

    public boolean getFidelidadBar() {
        return this.fidelidadBar;
    }

    public void setFidelidadBar(boolean fidelidadBar) {
        this.fidelidadBar = fidelidadBar;
    }

    public int getPropinasBar() {
        return this.propinasBar;
    }

    public void setPropinasBar(int propinasBar) {
        this.propinasBar = propinasBar;
    }

    public Bebida getBebidaFavorita() {
        return this.bebidaFavorita;
    }

    public void setBebidaFavorita(Bebida bebidaFavorita) {
        this.bebidaFavorita = bebidaFavorita;
    }

    public boolean isFidelidadArtista() {
        return this.fidelidadArtista;
    }

    public boolean getFidelidadArtista() {
        return this.fidelidadArtista;
    }

    public void setFidelidadArtista(boolean fidelidadArtista) {
        this.fidelidadArtista = fidelidadArtista;
    }

    public int getPropinasArtista() {
        return this.propinasArtista;
    }

    public void setPropinasArtista(int propinasArtista) {
        this.propinasArtista = propinasArtista;
    }

    public ArrayList<Cuenta> getCuentas() {
        return this.cuentas;
    }

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public RegistroJuego getRegistroJuego() {
        return this.registroJuego;
    }

    public void setRegistroJuego(RegistroJuego registroJuego) {
        this.registroJuego = registroJuego;
    }

    public Asiento getAsientoAsignado(){
        return asientoAsignado;
    }

    public void setAsientoAsignado(Asiento asientoAsignado){
        this.asientoAsignado = asientoAsignado;
    }
}