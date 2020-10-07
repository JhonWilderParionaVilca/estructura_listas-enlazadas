package listas;

public class ListaDoble<Tipo> {
    private NodoDoble primero;
    private int tamanio = 0;

    public ListaDoble() {
        this.primero = null;
    }
    
    private boolean esVacia(){
        return primero == null;
    }

    /*------------------------------------- insertar por el primero------------------------------------------------- */
    public ListaDoble insertarPrimero(Tipo dato) throws Exception{
        datoIUnico(dato);
        NodoDoble nuevo = new NodoDoble(dato);
        if (!esVacia()){
            nuevo.setSiguiente(primero);
            primero.setAnterior(nuevo);
        }
        primero = nuevo;
        tamanio++;
        return this;
    }

    /*----------------------------------------Eliminar por el primero --------------------------------------------- */
    public ListaDoble eliminarPrimero() throws Exception {
        exeptionListaVacia();
        if ( primero.getSiguiente() != null){
            primero = primero.getSiguiente();
            primero.getAnterior().setSiguiente(null);
            primero.setAnterior(null);
        }else{
            /**si tiene un solo nodo */
            primero = null;
        }
        tamanio--;
        return this;
    }
    /*---------------------------------------Insertar final-----------------------------------------------------------*/
    public ListaDoble insertarFinal(Tipo dato) throws Exception{
        datoIUnico(dato);
        NodoDoble nuevo = new NodoDoble(dato);
        
        if (!esVacia()){
            NodoDoble aux = primero;
            aux = recorrerFinal(aux);

            aux.setSiguiente(nuevo);
            nuevo.setAnterior(aux);

        }else {
            primero = nuevo;
        }
        tamanio++;
        return this;
    }
    /*-----------------------------Eliminar final--------------------------------------------------------*/
    public ListaDoble eliminarFinal() throws Exception {
        exeptionListaVacia();
        
        if (primero.getSiguiente() != null){
            NodoDoble aux= primero;
            aux = recorrerFinal(aux);
            
            aux.getAnterior().setSiguiente(null);
            aux.setAnterior(null);
        }else{
            /*solo hay un nodo*/
            primero = null;
        }
        tamanio--;
        return this;
    }
    /*-----------------------------Eliminar Elemento Buscado--------------------------------------------------------*/
    public ListaDoble eliminarElementoBuscado(Tipo datoB) throws Exception {
        exeptionListaVacia();
        NodoDoble aux = primero;
        aux = recorrerElementoBuscado(aux, datoB);
        eliminarNodoEncontrado(aux);
        return this;
    }

    /*---------------------------------------Insertar Antes Elemento Buscado------------------------------------------*/
    public ListaDoble insertarAntesElementoB(Tipo datoI, Tipo datoB) throws Exception {
        exeptionListaVacia();
        datoIUnico(datoI);
        
        NodoDoble nuevo = new NodoDoble(datoI);
        NodoDoble aux = primero;
        aux = recorrerElementoBuscado(aux, datoB);
        
        if (aux.getAnterior() == null) {
            /*primer nodo*/
            insertarPrimero(datoI);
        }else{
            aux.getAnterior().setSiguiente(nuevo);
            nuevo.setAnterior(aux.getAnterior());
            nuevo.setSiguiente(aux);
            aux.setAnterior(nuevo);
            tamanio++;
        }
        return this;
        
    }
    /*---------------------------------------Eliminar Antes Elemento Buscado------------------------------------------*/
    public ListaDoble eliminarAntesElementoB(Tipo datoB) throws Exception {
        exeptionListaVacia();
        
        NodoDoble aux = primero;
        aux = recorrerElementoBuscado(aux, datoB);

        if (aux.getAnterior() != null){
            aux = aux.getAnterior(); /*nos posicionamos en el nodo q queremos eliminar*/
            eliminarNodoEncontrado(aux);
        }else {
            throw new Exception("No se puede eliminar antes del primer nodo");
        }
        return this;
    }
    /*---------------------------------------Insertar despues Elemento Buscado------------------------------------------*/
    public ListaDoble insertarDespuesElementoB(Tipo datoI, Tipo datoB) throws Exception {
        exeptionListaVacia();
        datoIUnico(datoI);
        NodoDoble aux = primero;
        aux = recorrerElementoBuscado(aux, datoB);
        NodoDoble nuevo = new NodoDoble(datoI);

        if (aux.getSiguiente() != null){
            aux.getSiguiente().setAnterior(nuevo);
            nuevo.setSiguiente(aux.getSiguiente());
        }
        aux.setSiguiente(nuevo);
        nuevo.setAnterior(aux);
        tamanio++;
        return this;
    }
    /*---------------------------------------Eliminar despues Elemento Buscado------------------------------------------*/
    public ListaDoble eliminarDespuesElementoB(Tipo datoB) throws Exception {
        exeptionListaVacia();
        NodoDoble aux = primero;
        aux = recorrerElementoBuscado(aux, datoB);

        if (aux.getSiguiente() != null){
            aux = aux.getSiguiente(); /*nos posicionamos en el nodo q queremos eliminar*/
            eliminarNodoEncontrado(aux);
        }else {
            throw new Exception("No se puede eliminar despues del ultimo nodo");
        }
        return this;
    }


