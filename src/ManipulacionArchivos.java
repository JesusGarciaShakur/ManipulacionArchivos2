import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ManipulacionArchivos {

    public static int countFileLine(String name) {
        File archivo;
        FileReader reader;
        BufferedReader bufer;

        int numLinea = 0;

        try {
            archivo = new File("C:\\archivos\\" + name + ".txt");
            reader = new FileReader(archivo);
            bufer = new BufferedReader(reader);

            while ((bufer.readLine()) != null) {
                numLinea++;
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo" + e.toString());
        }

        return numLinea;
    }

    public static String[] fileToStringArray(String name) throws IOException {
        File archivo;
        FileReader reader;
        BufferedReader bufer;
        String linea;
        String[] array = null;
        int t;
        int i = 0;

        try {
            t = countFileLine(name);
            array = new String[t];

            archivo = new File("C:\\archivos\\" + name + ".txt");
            reader = new FileReader(archivo);
            bufer = new BufferedReader(reader);

            while ((linea = bufer.readLine()) != null) {
                array[i] = linea;
                i++;
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo" + e.toString());
        }

        return array;
    }

    public static int[] fileToIntArray(String name) throws IOException {
        File archivo;
        FileReader reader;
        BufferedReader bufer;
        String linea;
        int[] array = null;
        int t;
        int i = 0;

        try {
            t = countFileLine(name);
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
            System.out.println("Error al leer el archivo" + e.toString());
        }

        return array;
    }

    public static double[] fileToDoubleArray(String name) throws IOException {
        File archivo;
        FileReader reader;
        BufferedReader bufer;
        String linea;
        double[] array = null;
        int t;
        int i = 0;

        try {
            t = countFileLine(name);
            array = new double[t];

            archivo = new File("C:\\archivos\\" + name + ".txt");
            reader = new FileReader(archivo);
            bufer = new BufferedReader(reader);

            while ((linea = bufer.readLine()) != null) {
                array[i] = Double.parseDouble(linea);
                i++;
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo" + e.toString());
        }

        return array;
    }

    public static boolean[] fileToBooleanArray(String name) throws IOException {
        File archivo;
        FileReader reader;
        BufferedReader bufer;
        String linea;
        boolean[] array = null;
        int t;
        int i = 0;

        try {
            t = countFileLine(name);
            array = new boolean[t];

            archivo = new File("C:\\archivos\\" + name + ".txt");
            reader = new FileReader(archivo);
            bufer = new BufferedReader(reader);

            while ((linea = bufer.readLine()) != null) {
                array[i] = Boolean.parseBoolean(linea);
                i++;
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo" + e.toString());
        }

        return array;
    }

    public static void writeKeyboardToFile(String name) {
        FileWriter archivo;
        PrintWriter writer;
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        char respuesta;

        try {
            archivo = new FileWriter("C:\\archivos\\" + name + ".txt");
            writer = new PrintWriter(archivo);

            do {
                System.out.println("Escribe el contenido del archivo");
                entrada = bufer.readLine();
                writer.println(entrada);

                System.out.println("Escribe la letra X para detener, cualquier otra tecla llena el archivo");
                entrada = bufer.readLine();
                respuesta = entrada.toLowerCase().charAt(0);
            } while (respuesta != 'x');

            archivo.close();
        } catch (Exception e) {
            System.out.println("Error al escribir el archivo" + e.toString());
        }
    }

    // Crear un archivo con información de un arreglo
    public static void writeArrayToFile(String name, int[] array) {
        FileWriter archivo;
        PrintWriter writer;

        try {
            archivo = new FileWriter("C:\\archivos\\" + name + ".txt");
            writer = new PrintWriter(archivo);
            // Guardar el arreglo a un archivo
            for (int unDato : array) {
                writer.println(unDato);
            }
            archivo.close();
        } catch (Exception e) {
            System.out.println("Error al escribir el archivo" + e.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));

        String fileName;
        String[] mascotas;
        int[] num;
        int[] numx3;

        System.out.println("Lectura de datos String");
        System.out.println("-----------------------------");
        System.out.println("Escribe el nombre del archivo");
        System.out.println("-----------------------------");
        fileName = bufer.readLine();
        mascotas = fileToStringArray(fileName);
        System.out.println("Contenido del arreglo de juegos");
        for (String unlinea : mascotas) {
            System.out.println(unlinea);
        }

        System.out.println("Lectura de datos enteros");
        System.out.println("-----------------------------");
        System.out.println("Escribe el nombre del archivo");
        System.out.println("-----------------------------");
        fileName = bufer.readLine();
        num = fileToIntArray(fileName);
        System.out.println("Contenido del arreglo de números enteros");
        for (int numi : num) {
            System.out.println(numi);
        }

        // System.out.println("Lectura de datos doubles");
        // System.out.println("-----------------------------");
        // System.out.println("Escribe el nombre del archivo");
        // System.out.println("-----------------------------");
        // fileName = bufer.readLine();
        // doubles = fileToDoubleArray(fileName);
        // System.out.println("Contenido del arreglo doubles");
        // for (double d : doubles) {
        // System.out.println(d);
        // }

        // System.out.println("Lectura de datos booleans");
        // System.out.println("-----------------------------");
        // System.out.println("Escribe el nombre del archivo");
        // System.out.println("-----------------------------");
        // fileName = bufer.readLine();
        // booleans = fileToBooleanArray(fileName);
        // System.out.println("Contenido del arreglo de valores booleans");
        // for (boolean b : booleans) {
        // System.out.println(b);
        // }
        // Crear y llenar arreglo numx3
        System.out.println("Numeros X3");
        numx3 = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            numx3[i] = num[i] * 3;
            System.out.println("numeros3[" + i + "]: " + numx3[i]);
        }
        System.out.println("Escribe el nombre del archivo de numeros X3: ");
        fileName = bufer.readLine();
        writeArrayToFile(fileName, numx3);

        // System.out.println("Crear un archivo de texto");
        // System.out.println("-----------------------------");
        // System.out.println("Ingresa el nombre del archivo");
        // System.out.println("-----------------------------");
        // fileName = bufer.readLine();
        // writeFile(fileName);
    }
}