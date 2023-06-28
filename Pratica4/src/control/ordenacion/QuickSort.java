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
public class QuickSort<E extends Comparable<E>> {

    public void ordenar(ListaEnlazada<E> lista, boolean ascendente) throws VacioException, PosicionException {
        quickSortRecursivo(lista, 0, lista.getSize() - 1, ascendente);
    }

    private void quickSortRecursivo(ListaEnlazada<E> lista, int bajo, int alto, boolean ascendente)
            throws VacioException, PosicionException {
        if (bajo >= alto) {
            return;
        }

        int indicePivote = particion(lista, bajo, alto, ascendente);
        quickSortRecursivo(lista, bajo, indicePivote - 1, ascendente);
        quickSortRecursivo(lista, indicePivote + 1, alto, ascendente);
    }

    private int particion(ListaEnlazada<E> lista, int bajo, int alto, boolean ascendente)
            throws VacioException, PosicionException {
        E pivote = lista.get(alto);
        int i = bajo;

        for (int j = bajo; j < alto; j++) {
            int resultadoComparacion = ascendente ? lista.get(j).compareTo(pivote) : pivote.compareTo(lista.get(j));
            if (resultadoComparacion >= 0) {
                intercambiar(lista, i, j);
                i++;
            }
        }

        intercambiar(lista, i, alto);
        return i;
    }

    private void intercambiar(ListaEnlazada<E> lista, int i, int j) throws VacioException, PosicionException {
        if (i != j) {
            E temp = lista.get(i);
            lista.modificar(lista.get(j), i);
            lista.modificar(temp, j);
        }
    }
}
