package gestorAplicacion.Servicios.juegos;

import gestorAplicacion.personal.Cliente;

public class Blackjack extends Juego {
    private int acumulado;

    public Blackjack(int apuesta, float riesgo) {
        super(apuesta, riesgo);
        this.acumulado = 0;
    }

    @Override
    public void jugar(Cliente cliente) {
        // se verifica que el monto de la apuesta sea menor o igual a la cantidad de
        // fichas del cliente
        int montoApuesta = this.apuesta;
        int fichasCliente = cliente.getFichas();
        if (fichasCliente >= montoApuesta) {
            cliente.setFichas(fichasCliente - montoApuesta);
        }
    }
}