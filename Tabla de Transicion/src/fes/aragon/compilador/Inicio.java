package fes.aragon.compilador;

import java.io.BufferedReader;
import java.io.FileReader;

public class Inicio {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("fuente.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                Lexico app = new Lexico();
                app.setToken(line);
                int verifica = app.inicio();
                if (verifica == 1) {
                    System.out.println("Palabra '" + line + "' es Valida");
                } else {
                    System.out.println("Palabra '" + line + "' no es Valida");
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}