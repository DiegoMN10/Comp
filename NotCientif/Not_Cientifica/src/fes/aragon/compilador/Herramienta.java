package fes.aragon.compilador;

public class Herramienta {
    public static boolean letra(char c){
        boolean letra=false;
        if((c>=97 && c<=122) || c>=65 && c<=90){
            System.out.println("letra");
            letra = true;
        }
        return letra;
    }

    public static boolean numero(char c){
        boolean numero=false;
        if(c>=48 && c<=57){
            numero = true;
        }
        return numero;
    }

    public static boolean finCadena(char c){
        boolean fc=false;
        if(c==';'){
            fc = true;
        }
        return fc;
    }
}
