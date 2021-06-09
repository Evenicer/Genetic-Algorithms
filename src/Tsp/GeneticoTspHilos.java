/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tsp;

import HerramientasGeneral.Grafica;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import nSat.NSatHilosJFrame;
import org.jfree.data.xy.XYDataItem;

/**
 *
 * @author Rogelio Valle
 */
public class GeneticoTspHilos implements Runnable{
    
    // parametros
    private ArrayList<IndividuoTsp> poblacionActual;
    private Control control;
    private double[] fitness;
    
    public GeneticoTspHilos(Control manager) {
        this.control = manager;
        this.poblacionActual = new ArrayList<>();
        this.fitness = new double[this.control.getNumGeneraciones()];
    }
    
    public void evolucionar() throws InterruptedException {
        
        Grafica g1 = new Grafica("Generaciones","Fitness","Tsp");
        g1.crearGrafica();
        g1.agrearSerie("RED");
        g1.muestraGrafica();

        generarPoblacionInicial();
        // generar las itereaciones para las generaciones
        for(int i=1; i<this.control.getNumGeneraciones(); i++){
            ArrayList<IndividuoTsp> nuevaPob = new ArrayList<>();
            for(int j=0; j<this.control.getTamPoblacion(); j++){
                // seleccionamos
                IndividuoTsp madre = this.control.ElegirSeleccion(poblacionActual, control.getIdSeleccion());
                IndividuoTsp padre = this.control.ElegirSeleccion(poblacionActual, control.getIdSeleccion());
                // reproducimos
                IndividuoTsp hijo = Cruza.cruzaXMascara2(madre, padre, this.control.getMask());
                // mutamos 
                // evaluar la probabilidad
                if (generarProbabilidadMuta()){
                    Muta.mutaIntercambio(hijo);
                }
                // agregamos a la nueva poblacion
                nuevaPob.add(hijo);
            }
            // actualizamos la nueva población
            sustituirPoblacion(nuevaPob);
            //Mando el mejor individuo de cada generacion para graficar
            fitness[i] = HerramientasTsp.mejorPoblacion(nuevaPob).getFitnessGeneral();
            System.out.println("Generacion: " + i + " Fitness: " + HerramientasTsp.mejorPoblacion(nuevaPob).getFitnessGeneral());
            // Mando a la GUI los datos del mejor individuo de cada generacion
            TSPJFrame.jTextArea1.setText("Generacion: "+i+"\n"+"Fitness: "+HerramientasTsp.mejorPoblacion(nuevaPob).getFitnessGeneral()+"\n"
            +"Genotipo: " + Arrays.toString(HerramientasTsp.mejorPoblacion(nuevaPob).getGenotipo()));
            g1.agregarDatoASerie("RED", new XYDataItem(i,fitness[i]));
            Thread.sleep(10);
        }
        //graficar();
    }
    
    
    public void graficar (){
       
        Grafica g1 = new Grafica("Generaciones","Fitness","TSP");
        //g1.agregarSerie("RED:", this.fitness);
        g1.agrearSerie("RED");
        g1.crearGrafica();
        g1.muestraGrafica();
    
    }
    
    public void setIndividuo(IndividuoTsp ind){
        this.poblacionActual.add(ind);
    }
     
    private void generarPoblacionInicial() {
        // generar un población aleatoria de individuos
        for (int i = 0; i < control.getTamPoblacion(); i++) {
            this.getPoblacionActual().add(new IndividuoTsp(control.getTamGenotipo()));
        }
    }
    
    
    public void sustituirPoblacion(ArrayList<IndividuoTsp> nuevaPob) {
        this.getPoblacionActual().clear();
        for (IndividuoTsp aux : nuevaPob) {
            //aux.ActualizarInd();
            this.getPoblacionActual().add(new IndividuoTsp(aux));
        }
    }
    
    private boolean generarProbabilidadMuta() {
        if (control.getProbMuta() > Math.random()) {
            return true;
        } else {
            return false;
        }

    }

    public ArrayList<IndividuoTsp> getPoblacionActual() {
        return poblacionActual;
    }

    /**
     * @return the manager
     */
    public Control getManager() {
        return control;
    }

    @Override
    public void run() {
        try {
            evolucionar();
        } catch (InterruptedException ex) {
            Logger.getLogger(GeneticoTspHilos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
