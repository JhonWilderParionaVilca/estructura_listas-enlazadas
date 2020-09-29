package listas;

public class NodoDoble<Tipo> {
    private Tipo dato;/*Generica*/
    private NodoDoble anterior; /* Autoreferenciado*/
    private NodoDoble siguiente;  /* Autoreferenciado*/

    public NodoDoble(Tipo dato){
        this.dato = dato;
        anterior = siguiente = null; /*Apunta*/
    }

    public Tipo getDato() {
        return dato;
    }

    public void setDato(Tipo dato) {
        this.dato = dato;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }
}
