package AG;
import java.util.ArrayList;


public abstract class Cromosoma {
	
	protected boolean[] genes;
	protected double fenotipo;
	protected double aptitud;
	protected double puntuacion;
	protected double puntuacion_acumulada;
	protected int longCromosoma;
	protected double tolerancia;
	
	
	// METODOS ABSTRACTOS	
	public abstract void inicializaCromosoma();
	public abstract double evalua();
	
	// METODOS PROTEGIDOS
	
	protected void iniciaGen(int lon)
	{
		genes= new boolean[lon];
	}
	
	// METODOS PUBLICOS
	
	public Cromosoma (double tolerancia)
	{
		this.tolerancia=tolerancia;
	}
	
	public Cromosoma(Cromosoma cr) {
		
		 setGenes(cr.getGenes());
		 setAptitud(cr.getAptitud());
		 setFenotipo(cr.getFenotipo());
		 setPuntuacion(cr.getPuntuacion());
		 setPuntuacion_acumulada(cr.getPuntuacion_acumulada());
		 setLongCromosoma(cr.getLongCromosoma());
	}
	public double getFenotipo() {
		return fenotipo;
	}
	
	public void setFenotipo(double fenotipo)
	{
		this.fenotipo=fenotipo;
	} 
	public void setAptitud(double aptitud) {
		this.aptitud = aptitud;
	}

	public double getAptitud() {
		return aptitud;
	}

	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}

	public double getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion_acumulada(double puntuacion_acumulada) {
		this.puntuacion_acumulada = puntuacion_acumulada;
	}

	public double getPuntuacion_acumulada() {
		return puntuacion_acumulada;
	}
	public void setGenes(boolean[] genes) {
		this.genes = genes;
	}
	public boolean[] getGenes() {
		return genes;
	}
	public void setLongCromosoma(int longCromosoma) {
		this.longCromosoma = longCromosoma;
	}

	public int getLongCromosoma() {
		return longCromosoma;
	}
	
	public double getTolerancia() {
		return tolerancia;
	}

	public void setTolerancia(double tolerancia) {
		this.tolerancia = tolerancia;
	}
	
	public void copiaCromosoma(Cromosoma cr) {
		 
		 setGenes(cr.getGenes());
		 setAptitud(cr.getAptitud());
		 setFenotipo(cr.getFenotipo());
		 setPuntuacion(cr.getPuntuacion());
		 setPuntuacion_acumulada(cr.getPuntuacion_acumulada());
		
	}
	

}
