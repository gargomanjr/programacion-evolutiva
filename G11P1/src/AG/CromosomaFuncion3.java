package AG;

import java.util.ArrayList;
import java.util.Random;


public class CromosomaFuncion3 extends Cromosoma {

	private	int Xmin;
	private int Xmax;
	
		
	

	public CromosomaFuncion3(double tolerancia)
	{
		super(tolerancia);
		this.Xmax=25;
		this.Xmin=0;
		this.setLongCromosoma(longitudCrom());
		iniciaGen(longCromosoma);		
		
	}
	
	public CromosomaFuncion3(CromosomaFuncion3 cr) {
				
		 super(cr);
		 this.Xmax=1; 
		 this.Xmin=0;
		 
		 
	}

	private boolean boolRandom()
	{
		if(Math.random()<0.5)
			return false;
		else
			return true;	
		
		
	}
	
	public void inicializaCromosoma()
	{
		for(int i=0;i<this.longCromosoma;i++)
			getGenes()[i]= boolRandom(); 
		
	}
	

	private int longitudCrom() {
		
		int lon=(int)Math.ceil(Math.log(1+((this.Xmax-this.Xmin)/this.tolerancia))/Math.log(2));
		return lon;
	}
	
	public double evalua()
	{
		
		setFenotipo( fenotipo());
		return f(getFenotipo());
		
	}

	private double fenotipo() {
		
		double valor;
		valor = Xmin + ( Xmax - Xmin )* binToDec(getGenes(),longCromosoma)/(Math.pow(2, longCromosoma)-1);
		return valor;
	}

	private int valorBool(boolean b)
	{
		if(b)
			return 1;
		else
			return 0;
	}
	
	private int binToDec(boolean[] genes, int longCromosoma2) {

		//False = 0
		//True = 1
		
		int suma=0;
		for(int i=0; i< longCromosoma2;i++ )
		{
			suma=(int) (suma + (Math.pow(2,longCromosoma2-1-i) * valorBool(genes[i])));	
		}
		return suma;
	}

	private double f(double x) {
		
		double resultado;
		resultado= (Math.sin(x))/(1+ Math.sqrt(x)+ (Math.cos(x))/(1+x) );
		return resultado;
	}

	@Override
	public void escalado(double a, double b) {
		
			
		setAptitud_neta(a*aptitud +b);
		
	}

	
	
}
