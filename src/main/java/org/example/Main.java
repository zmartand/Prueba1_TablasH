package org.example;

public class Main {
    public static void main(String[] args) {
        Diccionario diccionario = new Diccionario();
        diccionario.leerArchivo("palabras.csv");
        diccionario.imprimirTablaHash();
    }
}