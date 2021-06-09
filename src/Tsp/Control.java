/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tsp;

import java.util.ArrayList;

/**
 *
 * @author Rogelio Valle
 */
public class Control {
   private int numGeneraciones;
   private int tamPoblacion;
   private double probMuta;
   private int mask[];
   private Seleccion.TipoSeleccion tipoSeleccion[];
   private int CI;
   private int IdSeleccion;
   private int tamGenotipo;
   private int[][] matrizDistancias;
   private int[][] matrizInclinaciones;
   
   public Control(int IdSeleccion, int numGeneraciones, int tamPoblacion, double probMuta, Seleccion.TipoSeleccion[] tipoSeleccion, int tamGenotipo , int CInicial, int[][] matrizDistancias, int[][] matrizInclinaciones) {
        this.numGeneraciones = numGeneraciones;
        this.tamPoblacion = tamPoblacion;
        this.probMuta = probMuta;
        this.mask = binario.Herramientas.generarArregloBinarios(tamGenotipo);
        this.tipoSeleccion = tipoSeleccion;
        this.tamGenotipo = tamGenotipo;
        IndividuoTsp.matrizDistancias = matrizDistancias;
        IndividuoTsp.matrizInclinaciones = matrizInclinaciones;
        this.IdSeleccion = IdSeleccion;
        this.CI = CInicial;
        IndividuoTsp.CInicial = CInicial;
    }
   
   
   public IndividuoTsp ElegirSeleccion(ArrayList<IndividuoTsp> pobActual, int i){
       IndividuoTsp aux = null; 
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
   
   
    public int getIdSeleccion() {
        return IdSeleccion;
    }

    public void setIdSeleccion(int IdSeleccion) {
        this.IdSeleccion = IdSeleccion;
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
