package gestorAplicacion.Servicios;

import gestorAplicacion.Servicios.Bebida;
import gestorAplicacion.personal.Cliente;
import gestorAplicacion.personal.Bartender;

public class Cuenta {
    private boolean pagada;
    private List<String> descripciones; // Lista de descripciones de los gastos
    private List<Double> precios;       // Lista de precios de los gastos

    // Constructor
    public Cuenta() {
        this.descripciones = new ArrayList<>();
        this.precios = new ArrayList<>();
    }

    // Método para registrar un gasto
    public void registrarGasto(String descripcion, double precio) {
        this.descripciones.add(descripcion);
        this.precios.add(precio);
    }


    // Método para generar la factura con descuento y propina
    public String generarFacturaBar(Bebida bebida, Cliente cliente, double montoPropina, Bartender bartender) {
        StringBuilder factura = new StringBuilder();
        factura.append("----- Factura Detallada -----\n");

        double total = bebida.getPrecio();

        // Obtener descuentos
        double descuentoPorFidelidad = cliente.obtenerDescuentoPorFidelidadBar() * 100; // 5% si tiene fidelidad en el bar
        double descuentoPorSuscripcion = cliente.getSuscripcion().getDescuento() * 100; 

        // Calcular el total con descuentos
        double descuentoTotal = descuentoPorFidelidad + descuentoPorSuscripcion;
        double totalConDescuento = total * (1 - (descuentoTotal / 100));

        // Agregar los detalles de la factura
        factura.append(bebida.getNombre())
               .append(": $")
               .append(String.format("%.2f", total))
               .append("\n");

        if (descuentoPorFidelidad > 0) {
            factura.append("Descuento por Fidelidad: -$")
                   .append(String.format("%.2f", total * (descuentoPorFidelidad / 100)))
                   .append("\n");
        }

        if (descuentoPorSuscripcion > 0) {
            factura.append("Descuento por Suscripción: -$")
                   .append(String.format("%.2f", total * (descuentoPorSuscripcion / 100)))
                   .append("\n");
        }

        factura.append("-----------------------------\n");
        factura.append("Total a Pagar: $")
               .append(String.format("%.2f", totalConDescuento))
               .append("\n");
        factura.append("-----------------------------");

        registrarGasto(bebida.getNombre(), totalConDescuento);
        cliente.getCuentas.add(this); 
        
        cliente.setBebidaFavorita(bartender.evaluarBebidaFavorita(cliente.getCuentas()));
        return factura.toString();
    }

    // Método para reiniciar la cuenta después del pago
    public void reiniciarCuenta() {
        descripciones.clear();
        precios.clear();
    }

    public boolean isPagada() {
        return this.pagada;
    }

    public boolean getPagada() {
        return this.pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    public List<String> getDescripciones() {
        return this.descripciones;
    }

    public void setDescripciones(List<String> descripciones) {
        this.descripciones = descripciones;
    }

    public List<Double> getPrecios() {
        return this.precios;
    }

    public void setPrecios(List<Double> precios) {
        this.precios = precios;
    }

}
