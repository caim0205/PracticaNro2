/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica4;

import control.listas.ListaEnlazada;
import static control.listas.ListaEnlazada.generarN;
import control.listas.exception.PosicionException;
import control.listas.exception.VacioException;
import control.ordenacion.MergeSort;
import control.ordenacion.QuickSort;

/**
 *
 * @author santiago
 */
public class Ejecutor {

    /*
     public static void imprimirArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }
  /*  
    public static ListaEnlazada<Integer> generarNumerosAleatorios(int n) {
        ListaEnlazada<Integer> numeros = new ListaEnlazada<>();

        for (int i = 0; i < n; i++) {
            int numero = (int) (Math.random() * 20000) + 1;
            numeros.insertarNodo(numero);
        }

        return numeros;
    }
     */
    public static void main(String[] args) {
    try {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();

        for (int i = 0; i < 20; i++) {
            int numero = generarN(1, 20);
            lista.insertarPosicion(numero, i);
        }

        System.out.println("Lista original:");
        lista.imprimir();

       
        QuickSort<Integer> quickSort = new QuickSort<>();
        quickSort.ordenar(lista, false);
        System.out.println("Ordenación Ascendente (Quick Sort):");
        lista.imprimir();

        
        quickSort.ordenar(lista, true );
        System.out.println("Ordenación Descendente (Quick Sort):");
        lista.imprimir();
    } catch (VacioException | PosicionException e) {
        e.printStackTrace();
    }
}

}

/*
        MergeSort<Integer> mergeSort = new MergeSort<>();
        mergeSort.ordenarAscendente(lista);
        System.out.println("Ordenacion Ascendente:");
        lista.imprimir();
        
        mergeSort.ordenarDescendente(lista);
        System.out.println("Ordenacion Descendente:");
        lista.imprimir();
 */
