package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class TablasHash {
    // Representación de la tabla como un arreglo de listas enlazadas
    private ArrayList<LinkedList<String>> tabla;
    private int tamaño;

    public TablasHash(int tamaño) {
        this.tamaño = tamaño;
        tabla = new ArrayList<>(tamaño);
        for (int i = 0; i < tamaño; i++) {
            tabla.add(new LinkedList<>());
        }
    }

    public void agregar(String dato) {
        int posicion = funcion_hash(dato, tamaño);
        LinkedList<String> lista = tabla.get(posicion);
        if (lista.contains(dato)) {
            return; // El elemento ya se encuentra en la tabla
        }
        lista.add(dato);
    }

    public String quitar(String dato) {
        int posicion = funcion_hash(dato, tamaño);
        LinkedList<String> lista = tabla.get(posicion);
        if (lista.contains(dato)) {
            lista.remove(dato);
            return dato;
        }
        return null; // El elemento no se encontró en la tabla
    }

    public int buscar(String dato) {
        int posicion = funcion_hash(dato, tamaño);
        LinkedList<String> lista = tabla.get(posicion);
        if (lista.contains(dato)) {
            return posicion;
        }
        return -1; // El elemento no se encontró en la tabla
    }

    private int funcion_hash(String dato, int tamaño_tabla) {
        // Implementación de la función hash utilizando el primer carácter del dato
        int ascii = (int) dato.charAt(0);
        return ascii % tamaño_tabla;
    }

    private int sondeo(int posicion, int tamaño_tabla) {
        // Implementación de la función de sondeo utilizando la técnica lineal
        return (posicion + 1) % tamaño_tabla;
    }

    public int cantidad_elementos() {
        int contador = 0;
        for (LinkedList<String> lista : tabla) {
            contador += lista.size();
        }
        return contador;
    }
}