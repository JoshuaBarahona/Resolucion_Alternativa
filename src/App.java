import java.util.Scanner;

public class App {
    public static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Ingrese la cantidad de estudiantes a registrar: ");
        int numEstudiantes = leer.nextInt();
        leer.nextLine(); // Limpiar el buffer

        String[] nombresEstudiantes = new String[numEstudiantes];
        double[][] calificaciones = new double[numEstudiantes][6];

        // Entrada de datos para cada estudiante
        for (int i = 0; i < numEstudiantes; i++) {
            nombresEstudiantes[i] = obtenerNombreEstudiante(i + 1);
            ingresarCalificaciones(calificaciones[i]);
        }

        // Calcular promedios individuales y mostrar mensaje
        for (int i = 0; i < numEstudiantes; i++) {
            double promedioEstudiante = calcularPromedio(calificaciones[i]);
            mostrarResultados(nombresEstudiantes[i], promedioEstudiante);
        }
    }

    public static String obtenerNombreEstudiante(int numeroEstudiante) {
        System.out.println("Estudiante " + numeroEstudiante);
        System.out.print("Ingrese el nombre del estudiante: ");
        return leer.nextLine();
    }

    public static void ingresarCalificaciones(double[] calificaciones) {
        for (int j = 0; j < 6; j++) {
            try {
                System.out.print("Ingrese la calificación de la asignatura " + (j + 1) + ": ");
                calificaciones[j] = leer.nextDouble();
            } catch (Exception e) {
                System.out.println("Error al ingresar la calificación. Intente nuevamente.");
                j--; // Reintentar la misma asignatura
                leer.nextLine(); // Limpiar el buffer
            }
        }
        leer.nextLine(); // Limpiar el buffer después de ingresar las calificaciones
    }

    public static double calcularPromedio(double[] calificaciones) {
        double sumaCalificaciones = 0;
        for (double calificacion : calificaciones) {
            sumaCalificaciones += calificacion;
        }
        return sumaCalificaciones / calificaciones.length;
    }

    public static void mostrarResultados(String nombreEstudiante, double promedioEstudiante) {
        System.out.println("Estudiante: " + nombreEstudiante);
        System.out.println("Promedio: " + promedioEstudiante);
        if (promedioEstudiante >= 70.0) {
            System.out.println("Promedio satisfactorio.");
        } else {
            System.out.println("Promedio no satisfactorio.");
        }
    }
}