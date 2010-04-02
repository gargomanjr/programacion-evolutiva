package AG;

import java.util.ArrayList;
import java.util.Random;


public class CromosomaFuncion5 extends Cromosoma {

	private	int Xmin;
	private double Xmax;
	
		
	

	public CromosomaFuncion5(double tolerancia)
	{
		super(tolerancia);
		this.Xmax= Math.PI;
		this.Xmin=0;
		this.setLongCromosoma(longitudCrom());
		iniciaGen(longCromosoma);		
		
	}
	
	public CromosomaFuncion5(CromosomaFuncion5 cr) {
				
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
	
	public double evalua(){
		return 0;
		}
	
	public double evalua2(Cromosoma[] poblacion,int n)
	{
		
		setFenotipo( fenotipo(poblacion,n));
		return f(getFenotipo());
		
	}

	private double fenotipo(Cromosoma[] pob,int n) {
		
		double valor = 0;
		double f_aux = 0;
		for(int i=0; i<n; i++)
		{
			f_aux = pob[i].getFenotipo();
			valor = valor + Math.sin(f_aux) * Math.sin(  ((i+1)*(f_aux * f_aux))/Math.PI      );
		}
		valor = - valor;
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
