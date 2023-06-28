/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control.ordenacion;

import control.listas.ListaEnlazada;
import control.listas.exception.PosicionException;
import control.listas.exception.VacioException;

/**
 *
 * @author santiago
 */
public class MergeSort<E extends Comparable<E>>  {
    
    public void ordenarAscendente(ListaEnlazada<E> lista) throws VacioException, PosicionException {
        mergeSort(lista, false);
    }

    public void ordenarDescendente(ListaEnlazada<E> lista) throws VacioException, PosicionException {
        mergeSort(lista, true );
    }

    private void mergeSort(ListaEnlazada<E> lista, boolean ascendente) throws VacioException, PosicionException {
        if (lista.getSize() > 1) {
            ListaEnlazada<E> mitadIzquierda = new ListaEnlazada<>();
            ListaEnlazada<E> mitadDerecha = new ListaEnlazada<>();
            int medio = lista.getSize() / 2;

            for (int i = 0; i < medio; i++) {
                mitadIzquierda.insertarNodo(lista.get(i));
            }

            for (int i = medio; i < lista.getSize(); i++) {
                mitadDerecha.insertarNodo(lista.get(i));
            }

            mergeSort(mitadIzquierda, ascendente);
            mergeSort(mitadDerecha, ascendente);

            fusionar(lista, mitadIzquierda, mitadDerecha, ascendente);
        }
    }

    private void fusionar(ListaEnlazada<E> lista, ListaEnlazada<E> mitadIzquierda, ListaEnlazada<E> mitadDerecha,
            boolean ascendente) throws VacioException, PosicionException {
        lista.deleteAll();

        int tamanoIzquierda = mitadIzquierda.getSize();
        int tamanoDerecha = mitadDerecha.getSize();
        int indiceIzquierda = 0;
        int indiceDerecha = 0;

        while (indiceIzquierda < tamanoIzquierda && indiceDerecha < tamanoDerecha) {
            E elementoIzquierda = mitadIzquierda.get(indiceIzquierda);
            E elementoDerecha = mitadDerecha.get(indiceDerecha);

            int resultadoComparacion;
            if (ascendente) {
                resultadoComparacion = elementoIzquierda.compareTo(elementoDerecha);
            } else {
                resultadoComparacion = elementoDerecha.compareTo(elementoIzquierda);
            }

            if (resultadoComparacion <= 0) {
                lista.insertarNodo(elementoDerecha);
                indiceDerecha++;
            } else {
                lista.insertarNodo(elementoIzquierda);
                indiceIzquierda++;
            }
        }

        while (indiceIzquierda < tamanoIzquierda) {
            lista.insertarNodo(mitadIzquierda.get(indiceIzquierda));
            indiceIzquierda++;
        }

        while (indiceDerecha < tamanoDerecha) {
            lista.insertarNodo(mitadDerecha.get(indiceDerecha));
            indiceDerecha++;
        }
    }

 /*
    public static void mergeSort(ListaEnlazada<Integer> lista) throws VacioException, PosicionException {
        if (lista.size() < 2) {
            return;
        }

        ListaEnlazada<Integer> listaIzquierda = new ListaEnlazada<>();
        ListaEnlazada<Integer> listaDerecha = new ListaEnlazada<>();

        int medio = lista.size() / 2;
        for (int i = 0; i < medio; i++) {
            try {
                listaIzquierda.insertarNodo(lista.get(i));
            } catch (PosicionException e) {
                e.printStackTrace();
            }
        }
        for (int i = medio; i < lista.size(); i++) {
            try {
                listaDerecha.insertarNodo(lista.get(i));
            } catch (PosicionException e) {
                e.printStackTrace();
            }
        }

        mergeSort(listaIzquierda);
        mergeSort(listaDerecha);

        merge(lista, listaIzquierda, listaDerecha);
    }

    public static void merge(ListaEnlazada<Integer> lista, ListaEnlazada<Integer> listaIzquierda,
            ListaEnlazada<Integer> listaDerecha) throws PosicionException, VacioException {
        int i = 0, j = 0, k = 0;
        while (!listaIzquierda.isEmpty() && !listaDerecha.isEmpty()) {
            if (listaIzquierda.getCabecera().getInfo() <= listaDerecha.getCabecera().getInfo()) {
                lista.modificar(listaIzquierda.delete(0), k++);
            } else {
                lista.modificar(listaDerecha.delete(0), k++);
            }
        }
        while (!listaIzquierda.isEmpty()) {
            lista.modificar(listaIzquierda.delete(0), k++);
        }
        while (!listaDerecha.isEmpty()) {
            lista.modificar(listaDerecha.delete(0), k++);
        }
    }
*/
}
