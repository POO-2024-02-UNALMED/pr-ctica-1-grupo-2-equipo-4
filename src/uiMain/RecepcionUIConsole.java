package uiMain;

import java.util.Scanner;

public class RecepcionUIConsole implements RecepcionUI {
    private Scanner scanner = new Scanner(System.in);

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
        return scanner.nextInt();
    }

    @Override
    public int pedirFila() {
        System.out.print("Por favor, ingrese la fila donde desea estacionar su auto: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. Por favor, ingrese un número entero para la fila: ");
            scanner.next();
        }
        return scanner.nextInt();
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
        return scanner.nextLong();
    }

    @Override
    public int pedirNombre() {
        System.out.print("Por favor, ingrese su nombre: ");
        return scanner.nextInt();
    }
}


