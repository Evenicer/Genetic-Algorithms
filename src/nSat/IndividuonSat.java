/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nSat;

import java.util.ArrayList;

/**
 *
 * @author Rogelio Valle
 */
public class IndividuonSat {

    //Atributos del individuo para el problema 3Sat
    private int[] genotipo;
    private int fitness;
    private int n;
    public static ArrayList<Integer[]> clausulas;

    public IndividuonSat(int n) {
        this.n = n;
        this.genotipo = binario.Herramientas.generarArregloBinarios(n);
        calcularFitness();
    }
    
    public IndividuonSat(int n , int x){
        this.n = n;
        int[] arreglo = new int[]{0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0};
        this.genotipo = arreglo;
        calcularFitness();
        System.out.println("Fitness "+fitness);
    }

    public IndividuonSat(int[] gen) {
        // valorar su inicio aleatorio
        this.n = gen.length;
        this.genotipo = gen.clone();
        calcularFitness();
    }

    public IndividuonSat(IndividuonSat i) {
        this.genotipo = i.getGenotipo().clone();
        this.fitness = i.getFitness();
    }
    
    public void ActualizarInd(){
        calcularFitness();
    }
  
     private void calcularFitness() {
        // recorrer las clausulas
        this.fitness = 0;
        for (Clausula c:Herramientas.clausulas){
            if(verificarClausula(c)){
                this.fitness++;
            } 
        }
    }

    private boolean verificarClausula(Clausula c) {
       return (verificarNeg(c.getA())==1||
               verificarNeg(c.getB())==1||
               verificarNeg(c.getC())==1);
            
    }

    private int verificarNeg(int a) {
       boolean negacion = false;
       int valor = -1;
       if(a<0){
           a*=-1;
           negacion = true;
           
       }
       if (negacion){
            valor = this.genotipo[a-1];
        if (valor==0){valor = 1;}else{
            valor = 0;
        }
       } else {
            valor = this.genotipo[a-1];
       }
       return valor;
    }
    
    
    public int[] getGenotipo() {
        return genotipo;
    }

    public int getFitness() {
        return fitness;
    }
    
    
    
    

//    private void calcularFitness() {
//        // recorrer las clausulas
//        this.fitness = 0;
//        for (Clausula c : Herramientas.clausulas) {
//                if((valor(c.getA()) == 1) || (valor(c.getB()) == 1) || (valor(c.getC()) == 1) ){
//                    this.fitness++;
//                }
//        }
//    }
//
//    private int valor(int a){
//        boolean negacion = false;
//        int valor = 0;
//        
//        if(a < 0){
//            a = a*-1;
//            negacion = true;
//        }
//        
//        if(negacion){
//            if(this.genotipo[a-1] == 1){
//                valor = 1;
//            }else if(this.genotipo[a-1] == 0){
//                valor = 0;
//            }
//        }else{
//            valor = this.genotipo[a-1];
//        }
//        return valor;
//    }
    
}
