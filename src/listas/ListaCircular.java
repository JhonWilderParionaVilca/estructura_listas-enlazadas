package listas;

public class ListaCircular<Tipo> {

    private NodoCircular primero;
    private int tamanio;

    public ListaCircular() {
        this.primero = null;
    }

    /*------------------------------------- insertar por el primero------------------------------------------------- */
    public ListaCircular insertarPrimero(Tipo datoI) throws Exception {
        exceptionDatoDuplicado(datoI);
        NodoCircular nuevo = new NodoCircular(datoI);
        if (primero != null) {
            NodoCircular aux = primero;
            aux = recorrerFinal(aux);
            
            nuevo.setSiguiente(primero);
            aux.setSiguiente(nuevo);
        }
        primero = nuevo;
        tamanio++;
        return this;
    }

    /*------------------------------------- Eliminar por el primero------------------------------------------------- */
    public ListaCircular eliminarPrimero() throws Exception {
        exceptionListaVacia("No se puede eliminar. La lista esta vacia");
        if (primero.getSiguiente() != primero) {
            NodoCircular aux = primero;
            aux = recorrerFinal(aux);
            primero = primero.getSiguiente();
            aux.getSiguiente().setSiguiente(null);
            aux.setSiguiente(primero);

        } else {
            /*si solo hay un nodo*/
            primero = null;
        }
        tamanio--;
        return this;
    }

    /*------------------------------------- insertar Final------------------------------------------------- */
    public ListaCircular insertarFinal(Tipo datoI) throws Exception {
        exceptionDatoDuplicado(datoI);
        NodoCircular nuevo = new NodoCircular(datoI);
        if (primero != null) {
            NodoCircular aux = primero;
            aux = recorrerFinal(aux);
            
            aux.setSiguiente(nuevo);
            nuevo.setSiguiente(primero);
            
        } else {
            /*si la lista esta vacia*/
            primero = nuevo;
        }
        tamanio++;
        return this;
    }

    /*------------------------------------- Eliminar Final------------------------------------------------- */
    public ListaCircular eliminarFinal() throws Exception {
        exceptionListaVacia("No se puede eliminar una lista circular vacia");
        if (primero.getSiguiente() != primero) {
            NodoCircular aux = primero;
            aux = recorrerUnoAntesFinal(aux);

            aux.getSiguiente().setSiguiente(null);
            aux.setSiguiente(primero);

        } else {
            /*si solo tiene un nodo*/
            primero = null;
        }
        tamanio--;
        return this;
    }

    /*------------------------------------- Eliminar Nodo Buscado------------------------------------------------- */
    public ListaCircular eliminarElementoBuscado(Tipo datoB) throws Exception {
        exceptionListaVacia("No se puede eliminar elelemnto buscado en lista Circular vacia");
        NodoCircular aux = primero;
        aux = recorrerUnNodoAntesBuscado(aux, datoB);

        if (aux.getDato().equals(datoB)) {
            eliminarPrimero();
        } else if (aux.getSiguiente().getSiguiente() == primero) {
            eliminarFinal();
        } else {
            /*eliminar intermedio*/
            NodoCircular aux1 = aux.getSiguiente();
            
            aux.setSiguiente(aux1.getSiguiente());
            aux1.setSiguiente(null);
            tamanio--;
        }
        return this;
    }

    /*------------------------------------- Insertar Antes Nodo Buscado------------------------------------------------- */
    public ListaCircular insertarAntesElementoB(Tipo datoI, Tipo datoB) throws Exception {
        exceptionListaVacia("no se puede insertar antes de una lista vacia");
        exceptionDatoDuplicado(datoI);
        
        if (primero.getDato().equals(datoB)) {
            insertarPrimero(datoI);
        } else {
            NodoCircular aux = primero;
            aux = recorrerUnNodoAntesBuscado(aux, datoB);
            NodoCircular nuevo = new NodoCircular(datoI);
            
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
            tamanio++;
        }
        return this;
    }

    /*------------------------------------- Eliminar Antes Nodo Buscado------------------------------------------------- */
    public ListaCircular eliminarAntesElementoB(Tipo datoB) throws Exception {
        exceptionListaVacia("No se puede eliminar antes en una lista vacia Circular");

        if (!primero.getDato().equals(datoB)) {
            NodoCircular aux = primero;
            aux = recorrerDosAntesElementoBuscado(aux, datoB);
            System.out.println("aux = " + aux);
            NodoCircular aux1;
            
            if (!aux.getSiguiente().getDato().equals(datoB)) {
                aux1 = aux.getSiguiente();
                aux.setSiguiente(aux1.getSiguiente());
                aux1.setSiguiente(null);
            }else{
                /*El nodo buscado es el segundo*/
                aux1 = recorrerFinal(aux);
                primero = aux.getSiguiente();
                aux.setSiguiente(null);
                aux1.setSiguiente(primero);
            }
        } else {
            /*si el nodo buscado es el primero*/
            throw new Exception("No existe un nodo antes de " + primero.getDato());
        }
        tamanio--;
        return this;
    }