    /*----------------------------------------utils-------------------------------------------------------------------*/
    public void exeptionListaVacia() throws Exception {
        if (primero == null){
            throw new Exception("La lista esta vacia");
        }
    }
    
    private void eliminarNodoEncontrado(NodoDoble aux) throws Exception{
        if(aux.getAnterior() == null){
            System.out.println("eliminar primero");
            eliminarPrimero();
        }else if(aux.getSiguiente() == null){
            eliminarFinal();
        }else{
            /*eliminar un nodo intermedio*/
            aux.getAnterior().setSiguiente(aux.getSiguiente());
            aux.getSiguiente().setAnterior(aux.getAnterior());
            aux.setAnterior(null);
            tamanio--;
        }
    }

    /*---------------------------------Recorrer----------------------------------------------------------------------*/
    public NodoDoble recorrerFinal(NodoDoble aux){
        while (aux.getSiguiente() != null){
            aux = aux.getSiguiente();
        }
        return aux;
    }
    public NodoDoble recorrerElementoBuscado(NodoDoble aux, Tipo datoB) throws Exception {
        while (!aux.getDato().equals(datoB) && aux.getSiguiente() != null){
            aux = aux.getSiguiente();
        }
        if (!aux.getDato().equals(datoB)){
            throw new Exception("No se encontro el elemento Buscado");
        }
        return aux;
    }

    @Override
    public String toString(){
        String salida = "primero y null <=>";
        if (primero == null){
            return "La lista esta vacia";
        }
        NodoDoble actual =primero;
        while (actual.getSiguiente() != null){
            salida = salida + "[" + actual.getDato()+ "]<=>";
            actual = actual.getSiguiente();
        }
        //al ultimo nodo apunta  a null
        salida = salida + "[" + actual.getDato()+ "]-> null";
        return salida;
    }

    public String imprimirReveso(){
        String salida = "-> null";
        if (primero == null){
            return "La lista esta vacia";
        }
        NodoDoble actual = primero;
        actual = recorrerFinal(actual);
        while (actual.getAnterior() != null){
            salida = "[" + actual.getDato()+ "]<=>" + salida;
            actual = actual.getAnterior();
        }
        salida =  "primero y null <=>[" + actual.getDato()+ "]<=>" + salida;
        return salida;
    }
    /*--------------------------------------Retornar Dato indice------------------------------------------------   */
    public Tipo getDatoIndex(int index){
        NodoDoble actual = primero;
        int contador = 0;
        while(contador < index){
            actual = actual.getSiguiente();
            contador++;
        }
        
        return (Tipo) actual.getDato();
    }
    public Tipo getElementoBuscado(Tipo datoB) throws Exception {
        exeptionListaVacia();
        NodoDoble aux = primero;
        while (!aux.getDato().equals(datoB) && aux.getSiguiente() != null){
            aux = aux.getSiguiente();
        }
        if (!aux.getDato().equals(datoB) ){
            throw new Exception("No se encontro el elemento Buscado");
        }
        return (Tipo) aux.getDato();
    }
    private void datoIUnico(Tipo datoI) throws Exception{
        if(primero != null){
            NodoDoble actual = primero;
            while (!actual.getDato().equals(datoI) && actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            if (actual.getDato().equals(datoI)) {
                throw new Exception("El alumno ya existe no se puede insertar");
            }
        }   
    }



    public int getTamanio() {
        return tamanio;
    }
}
