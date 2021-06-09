/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nSat;

import java.util.Random;

/**
 *
 * @author Rogelio Valle
 */
public class Hilos extends Thread {
    
    Double probMuta;

    public Double getProbMuta() {
        return probMuta;
    }

    public void setProbMuta(Double probMuta) {
        this.probMuta = probMuta;
    }
    
    public Hilos(String nombre){
        this.setName(nombre);
    }
    
    public void run(){
       nSat.Herramientas.leerDatos();
       Random r = new Random();
       setProbMuta(Math.random());
       Genetico3Sat nsat = new Genetico3Sat(300,300,probMuta,100);
       nsat.Evolucionar();
       for(int i=0; i<300; i++){
       System.out.println(this.getName()+"- Generacion: "+i+" Muta: "+probMuta);
       }
    }
    
    public static void main(String[] args){
        // TODO code application logic here
        Hilos mt = new Hilos("3Sat -- Genetico");
        mt.start();
    }
}
