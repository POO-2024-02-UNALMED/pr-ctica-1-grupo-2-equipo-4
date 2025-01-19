package gestorAplicacion.Servicios;

public class Cuenta {
    private List<String> descripciones; // Lista de descripciones de los gastos
    private List<Double> precios;       // Lista de precios de los gastos

    // Constructor
    public Cuenta() {
        this.descripciones = new ArrayList<>();
        this.precios = new ArrayList<>();
    }

    // Método para registrar un gasto
    public void registrarGasto(String descripcion, double precio) {
        descripciones.add(descripcion);
        precios.add(precio);
    }

    // Método para generar la factura
    public String generarFactura(double descuentoPorcentaje) {
        StringBuilder factura = new StringBuilder();
        factura.append("----- Factura Detallada -----\n");

        double total = 0.0;

        // Agregar los gastos a la factura
        for (int i = 0; i < descripciones.size(); i++) {
            factura.append(descripciones.get(i))
                   .append(": $")
                   .append(String.format("%.2f", precios.get(i)))
                   .append("\n");
            total += precios.get(i);
        }

        // Calcular y aplicar el descuento
        double descuento = (total * descuentoPorcentaje) / 100;
        double totalConDescuento = total - descuento;

        factura.append("-----------------------------\n");
        factura.append("Subtotal: $").append(String.format("%.2f", total)).append("\n");
        factura.append("Descuento (").append(descuentoPorcentaje).append("%): $").append(String.format("%.2f", descuento)).append("\n");
        factura.append("Total a Pagar: $").append(String.format("%.2f", totalConDescuento)).append("\n");
        factura.append("-----------------------------");

        return factura.toString();
    }

    // Método para reiniciar la cuenta después del pago
    public void reiniciarCuenta() {
        descripciones.clear();
        precios.clear();
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
