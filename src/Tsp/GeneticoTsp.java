/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tsp;

import HerramientasGeneral.Grafica;
import binario.Herramientas;
import java.util.ArrayList;

/**
 *
 * @author Rogelio Valle
 */
public class GeneticoTsp {
      //Elementos que necesitamos
    private int tamPob;
    private double probMuta;
    private int numGeneraciones;
    private int tamGenotipo;
    private ArrayList<IndividuoTsp> poblacionActual;
    private int[] fitness;
    private int CInicial;
    private int[][] matrizDistancias;
    
    
    public GeneticoTsp(int tamPob, double probMuta, int numGeneraciones , int tamGenotipo , int CInicial , int[][] matrizDistancias){
        this.tamPob = tamPob;
        this.probMuta = probMuta;
        this.numGeneraciones = numGeneraciones;
        this.tamGenotipo = tamGenotipo;
        this.poblacionActual = new ArrayList<>();
        this.CInicial = CInicial;
        IndividuoTsp.CInicial = CInicial;
        this.fitness = new int[this.numGeneraciones];
        IndividuoTsp.matrizDistancias = matrizDistancias;
    }
    
    public void Evolucionar(){
        //Se genera una poblacion inicial
        generarPoblacionInicial();
        
        int[] mask;
        //ciclo para las generaciones
        for(int i=1; i<this.numGeneraciones; i++){
            //proceso iterativo para creacion de la nueva poblacion
            ArrayList<IndividuoTsp> nuevaPob = new ArrayList<>();
            for(int j=0; j<tamPob; j++){
                //Seleccionamos una madre y un padre
                IndividuoTsp padre = Seleccion.seleccionAleatoria(this.getPoblacionActual());
                IndividuoTsp madre = Seleccion.seleccionAleatoria(this.getPoblacionActual());
                //Se crea una mascara
                mask = Herramientas.generarArregloTsp(this.tamGenotipo);
                //cruza
                IndividuoTsp hijo = Cruza.cruzaMascara2(madre, padre,mask);
                //evaluar la probabilidad de muta
                if (generarProbabilidadMuta()){
                    Muta.mutaIntercambio2(hijo);
                }
                //agregamos el individuo a la nueva poblacion
                nuevaPob.add(hijo);
            }
            //Actualuzamos la poblacion actual
            sustituirPoblacion(nuevaPob);
            System.out.println("Generacion: "+i+" Fitness: "+HerramientasTsp.mejorPoblacion(nuevaPob).getFitness());
            fitness[i] = HerramientasTsp.mejorPoblacion(nuevaPob).getFitness();
        }
        graficar();
    }
    
     public void graficar (){
       
        Grafica g1 = new Grafica("Generaciones","Fitness","TSP");
        g1.agregarSerie("Mejor Fitness:", this.fitness);
        g1.crearGrafica();
        g1.muestraGrafica();
    
    }
    
     private void generarPoblacionInicial() {
        // generar un población aleatoria de individuos
        for (int i = 0; i < this.tamPob; i++) {
            this.getPoblacionActual().add(new IndividuoTsp(this.tamGenotipo));
        }
    }
     
    private boolean generarProbabilidadMuta() {
        if (this.probMuta > Math.random()) {
            return true;
        } else {
            return false;
        }

    }

    private void sustituirPoblacion(ArrayList<IndividuoTsp> nuevaPob) {
        this.getPoblacionActual().clear();
        for (IndividuoTsp aux : nuevaPob) {
            this.getPoblacionActual().add(new IndividuoTsp(aux));
        }
    }

    /**
     * @return the poblacionActual
     */
    public ArrayList<IndividuoTsp> getPoblacionActual() {
        return poblacionActual;
    }
}
