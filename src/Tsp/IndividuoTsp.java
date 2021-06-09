/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tsp;

/**
 *
 * @author Rogelio Valle
 */
public class IndividuoTsp {

    public static int[][] matrizDistancias;
    public static int[][] matrizInclinaciones;

    private int[] genotipo;
    private double fitness;
    private double fitnessInclinacion;
    private double fitnessGeneral;

    public static int CInicial;

    public IndividuoTsp(int tam) {
        genotipo = HerramientasTsp.GenerarGenotipoAleatorio(tam, this.CInicial);
        genotipo[0] = this.CInicial;
        calcularFitnessDistancias();
        calcularFitnessInclinacion();
        calcularFitnessGeneral();
    }

    public IndividuoTsp(int[] genotipo) {
        this.CInicial = genotipo[0];
        this.genotipo = genotipo.clone();
        calcularFitnessDistancias();
        calcularFitnessInclinacion();
        calcularFitnessGeneral();
    }

    public IndividuoTsp(IndividuoTsp i) {
        this.genotipo = i.getGenotipo().clone();
        this.fitnessGeneral = i.getFitnessGeneral();
    }
    
    public void calcularFitnessDistancias(){
        if(matrizDistancias != null){
            int valor = matrizDistancias[this.genotipo[0]][this.genotipo[this.genotipo.length-1]];
            for(int i=0;i<this.genotipo.length-1;i++){
                valor += matrizDistancias[this.genotipo[i]][this.genotipo[i+1]];
            }
            this.fitness = valor;
        }
        else{
            this.fitness = -1;
        }
    }
        
    public void calcularFitnessInclinacion() {
        
        for(int x=0; x < this.genotipo.length-1; x++){
           if(matrizDistancias[this.genotipo[x]][this.genotipo[x+1]] > 0){
               this.fitnessGeneral -= matrizDistancias[this.genotipo[x]][this.genotipo[x+1]];
           }else if(matrizDistancias[this.genotipo[x]][this.genotipo[x+1]] < 0 ){
               this.fitnessGeneral += matrizDistancias[this.genotipo[x]][this.genotipo[x+1]];
           }else if(matrizDistancias[this.genotipo[x]][this.genotipo[x+1]] == 0 ){
               this.fitnessGeneral = this.fitnessGeneral;
           }
        }
        //Se agrega la inclinacion de la ultima a la primer ciudad
        this.fitnessInclinacion += matrizDistancias[this.genotipo[this.genotipo.length-1]][this.genotipo[0]];
    }
    
    private void calcularFitnessGeneral(){
        
        //System.out.println("Distancia: "+this.fitness);
        //System.out.println("Inclinacion: "+this.fitnessInclinacion);
        this.fitnessGeneral = (0.5)*(this.fitness) + (0.5)*(this.fitnessInclinacion);
    }

    public int getCInicial() {
        return CInicial;
    }

    public double getFitness() {
        return fitness;
    }

    public int[] getGenotipo() {
        return genotipo;
    }
    
    public double getFitnessInclinacion() {
        return fitnessInclinacion;
    }

    public double getFitnessGeneral() {
        return fitnessGeneral;
    }

}
