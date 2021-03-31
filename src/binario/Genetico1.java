/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario;

/**
 *
 * @author Rogelio Valle
 */
public class Genetico1 {
    
    //Elementos que necesitamos
    private int tamPob;
    private double probMuta;
    private int numGeneraciones;
    private int tamGenotipo;
    private Poblacion pobActual;
    
    public Genetico1(int tamPob, double probMuta, int numGeneraciones , int tamGenotipo){
        this.tamPob = tamPob;
        this.probMuta = probMuta;
        this.numGeneraciones = numGeneraciones;
        this.tamGenotipo = tamGenotipo;
        this.pobActual = new Poblacion(tamPob,tamGenotipo);
    }
    
    public void evolucionar(){
        Poblacion nuevaPoblacion;
        
        int[] mask;
        mask = Herramientas.generarArregloBinarios(this.tamGenotipo);
        //System.out.println("Fenotipo: "+this.pobActual.getMejor().getFenotipo()+" Fitness: "+this.pobActual.getMejor().getFitness());
        //ciclo para las generaciones
        for(int i=0; i<this.numGeneraciones; i++){
            //proceso iterativo para creacion de la nueva poblacion
            nuevaPoblacion = new Poblacion(tamPob,this.tamGenotipo);
            for(int j=0; j<tamPob; j++){
                //Seleccionamos una madre y un padre
                Individuo padre = Seleccion.seleccionAleatoria(pobActual);
                Individuo madre = Seleccion.seleccionAleatoria(pobActual);
                //cruza
                Individuo nuevo = Cruza.cruza1punto(mask, madre, padre);
                //evaluar la probabilidad de muta
                if(Math.random()>this.probMuta){
                    Muta.mutaAleatoria(nuevo);
                }
                //agregamos el individuo a la nueva poblacion
                nuevaPoblacion.getPoblacion().add(nuevo);
            }
            //Actualuzamos la poblacion actual
            this.pobActual = new Poblacion(nuevaPoblacion);
        }
        System.out.println("Fenotipo: "+this.pobActual.getMejor().getFenotipo()+" Fitness: "+this.pobActual.getMejor().getFitness());
    }
    
}
