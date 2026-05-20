/**
 * Clase de ejecucion interactiva que procesa las urgencias del hospital.
 * Implementa las dos variantes obligatorias de la rubrica: VectorHeap y JCF PriorityQueue.
 * @author Sebastian Rodas 25038
 * @version 1.0
 * @since 2026-05-19
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Paciente> miCola = new VectorHeap<>();
        java.util.PriorityQueue<Paciente> jcfCola = new java.util.PriorityQueue<>();
        String archivo = "pacientes.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    String nombre = partes[0].trim();
                    String sintoma = partes[1].trim();
                    String codigo = partes[2].trim();
                    Paciente p = new Paciente(nombre, sintoma, codigo);
                    miCola.add(p);
                    jcfCola.add(p);
                }
            }
            System.out.println("Archivo 'pacientes.txt' cargado con exito.");
        } catch (IOException e) {
            System.out.println("Error: No se pudo encontrar o leer el archivo 'pacientes.txt'.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int implementacion = 0;

        while (implementacion != 1 && implementacion != 2) {
            System.out.println("\nSeleccione la estructura a utilizar para la simulacion:");
            System.out.println("1. VectorHeap propio");
            System.out.println("2. Cola de prioridad");
            System.out.print("Opcion: ");
            try {
                implementacion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                implementacion = 0;
            }
        }

        System.out.println("\n--- SISTEMA DE CONTROL DE TRIAJE MEDICO ---");
        System.out.println("Presione ENTER para llamar al siguiente paciente en prioridad.");
        System.out.println("Escriba 'salir' y presione ENTER para finalizar la simulacion.");

        while (true) {
            if (implementacion == 1 && miCola.isEmpty()) {
                System.out.println("\nNo quedan mas pacientes en la cola de emergencias.");
                break;
            } else if (implementacion == 2 && jcfCola.isEmpty()) {
                System.out.println("\nNo quedan mas pacientes en la cola de emergencias.");
                break;
            }

            System.out.print("\nSiguiente > ");
            String entrada = scanner.nextLine().trim().toLowerCase();

            if (entrada.equals("salir")) {
                break;
            }

            Paciente proximo = null;
            if (implementacion == 1) {
                proximo = miCola.remove();
            } else {
                proximo = jcfCola.poll();
            }

            if (proximo != null) {
                System.out.println("Atendiendo a: " + proximo.getNombre());
                System.out.println("Sintomatologia: " + proximo.getSintoma());
                System.out.println("Prioridad Asignada: " + proximo.getCodigoEmergencia());
            }
        }

        System.out.println("Simulacion hospitalaria finalizada con exito.");
        scanner.close();
    }
}