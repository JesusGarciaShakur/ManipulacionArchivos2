import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import files.Files;

public class ManipulacionArchivos {

    public static void main(String[] args) throws IOException {
        Files files = new Files();
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
        mascotas = files.fileToStringArray(fileName);
        System.out.println("Contenido del arreglo de juegos");
        for (String unlinea : mascotas) {
            System.out.println(unlinea);
        }

        System.out.println("Lectura de datos enteros");
        System.out.println("-----------------------------");
        System.out.println("Escribe el nombre del archivo");
        System.out.println("-----------------------------");
        fileName = bufer.readLine();
        num = files.fileToIntArray(fileName);
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
        files.writeArrayToFile(fileName, numx3);

        // System.out.println("Crear un archivo de texto");
        // System.out.println("-----------------------------");
        // System.out.println("Ingresa el nombre del archivo");
        // System.out.println("-----------------------------");
        // fileName = bufer.readLine();
        // writeFile(fileName);
    }
}