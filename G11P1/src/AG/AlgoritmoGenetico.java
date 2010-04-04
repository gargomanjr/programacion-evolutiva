package AG;

import java.util.ArrayList;
import java.util.logging.Logger;

public abstract class AlgoritmoGenetico {

	/**
	 * @param args
	 */
	
	// Atributos
	protected Cromosoma[] pob,pobIntermedia;
	protected double medioAptitud,maximoAptitud;
	protected int tamañoPob;
	protected int numIter;
	protected double probCruce;
	protected double probMut;
	protected double tolerancia; 
	protected Funcion funcion;
	protected int longCrom;
	protected int numGenes;
	protected Cromosoma elMejor;
	protected int P=6;
	protected static final Logger log = Logger
			.getLogger("AlgoritmoGenetico.class");
	
	
	
	//Metodos Abstractos
	
	public abstract void inicializa();

	public abstract void evaluarPoblacion();

	public abstract void seleccionRuleta();

	public abstract void reproduccion();

	public abstract void mutacion();
	
	public abstract void ejecuta();
	
	public abstract void escalado();
	
	
	
	//Metodos Accesores y Mutadores 
	public Cromosoma[] getPob() {
		return pob;
	}
	
	public void setPob(Cromosoma[] pob) {
		this.pob = pob;
	}

	public Cromosoma getElMejor() {
		return elMejor;
	}

	public void setElMejor(Cromosoma elMejor) {
		this.elMejor = elMejor;
	}

	public Cromosoma[] getPobIntermedia() {
		return pobIntermedia;
	}

	public void setPobIntermedia(Cromosoma[] pobIntermedia) {
		this.pobIntermedia = pobIntermedia;
	}

	public void setTamañoPob(int tamañoPob) {
		this.tamañoPob = tamañoPob;
	}

	public int getTamañoPob() {
		return tamañoPob;
	}

	public void setNumIter(int numIter) {
		this.numIter = numIter;
	}

	public int getNumIter() {
		return numIter;
	}

	public void setProbCruce(double probCruce) {
		this.probCruce = probCruce;
	}

	public double getProbCruce() {
		return probCruce;
	}

	public void setProbMut(double probMut) {
		this.probMut = probMut;
	}

	public double getProbMut() {
		return probMut;
	}

	public void setTolerancia(double tolerancia) {
		this.tolerancia = tolerancia;
	}

	public double getTolerancia() {
		return tolerancia;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

	public Funcion getFuncion() {
		return funcion;
	}

	public void setMaximoAptitud(double maximoAptitud) {
		this.maximoAptitud = maximoAptitud;
	}

	public double getMaximoAptitud() {
		return maximoAptitud;
	}

	public void setMedioAptitud(double medioAptitud) {
		this.medioAptitud = medioAptitud;
	}

	public double getMedioAptitud() {
		return medioAptitud;
	}
	
	
	//Constructora
	
	public AlgoritmoGenetico(int tamañoPob, int numIter , double probCruce , double probMut, double tolerancia, Funcion funcion)
	{
		this.tamañoPob 			= tamañoPob;
		this.numIter 			= numIter;
		this.probCruce 			= probCruce;
		this.probMut 			= probMut;
		this.tolerancia 		= tolerancia;
		this.funcion 			= funcion;
		this.pob				= new Cromosoma[tamañoPob];
		this.pobIntermedia		= new Cromosoma[tamañoPob];
		this.setMaximoAptitud(0);
		this.setMedioAptitud(0);
		
		
	}

	//Metodos Auxiliares
	
	protected boolean terminado() {
		
		return numIter==0;
	}

	protected void IncrementoNumIter() {
		
		numIter--;
		
	}

	protected double aleatorio() 
	{
		
		return  Math.random();
	}

	protected int aleatorioPCruce(int min, int max) {
		// TODO Auto-generated method stub
		return (int)(Math.random()*(max-min))+min;
	}

	

	

}
