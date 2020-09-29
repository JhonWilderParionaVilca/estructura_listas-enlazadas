package listas;

public class Main {
    public static void main(String[] args) {
        Estudiante e1 = new Estudiante("1","e1", "apell", 12);
        Estudiante e2 = new Estudiante("2","e2", "apell", 13);
        Estudiante e3 = new Estudiante("3","e3", "apell", 11);
        Estudiante e4 = new Estudiante("4","e4", "apell", 20);
        Estudiante e5 = new Estudiante("5","e5", "apell", 28);
        Estudiante e6 = new Estudiante("5","e5", "apell", 28);
        System.out.println("hola" == "hola");

        /*
                                    Lista Simple
         */
        System.out.println("**************************************Lista Simple************************************************");
        ListaSimple<Estudiante> estudiantes = new ListaSimple<>(); //crear lista vacia
        System.out.println(estudiantes); //La lista esta vacia
        System.out.println("=> tamaño: " + estudiantes.getTamanio());

        System.out.println("--------------------------Insertar por el primero-----------------------------------------");
        estudiantes.insertarPrimero(e1);
        System.out.println(estudiantes); //primero->[{'e1', 'apell', 12}]-> null
        estudiantes.insertarPrimero(e2);
        System.out.println(estudiantes); //primero->[{'e2', 'apell', 13}]->[{'e1', 'apell', 12}]-> null
        estudiantes.insertarPrimero(e3);
        System.out.println(estudiantes); //primero->[{'e3', 'apell', 11}]->[{'e2', 'apell', 13}]->[{'e1', 'apell', 12}]-> null
        estudiantes.insertarPrimero(e4);
        System.out.println(estudiantes); //primero->[{'e4', 'apell', 20}]->[{'e3', 'apell', 11}]->[{'e2', 'apell', 13}]->[{'e1', 'apell', 12}]-> null

        System.out.println("=> tamaño: " + estudiantes.getTamanio());

        System.out.println("-----------------------------Eliminar por el primero---------------------------------------");
        try{
            estudiantes.eliminarPrimero();
            System.out.println(estudiantes); //primero->[{'e3', 'apell', 11}]->[{'e2', 'apell', 13}]->[{'e1', 'apell', 12}]-> null
            estudiantes.eliminarPrimero();
            System.out.println(estudiantes);//primero->[{'e2', 'apell', 13}]->[{'e1', 'apell', 12}]-> null
            estudiantes.eliminarPrimero();
            System.out.println(estudiantes);//primero->[{'e1', 'apell', 12}]-> null
            estudiantes.eliminarPrimero();
            System.out.println(estudiantes); //La lista esta vacia
            estudiantes.eliminarPrimero();
            System.out.println(estudiantes); //java.lang.Exception: La lista esta vacia
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println("=> tamaño: " + estudiantes.getTamanio());

        System.out.println("-----------------------Insertar por el final---------------------------------");
        estudiantes.insertarFinal(e1);
        System.out.println(estudiantes); //primero->[{'e1', 'apell', 12}]-> null
        estudiantes.insertarFinal(e2);
        System.out.println(estudiantes); //primero->[{'e1', 'apell', 12}]->[{'e2', 'apell', 13}]-> null
        estudiantes.insertarFinal(e3);
        System.out.println(estudiantes); //primero->[{'e1', 'apell', 12}]->[{'e2', 'apell', 13}]->[{'e3', 'apell', 11}]-> null
        estudiantes.insertarFinal(e4);
        System.out.println(estudiantes); //primero->[{'e1', 'apell', 12}]->[{'e2', 'apell', 13}]->[{'e3', 'apell', 11}]->[{'e4', 'apell', 20}]-> null

        System.out.println("=> tamaño: " + estudiantes.getTamanio());

        System.out.println("-----------------------Eliminar por el final---------------------------------");
        try {
            estudiantes.eliminarFinal();
            System.out.println(estudiantes); //primero->[{'e1', 'apell', 12}]->[{'e2', 'apell', 13}]->[{'e3', 'apell', 11}]-> null
            estudiantes.eliminarFinal();
            System.out.println(estudiantes);//primero->[{'e1', 'apell', 12}]->[{'e2', 'apell', 13}]-> null
            estudiantes.eliminarFinal();
            System.out.println(estudiantes); //primero->[{'e1', 'apell', 12}]-> null
            estudiantes.eliminarFinal();
            System.out.println(estudiantes);//La lista esta vacia
            estudiantes.eliminarFinal();
            System.out.println(estudiantes);//java.lang.Exception: La lista esta vacia

        }
        catch(Exception e) {
            System.out.println(e);
        }
        System.out.println("=> tamaño: " + estudiantes.getTamanio());
        System.out.println("-----------------------Eliminar dato buscado---------------------------------");
        try {
            estudiantes.insertarPrimero(e1);
            estudiantes.insertarFinal(e4);
            estudiantes.insertarDespuesElementoBuscado(e1, e2);
            estudiantes.insertarAntesElementoBuscado(e4, e3);
            estudiantes.insertarFinal(e5);
            System.out.println(estudiantes);
            System.out.println("=> tamaño: " + estudiantes.getTamanio());

            //eliminar el intermedio
            estudiantes.eliminarElementoBuscado(e3);
            System.out.println(estudiantes);
            //eliminar primero
            estudiantes.eliminarElementoBuscado(e1);
            System.out.println(estudiantes);
            //estudiantes.eliminarElementoBuscado(e3);
            //eliminar el intermedio
            estudiantes.eliminarElementoBuscado(e4);
            System.out.println(estudiantes);
            //eliminar el final
            estudiantes.eliminarElementoBuscado(e5);
            System.out.println(estudiantes);
            //eliminar el primero
            estudiantes.eliminarElementoBuscado(e2);
            System.out.println(estudiantes);
            estudiantes.eliminarElementoBuscado(e2);
            System.out.println(estudiantes);

        }
        catch(Exception e) {
            System.out.println(e);
        }
        System.out.println("=> tamaño: " + estudiantes.getTamanio());


        System.out.println("-----------------------Insertar Antes ElementoB---------------------------------");
        try {
            estudiantes.insertarAntesElementoBuscado(e4, e2);
            System.out.println(estudiantes); //exception la lista esta vacia
        }
        catch(Exception e) {
            System.out.println(e);
        }

        try {
            estudiantes.insertarFinal(e4);
            System.out.println(estudiantes);
            System.out.println("=> tamaño: " + estudiantes.getTamanio());

            //si hay un solo elemento
            estudiantes.insertarAntesElementoBuscado(e4, e2); //primero->[{'e4', 'apell', 20}]->[{'e1', 'apell', 12}]-> null
            System.out.println(estudiantes);

            /*//no se encuentra el elemento
            estudiantes.insertarAntesElementoBuscado(e5, e3); //java.lang.Exception: No se encontro el elemento buscado*/

            //elemento esta al inicio
            estudiantes.insertarAntesElementoBuscado(e2, e1); //primero->[{'e2', 'apell', 13}]->[{'e4', 'apell', 20}]->[{'e1', 'apell', 12}]-> null
            System.out.println(estudiantes);

            //elemento esta al final
            estudiantes.insertarAntesElementoBuscado(e4, e3); //primero->[{'e2', 'apell', 13}]->[{'e4', 'apell', 20}]->[{'e3', 'apell', 11}]->[{'e1', 'apell', 12}]-> null
            System.out.println(estudiantes);


            //si no se encuentra el elemento
            estudiantes.insertarAntesElementoBuscado(e5, e3); //java.lang.Exception: No se encontro el elemento buscado
            System.out.println(estudiantes);

        }
        catch(Exception e) {
            System.out.println(e);
        }
        System.out.println("=> tamaño: " + estudiantes.getTamanio());

        System.out.println("-----------------------Eliminar Antes ElementoB---------------------------------");

        try {
            /*eliminar antes del primero*/
            estudiantes.eliminarAntesElementoBuscado(e1);
            System.out.println(estudiantes);
        }catch (Exception e){
            System.out.println(e); /*java.lang.Exception: No existe un nodo antes de {'e1', 'apell', 12}*/
        }
        try {
            /*eliminar antes del segundo*/
            estudiantes.eliminarAntesElementoBuscado(e2); //elimina e1
            System.out.println(estudiantes); /*primero->[{'e2', 'apell', 13}]->[{'e3', 'apell', 11}]->[{'e4', 'apell', 20}]-> null*/
            /*eliminar el final*/
            estudiantes.eliminarAntesElementoBuscado(e4); //elimina e3
            System.out.println(estudiantes);/*primero->[{'e2', 'apell' , 13}]->[{'e4', 'apell', 20}]-> null*/
            estudiantes.eliminarAntesElementoBuscado(e4); //elimina e2
            System.out.println(estudiantes);/*primero->[{'e4', 'apell', 20}]-> null*/
        }catch (Exception e){
            System.out.println(e);
        }

        try {
            estudiantes.eliminarElementoBuscado(e4);
            System.out.println(estudiantes); //la lista esta vacia
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println("-----------------------Insertar Despues ElementoB---------------------------------");
        try {
            estudiantes.insertarDespuesElementoBuscado(e4, e2);
            System.out.println(estudiantes); //exception la lista esta vacia
        }
        catch(Exception e) {
            System.out.println(e);
        }

        try {
            estudiantes.insertarFinal(e1);
            System.out.println(estudiantes); /*primero->[{'e1', 'apell', 12}]-> null*/

            //si hay un solo elemento
            estudiantes.insertarDespuesElementoBuscado(e1, e3); /*primero->[{'e1', 'apell', 12}]->[{'e3', 'apell', 11}]-> null*/
            System.out.println(estudiantes);
            //elemento esta al inicio
            estudiantes.insertarDespuesElementoBuscado(e1, e2); /*primero->[{'e1', 'apell', 12}]->[{'e2', 'apell', 13}]->[{'e3', 'apell', 11}]-> null*/
            System.out.println(estudiantes);
            //elemento esta al final
            estudiantes.insertarDespuesElementoBuscado(e3, e4);
            System.out.println(estudiantes);/*primero->[{'e1', 'apell', 12}]->[{'e2', 'apell', 13}]->[{'e3', 'apell', 11}]->[{'e4', 'apell', 20}]-> null*/
            //si no se encuentra el elemento
            estudiantes.insertarDespuesElementoBuscado(e5, e3); //java.lang.Exception: No se encontro el elemento buscado
        }
        catch(Exception e) {
            System.out.println(e);
        }
        System.out.println("=> tamaño: " + estudiantes.getTamanio());
        System.out.println("-----------------------Eliminar Despues ElementoB---------------------------------");
        System.out.println(estudiantes);
        /*primero->[{'e1', 'apell', 12}]->[{'e2', 'apell', 13}]->[{'e3', 'apell', 11}]->[{'e4', 'apell', 20}]-> null*/
        try {
            /*No se puede eliminar despues del ultimo elemento*/
            estudiantes.eliminarDespuesElementoBuscado(e4);
            System.out.println(estudiantes); /*java.lang.Exception: No hay un elemento despues de {'e4', 'apell', 20}*/
        }
        catch(Exception e) {
            System.out.println(e);
        }

        try{
            /*eliminar despues del penultimo elemento*/
            estudiantes.eliminarDespuesElementoBuscado(e3); //elimina e4
            System.out.println(estudiantes); /*primero->[{'e1', 'apell', 12}]->[{'e2', 'apell', 13}]->[{'e3', 'apell', 11}]-> null*/

            estudiantes.eliminarDespuesElementoBuscado(e2); //elimina e3
            System.out.println(estudiantes); /*primero->[{'e1', 'apell', 12}]->[{'e2', 'apell', 13}]-> null*/

            estudiantes.eliminarDespuesElementoBuscado(e1);
            System.out.println(estudiantes);

            estudiantes.eliminarDespuesElementoBuscado(e1); /*si solo hay un nodo*/
            System.out.println(estudiantes);/*java.lang.Exception: No hay un elemento despues de {'e1', 'apell', 12}*/

        }catch (Exception e){
            System.out.println(e);
        }
        try{
            estudiantes.eliminarPrimero();
            System.out.println(estudiantes);
            System.out.println("=> tamaño: " + estudiantes.getTamanio());
        }catch (Exception e){
            System.out.println(e);
        }



        /*
                                    Lista doble
         */
        System.out.println("**************************************Lista Doble *************************************");
        ListaDoble<Estudiante> estudiantesD = new ListaDoble<>(); //crear lista vacia
        System.out.println(estudiantesD); //La lista esta vacia
        System.out.println("=> tamaño: " + estudiantesD.getTamanio());

        System.out.println("------------------------------------Insertar por el inicio-------------------------------------------------");
        estudiantesD.insertarPrimero(e5);
        System.out.println(estudiantesD); /*primero y null <=>[{'e1'}]-> null*/
        estudiantesD.insertarPrimero(e4);
        System.out.println(estudiantesD);/*primero y null <=>[{'e2'}]<=>[{'e1'}]-> null*/
        estudiantesD.insertarPrimero(e3);
        System.out.println(estudiantesD);/*primero y null <=>[{'e3'}]<=>[{'e2'}]<=>[{'e1'}]-> null*/
        estudiantesD.insertarPrimero(e2);
        System.out.println(estudiantesD);/*primero y null <=>[{'e3'}]<=>[{'e2'}]<=>[{'e1'}]-> null*/
        estudiantesD.insertarPrimero(e1);
        System.out.println(estudiantesD);/*primero y null <=>[{'e3'}]<=>[{'e2'}]<=>[{'e1'}]-> null*/
        System.out.println("=> tamaño: " + estudiantesD.getTamanio());
        System.out.println(estudiantesD.imprimirReveso());

        System.out.println("------------------------------------Eliminar por el inicio-------------------------------------------------");
        try {
            estudiantesD.eliminarPrimero();
            System.out.println(estudiantesD); /*primero y null <=>[{'e2'}]<=>[{'e3'}]<=>[{'e4'}]<=>[{'e5'}]-> nul*/
            estudiantesD.eliminarPrimero();
            System.out.println(estudiantesD); /*primero y null <=>[{'e3'}]<=>[{'e4'}]<=>[{'e5'}]-> null*/
            estudiantesD.eliminarPrimero();
            System.out.println(estudiantesD);/*primero y null <=>[{'e4'}]<=>[{'e5'}]-> null*/
            estudiantesD.eliminarPrimero();
            System.out.println(estudiantesD);/*primero y null <=>[{'e5'}]-> null*/
            estudiantesD.eliminarPrimero();
            System.out.println(estudiantesD);/*La lista esta vacia*/

            System.out.println("=> tamaño: " + estudiantesD.getTamanio());

            estudiantesD.eliminarPrimero();
            System.out.println(estudiantesD); /*java.lang.Exception: La lista esta vacia*/
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println("------------------------------------Insertar final-------------------------------------------------");
        estudiantesD.insertarFinal(e1);
        System.out.println(estudiantesD); /*primero y null <=>[{'e1'}]-> null*/
        estudiantesD.insertarFinal(e2);
        System.out.println(estudiantesD); /*primero y null <=>[{'e1'}]<=>[{'e2'}]-> null*/
        estudiantesD.insertarFinal(e3);
        System.out.println(estudiantesD); /*primero y null <=>[{'e1'}]<=>[{'e2'}]<=>[{'e3'}]-> null*/
        estudiantesD.insertarFinal(e4);
        System.out.println(estudiantesD); /*primero y null <=>[{'e1'}]<=>[{'e2'}]<=>[{'e3'}]<=>[{'e4'}]-> null*/
        estudiantesD.insertarFinal(e5);
        System.out.println(estudiantesD); /*primero y null <=>[{'e1'}]<=>[{'e2'}]<=>[{'e3'}]<=>[{'e4'}]<=>[{'e5'}]-> null*/
        System.out.println("=> tamaño: " + estudiantesD.getTamanio());

        System.out.println("------------------------------------Eliminar final-------------------------------------------------");
        try{
            estudiantesD.eliminarFinal();
            System.out.println(estudiantesD); /*primero y null <=>[{'e1'}]<=>[{'e2'}]<=>[{'e3'}]<=>[{'e4'}]-> null*/
            estudiantesD.eliminarFinal();
            System.out.println(estudiantesD); /*primero y null <=>[{'e1'}]<=>[{'e2'}]<=>[{'e3'}]-> null*/
            estudiantesD.eliminarFinal();
            System.out.println(estudiantesD); /*primero y null <=>[{'e1'}]<=>[{'e2'}]-> null*/
            estudiantesD.eliminarFinal();
            System.out.println(estudiantesD); /*primero y null <=>[{'e1'}]-> null*/
            estudiantesD.eliminarFinal();
            System.out.println(estudiantesD); /*La lista esta vacia*/

            System.out.println("=> tamaño: " + estudiantesD.getTamanio());

            estudiantesD.eliminarFinal();
            System.out.println(estudiantesD); /*java.lang.Exception: La lista esta vacia*/

        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println("------------------------------Eliminar Elemento Buscado-----------------------------------------------");
        estudiantesD.insertarFinal(e1);
        estudiantesD.insertarFinal(e2);
        estudiantesD.insertarFinal(e3);
        estudiantesD.insertarFinal(e4);
        estudiantesD.insertarFinal(e5);
        System.out.println(estudiantesD);
        System.out.println("=> tamaño: " + estudiantesD.getTamanio());
        try{
            /*Eliminar el ultimo*/
            estudiantesD.eliminarElementoBuscado(e5);
            System.out.println(estudiantesD);
            /*eliminar el primero*/
            estudiantesD.eliminarElementoBuscado(e1);
            System.out.println(estudiantesD);
            /*eliminar nodo intermedio*/
            estudiantesD.eliminarElementoBuscado(e3);
            System.out.println(estudiantesD);
            estudiantesD.eliminarElementoBuscado(e4);
            System.out.println(estudiantesD);
            estudiantesD.eliminarElementoBuscado(e2);
            System.out.println(estudiantesD);
            estudiantesD.eliminarElementoBuscado(e2);
            System.out.println(estudiantesD);
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println("------------------------------Insertar antes Elemento Buscado-----------------------------------------------");
        try {
            System.out.println(estudiantesD); /*La lista esta vacia*/
            System.out.println("=> tamaño: " + estudiantesD.getTamanio());

            estudiantesD.insertarAntesElementoB(e2, e1);
            System.out.println(estudiantesD); /*java.lang.Exception: La lista esta vacia*/
        }catch (Exception e){
            System.out.println(e);
        }

        try {
            estudiantesD.insertarPrimero(e4);
            System.out.println(estudiantesD); /*primero y null <=>[{'e4'}]-> null*/

            /*Si el eleento buscado esta en el primero o solo hay un nodo*/
            estudiantesD.insertarAntesElementoB(e2,e4);
            System.out.println(estudiantesD); /*primero y null <=>[{'e2'}]<=>[{'e4'}]-> null*/

            /*Si el buscado esta en el final o intermedio*/
            estudiantesD.insertarAntesElementoB(e3, e4);
            System.out.println(estudiantesD); /*primero y null <=>[{'e2'}]<=>[{'e3'}]<=>[{'e4'}]-> null*/

            /*elemento buscado es el primero*/
            estudiantesD.insertarAntesElementoB(e1,e2);
            System.out.println(estudiantesD);/*primero y null <=>[{'e1'}]<=>[{'e2'}]<=>[{'e3'}]<=>[{'e4'}]-> null*/

            /*elemento*/
            estudiantesD.insertarAntesElementoB(e1, e5); /*java.lang.Exception: No se encontro el elemento Buscado*/

        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println("------------------------------Eliminar antes Elemento Buscado-----------------------------------------------");
        System.out.println(estudiantesD.imprimirReveso());
        System.out.println("=> tamaño: " + estudiantesD.getTamanio());
        try{
            /*No se puede eliminar antes del primer nodo*/
            estudiantesD.eliminarAntesElementoB(e1); /*java.lang.Exception: No se puede eliminar antes del primer nodo*/
        }catch (Exception e){
            System.out.println(e);
        }

        try {
            /*eliminar antes del segundo*/
            estudiantesD.eliminarAntesElementoB(e2);
            System.out.println(estudiantesD); /*primero y null <=>[{'e2'}]<=>[{'e3'}]<=>[{'e4'}]-> null*/

            /*eliminar antes del ultimo*/
            estudiantesD.eliminarAntesElementoB(e4);
            System.out.println(estudiantesD);/*primero y null <=>[{'e2'}]<=>[{'e4'}]-> null*/
            estudiantesD.eliminarAntesElementoB(e4);
            System.out.println(estudiantesD);/*primero y null <=>[{'e4'}]-> null*/
            estudiantesD.eliminarAntesElementoB(e4); /*java.lang.Exception: No se puede eliminar antes del primer nodo*/
        }catch (Exception e){
            System.out.println(e);
        }

        try {
            estudiantesD.eliminarPrimero();
            System.out.println(estudiantesD);
            System.out.println("=> tamaño: " + estudiantesD.getTamanio());
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("------------------------------Insertar despues  Elemento Buscado-----------------------------------------------");
        try {
            /*si la lista esta vacia*/
            estudiantesD.insertarDespuesElementoB(e1, e5); /*java.lang.Exception: La lista esta vacia*/
        }catch (Exception e){
            System.out.println(e);
        }

        try {
            estudiantesD.insertarFinal(e1);
            System.out.println(estudiantesD);

            /*Si solo hay un elemento*/
            estudiantesD.insertarDespuesElementoB(e2, e1);
            System.out.println(estudiantesD); /*primero y null <=>[{'e1'}]<=>[{'e2'}]-> null*/

            /*insertar despues del final*/
            estudiantesD.insertarDespuesElementoB(e4,e2);
            System.out.println(estudiantesD); /*primero y null <=>[{'e1'}]<=>[{'e2'}]<=>[{'e4'}]-> null*/

            /*insertar elemento intermedio*/
            estudiantesD.insertarDespuesElementoB(e3, e2);
            System.out.println(estudiantesD); /*primero y null <=>[{'e1'}]<=>[{'e2'}]<=>[{'e3'}]<=>[{'e4'}]-> null*/

            /*no se encuentra el elemento*/
            estudiantesD.insertarDespuesElementoB(e1,e5); /*java.lang.Exception: No se encontro el elemento Buscado*/
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println("------------------------------Eliminar despues  Elemento Buscado-----------------------------------------------");
        System.out.println(estudiantesD.imprimirReveso());
        System.out.println("=> tamaño: " + estudiantesD.getTamanio());

        try {
            /*eliminar despues ultimo elemento*/
            estudiantesD.eliminarDespuesElementoB(e4); /*java.lang.Exception: No se puede eliminar despues del ultimo nodo*/
        }catch (Exception e){
            System.out.println(e);
        }

        try{
            /*eliminar despues del primer nodo*/
            estudiantesD.eliminarDespuesElementoB(e1);
            System.out.println(estudiantesD); /*primero y null <=>[{'e1'}]<=>[{'e3'}]<=>[{'e4'}]-> null*/
            estudiantesD.eliminarDespuesElementoB(e3);
            System.out.println(estudiantesD); /*primero y null <=>[{'e1'}]<=>[{'e3'}]-> null*/
            estudiantesD.eliminarDespuesElementoB(e1);
            System.out.println(estudiantesD);/*primero y null <=>[{'e1'}]-> null*/
            /*no se encuentra el elemento*/
            estudiantesD.eliminarDespuesElementoB(e5); /*java.lang.Exception: No se encontro el elemento Buscado*/

        }catch (Exception e){
            System.out.println(e);
        }

        try{
            estudiantesD.eliminarElementoBuscado(e1);
            System.out.println(estudiantesD);
            System.out.println("=> tamaño: " + estudiantesD.getTamanio());
        }catch (Exception e){
            System.out.println(e);
        }

        /*
                    Lista circular
         */

        System.out.println("********************Lista circular**********************************************");

        /*Crear Lista circular vacia*/
        ListaCircular<Estudiante> estudiantesC = new ListaCircular<>();
        System.out.println(estudiantesC);
        System.out.println("=> tamaño: " + estudiantesC.getTamanio());

        System.out.println("------------------------------------Insertar por el inicio-------------------------------------------------");
        estudiantesC.insertarPrimero(e5);
        System.out.println(estudiantesC); /*primero->[{'e5'}]-> primero*/
        estudiantesC.insertarPrimero(e4);
        System.out.println(estudiantesC); /*primero->[{'e4'}]->[{'e5'}]-> primero*/
        estudiantesC.insertarPrimero(e3);
        System.out.println(estudiantesC); /*primero->[{'e3'}]->[{'e4'}]->[{'e5'}]-> primero*/
        estudiantesC.insertarPrimero(e2);
        System.out.println(estudiantesC);/*primero->[{'e2'}]->[{'e3'}]->[{'e4'}]->[{'e5'}]-> primero*/
        estudiantesC.insertarPrimero(e1);
        System.out.println(estudiantesC);/*primero->[{'e1'}]->[{'e2'}]->[{'e3'}]->[{'e4'}]->[{'e5'}]-> primero*/

        System.out.println("=> tamaño: " + estudiantesC.getTamanio());

        System.out.println("------------------------------------Eliminar por el inicio-------------------------------------------------");
        try {
            estudiantesC.elimimarPrimero();
            System.out.println(estudiantesC); /*primero->[{'e2'}]->[{'e3'}]->[{'e4'}]->[{'e5'}]-> primero*/
            estudiantesC.elimimarPrimero();
            System.out.println(estudiantesC);/*primero->[{'e3'}]->[{'e4'}]->[{'e5'}]-> primero*/
            estudiantesC.elimimarPrimero();
            System.out.println(estudiantesC); /*primero->[{'e4'}]->[{'e5'}]-> primero*/
            estudiantesC.elimimarPrimero();
            System.out.println(estudiantesC);/*primero->[{'e5'}]-> primero*/
            estudiantesC.elimimarPrimero();
            System.out.println(estudiantesC);/*La lista esta vacia*/

            /*si la lista esta vacia*/
            estudiantesC.elimimarPrimero(); /*java.lang.Exception: No se puede eliminar. la lista esta vacia*/
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println("------------------------------------Insertar por el Final-------------------------------------------------");
        System.out.println("=> tamaño: " + estudiantesC.getTamanio());
        estudiantesC.insertarFinal(e1);
        System.out.println(estudiantesC); /*primero->[{'e1'}]-> primero*/
        estudiantesC.insertarFinal(e2);
        System.out.println(estudiantesC); /*primero->[{'e1'}]->[{'e2'}]-> primero*/
        estudiantesC.insertarFinal(e3);
        System.out.println(estudiantesC); /*primero->[{'e1'}]->[{'e2'}]->[{'e3'}]-> primero*/
        estudiantesC.insertarFinal(e4);
        System.out.println(estudiantesC); /*primero->[{'e1'}]->[{'e2'}]->[{'e3'}]->[{'e4'}]-> primero*/
        estudiantesC.insertarFinal(e5);
        System.out.println(estudiantesC); /*primero->[{'e1'}]->[{'e2'}]->[{'e3'}]->[{'e4'}]->[{'e5'}]-> primero*/

        System.out.println("=> tamaño: " + estudiantesC.getTamanio());
        System.out.println("------------------------------------Eliminar por el Final-------------------------------------------------");
        try{
            estudiantesC.eliminarFinal();
            System.out.println(estudiantesC); /*primero->[{'e1'}]->[{'e2'}]->[{'e3'}]->[{'e4'}]-> primero*/
            estudiantesC.eliminarFinal();
            System.out.println(estudiantesC);/*primero->[{'e1'}]->[{'e2'}]->[{'e3'}]-> primero*/
            estudiantesC.eliminarFinal();
            System.out.println(estudiantesC);/*primero->[{'e1'}]->[{'e2'}]-> primero*/
            estudiantesC.eliminarFinal();
            System.out.println(estudiantesC); /*primero->[{'e1'}]-> primero*/
            estudiantesC.eliminarFinal();
            System.out.println(estudiantesC);/*La lista esta vacia*/
            System.out.println("=> tamaño: " + estudiantesC.getTamanio());

            estudiantesC.eliminarFinal();
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println("------------------------------------Eliminar Dato Buscado-------------------------------------------------");
        try {
            /*lista vacia*/
            estudiantesC.eliminarElementoBuscado(e1); /*java.lang.Exception: No se puede eliminar elelemnto buscado en lista vacia*/
        }catch (Exception e){
            System.out.println(e);
        }

        estudiantesC.insertarPrimero(e4);
        estudiantesC.insertarPrimero(e3);
        estudiantesC.insertarPrimero(e2);
        estudiantesC.insertarPrimero(e1);
        System.out.println(estudiantesC);
        System.out.println("=> tamaño: " + estudiantesC.getTamanio());

        try{
            /*Eliminar primero*/
            estudiantesC.eliminarElementoBuscado(e1);
            System.out.println(estudiantesC); /*primero->[{'e2'}]->[{'e3'}]->[{'e4'}]-> primero*/

            /*eliminar intermedio*/
            estudiantesC.eliminarElementoBuscado(e3);
            System.out.println(estudiantesC); /*primero->[{'e2'}]->[{'e4'}]-> primero*/

            /*eliminar final*/
            estudiantesC.eliminarElementoBuscado(e4);
            System.out.println(estudiantesC); /*primero->[{'e2'}]-> primero*/

            /*eliminar 1 solo nodo*/
            estudiantesC.eliminarElementoBuscado(e2);
            System.out.println(estudiantesC); /*La lista esta vacia*/
            System.out.println("=> tamaño: " + estudiantesC.getTamanio());

            estudiantesC.eliminarElementoBuscado(e5);/*java.lang.Exception: No se puede eliminar elelemnto buscado en lista vacia*/

        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println("------------------------------------Insertar Antes Dato Buscado-------------------------------------------------");
        try{
            /*Lista vacia*/
            System.out.println("=> tamaño: " + estudiantesC.getTamanio());
            estudiantesC.insertarAntesElementoB(e1, e5); /*java.lang.Exception: no se puede insertar antes de una lista vacia*/
        }catch (Exception e){
            System.out.println(e);
        }

        try {
            /*creando un elemento*/
            estudiantesC.insertarFinal(e4);
            System.out.println(estudiantesC);

            /*insertar antes del primero*/
            estudiantesC.insertarAntesElementoB(e1,e4);
            System.out.println(estudiantesC);/*primero->[{'e1'}]->[{'e4'}]-> primero*/
            /*insertar antes del ultimo*/
            estudiantesC.insertarAntesElementoB(e3,e4);
            System.out.println(estudiantesC);/*primero->[{'e1'}]->[{'e3'}]->[{'e4'}]-> primero*/
            /*insertar antes intermedio*/
            estudiantesC.insertarAntesElementoB(e2, e3);
            System.out.println(estudiantesC);/*primero->[{'e1'}]->[{'e2'}]->[{'e3'}]->[{'e4'}]-> primero*/

            estudiantesC.insertarAntesElementoB(e1, e5); /*java.lang.Exception: No se encontro el elemento buscado*/
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println("------------------------------------Eliminar Antes Dato Buscado-------------------------------------------------");
        try {
            System.out.println(estudiantesC);
            System.out.println("=> tamaño: " + estudiantesC.getTamanio());

            /*eliminamos el priemr nodo*/
            estudiantesC.eliminarAntesElementoB(e1); /*java.lang.Exception: No existe un nodo antes de {'e1'}*/
        }catch (Exception e){
            System.out.println(e);
        }

        try {
            /*eliminar antes del segundo*/
            estudiantesC.eliminarAntesElementoB(e2);
            System.out.println(estudiantesC); /*primero->[{'e2'}]->[{'e3'}]->[{'e4'}]-> primero*/

            /*eliminar tercero*/
            estudiantesC.eliminarAntesElementoB(e4);
            System.out.println(estudiantesC); /*primero->[{'e2'}]->[{'e4'}]-> primero*/

            estudiantesC.eliminarAntesElementoB(e4); /*primero->[{'e4'}]-> primero*/
            System.out.println(estudiantesC);

            estudiantesC.eliminarAntesElementoB(e4); /*java.lang.Exception: No existe un nodo antes de {'e4'}*/
        }catch (Exception e){
            System.out.println(e);
        }

        try {
            estudiantesC.elimimarPrimero();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(estudiantesC);
        System.out.println("=> tamaño: " + estudiantesC.getTamanio());
    }
}
