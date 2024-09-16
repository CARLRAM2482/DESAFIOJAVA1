import java.util.Scanner;

public class GestionBancaria {
    static Scanner scanner = new Scanner(System.in);
    private double saldo;

    public GestionBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void consultarSaldo() {
        System.out.println("Su saldo actual es: $" + saldo);
    }

    public void depositar() {
        System.out.print("Ingrese la cantidad a depositar: $");
        double cantidad = scanner.nextDouble();
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito realizado correctamente. Saldo actual: $" + saldo);
        } else {
            System.out.println("No se puede depositar una cantidad negativa.");
        }
    }

    public void retirar() {
        System.out.print("Ingrese la cantidad a retirar: $");
        double cantidad = scanner.nextDouble();
        if (cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("Retiro realizado correctamente. Saldo actual: $" + saldo);
        } else {
            System.out.println("Fondos insuficientes para realizar el retiro.");
        }
    }

    public static void main(String[] args) {
        GestionBancaria cuenta = new GestionBancaria(1000); // saldo inicial de $1000

        int opcion;
        do {
            System.out.println("\n*** Gestión Bancaria ***");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Retirar dinero");
            System.out.println("3 - Depositar dinero");
            System.out.println("9 - Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    cuenta.consultarSaldo();
                    break;
                case 2:
                    cuenta.retirar();
                    break;
                case 3:
                    cuenta.depositar();
                    break;
                case 9:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente nuevamente.");
                    break;
            }
        } while (opcion != 9);
    }
}
