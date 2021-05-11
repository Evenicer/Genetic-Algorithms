/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author working
 */
public class Herramientas {
    
    public static int[] generarArregloBinarios(int n ){
        int[] arreglo = new int[n];
        Random ran = new Random();
        for(int x=0; x< n ;x++){
            arreglo[x]= ran.nextInt(2);
        }
        return arreglo;
    }
    
    public static int[] generarArregloReinas(int n ){
        int[] arreglo = new int[n];
        Random ran = new Random();
        for(int x=0; x< n ;x++){
            arreglo[x]= ran.nextInt(n);
        }
        return arreglo;
    }
    
    public static int[] generarArregloTsp(int n ){
        int[] arreglo = new int[n];
        Random ran = new Random();
        
        do{
        for(int x=0; x< n ;x++){
            arreglo[x]= ran.nextInt(2);
        }
        }while(Validar(arreglo) == false);
        
        return arreglo;
    }
    
    public static boolean Validar(int[] mask) {
        boolean repetido = false;

        for (int i = 0; i < mask.length - 1; i++) {
            for (int j = i+1; j < mask.length; j++) {
                if (mask[i] != mask[j]) {
                    repetido = true;
                }
            }
        }
        return repetido;
    }
    
    public static nReinas.Individuo mejorPoblacion(ArrayList<nReinas.Individuo> pob){
        nReinas.Individuo mejor = new nReinas.Individuo(pob.get(0));
        for(nReinas.Individuo aux: pob){
            if (aux.getFitness()< mejor.getFitness()){
                mejor = new nReinas.Individuo(aux);
            }
        }
        return mejor;
    }
}
