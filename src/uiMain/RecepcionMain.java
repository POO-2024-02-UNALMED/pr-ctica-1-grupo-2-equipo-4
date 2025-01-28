package uiMain;

import gestorAplicacion.Servicios.Auto;
import gestorAplicacion.Servicios.Bebida;
import gestorAplicacion.Servicios.Casino;
import gestorAplicacion.Servicios.Ingrediente;
import gestorAplicacion.personal.Bartender;
import gestorAplicacion.personal.Cliente;
import gestorAplicacion.personal.Recepcionista;
import gestorAplicacion.personal.Valet;
import java.util.ArrayList;

public class RecepcionMain {
    public static Cliente funcionalidadRecepcion(){//funcionalidadRecepcion(){
        RecepcionUI consola = new RecepcionUIConsole();
        //inicializar objetos para el test
        Valet valet = new Valet("Valet", "Estacionamiento");
        Recepcionista recepcionista = new Recepcionista("Recepcionista", "Recepcion");

        // inicializacion bartender
        /* ArrayList<Ingrediente> ingredientes = new ArrayList<>();
        Ingrediente ingrediente1 = new Ingrediente("agua");
        ingredientes.add(ingrediente1);

        Bebida bebidaAgua = new Bebida("agua", 2000, false, false, false, false, 2, ingredientes);
        ArrayList<Ingrediente> barraIngredientesBar = new ArrayList<>();
        ArrayList<Bebida> barraBebidasBar = new ArrayList<>();
        barraIngredientesBar.add(ingrediente1);
        barraBebidasBar.add(bebidaAgua);
        Bartender bartender = new Bartender("bartender","barra",barraBebidasBar,barraIngredientesBar); */
        Bartender bartender = new Bartender("bartender","barra");

        // interaccion 1
        Auto auto = null;
        System.out.println("Bienvenido, porfavor deme su identificacion para ver si tiene un registro en el casino");
        long id = consola.pedirID();
        Cliente clienteOld = Valet.identificarCliente(id); 
        if (clienteOld!= null){
            System.out.println("Hola " + clienteOld.getNombreCliente() + "! Bienvenido al casino");
        }else{
            System.out.println("no hay registros para esa identificacion");
        }
        
    
        String modelo = consola.pedirModelo();
        System.out.println("modelo " + modelo);
        String placa = consola.pedirPlaca();
        System.out.println("placa " + placa);
        Casino.inicializarEstacionamiento(5,5);

        if (clienteOld != null){
            System.out.println(Casino.mostrarEspaciosEstacionamiento(clienteOld.getSuscripcion()));
        }else{
            System.out.println(Casino.mostrarEspaciosEstacionamiento(null));
        }
        
        int columna = 0;
        int fila = 0;
        while(auto == null){
            columna = consola.pedirColumna();
            fila = consola.pedirFila();
            auto = valet.estacionarRegistrarAuto(modelo, placa, columna, fila, id);//metodo principal interaccion 1
        }
        System.out.println("auto estacionado en [" +columna+","+fila+"]");
        System.out.println("su "+ modelo + " con placa "+ placa + " fue estacionado correctamente");
        
        // interaccion 2
        Cliente clienteNow = null;
        String nombre;
        if (clienteOld == null){
            nombre = consola.pedirNombre();
        }else{
            nombre = clienteOld.getNombreCliente();
        }
        float saldo = consola.pedirSaldo();

        while(clienteNow == null){
            int edad = consola.pedirEdad();
            clienteNow = recepcionista.registrarCliente(edad, saldo, id, nombre, auto);//metodo principal interaccion 2
        }
        System.out.println("ha sido registrado exitosamente, "+ clienteNow.getNombreCliente());
        float dineroACambiar = consola.cambiarFichas(clienteNow);
        recepcionista.cambiarFichas(clienteNow, dineroACambiar);
        System.out.println("Has cambiado " + dineroACambiar + " pesos por " + clienteNow.getFichas() + " fichas.");

        // interaccion 3
        Bebida bebidaBienvenida = bartender.prepararBebidaBienvenida(clienteNow);//metodo principal interaccion 3
        System.out.println("porfavor, reciba esta " + bebidaBienvenida.getNombre() + " que le preparamos especialmente para darle la bienvenida");
        System.out.println(bebidaBienvenida.toString());
        consola.encuestaBebidaBienvenida(bebidaBienvenida);
        System.out.println("ya puede acceder a las instalaciones del casino, disfrute su estadía");

        return clienteNow;
    }
}