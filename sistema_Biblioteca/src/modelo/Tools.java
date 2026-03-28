package modelo;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.InputMismatchException;

//Clase unica
public class Tools {

    //Variables para dar color al texto
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    //Variables para resetear el color de texto
    public static final String ANSI_RESET = "\u001B[0m";

    //Inicialización de objetos
    public Scanner scanner = new Scanner(System.in);
    public LocalDate fechaActual = LocalDate.now();

    //Metodo con Try Catch para poder leer enteros sin problemas
    public int leerEntero(Scanner scanner) {
        while (true) {
            try {
                int numero = scanner.nextInt();

                if (numero < 0) {
                    System.out.print(ANSI_RED +"Error: No se permiten números menores a 0. Intenta de nuevo: " + ANSI_RESET);
                    continue;
                }

                return numero;
            } catch (InputMismatchException e) {
                System.out.print(ANSI_RED + "Error, ingresa un valor numérico: " + ANSI_RESET);
                scanner.next(); // Limpia el error del buffer
            }
        }
    }
}
