package fes.aragon.compilador;

public class Main {
    public static void main(String[] args) {
        MaquinaParImpar maquina = new MaquinaParImpar();
        maquina.addPalabras("entradas.txt");
        maquina.probarLista();
    }
}
