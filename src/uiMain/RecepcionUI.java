package uiMain;

import gestorAplicacion.Servicios.Bebida;
import gestorAplicacion.personal.Cliente;

public interface RecepcionUI {
    // Pregunta al cliente por el modelo de su auto
    String pedirModelo();

    // Pregunta al cliente por la placa de su auto
    String pedirPlaca();

    // Pregunta al cliente por su ID
    long pedirID();
    
    // Pregunta al cliente por la columna del estacionamiento
    int pedirColumna();

    // Pregunta al cliente por la fila del estacionamiento
    int pedirFila();

    // Pregunta al cliente por su edad
    int pedirEdad();

    // Pregunta al cliente por su saldo
    float pedirSaldo();

    // Pregunta al cliente por su nombre
    String pedirNombre();

    // Pregunta por el numero de fichas que desea cambiar
    float cambiarFichas(Cliente cliente);

    void encuestaBebidaBienvenida(Bebida bebida);
}
