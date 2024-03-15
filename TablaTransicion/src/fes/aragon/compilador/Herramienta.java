package fes.aragon.compilador;

class Herramienta {
    public static boolean letra(char c) {
        return (c >= 97 && c <= 122) || (c >= 65 && c <= 90);
    }

    public static boolean numero(char c) {
        return (c >= 48 && c <= 57);
    }

    public static boolean finCadena(char c) {
        return (c == ';' || c == ' ');
    }
}