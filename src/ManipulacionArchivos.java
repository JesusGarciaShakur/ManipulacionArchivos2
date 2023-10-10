import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Estudiante
 */
public class ManipulacionArchivos {

    public static int countFileLines(String name) {
        File archivo; // Apunta a un archivo fisico de dd
        FileReader reader; // Llave con permiso de solo lectura
        BufferedReader bufer; // Recuperar info. del archivo
        int numLineas = 0;
        try {
            archivo = new File("C:\\archivos\\" + name + ".txt");
            reader = new FileReader(archivo);
            bufer = new BufferedReader(reader);
            // Contar las lineas que contiene del archivo
            while ((bufer.readLine()) != null) {
                numLineas++;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo:" + e.toString());
        }
        return numLineas;

    }

    public static String[] fileToStringArray(String name) throws FileNotFoundException, IOException {
        File archivo; // Apunta a un archivo fisico de dd
        FileReader reader; // Llave con permiso de solo lectura
        BufferedReader bufer; // Recuperar info. del archivo
        String linea;
        String[] array = null;
        int t;
        int i = 0;

        try {
            // Obtenemos el tamaño del archivo
            t = countFileLines(name);

            array = new String[t];
            // Craer un apuntador al archivo fisico
            archivo = new File("C:\\archivos\\" + name + ".txt");
            // Abrir el archivo para lectura
            reader = new FileReader(archivo);
            // Configurar el bufer para leer datos del archivo
            bufer = new BufferedReader(reader);
            // Lectura del contenido del archivo
            while ((linea = bufer.readLine()) != null) {
                // System.out.println("Linea leida:" + linea);

                array[i] = linea;
                i++;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo:" + e.toString());
        }

        return array;

    }

    public static int[] fileToIntArray(String name) throws FileNotFoundException, IOException {
        File archivo; // Apunta a un archivo fisico de dd
        FileReader reader; // Llave con permiso de solo lectura
        BufferedReader bufer; // Recuperar info. del archivo
        String linea;
        int[] array = null;
        int t;
        int i = 0;

        try {
            t = countFileLines(name);

            array = new int[t];
            archivo = new File("C:\\archivos\\" + name + ".txt");
            reader = new FileReader(archivo);
            bufer = new BufferedReader(reader);
            while ((linea = bufer.readLine()) != null) {

                array[i] = Integer.parseInt(linea);
                i++;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo:" + e.toString());
        }

        return array;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        BufferedReader bufer = new BufferedReader(
                new InputStreamReader(System.in));
        String fileName;
        String[] mascotas;
        int[] numeros;

        System.out.println("Lectura de un archivo de texto");
        System.out.println("Escribe el nombre del archivo:");
        fileName = bufer.readLine();
        mascotas = fileToStringArray(fileName);
        System.out.println("Contenido del arreglo de mascotas:");
        for (String unaMascota : mascotas) {
            System.out.println(unaMascota);
        }

        System.out.println("Lectura de datos numericos: ");
        System.out.println("Escribe el nombre del archivo: ");
        fileName = (bufer.readLine());
        numeros = fileToIntArray(fileName);
        System.out.println("Contenido del arreglo d enuemros");
        for (int unNumero : numeros) {
            System.out.println(unNumero);
        }

    }

}