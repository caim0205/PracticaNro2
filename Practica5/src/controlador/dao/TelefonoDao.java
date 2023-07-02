/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.ed.listas.ListaEnlazada;
import modelo.Telefono;

/**
 *
 * @author santiago
 */
public class TelefonoDao extends AdaptadorDao<Telefono> {

    private Telefono telefono;

    public TelefonoDao() {
        super(Telefono.class);
    }

    public Telefono getTelefono() {
        if (this.telefono == null) {
            this.telefono = new Telefono();
        }
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    public void guardar() throws Exception {
        telefono.setId(generateID());
        this.guardar(telefono);
    }

    public void modificar(Integer pos) throws Exception {
        this.modificar(telefono, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }
}
