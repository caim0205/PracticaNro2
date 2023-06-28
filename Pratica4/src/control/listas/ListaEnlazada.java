/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control.listas;

import control.listas.exception.PosicionException;
import control.listas.exception.VacioException;

/**
 *
 * @author santiago
 */
public class ListaEnlazada<E> {

    private NodoLista<E> cabecera;
    private int size;

    public ListaEnlazada() {
        cabecera = null;
        size = 0;
    }

    public boolean isEmpty() {
        return getCabecera() == null;
    }

    public int size() {
        return getSize();
    }

    public void insertarNodo(E info) {
        NodoLista<E> nuevo = new NodoLista<>(info, null);
        if (isEmpty()) {
            setCabecera(nuevo);
            setSize(getSize() + 1);
        } else {
            NodoLista<E> aux = getCabecera();
            while (aux.getSig() != null) {
                aux = aux.getSig();
            }
            aux.setSig(nuevo);
            setSize(getSize() + 1);
        }
    }

    public void imprimir() {
        NodoLista<E> aux = getCabecera();
        System.out.println("-----LISTA-----");
        while (aux != null) {
            System.out.println(aux.getInfo());
            aux = aux.getSig();
        }
        System.out.println("-----LISTA FIN-----");
    }

    public static int generarN(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public E get(Integer pos) throws VacioException, PosicionException {
        if (isEmpty()) {
            throw new VacioException();
        } else {
            if (pos >= 0 && pos < size()) {
                NodoLista<E> aux = getCabecera();
                for (int i = 0; i < pos; i++) {
                    aux = aux.getSig();
                }
                return aux.getInfo();
            } else {
                throw new PosicionException();
            }
        }
    }

    public E delete(Integer pos) throws PosicionException, VacioException {
        if (isEmpty()) {
            throw new VacioException();
        } else {
            if (pos >= 0 && pos < size()) {
                if (pos == 0) {
                    E dato = getCabecera().getInfo();
                    setCabecera((NodoLista<E>) getCabecera().getSig());
                    setSize(getSize() - 1);
                    return dato;
                } else {
                    NodoLista<E> aux = getCabecera();
                    for (int i = 0; i < (pos - 1); i++) {
                        aux = aux.getSig();
                    }
                    NodoLista<E> nodoEliminar = aux.getSig();
                    E dato = nodoEliminar.getInfo();
                    aux.setSig(nodoEliminar.getSig());
                    setSize(getSize() - 1);
                    return dato;
                }
            } else {
                throw new PosicionException();
            }
        }
    }

    public void modificar(E info, Integer pos) throws PosicionException {
        if (isEmpty()) {
            throw new PosicionException();
        } else if (pos >= 0 && pos < size()) {
            NodoLista<E> aux = getCabecera();
            for (int i = 0; i < pos; i++) {
                aux = aux.getSig();
            }
            aux.setInfo(info);
        } else {
            throw new PosicionException();
        }
    }

    public void deleteAll() {
        setCabecera(null);
        setSize(0);
    }

    public void insertarInicio(E info) {
        NodoLista<E> nuevo = new NodoLista<>(info, getCabecera());
        setCabecera(nuevo);
        setSize(getSize() + 1);
    }

    public void insertarPosicion(E info, Integer pos) throws PosicionException {
        if (pos >= 0 && pos <= size()) {
            if (pos == 0) {
                insertarInicio(info);
            } else {
                NodoLista<E> nuevo = new NodoLista<>(info, null);
                NodoLista<E> aux = getCabecera();
                for (int i = 0; i < (pos - 1); i++) {
                    aux = aux.getSig();
                }
                nuevo.setSig(aux.getSig());
                aux.setSig(nuevo);
                setSize(getSize() + 1);
            }
        } else {
            throw new PosicionException();
        }
    }

    /**
     * @return the cabecera
     */
    public NodoLista<E> getCabecera() {
        return cabecera;
    }

    /**
     * @param cabecera the cabecera to set
     */
    public void setCabecera(NodoLista<E> cabecera) {
        this.cabecera = cabecera;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    
}
