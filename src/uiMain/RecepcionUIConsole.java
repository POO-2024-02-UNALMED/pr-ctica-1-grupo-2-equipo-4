package uiMain;

import gestorAplicacion.Servicios.Bebida;
import gestorAplicacion.personal.Cliente;
import java.util.Scanner;

public class RecepcionUIConsole implements RecepcionUI {
    public Scanner scanner = new Scanner(System.in);

    @Override
    public String pedirModelo() {
        System.out.print("Por favor, ingrese el modelo de su auto: ");
        return scanner.nextLine();
    }

    @Override
    public String pedirPlaca() {
        System.out.print("Por favor, ingrese la placa de su auto: ");
        return scanner.nextLine();
    }

    @Override
    public int pedirColumna() {
        System.out.print("Por favor, ingrese la columna donde desea estacionar su auto: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. Por favor, ingrese un número entero para la columna: ");
            scanner.next();
        }
        int columna = scanner.nextInt();
        scanner.nextLine();
        return columna;
    }

    @Override
    public int pedirFila() {
        System.out.print("Por favor, ingrese la fila donde desea estacionar su auto: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. Por favor, ingrese un número entero para la fila: ");
            scanner.next();
        }
        int fila = scanner.nextInt();
        scanner.nextLine();
        return fila;
    }

    @Override
    public int pedirEdad() {
        System.out.print("Por favor, ingrese su edad: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. Por favor, ingrese un número entero para su edad: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    @Override
    public float pedirSaldo() {
        System.out.print("Por favor, ingrese su saldo disponible: ");
        while (!scanner.hasNextFloat()) {
            System.out.print("Entrada inválida. Por favor, ingrese un número válido para su saldo: ");
            scanner.next();
        }
        return scanner.nextFloat();
    }

    @Override
    public long pedirID() {
        System.out.print("Por favor, ingrese su identificación (ID): ");
        while (!scanner.hasNextLong()) {
            System.out.print("Entrada inválida. Por favor, ingrese un número válido para su ID: ");
            scanner.next();
        }
        long id = scanner.nextLong();
        scanner.nextLine();
        return id;
    }

    @Override
    public String pedirNombre() {
        System.out.print("Por favor, ingrese su nombre: ");
        String nombre = scanner.nextLine();
        
        return nombre;
    }

    @Override
    public float cambiarFichas(Cliente cliente) {
        Scanner scanner = new Scanner(System.in); // Crear un único Scanner
        boolean noValido = true;
        float dinero = 0;
    
        while (noValido) {
            System.out.println("¿Cuánto dinero quieres cambiar por fichas? (1 ficha por cada 1000 pesos)");
            String entrada = scanner.nextLine(); // Leer la entrada del usuario
            
            // Validar que la entrada es un número positivo dentro del saldo del cliente
            if (entrada.matches("\\d+(\\.\\d+)?")) {
                dinero = Float.parseFloat(entrada);
    
                if (dinero > 0 && dinero <= cliente.getSaldo()) {
                    noValido = false; // Entrada válida, salir del bucle
                } else {
                    System.out.println("El monto ingresado no es válido. Ingrese un valor entre 0 y " + cliente.getSaldo() + " pesos.");
                }
            } else {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
        return dinero;
    }

    @Override
    public void encuestaBebidaBienvenida(Bebida bebida){
        System.out.println("que le parecio la bebida?");
        System.out.println("1. Buena");
        System.out.println("2. Regular");
        System.out.println("3. Mala");
        int respuesta = scanner.nextInt();
        switch (respuesta) {
            case 1:
                bebida.setFavorito((bebida.getFavorito()+1));
                break;
            case 2:
                break;
            case 3:
                bebida.setFavorito((bebida.getFavorito()-1)); 
                break;
            default:
                System.out.println("Respuesta no válida.");
        }
        System.out.println("Gracias por su recomendacion");
    }
}


