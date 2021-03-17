/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario;

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
    
}
