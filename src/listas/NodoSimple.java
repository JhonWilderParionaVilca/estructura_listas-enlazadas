/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author bh
 */
public class NodoSimple<Tipo> {
    private Tipo dato; /* Genérica*/
    private NodoSimple siguiente; /*Autoreferenciada*/

    public NodoSimple(Tipo dato) {
        this.dato = dato;
        siguiente = null;/*Apunta*/
    }

    public Tipo getDato() {
        return dato;
    }

    public void setDato(Tipo dato) {
        this.dato = dato;
    }

    public NodoSimple getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoSimple siguiente) {
        this.siguiente = siguiente;
    }
}
