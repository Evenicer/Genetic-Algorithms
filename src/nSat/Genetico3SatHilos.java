/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nSat;

import HerramientasGeneral.Grafica;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.data.xy.XYDataItem;

/**
 *
 * @author Rogelio Valle
 */
public class Genetico3SatHilos implements Runnable{
    
    // parametros
    private ArrayList<IndividuonSat> poblacionActual;
    private Control control;
    private int[] fitness;
    
    public Genetico3SatHilos(Control manager) {
        this.control = manager;
        this.poblacionActual = new ArrayList<>();
        this.fitness = new int[this.control.getNumGeneraciones()];
    }
    
    public void evolucionar() throws InterruptedException {
        
        Grafica g1 = new Grafica("Generaciones","Fitness","3Sat");
        g1.crearGrafica();
        g1.agrearSerie("RED");
        g1.muestraGrafica();

        generarPoblacionInicial();
        // generar las itereaciones para las generaciones
        for(int i=1; i<this.control.getNumGeneraciones(); i++){
            ArrayList<IndividuonSat> nuevaPob = new ArrayList<>();
            for(int j=0; j<this.control.getTamPoblacion(); j++){
                // seleccionamos
                IndividuonSat madre = this.control.ElegirSeleccion(poblacionActual, 0);
                IndividuonSat padre = this.control.ElegirSeleccion(poblacionActual, 1);
                // reproducimos
                IndividuonSat hijo = Cruza.cruza1punto(this.control.getMask(), madre, padre);
                // mutamos 
                // evaluar la probabilidad
                if (generarProbabilidadMuta()){
                    Muta.mutaAleatoria(hijo);
                }
                // agregamos a la nueva poblacion
                nuevaPob.add(hijo);
            }
            // actualizamos la nueva población
            sustituirPoblacion(nuevaPob);
            //Mando el mejor individuo de cada generacion para graficar
            fitness[i] = Herramientas.mejorPoblacion(nuevaPob).getFitness();
            // Mando a la GUI los datos del mejor individuo de cada generacion
            NSatHilosJFrame.jTextArea1.setText("Generacion: "+i+"\n"+"Fitness: "+nSat.Herramientas.mejorPoblacion(nuevaPob).getFitness()+"\n"
            +"Genotipo: " + Arrays.toString(nSat.Herramientas.mejorPoblacion(nuevaPob).getGenotipo()));
            g1.agregarDatoASerie("RED", new XYDataItem(i,fitness[i]));
            Thread.sleep(10);
        }
        //graficar();
    }
    
    public void graficar (){
       
        Grafica g1 = new Grafica("Generaciones","Fitness","3Sat");
        //g1.agregarSerie("RED:", this.fitness);
        g1.agrearSerie("RED");
        g1.crearGrafica();
        g1.muestraGrafica();
    
    }
    
    private void generarPoblacionInicial() {
        // generar un población aleatoria de individuos
        for (int i = 0; i < control.getTamPoblacion(); i++) {
            this.getPoblacionActual().add(new IndividuonSat(control.getTamGenotipo()));
        }
    }
    
    private void sustituirPoblacion(ArrayList<IndividuonSat> nuevaPob) {
        this.getPoblacionActual().clear();
        for (IndividuonSat aux : nuevaPob) {
            aux.ActualizarInd();
            this.getPoblacionActual().add(new IndividuonSat(aux));
        }
    }
    
    private boolean generarProbabilidadMuta() {
        if (control.getProbMuta() > Math.random()) {
            return true;
        } else {
            return false;
        }

    }

    public ArrayList<IndividuonSat> getPoblacionActual() {
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
            Logger.getLogger(Genetico3SatHilos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
