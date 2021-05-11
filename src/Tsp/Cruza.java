/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tsp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Rogelio Valle
 */
public class Cruza {
    
    public static IndividuoTsp cruza(int mask[] , IndividuoTsp madre, IndividuoTsp padre){
        int genotipo1[] = new int[mask.length];
        int genotipo2[] = new int[mask.length];
        
        do{
        //Con un for recorro la mascara y comparo con los genotipos
        for (int i = 0; i < mask.length; i++) {
            if (mask[i] == 1) {
                genotipo1[i] = madre.getGenotipo()[i];
                genotipo2[i] = padre.getGenotipo()[i];
            } else {
                genotipo1[i] = padre.getGenotipo()[i];
                genotipo2[i] = madre.getGenotipo()[i];
            }
        }
        }while(Validar(genotipo1) == true && Validar(genotipo2) == true);
        
        IndividuoTsp hijo1 = new IndividuoTsp(genotipo1);
        IndividuoTsp hijo2 = new IndividuoTsp(genotipo2);

        //comparamos el fenotipo de los dos para retornar al mejor adaptado
        if (hijo1.getFitness() < hijo2.getFitness()) {
            return hijo1;
        } else {
            return hijo2;
        }
    } 

    public static IndividuoTsp cruza1punto(int mask[], IndividuoTsp madre, IndividuoTsp padre) {
        // int genotipo1[] = new int[mask.length];
        // int genotipo2[] = new int[mask.length];

        int maskAux[] = new int[padre.getGenotipo().length - 1];
        int geno1[] = new int[padre.getGenotipo().length];
        int geno2[] = new int[madre.getGenotipo().length];
        IndividuoTsp hijo1 = new IndividuoTsp(5);
        IndividuoTsp hijo2 = new IndividuoTsp(5);

        do {
        //Creo una mascara de indices
        for (int i = 0; i < maskAux.length; i++) {
            maskAux[i] = -1;
        }
       
        for (int i = 1; i <= maskAux.length; i++) {
            int ind = HerramientasTsp.generarIndiceValido(maskAux);
            maskAux[ind] = i;
        }
      
            geno1[0] = padre.getGenotipo()[0];
            geno2[0] = madre.getGenotipo()[0];
            // construimos los nuevos genotipos
            for (int x = 1; x < geno1.length; x++) {
                geno1[maskAux[x - 1]] = padre.getGenotipo()[x];
                geno2[maskAux[x - 1]] = madre.getGenotipo()[x];
            }
            System.out.println(Validar(geno1)+" "+Validar(geno2));
            
        } while (Validar(geno1) == true && Validar(geno2) == true);

        if(Validar(geno1) == false && Validar(geno2) == false){
        
        hijo1 = new IndividuoTsp(geno1);
        hijo2 = new IndividuoTsp(geno2);
        
        //comparamos el fenotipo de los dos para retornar al mejor adaptado
        if (hijo1.getFitness() < hijo2.getFitness()) {
            return hijo1;
        }
      }
        return hijo2;
    }

    public static boolean Validar(int[] hijo) {
        boolean repetido = false;

        for (int i = 0; i < hijo.length - 1; i++) {
            for (int j = i+1; j < hijo.length; j++) {
                if (hijo[i] == hijo[j]) {
                    repetido = true;
                }
            }
        }
        return repetido;
    }

    public static IndividuoTsp cruzaMascara(IndividuoTsp madre, IndividuoTsp padre) {
        int genotipo1[] = new int[padre.getGenotipo().length];
        int genotipo2[] = new int[padre.getGenotipo().length];
        int[] mask;
       
        do{
            mask = binario.Herramientas.generarArregloBinarios(madre.getGenotipo().length-1);
            //System.out.println(mask.toString().trim());
            genotipo1[0] = padre.getGenotipo()[0];
            genotipo2[0] = madre.getGenotipo()[0];
        //Con un for recorro la mascara y comparo con los genotipos
        for (int i = 0; i < mask.length; i++) {
            if (mask[i] == 1) {
                genotipo1[i+1] = madre.getGenotipo()[i+1];
                genotipo2[i+1] = padre.getGenotipo()[i+1];
            } else {
                genotipo1[i+1] = padre.getGenotipo()[i+1];
                genotipo2[i+1] = madre.getGenotipo()[i+1];
            }
        }
        }while( (Validar(genotipo1) == true && Validar(genotipo2) == true) 
                || (Validar(genotipo1) == false && Validar(genotipo2) == true)
                || (Validar(genotipo1) == true && Validar(genotipo2) == false));
        
        
        
        
        IndividuoTsp hijo1 = new IndividuoTsp(genotipo1);
        IndividuoTsp hijo2 = new IndividuoTsp(genotipo2);

        //comparamos el fenotipo de los dos para retornar al mejor adaptado
        if (hijo1.getFitness() < hijo2.getFitness()) {
            return hijo1;
        } else {
            return hijo2;
        }
    }
    
