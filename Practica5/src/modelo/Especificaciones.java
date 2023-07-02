/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author santiago
 */
public class Especificaciones {

    private Integer id;
    private String display;
    private String capacidadA;
    private String modelo;
    private Integer id_telefono;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getCapacidadA() {
        return capacidadA;
    }

    public void setCapacidadA(String capacidadA) {
        this.capacidadA = capacidadA;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getId_telefono() {
        return id_telefono;
    }

    public void setId_telefono(Integer id_telefono) {
        this.id_telefono = id_telefono;
    }
    
    @Override
    public String toString() {
        return "Marca{" + "display=" + display + ", capacidadA=" + capacidadA + ", modelo=" + modelo + '}';

    }

}
