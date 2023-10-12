package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Files {
    public int countFileLine(String name) {
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

    public String[] fileToStringArray(String name) throws IOException {
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

    public int[] fileToIntArray(String name) throws IOException {
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

    public double[] fileToDoubleArray(String name) throws IOException {
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

    public boolean[] fileToBooleanArray(String name) throws IOException {
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

    public void writeKeyboardToFile(String name) {
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
    public void writeArrayToFile(String name, int[] array) {
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
}