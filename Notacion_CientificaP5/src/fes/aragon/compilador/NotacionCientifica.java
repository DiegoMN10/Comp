package fes.aragon.compilador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NotacionCientifica {
    private static int indice=0;
    private String cadena="";
    private final int error=-1;
    private final int aceptado=1;
    public static void main(String[] args) throws IOException {
        char finCadena=';';
        int fila=1;
        NotacionCientifica app = new NotacionCientifica();
        FileReader fr = new FileReader("entradas.txt");
        BufferedReader br = new BufferedReader(fr);
        app.cadena= br.readLine();
        app.cadena+=finCadena;
        while(app.cadena!=null){
            int valor =app.estado_1();
            if(valor == app.aceptado){
                System.out.println(fila + "- " + app.cadena + " <--- Valida.");
            }
            else{
                System.out.println(fila + "- " + app.cadena + " <--- No valida.");
            }

            app.cadena= br.readLine();
            if (app.cadena!=null){
                app.cadena+=finCadena;
            }
            fila++;
            indice=0;
        }
    }

    private char siguienteCaracter(){
        char caracter = ' ';
        if(indice < cadena.length()){
            caracter=cadena.charAt(indice);
            indice++;
        }
        return caracter;
    }

    private int estado_0(){
        char c=siguienteCaracter();
        if(Herramienta.numero(c)){
            return estado_1();
        }else{
            return error;
        }
    }

    private int estado_1(){
        char c=siguienteCaracter();
        if(Herramienta.numero(c)){
            return estado_1();
        } else if (c=='.') {
            return estado_2();
        } else if (c=='e') {
            return estado_4();
        } else{
            return error;
        }
    }
    private int estado_2(){
        char c=siguienteCaracter();
        if(Herramienta.numero(c)){
            return estado_3();
        }else{
            return error;
        }
    }

    private int estado_3(){
        char c=siguienteCaracter();
        if(Herramienta.numero(c)){
            return estado_3();
        }else if (c=='e') {
            return estado_4();
        }else if (Herramienta.finCadena(c)) {
            return aceptado;
        }else{
            return error;
        }
    }

    private int estado_4(){
        char c=siguienteCaracter();
        if(Herramienta.numero(c)){
            return estado_6();
        }else if (c=='+'||c=='-') {
            return estado_5();
        }else{
            return error;
        }
    }
    private int estado_5(){
        char c=siguienteCaracter();
        if(Herramienta.numero(c)){
            return estado_6();
        }else{
            return error;
        }
    }

    private int estado_6(){
        char c=siguienteCaracter();
        if(Herramienta.numero(c)){
            return estado_6();
        }else if (Herramienta.finCadena(c)) {
            return aceptado;
        }else{
            return error;
        }
    }


}