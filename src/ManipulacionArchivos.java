import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ManipulacionArchivos {

    public static int countFileLines(String name) {
        File archivo; // Apunta a un archivo físico de dd
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

    public static void writeFile(String name) {
        // apuntador a un espacio físico del disco duro
        FileWriter archivo;
        // La llave de acceso para escribir el archivo
        PrintWriter writer;
        // Para escribir de teclado al DD
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        char respuesta;

        try {
            // Apuntador al archivo que se va a crear
            archivo = new FileWriter("C:\\archivos\\" + name + ".txt");
            // Abrir el archivo en modo escritura
            writer = new PrintWriter(archivo);
            do {
                System.out.println("Escribe algo para guardar al archivo: ");
                entrada = bufer.readLine();
                // Agregar o guardar al archivo
                writer.println(entrada);
                System.out.println("Escribe x para parar, cualquier otra tecla pra continuar: ");
                entrada = bufer.readLine();
                respuesta = entrada.charAt(0);
            } while (respuesta != 'x');
            archivo.close();
        } catch (Exception e) {
            System.out.println("Error al escribir el archivo:" + e.toString());
        }

    }

    public static void main(String[] args) throws IOException {

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

        System.out.println("Lectura de datos numéricos: ");
        System.out.println("Escribe el nombre del archivo: ");
        fileName = (bufer.readLine());
        numeros = fileToIntArray(fileName);
        System.out.println("Contenido del arreglo de números");
        for (int unNumero : numeros) {
            System.out.println(unNumero);
        }

        System.out.println("Crear un archivo de texto");
        System.out.println("Escribe el nombre del archivo a crear: ");
        fileName = bufer.readLine();
        writeFile(fileName);
    }

}