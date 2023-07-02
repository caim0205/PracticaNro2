/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.ed.listas.ListaEnlazada;
import modelo.Especificaciones;
import modelo.Telefono;

/**
 *
 * @author santiago
 */
public class EspecificacionesDao extends AdaptadorDao<Especificaciones> {

    private Especificaciones especificaciones;

    public EspecificacionesDao() {
        super(Especificaciones.class);
    }

    public Especificaciones getEspecificaciones() {
        if (this.especificaciones == null) {
            this.especificaciones = new Especificaciones();
        }
        return especificaciones;
    }

    public void setEspecificaciones(Especificaciones especificaciones) {
        this.especificaciones = especificaciones;
    }

    public void guardar() throws Exception {
        especificaciones.setId(generateID());
        this.guardar(especificaciones);
    }

    public void modificar(Integer pos) throws Exception {
        this.modificar(especificaciones, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }

    public ListaEnlazada<Especificaciones> ordenarDisplay(ListaEnlazada<Especificaciones> lista) {
        try {
            Especificaciones[] matriz = lista.toArray();
            for (int i = 1; i < lista.size(); i++) {
                Especificaciones key = lista.get(i);
                int j = i - 1;
                while (j >= 0 && (matriz[j].getDisplay().compareToIgnoreCase(key.getDisplay())) > 0) {
                    matriz[j + 1] = matriz[j];
                    j = j - 1;
                }
                matriz[j + 1] = key;
            }
            lista.toList(matriz);
        } catch (Exception e) {
        }
        return lista;
    }

    //Busqueda Binaria
    public ListaEnlazada<Especificaciones> buscarDisplayBin(String display) throws Exception {
        ListaEnlazada<Especificaciones> lista = listar();
        lista = ordenarDisplay(lista);
        ListaEnlazada<Especificaciones> resultado = new ListaEnlazada<>();
        int i = 0, l = lista.size() - 1;
        while (i <= l) {
            int m = i + (l - i) / 2;
            Especificaciones aux = lista.get(m);
            if (aux.getDisplay().compareToIgnoreCase(display) == 0) {
                resultado.insertarNodo(aux);
                return resultado;
            }

            if (aux.getDisplay().compareToIgnoreCase(display) < 0) {
                i = m + 1;
            } else {
                l = m - 1;
            }
        }
        return null;
    }

    //Busqueda lineal binaria
    public ListaEnlazada<Especificaciones> buscarDisplayLineal(String display) throws Exception {
        ListaEnlazada<Especificaciones> lista = listar();
        lista = ordenarDisplay(lista);
        ListaEnlazada<Especificaciones> resultado = new ListaEnlazada<>();
        int low = 0;
        int high = lista.size() - 1;
        boolean encontrado = false;

        while (low <= high) {
            int mid = (low + high) / 2;
            Especificaciones ep = lista.get(mid);
            int comparacion = ep.getDisplay().compareToIgnoreCase(display);

            if (comparacion == 0) {
                resultado.insertarNodo(ep);
                encontrado = true;

                int left = mid - 1;
                while (left >= 0 && lista.get(left).getDisplay().equalsIgnoreCase(display)) {
                    resultado.insertarNodo(lista.get(left));
                    left--;
                }

                int right = mid + 1;
                while (right < lista.size() && lista.get(right).getDisplay().equalsIgnoreCase(display)) {
                    resultado.insertarNodo(lista.get(right));
                    right++;
                }

                break;
            } else if (comparacion < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (!encontrado) {
            for (int i = 0; i < lista.size(); i++) {
                Especificaciones ep = lista.get(i);
                if (ep.getDisplay().equalsIgnoreCase(display)) {
                    resultado.insertarNodo(ep);
                    encontrado = true;
                }
            }
        }

        return encontrado ? resultado : null;
    }

    public ListaEnlazada<Especificaciones> ordenarCapacidad(ListaEnlazada<Especificaciones> lista) {
        try {
            Especificaciones[] matriz = lista.toArray();
            for (int i = 1; i < lista.size(); i++) {
                Especificaciones key = lista.get(i);
                int j = i - 1;
                while (j >= 0 && (matriz[j].getCapacidadA().compareToIgnoreCase(key.getCapacidadA())) > 0) {

                    matriz[j + 1] = matriz[j];
                    j = j - 1;
                }
                matriz[j + 1] = key;
            }
            lista.toList(matriz);
        } catch (Exception e) {
        }
        return lista;
    }

    // Busqueda Binaria
    public ListaEnlazada<Especificaciones> buscarCapacidadBin(String capacidadA) throws Exception {
        ListaEnlazada<Especificaciones> lista = listar();
        lista = ordenarCapacidad(lista);
        ListaEnlazada<Especificaciones> resultado = new ListaEnlazada<>();
        int i = 0, l = lista.size() - 1;
        while (i <= l) {
            int m = i + (l - i) / 2;
            Especificaciones aux = lista.get(m);
            if (aux.getCapacidadA().compareToIgnoreCase(capacidadA) == 0) {
                resultado.insertarNodo(aux);
                return resultado;
            }

            if (aux.getCapacidadA().compareToIgnoreCase(capacidadA) < 0) {
                i = m + 1;
            } else {
                l = m - 1;
            }
        }
        return null;
    }

    //Busqueda lineal binaria
    public ListaEnlazada<Especificaciones> buscarCapacidadALineal(String capacidadA) throws Exception {
        ListaEnlazada<Especificaciones> lista = listar();
        lista = ordenarCapacidad(lista);
        ListaEnlazada<Especificaciones> resultado = new ListaEnlazada<>();
        int low = 0;
        int high = lista.size() - 1;
        boolean encontrado = false;

        while (low <= high) {
            int mid = (low + high) / 2;
            Especificaciones ep = lista.get(mid);
            int comparacion = ep.getCapacidadA().compareToIgnoreCase(capacidadA);

            if (comparacion == 0) {
                resultado.insertarNodo(ep);
                encontrado = true;

                int left = mid - 1;
                while (left >= 0 && lista.get(left).getCapacidadA().equalsIgnoreCase(capacidadA)) {
                    resultado.insertarNodo(lista.get(left));
                    left--;
                }

                int right = mid + 1;
                while (right < lista.size() && lista.get(right).getCapacidadA().equalsIgnoreCase(capacidadA)) {
                    resultado.insertarNodo(lista.get(right));
                    right++;
                }

                break;
            } else if (comparacion < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (!encontrado) {
            for (int i = 0; i < lista.size(); i++) {
                Especificaciones ep = lista.get(i);
                if (ep.getCapacidadA().equalsIgnoreCase(capacidadA)) {
                    resultado.insertarNodo(ep);
                    encontrado = true;
                }
            }
        }

        return encontrado ? resultado : null;
    }

    public ListaEnlazada<Especificaciones> ordenarModelo(ListaEnlazada<Especificaciones> lista) {
        try {
            Especificaciones[] matriz = lista.toArray();
            for (int i = 1; i < lista.size(); i++) {
                Especificaciones key = lista.get(i);
                int j = i - 1;
                while (j >= 0 && (matriz[j].getModelo().compareToIgnoreCase(key.getModelo())) > 0) {

                    matriz[j + 1] = matriz[j];
                    j = j - 1;
                }
                matriz[j + 1] = key;
            }
            lista.toList(matriz);
        } catch (Exception e) {
        }
        return lista;
    }

    //Busqueda Binaria
    public ListaEnlazada<Especificaciones> buscarModeloBin(String modelo) throws Exception {
        ListaEnlazada<Especificaciones> lista = listar();
        lista = ordenarModelo(lista);
        ListaEnlazada<Especificaciones> resultado = new ListaEnlazada<>();
        int i = 0, l = lista.size() - 1;
        while (i <= l) {
            int m = i + (l - i) / 2;
            Especificaciones aux = lista.get(m);
            if (aux.getModelo().compareToIgnoreCase(modelo) == 0) {
                resultado.insertarNodo(aux);
                return resultado;
            }

            if (aux.getModelo().compareToIgnoreCase(modelo) < 0) {
                i = m + 1;
            } else {
                l = m - 1;
            }
        }
        return null;
    }

    //Busqueda lineal binaria
    public ListaEnlazada<Especificaciones> buscarModeloLineal(String modelo) throws Exception {
        ListaEnlazada<Especificaciones> lista = listar();
        lista = ordenarModelo(lista);
        ListaEnlazada<Especificaciones> resultado = new ListaEnlazada<>();
        int low = 0;
        int high = lista.size() - 1;
        boolean encontrado = false;

        while (low <= high) {
            int mid = (low + high) / 2;
            Especificaciones ep = lista.get(mid);
            int comparacion = ep.getModelo().compareToIgnoreCase(modelo);

            if (comparacion == 0) {
                resultado.insertarNodo(ep);
                encontrado = true;

                int left = mid - 1;
                while (left >= 0 && lista.get(left).getModelo().equalsIgnoreCase(modelo)) {
                    resultado.insertarNodo(lista.get(left));
                    left--;
                }

                int right = mid + 1;
                while (right < lista.size() && lista.get(right).getModelo().equalsIgnoreCase(modelo)) {
                    resultado.insertarNodo(lista.get(right));
                    right++;
                }

                break;
            } else if (comparacion < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (!encontrado) {
            for (int i = 0; i < lista.size(); i++) {
                Especificaciones ep = lista.get(i);
                if (ep.getModelo().equalsIgnoreCase(modelo)) {
                    resultado.insertarNodo(ep);
                    encontrado = true;
                }
            }
        }

        return encontrado ? resultado : null;
    }

}
