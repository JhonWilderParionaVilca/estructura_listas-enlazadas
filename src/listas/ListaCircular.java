package listas;

public class ListaCircular<Tipo> {
    private NodoCircular primero;
    private int tamanio;

    public ListaCircular() {
        this.primero = null;
    }

    /*------------------------------------- insertar por el primero------------------------------------------------- */
    public ListaCircular insertarPrimero(Tipo datoI){
        NodoCircular nuevo = new NodoCircular(datoI);
        if (primero != null){ /*Si la lista no esta vacia*/
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
    public ListaCircular elimimarPrimero() throws Exception {
        exceptionListaVacia("No se puede eliminar. la lista esta vacia");
        if (primero.getSiguiente() != primero){
            NodoCircular aux = primero;
            NodoCircular aux1 = aux;
            aux = recorrerFinal(aux);

            aux.setSiguiente(aux1.getSiguiente());
            primero = aux1.getSiguiente();
            aux1.setSiguiente(null);

        }else {
            /*si solo hay un nodo*/
            primero = null;
        }
        tamanio--;
        return this;
    }
    /*------------------------------------- insertar Final------------------------------------------------- */
    public ListaCircular insertarFinal(Tipo datoI){
        NodoCircular nuevo = new NodoCircular(datoI);
        if (primero != null){
            NodoCircular aux = primero;
            aux = recorrerFinal(aux);

            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }else {
            primero = nuevo;
        }
        tamanio++;
        return this;
    }
    /*------------------------------------- Eliminar Final------------------------------------------------- */
    public ListaCircular eliminarFinal() throws Exception {
        exceptionListaVacia("No se puede eliminar una lista vacia");
        if (primero.getSiguiente() != primero){
            NodoCircular aux = primero;
            NodoCircular aux1 = aux;
            aux = recorrerFinal(aux);
            aux1 = recorrerUnoAntesFinal(aux1);

            aux1.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(null);

        }else {
            /*si solo tiene un nodo*/
            primero = null;
        }
        tamanio--;
        return this;
    }

    /*------------------------------------- Eliminar Nodo Buscado------------------------------------------------- */
    public ListaCircular eliminarElementoBuscado(Tipo datoB) throws Exception {
        exceptionListaVacia("No se puede eliminar elelemnto buscado en lista vacia");
        NodoCircular aux1 = primero;
        aux1 = recorrerUnNodoAntesBuscado(aux1,datoB);
        if (aux1.getDato() == datoB){
            elimimarPrimero();
        }else if(aux1.getSiguiente().getSiguiente() == primero){
            eliminarFinal();
        }else {
            /*eliminar intermedio*/
            NodoCircular aux = aux1;
            aux = aux1.getSiguiente();
            aux1.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(null);
            tamanio--;
        }
        return this;
    }

    /*------------------------------------- Insertar Antes Nodo Buscado------------------------------------------------- */
    public ListaCircular insertarAntesElementoB(Tipo datoI, Tipo datoB) throws Exception {
        exceptionListaVacia("no se puede insertar antes de una lista vacia");
        NodoCircular aux1 = primero;
        aux1 = recorrerUnNodoAntesBuscado(aux1,datoB);
        if (aux1.getDato() == datoB){
            insertarPrimero(datoI);
        }else {
            NodoCircular nuevo = new NodoCircular(datoI);
            nuevo.setSiguiente(aux1.getSiguiente());
            aux1.setSiguiente(nuevo);
            tamanio++;
        }
        return this;
    }
    /*------------------------------------- Eliminar Antes Nodo Buscado------------------------------------------------- */
    public ListaCircular eliminarAntesElementoB(Tipo datoB) throws Exception {
        exceptionListaVacia("No se puede eliminar en una lista vacia");
        NodoCircular aux1 = primero;
        NodoCircular aux = aux1;
        aux = recorrerFinal(aux);
        aux1 = recorrerDosAntesElementoBuscado(aux1,datoB);
        if (aux1.getDato() != datoB){
            if (aux1.getSiguiente().getDato() != datoB){
                NodoCircular auxAnterior = aux1;
                aux1 = aux1.getSiguiente();
                auxAnterior.setSiguiente(aux1.getSiguiente());
            }else {
                primero = aux1.getSiguiente();
                aux.setSiguiente(primero);
            }
            aux1.setSiguiente(null);
        }else {
            throw new Exception("No existe un nodo antes de " + aux1.getDato());
        }
        tamanio--;
        return this;
    }
    /*------------------------------------- Insertar despues Nodo Buscado------------------------------------------------- */
    public ListaCircular insertarDespuesElementoB(Tipo datoI, Tipo datoB) throws Exception{
        if(primero != null){
            NodoCircular nuevo = new NodoCircular(datoI);
            NodoCircular aux = primero;
            
            while(!aux.getDato().equals(datoB)&& aux.getSiguiente()!= primero){
                aux = aux.getSiguiente();
            }
            
            if(aux.getDato().equals(datoB)){
                nuevo.setSiguiente(aux.getSiguiente());
                aux.setSiguiente(nuevo);
            }
            
            else{
                throw new Exception("Elemento no encontrado");
            }
        }
        
        else{
            throw new Exception("Lista vacia");
        }
        return this;
    }
    /* */
    public ListaCircular eliminarDespuesElementoB(Tipo datoB) throws Exception{
        if(primero != null){
            //Creaos nodos auxliares
            NodoCircular aux = primero;
            NodoCircular aux1 = null;
            
            if(primero.getDato().equals(datoB) && primero.getSiguiente() == primero){
               throw new Exception("solo hay un elemento en la lista");
            }
            
            //Mas de dos elementos
            else{
                //Ciclo para recorrer la lista
                while(aux.getSiguiente()!= primero && aux.getDato() != datoB ){
                        aux = aux.getSiguiente();
                }
                aux1 = aux.getSiguiente().getSiguiente();
                
                
                //Elemento encontrado en el ultimo nodo
                if(aux.getDato().equals(datoB) && aux.getSiguiente() == primero){
                    elimimarPrimero();
                }
                
                //Elemento no encontrado
                else if(aux.getSiguiente() == primero){
                    throw new Exception("no se encontro elelemnto");

                }
                //elemento en medio de la lista
                else{
                  aux.getSiguiente().setSiguiente(null);
                  aux.setSiguiente(aux1);
                  tamanio--;
                }
            }
        }
        else{
            throw new Exception("lista vacia");
        }
        return this;
    }

    /*------------------------------------- Recorrer------------------------------------------------- */
    private NodoCircular recorrerFinal(NodoCircular aux){
        while (aux.getSiguiente() != primero){
            aux = aux.getSiguiente();
        }
        return aux;
    }
    private NodoCircular recorrerUnoAntesFinal(NodoCircular aux){
        if (aux.getSiguiente() != primero){
            while (aux.getSiguiente().getSiguiente() != primero){
                aux = aux.getSiguiente();
            }
        }
        return aux;
    }


    /*------------------------------------- Recorrer Buscado------------------------------------------------- */
    private NodoCircular recorrerUnNodoAntesBuscado(NodoCircular aux, Tipo datoB) throws Exception {
        if (aux.getDato() != datoB){

            while (aux.getSiguiente() != primero && aux.getSiguiente().getDato() != datoB ){
                aux = aux.getSiguiente();
            }
            if (aux.getSiguiente() == primero){
                throw new Exception("No se encontro el elemento buscado");
            }
        }
        return aux;
    }

    private NodoCircular recorrerDosAntesElementoBuscado (NodoCircular aux, Tipo datoB) throws Exception {
        //precoindicion la lista no debe estar vacia
        //Retornamos el primer nodo si el dato buscado se enuentra en el primero o segundo nodo
        if (aux.getDato() != datoB && aux.getSiguiente().getDato() != datoB){
            //System.out.println("no es el primero ni el segundo " + aux.getDato() + " => " + datoBuscado);
            /*mientras haya mas de 3 nodos*/
            while (aux.getSiguiente().getSiguiente()!= null && aux.getSiguiente().getSiguiente().getDato() != datoB){
                aux = aux.getSiguiente();
            }
            if (aux.getSiguiente().getSiguiente() == null){
                throw new Exception("No se encontro el elemento buscado");
            }
        }
        //System.out.println(aux.getDato());
        return aux;
    }
    /*------------------------------------- utils------------------------------------------------------- */
    private void exceptionListaVacia(String msg) throws Exception {
        if (primero == null){
            throw new Exception(msg);
        }
    }
    /*--------------------------------------Retornar Dato indice------------------------------------------------   */
    public Tipo getDatoIndex(int index){
        NodoCircular actual = primero;
        int contador = 0;
        while(contador < index){
            actual = actual.getSiguiente();
            contador++;
        }
        
        return (Tipo) actual.getDato();
    }

    public Tipo getElementoBuscado(Tipo datoB) throws Exception {
        exceptionListaVacia("La lista esta vacia");
        NodoCircular aux = primero;
        while (!aux.getDato().equals(datoB) && aux.getSiguiente() != primero){
            aux = aux.getSiguiente();
        }
        if (!aux.getDato().equals(datoB) ){
            throw new Exception("No se encontro el elemento Buscado");
        }
        return (Tipo) aux.getDato();
    }



    public int getTamanio() {
        return tamanio;
    }
    @Override
    public String toString(){
        String salida = "primero->";
        if (primero == null){
            return "La lista esta vacia";
        }
        NodoCircular actual =primero;
        while (actual.getSiguiente() != primero){
            salida = salida + "[" + actual.getDato()+ "]->";
            actual = actual.getSiguiente();
        }
        //al ultimo nodo apunta  a primero
        salida = salida + "[" + actual.getDato()+ "]-> primero";
        return salida;
    }
}
