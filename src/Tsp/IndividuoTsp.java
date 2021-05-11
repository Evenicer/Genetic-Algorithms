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

    private int[] genotipo;
    private int fitness;
    public static int CInicial;

    public IndividuoTsp(int tam) {
        genotipo = HerramientasTsp.GenerarGenotipoAleatorio(tam, this.CInicial);
        genotipo[0] = this.CInicial;
        calcularFitness();
    }

    public IndividuoTsp(int[] genotipo) {
        this.CInicial = genotipo[0];
        this.genotipo = genotipo.clone();
        calcularFitness();
    }

    public IndividuoTsp(IndividuoTsp i) {
        this.genotipo = i.getGenotipo().clone();
        this.fitness = i.getFitness();
    }
    
    public void calcularFitness(){
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

    public int getCInicial() {
        return CInicial;
    }

    public int getFitness() {
        return fitness;
    }

    public int[] getGenotipo() {
        return genotipo;
    }

}