    /*------------------------------------- Insertar despues Nodo Buscado------------------------------------------------- */
    public ListaCircular insertarDespuesElementoB(Tipo datoI, Tipo datoB) throws Exception {
        exceptionListaVacia("La lista circular esta vacia");
        exceptionDatoDuplicado(datoI);

        NodoCircular nuevo = new NodoCircular(datoI);
        NodoCircular aux = primero;
        aux = recorrerElementoBuscado(aux, datoB);
        
        nuevo.setSiguiente(aux.getSiguiente());
        aux.setSiguiente(nuevo);

        tamanio++;
        return this;
    }
    /*------------------------------------- Insertar despues Nodo Buscado------------------------------------------------- */
    public ListaCircular eliminarDespuesElementoB(Tipo datoB) throws Exception {
        exceptionListaVacia("No se puede eliminar en una lista circular vacia");
        //Creaos nodos auxliares
        NodoCircular aux = primero;
        aux = recorrerElementoBuscado(aux, datoB);
        
        if (aux.getSiguiente() != primero) {
            NodoCircular aux1 = aux.getSiguiente();
            
            aux.setSiguiente(aux1.getSiguiente());
            aux1.setSiguiente(null);
            
        }else {
            /*si tiene un solo nodo y el buscado es eso o el buscado es el ultimo*/
            throw new Exception("No hay un elemento despues de " + aux.getDato());
        }
        tamanio--;
        return this;
    }

    /*------------------------------------- Recorrer------------------------------------------------- */
    private NodoCircular recorrerFinal(NodoCircular aux) {
        while (aux.getSiguiente() != primero) {
            aux = aux.getSiguiente();
        }
        return aux;
    }

    private NodoCircular recorrerUnoAntesFinal(NodoCircular aux) {
        if (aux.getSiguiente() != primero) {
            while (aux.getSiguiente().getSiguiente() != primero) {
                aux = aux.getSiguiente();
            }
        }
        return aux;
    }


    /*------------------------------------- Recorrer Buscado------------------------------------------------- */
    private NodoCircular recorrerElementoBuscado(NodoCircular aux, Tipo datoB) throws Exception {
        while (!aux.getDato().equals(datoB) && aux.getSiguiente() != null) {
            aux = aux.getSiguiente();
        }
        if (!aux.getDato().equals(datoB)) {
            throw new Exception("No se encontro el elemento Buscado");
        }
        return aux;
    }

    private NodoCircular recorrerUnNodoAntesBuscado(NodoCircular aux, Tipo datoB) throws Exception {
        if (!aux.getDato().equals(datoB)) {
            /*si no es el primer nodo*/
            while (aux.getSiguiente() != primero && !aux.getSiguiente().getDato().equals(datoB)) {
                aux = aux.getSiguiente();
            }
            if (aux.getSiguiente() == primero) {
                throw new Exception("No se encontro el elemento buscado");
            }
        }
        return aux;
    }

    private NodoCircular recorrerDosAntesElementoBuscado(NodoCircular aux, Tipo datoB) throws Exception {
        //precoindicion la lista no debe estar vacia
        //Retornamos el primer nodo si el dato buscado se enuentra en el primero o segundo nodo
        if (!aux.getDato().equals(datoB) && !aux.getSiguiente().getDato().equals(datoB)) {
            //System.out.println("no es el primero ni el segundo " + aux.getDato() + " => " + datoBuscado);
            /*mientras haya mas de 3 nodos*/
            while (aux.getSiguiente().getSiguiente() != null && !aux.getSiguiente().getSiguiente().getDato().equals(datoB)) {
                aux = aux.getSiguiente();
            }
            if (aux.getSiguiente().getSiguiente() == null) {
                throw new Exception("No se encontro el elemento buscado");
            }
        }
        //System.out.println(aux.getDato());
        return aux;
    }

    /*--------------------------------------Retornar Dato indice------------------------------------------------   */
    public Tipo getDatoIndex(int index) {
        NodoCircular actual = primero;
        int contador = 0;
        while (contador < index) {
            actual = actual.getSiguiente();
            contador++;
        }

        return (Tipo) actual.getDato();
    }

    public Tipo getElementoBuscado(Tipo datoB) throws Exception {
        exceptionListaVacia("La lista esta vacia");
        NodoCircular aux = primero;
        while (!aux.getDato().equals(datoB) && aux.getSiguiente() != primero) {
            aux = aux.getSiguiente();
        }
        if (!aux.getDato().equals(datoB)) {
            throw new Exception("No se encontro el elemento Buscado");
        }
        return (Tipo) aux.getDato();
    }

    public int getTamanio() {
        return tamanio;
    }

    @Override
    public String toString() {
        String salida = "primero->";
        if (primero == null) {
            return "La lista esta vacia";
        }
        NodoCircular actual = primero;
        while (actual.getSiguiente() != primero) {
            salida = salida + "[" + actual.getDato() + "]->";
            actual = actual.getSiguiente();
        }
        //al ultimo nodo apunta  a primero
        salida = salida + "[" + actual.getDato() + "]-> primero";
        return salida;
    }

    private void exceptionDatoDuplicado(Tipo datoI) throws Exception {
        if (primero != null) {
            NodoCircular actual = primero;
            while (!actual.getDato().equals(datoI) && actual.getSiguiente() != primero) {
                actual = actual.getSiguiente();
            }
            if (actual.getDato().equals(datoI)) {
                throw new Exception("El dato ya existe no se puede insertar datos duplicados");
            }
        }
    }

    private void exceptionListaVacia(String msg) throws Exception {
        if (primero == null) {
            throw new Exception(msg);
        }
    }
}