    public static IndividuoTsp cruzaMascara2(IndividuoTsp madre, IndividuoTsp padre ,int[] mask) {
        int genotipo1[] = new int[padre.getGenotipo().length];
        int genotipo2[] = new int[padre.getGenotipo().length];
        
        //Declaro arraylist para controlas las posiciones mejor
         ArrayList aux1 = new ArrayList();
         ArrayList aux2 = new ArrayList();
         ArrayList aux3 = new ArrayList();
         ArrayList hijo1 = new ArrayList();
         ArrayList hijo2 = new ArrayList();
        
        int aux[] = new int[padre.getGenotipo().length];
        
        //Hago una mascara de puros 1 para copiar toda la madre en un arraylist
        for(int i=0; i<mask.length; i++){
             aux[i] = 1;
         }
        
        //copio a la madre en un arraylist
        for(int i=0; i<mask.length; i++){
             if(aux[i] == 1){
                 aux3.add(madre.getGenotipo()[i]);
             }
         }
        
        //La primera posision siempre sera la primer ciudad
        aux1.add(padre.getCInicial());
        
        //Ahora en donde tenga 1 de mi mascara lo copio en un arraylist
        for(int i=1; i<mask.length; i++){
             if(mask[i] == 1){
                 //aux[i] = padre.getGenotipo()[i];
                 aux1.add(padre.getGenotipo()[i]);
             }
         }
        
        //Elimino del segundo arraylist los elementos que tengo del primero
        for(int i=0; i<aux1.size(); i++){
             for(int j=0; j<aux3.size(); j++){
                 if(aux1.get(i).equals(aux3.get(j))){
                     aux3.remove(j);
                 }
             }
         }
        
        //Creo un nuevo array list con los primeros elementos que saque
        //Y le agrego los del segundo arraylist
         hijo1.addAll(aux1);
         hijo1.addAll(aux3);
         
         //Cambio las posiciones del segundo arraylist para tener un segundo genotipo
         Collections.reverse(aux3);
         
         //Agrego el segundo genotipo
         hijo2.addAll(aux1);
         hijo2.addAll(aux3);
          
         if(hijo1.size() > madre.getGenotipo().length){
             hijo1.subList(5, hijo1.size()).clear();
         }
         
         if(hijo2.size() > madre.getGenotipo().length){
             hijo2.subList(5, hijo2.size()).clear();
         }
         
         //Aqui los convierto a un arreglo de enteros
         for(int i=0; i<hijo1.size(); i++){
             genotipo1[i] = (int)hijo1.get(i);
             genotipo2[i] = (int)hijo2.get(i);
         }
          
        
        IndividuoTsp hijo1_ = new IndividuoTsp(genotipo1);
        IndividuoTsp hijo2_ = new IndividuoTsp(genotipo2);

        //comparamos el fenotipo de los dos para retornar al mejor adaptado
        if ((hijo1_.getFitness() < hijo2_.getFitness()) && (hijo1_.getFitness() < padre.getFitness()) && (hijo1_.getFitness() < madre.getFitness())  ) {
            return hijo1_;
        } else if( (hijo2_.getFitness() < hijo1_.getFitness()) && (hijo2_.getFitness() < padre.getFitness()) && (hijo2_.getFitness() < madre.getFitness()) ) {
            return hijo2_;
        } else if( (padre.getFitness() < hijo2_.getFitness()) && (padre.getFitness() < hijo1_.getFitness()) && (padre.getFitness() < madre.getFitness()) ){
            return padre;
        }else{
            return madre;
        }
    }
    
     public static IndividuoTsp cruzaMascara3(IndividuoTsp madre, IndividuoTsp padre) {
        int genotipo1[] = new int[padre.getGenotipo().length];
        int genotipo2[] = new int[padre.getGenotipo().length];
        
        //Declaro arraylist para controlas las posiciones mejor
         ArrayList aux1 = new ArrayList();
         ArrayList aux2 = new ArrayList();
         ArrayList aux3 = new ArrayList();
         ArrayList hijo1 = new ArrayList();
         ArrayList hijo2 = new ArrayList();
        
        int aux[] = new int[padre.getGenotipo().length];
        
        //Hago una mascara de puros 1 para copiar toda la madre en un arraylist
        for(int i=0; i<padre.getGenotipo().length; i++){
             aux[i] = 1;
         }
        
        //copio a la madre en un arraylist
        for(int i=0; i<padre.getGenotipo().length; i++){
             if(aux[i] == 1){
                 aux3.add(madre.getGenotipo()[i]);
             }
         }
        
        //La primera posision siempre sera la primer ciudad
        aux1.add(padre.getCInicial());
        
        double num = padre.getGenotipo().length/2;
            
        //Ahora en donde tenga 1 de mi mascara lo copio en un arraylist
        for(int i=(int) Math.round(num); i<padre.getGenotipo().length; i++){
                 //aux[i] = padre.getGenotipo()[i];
                 aux1.add(padre.getGenotipo()[i]);
         }
        
        //Elimino del segundo arraylist los elementos que tengo del primero
        for(int i=0; i<aux1.size(); i++){
             for(int j=0; j<aux3.size(); j++){
                 if(aux1.get(i).equals(aux3.get(j))){
                     aux3.remove(j);
                 }
             }
         }
        
        //Creo un nuevo array list con los primeros elementos que saque
        //Y le agrego los del segundo arraylist
         hijo1.addAll(aux1);
         hijo1.addAll(aux3);
         
         //Cambio las posiciones del segundo arraylist para tener un segundo genotipo
         Collections.reverse(aux3);
         
         //Agrego el segundo genotipo
         hijo2.addAll(aux1);
         hijo2.addAll(aux3);
          
         if(hijo1.size() > madre.getGenotipo().length){
             hijo1.subList(5, hijo1.size()).clear();
         }
         
         if(hijo2.size() > madre.getGenotipo().length){
             hijo2.subList(5, hijo2.size()).clear();
         }
         
         //Aqui los convierto a un arreglo de enteros
         for(int i=0; i<hijo1.size(); i++){
             genotipo1[i] = (int)hijo1.get(i);
             genotipo2[i] = (int)hijo2.get(i);
         }
          
        
        IndividuoTsp hijo1_ = new IndividuoTsp(genotipo1);
        IndividuoTsp hijo2_ = new IndividuoTsp(genotipo2);

        //comparamos el fenotipo de los dos para retornar al mejor adaptado
        if (hijo1_.getFitness() < hijo2_.getFitness()) {
            return hijo1_;
        } else {
            return hijo2_;
        }
    }
     
}
