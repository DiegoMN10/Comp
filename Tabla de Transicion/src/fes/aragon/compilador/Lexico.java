package fes.aragon.compilador;

public class Lexico {
    private int indice = 0;
    private int error = -1;
    private int aceptar = 1;

    // variables del AFD
    private int estado = 0;
    private int entrada = 0;
    private int[][] matrix = { { 2, 1, -1 }, { 1, 1, -1 }, { 2, 2, 1 } };

    private String token;

    public Lexico() {
    }

    public void setToken(String token) {
        this.token = token;
        indice = 0;
        estado = 0;
    }

    private char siguienteCaracter() {
        char c = ' ';
        if (indice < token.length()) {
            c = token.charAt(indice);
            indice++;
        }
        return c;
    }

    public int inicio() throws Exception {
        char c = ' ';
        do {
            c = siguienteCaracter();
            if (Herramienta.letra(c)) {
                entrada = 0;
            } else if (Herramienta.numero(c)) {
                entrada = 1;
            } else if (Herramienta.finCadena(c)) {
                entrada = 2;
            } else {
                error = 0;
            }
            if (error != 0) {
                estado = matrix[estado][entrada];
            } else {
                throw new Exception("Carácter no válido: " + c);
            }
        } while (!Herramienta.finCadena(c));
        return estado;
    }
}
