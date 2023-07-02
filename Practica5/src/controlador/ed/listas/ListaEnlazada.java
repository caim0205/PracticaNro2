/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ed.listas;
import controlador.ed.listas.exception.PosicionException;
import controlador.ed.listas.exception.VacioException;

/**
 *
 * @author santiago
 */
public class ListaEnlazada<E> {
    
     private NodoLista<E> cabecera;
    private Integer size = 0;
    
    public NodoLista<E> getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista<E> cabecera) {
        this.cabecera = cabecera;
    }

    public boolean isEmpty() {
        return cabecera == null;
    }

    public Integer size() {
        return size;
    }


    public void insertarNodo(E info) {
        NodoLista<E> nuevo = new NodoLista<>(info, null);
        if (isEmpty()) {
            this.cabecera = nuevo;
            this.size++;
        } else {
            NodoLista<E> aux = cabecera;
            while (aux.getSig() != null) {
                aux = aux.getSig();
            }
            aux.setSig(nuevo);
            this.size++;
        }
    }


    public void insertarInicio(E info) {
        if (isEmpty()) {
            insertarNodo(info);
        } else {
            NodoLista<E> nuevo = new NodoLista<>(info, null);
            nuevo.setSig(cabecera);
            cabecera = nuevo;
            size++;
        }
    }

  
    public void insertarPosicion(E info, Integer pos) throws PosicionException {
        if (isEmpty()) {
            insertarInicio(info);
        } else if (pos == 0) {
            insertarInicio(info);
        } else if (pos > 0 && pos < size()) {
            NodoLista<E> nuevo = new NodoLista<>(info, null);
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < (pos - 1); i++) {
                aux = aux.getSig();

            }
            NodoLista<E> sig = aux.getSig();
            aux.setSig(nuevo);
            nuevo.setSig(sig);
            size++;
        } else {
            throw new PosicionException();
        }
    }

    public E delete(Integer pos) throws PosicionException, VacioException {
    if (isEmpty()) {
        throw new VacioException();
    } else {
        E dato = null;
        if (pos >= 0 && pos < size()) {
            if (pos == 0) {
                dato = cabecera.getInfo();
                cabecera = cabecera.getSig();
                size--;
            } else {
                NodoLista<E> aux = cabecera;
                for (int i = 0; i < (pos - 1); i++) {
                    aux = aux.getSig();
                }
                NodoLista<E> nodoEliminar = aux.getSig();
                dato = nodoEliminar.getInfo();
                aux.setSig(nodoEliminar.getSig());
                size--;
            }
        } else {
            throw new PosicionException();
        }
        return dato;
        }
}
    

    public E get(Integer pos) throws VacioException, PosicionException {
        if (isEmpty()) {
            throw new VacioException();
        } else {
            E dato = null;
            if (pos >= 0 && pos < size()) {
                if (pos == 0) {
                    dato = cabecera.getInfo();
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < (pos); i++) {
                        aux = aux.getSig();
                    }
                    dato = aux.getInfo();
                }
            } else {
                throw new PosicionException();
            }
            return dato;
        }
    }
    

    public void modificar(E info, Integer pos) throws PosicionException {
        NodoLista<E> aux = cabecera;
        int indice = 0;

        while (aux != null) {
            if (indice == pos) {
                aux.setInfo(info);
                break;
            }
            aux = aux.getSig();
            indice++;
        }
    }

 
    public void deleteAll() {
        this.cabecera = null;
        this.size = 0;
    }


    public void imprimir() throws VacioException {
        if (isEmpty()) {
            throw new VacioException();
        } else {
            NodoLista<E> aux = cabecera;
            System.out.println("-----LISTA-----");
            for (int i = 0; i < size(); i++) {
                System.out.println(aux.getInfo() + "   ");
                aux = aux.getSig();
            }
            System.out.println("-----LISTA FIN-----");
        }
    }
    
    //transformar lista al arreglo
    public E[] toArray (){
        Class<E> clazz = null;
        E[] matriz = null;
        if (this.size > 0) {
            matriz = (E[]) java.lang.reflect.Array.newInstance(cabecera.getInfo().getClass(), this.size);
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < this.size; i++) {
                matriz[i] = aux.getInfo();
                aux = aux.getSig();
            }
        }
        return matriz;
    }
    
    public ListaEnlazada<E> toList(E[] matriz){
        this.deleteAll();
        for (int i = 0; i < matriz.length; i++) {
            this.insertarNodo(matriz[i]);
        }
        return this;
    }

  
}
