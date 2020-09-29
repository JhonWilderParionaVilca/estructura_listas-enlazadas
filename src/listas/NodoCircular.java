package listas;

public class NodoCircular<Tipo> {
    private Tipo dato; /*Genrico*/
    private NodoCircular siguiente; /*Autoreferenciado*/

    public NodoCircular(Tipo dato) {
        this.dato = dato;
        siguiente = this;
    }

    public Tipo getDato() {
        return dato;
    }

    public void setDato(Tipo dato) {
        this.dato = dato;
    }

    public NodoCircular getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCircular siguiente) {
        this.siguiente = siguiente;
    }
}

