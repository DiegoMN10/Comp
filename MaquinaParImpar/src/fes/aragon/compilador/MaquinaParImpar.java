package fes.aragon.compilador;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class MaquinaParImpar {

    private ArrayList<String> palabras = new ArrayList<>();

    public void addPalabras(String nombreArchivo) {
        try {
            URL url = getClass().getResource(nombreArchivo);
            if (url == null) {
                throw new IllegalArgumentException("El archivo '" + nombreArchivo + "' no se encontró en el classpath.");
            }
            String rutaArchivo = url.getFile();
            try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    palabras.add(linea.trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void identificarParImpar(String palabra) {
        if (palabra.length() == 1) {
            char c = palabra.charAt(0);
            if (c == '1') {
                System.out.println("'" + palabra + "' no es par de unos ni tampoco impar de ceros");
            } else if (c == '0') {
                System.out.println("'" + palabra + "' no es par de unos ni tampoco impar de ceros");
            } else {
                System.out.println("'" + palabra + "' contiene caracteres no válidos");
            }
            return;
        }

        int countOnes = 0;
        int countZeros = 0;

        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);
            if (c == '1') {
                countOnes++;
            } else if (c == '0') {
                countZeros++;
            } else {
                System.out.println("'" + palabra + "' contiene caracteres no válidos");
                return;
            }
        }

        if (countOnes % 2 == 0 && countZeros % 2 == 1) {
            System.out.println("'" + palabra + "' es par de unos e impar de ceros");
        } else if (countOnes % 2 == 0) {
            System.out.println("'" + palabra + "' es par de unos");
        } else if (countZeros % 2 == 1) {
            System.out.println("'" + palabra + "' es impar de ceros");
        } else {
            System.out.println("'" + palabra + "' es par de unos e impar de ceros");
        }
    }

    public void probarLista() {
        for (String palabra : palabras) {
            System.out.println("_________________________");
            System.out.println("Palabra: " + palabra);
            identificarParImpar(palabra);
        }
    }
}
