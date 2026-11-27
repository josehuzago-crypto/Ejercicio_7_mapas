
package ejercicio_7_maps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Ejercicio_7_Maps {

    /*
 * Instrucciones:
 * Desarrolla un contador de frecuencia de palabras utilizando un `HashMap<String, Integer>`.
 * Dada una cadena de texto, el programa debe separar las palabras, normalizarlas (por ejemplo,
 * convirtiéndolas a minúsculas y eliminando signos de puntuación básicos) y contabilizar cuántas
 * veces aparece cada palabra.
 *
 * Implementa una clase con un método principal (`main`) que realice lo siguiente:
 * 1. Definir un texto de prueba con palabras repetidas, mayúsculas/minúsculas y puntuación.
 * 2. Procesar el texto y llenar el `HashMap<String, Integer>` donde la clave sea la palabra
 *    y el valor sea su frecuencia de aparición.
 * 3. Consultar y mostrar cuántas veces aparece una palabra específica de interés.
 * 4. Identificar y mostrar la palabra con mayor frecuencia (y su conteo).
 * 5. Recorrer el mapa para imprimir todas las palabras únicas y su frecuencia total.
 */
    
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        
       //Definimos texto a probar
        System.out.print("Ingrese un texto: ");
        //String textoPrueba = "java Es facIl, Java ES de tipaDO ; fuERte java con git";
       String textoPrueba = input.nextLine();
       
       //Separamos palabras en un arreglo de String 
       String palabras[] = textoPrueba.split("[,;\\s]+");
       
       //Definimos y llenamos el Mapa
        HashMap<String, Integer> frecuencia = new HashMap<>();
        rellenarMapa(palabras, frecuencia);
        
        //Consulat palabra
        boolean existe = false;
        
        do{
            System.out.println("--------Palabras--------");
            mostrarElementos(frecuencia,false);
            
            System.out.print("Ingrese palabras a buscar: ");
            String palabra = input.nextLine();
            
            existe = frecuencia.containsKey(palabra.toLowerCase());
            
            if (existe){
                System.out.println("\nEncontrada");
                System.out.println("Palabra: "+palabra);
                System.out.println("Frecuencia: "+frecuencia.get(palabra.toLowerCase()));
            }else{
                System.out.println("\nNo encontrada ingrese otra de nuevo");
            }
            
        }while(!existe);
        
        //Buscar palabra con mayor frecuencia
        palabraMayorFrecuencia(frecuencia);
        
        //Mostramos toda la lista de elementos
        System.out.println("\nPalabras unicas y su frecuencia");
        mostrarElementos(frecuencia,true);
        
    }
    
    private static void rellenarMapa(String [] palabras, HashMap<String, Integer> frecuencia){
        
        for(String palabra: palabras){
            
            String capi = palabra.toLowerCase();
            
            if(frecuencia.containsKey(capi)){
                
                int aux = frecuencia.get(capi) + 1;
                
                frecuencia.replace(capi, aux);
            }else{
                frecuencia.put(capi, 1);
            }
        }
    }
    
    private static void mostrarElementos(HashMap<String, Integer> frecuencia, boolean mostrarFrecuencia){
        
        if (mostrarFrecuencia) {
            for (Map.Entry par : frecuencia.entrySet()) {
                System.out.println("Palabra: " + par.getKey());
                System.out.println("Frecuencia: " + par.getValue());
                System.out.println("");
            }
        }else {
            for (Map.Entry par : frecuencia.entrySet()) {
                System.out.println("Palabra: " + par.getKey());
                //System.out.println("");
            }
        }
        
        
    }
    
    private static void palabraMayorFrecuencia(HashMap<String, Integer> frecuencia){
        
        ArrayList<String> palabras = new ArrayList<>();
        int frecAlta = 0;
        int frec = 0;
        String palabra;
        
        
        //Buscamos palabra
        for(Map.Entry par: frecuencia.entrySet()){
            
            palabra = (String)par.getKey();
            frec = (Integer)par.getValue();
            
            if(frec > frecAlta){//Significa que se encontro una palabra con mayor frecuencia
                
                frecAlta = frec;
                
                //Limpiamos lista porque hay otra u otras palabras con mayor frecuencia en la lista que deben ser borradas
                palabras.clear();
                
                palabras.add(palabra);    
            }else if (frec == frecAlta){//Si una palabra y otra contienen las misma frecuencia solo agregamos a la lista esa otra palabra
                palabras.add(palabra);
            }
        }
        
        System.out.println("\nMayor frecuencia ");
        for(String word: palabras){
            System.out.println("\nPalabra: "+word);
            System.out.println("Frecuencia: "+frecAlta);  
        }
        
    }
    
    

    
    
}
