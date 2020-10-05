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
public class pruebaPrimitivos {
    public static void main(String[] args) {
        ListaSimple<Integer> numeros = new ListaSimple<>(); //crear lista vacia
        try {
            numeros.insertarPrimero(5);
            System.out.println(numeros);
            numeros.insertarAntesElementoBuscado(8, 5);
            System.out.println(numeros);
            numeros.insertarAntesElementoBuscado(5, 10);
            System.out.println(numeros);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
    }
    
}
