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
public class Control {
   private int numGeneraciones;
   private int tamPoblacion;
   private double probMuta;
   private double pMuestra;
   private int mask[];
   private Seleccion.TipoSeleccion tipoSeleccion[];
   private int tamGenotipo;
   
   public Control(int numGeneraciones, int tamPoblacion, double probMuta, Seleccion.TipoSeleccion[] tipoSeleccion, int tamGenotipo) {
        this.numGeneraciones = numGeneraciones;
        this.tamPoblacion = tamPoblacion;
        this.probMuta = probMuta;
        this.mask = binario.Herramientas.generarArregloBinarios(tamGenotipo);
        this.tipoSeleccion = tipoSeleccion;
        this.tamGenotipo = tamGenotipo;
    }
   
   public Control(int tamGenotipo) {
        this.numGeneraciones = 10000;
        this.tamPoblacion = 50;
        this.probMuta = 0.2;
        this.pMuestra = 0.2;
        this.mask = binario.Herramientas.generarArregloBinarios(tamGenotipo);
        this.tipoSeleccion = new Seleccion.TipoSeleccion[]{Seleccion.TipoSeleccion.RANDOM,Seleccion.TipoSeleccion.RANDOM};
        this.tamGenotipo = tamGenotipo;
    }
   
   public IndividuonSat ElegirSeleccion(ArrayList<IndividuonSat> pobActual, int i){
       IndividuonSat aux = null; 
       // evaluar i
       switch(getTipoSeleccion()[i]){
           case RANDOM:
             aux = Seleccion.seleccionAleatoria(pobActual);
             break;
           case RULETA:
             aux = Seleccion.seleccionRuleta(pobActual);
             break;  
           default:
               aux = null;
       }
   return aux;
   }

    public int getNumGeneraciones() {
        return numGeneraciones;
    }

    public void setNumGeneraciones(int numGeneraciones) {
        this.numGeneraciones = numGeneraciones;
    }

    public int getTamPoblacion() {
        return tamPoblacion;
    }

    public void setTamPoblacion(int tamPoblacion) {
        this.tamPoblacion = tamPoblacion;
    }

    public double getProbMuta() {
        return probMuta;
    }

    public void setProbMuta(double probMuta) {
        this.probMuta = probMuta;
    }

    public double getpMuestra() {
        return pMuestra;
    }

    public void setpMuestra(double pMuestra) {
        this.pMuestra = pMuestra;
    }

    public int[] getMask() {
        return mask;
    }

    public void setMask(int[] mask) {
        this.mask = mask;
    }

    public Seleccion.TipoSeleccion[] getTipoSeleccion() {
        return tipoSeleccion;
    }

    public void setTipoSeleccion(Seleccion.TipoSeleccion[] tipoSeleccion) {
        this.tipoSeleccion = tipoSeleccion;
    }

    public int getTamGenotipo() {
        return tamGenotipo;
    }

    public void setTamGenotipo(int tamGenotipo) {
        this.tamGenotipo = tamGenotipo;
    }
   
   
   
}
