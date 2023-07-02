/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.dao.EspecificacionesDao;
import controlador.dao.TelefonoDao;
import controlador.ed.listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Especificaciones;
import modelo.Telefono;

/**
 *
 * @author santiago
 */
public class ModeloTablaEspecificaciones extends AbstractTableModel {

    private ListaEnlazada<Especificaciones> lista = new ListaEnlazada<>();

    @Override
    public int getRowCount() {
        if (lista != null) {
            return lista.size();
        }
        return 0;
        //return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Especificaciones ep = null;
        Telefono tel = null;
        try {
            ep = lista.get(i);
            tel = new TelefonoDao().obtener(ep.getId_telefono());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        switch (i1) {
            case 0:
                return (tel != null) ? tel.getNombre() : "No definido";
            case 1:
                return (tel != null) ? ep.getModelo() : "No definido";
            case 2:
                return (ep != null) ? ep.getDisplay() : "No definido";
            case 3:
                return (ep != null) ? ep.getCapacidadA() : "No definido";
            default:
                return null;
        }

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Marca";
            case 1:
                return "Modelo";
            case 2:
                return "Display";
            case 3:
                return "Capacidad";
            default:
                return null;
        }
    }

    /**
     * @return the lista
     */
    public ListaEnlazada<Especificaciones> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(ListaEnlazada<Especificaciones> lista) {
        this.lista = lista;
    }

}
