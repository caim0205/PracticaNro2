/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.dao.conexion.Conexion;
import controlador.ed.listas.ListaEnlazada;
import controlador.ed.listas.exception.PosicionException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 *
 * @author santiago
 */
public class AdaptadorDao<E> {

    private Conexion conexion;
    private Class clazz;
    private String url;
    public static Integer Ascendente = 0;
    public static Integer Descendente = 1;

    public AdaptadorDao(Class clazz) {
        this.conexion = new Conexion();
        this.clazz = clazz;
        this.url = Conexion.URL + clazz.getSimpleName().toLowerCase() + ".json";
    }

    public void guardar(E obj) throws IOException {
        ListaEnlazada<E> lista = listar();
        lista.insertarNodo(obj);
        conexion.getXstream().alias(lista.getClass().getName(), ListaEnlazada.class);
        conexion.getXstream().toXML(lista, new FileWriter(url));
    }

    public void modificar(E obj, Integer pos) {
        ListaEnlazada<E> lista = listar();
        try {
            lista.modificar(obj, pos);
            conexion.getXstream().alias(lista.getClass().getName(), ListaEnlazada.class);
            conexion.getXstream().toXML(lista, new FileWriter(url));
        } catch (PosicionException | IOException ex) {
            Logger.getLogger(ex.getMessage());
        }
    }

    public ListaEnlazada listar() {
        ListaEnlazada<E> lista = new ListaEnlazada<>();
        try {
            lista = (ListaEnlazada<E>) conexion.getXstream().fromXML(new File(url));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return lista;
    }

    public E obtener(Integer id) {
        E obj = null;
        ListaEnlazada<E> lista = listar();
        // getValueField();
        for (int i = 0; i < lista.size(); i++) {
            try {
                E dato = lista.get(i);
                if (id.intValue() == ((Integer) getValueField(lista.get(i))).intValue()) {
                    obj = dato;
                    break;
                }
            } catch (Exception e) {
                System.out.println("Error en metodo " + e);
            }
        }
        return obj;
    }

    private Object getValueField(E dato) throws Exception {
        Method metodo = null;
        for (Method aux : this.clazz.getDeclaredMethods()) {
            if (aux.getName().toLowerCase().equalsIgnoreCase("getId")) {
                metodo = aux;

            }
        }

        if (metodo == null) {
            for (Method aux : this.clazz.getSuperclass().getDeclaredMethods()) {
                if (aux.getName().toLowerCase().equalsIgnoreCase("getId")) {
                    metodo = aux;
                }
            }

        }
        return metodo.invoke(dato);
    }

    public Integer generarId() {
        return listar().size() + 1;
    }

}
