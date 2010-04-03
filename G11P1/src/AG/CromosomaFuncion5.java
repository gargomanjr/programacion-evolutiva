package AG;

import java.util.ArrayList;
import java.util.Random;


public class CromosomaFuncion5 extends Cromosoma {

	private	int Xmin;
	private double Xmax;
	private int n;
	private int longitud_de_1_cromosoma;
	protected double [] fenotipo_gen;
	
	
	public double getfenotipo_gen(int indice){
		return this.fenotipo_gen[indice];
	}
	public void setfenotipo_gen(double valor,int indice){
		this.fenotipo_gen[indice] = valor;
	}
	

	public CromosomaFuncion5(double tolerancia,int n_aux)
	{
		super(tolerancia);
		this.n = n_aux;
		this.Xmax= Math.PI;
		this.Xmin=0;
		this.longitud_de_1_cromosoma = longitudCrom()/this.n ;
		fenotipo_gen= new double[longitud_de_1_cromosoma - 1];
		this.setLongCromosoma(longitudCrom());
		iniciaGen(longCromosoma);		

		
	}
	
	public CromosomaFuncion5(CromosomaFuncion5 cr) {
				
		 super(cr);
		 this.Xmax=1; 
		 this.Xmin=0;
		 this.n = cr.n;
		 this.longitud_de_1_cromosoma = cr.longitud_de_1_cromosoma;
		 this.fenotipo_gen= new double[longitud_de_1_cromosoma - 1];
		 for(int i =0;i<n;i++){
			 this.setfenotipo_gen(cr.getfenotipo_gen(i), i);		 
		 }
		 
		 
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
		return lon * this.n;
	}
	
	public double evalua(){
		for(int i =0;i< this.n;i++){
			setfenotipo_gen(fenotipo(i),i);
		}		
		return f();
		}
	


	private double fenotipo(int num_gen) {
		double valor;
		valor = Xmin + ( Xmax - Xmin )* binToDec(getGenes(),(num_gen*longCromosoma),(num_gen + 1)*longCromosoma)/(Math.pow(2, this.longitud_de_1_cromosoma)-1);
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

	private double f() {	
		double valor = 0;
		double f_aux = 0;
		for(int i=0; i<n; i++)
		{
			f_aux = this.getfenotipo_gen(i);
			valor = valor + Math.sin(f_aux) * Math.pow(Math.sin(((i+1)*(f_aux * f_aux))/Math.PI),20);
		}
		valor = - valor;
		return valor;
	}
	
	private int binToDec(boolean[] genes,int inicio, int longCromosoma2) {

		//False = 0
		//True = 1
		
		int suma=0;
		for(int i=inicio; i< longCromosoma2;i++ )
		{
			suma=(int) (suma + (Math.pow(2,longCromosoma2-1-i) * valorBool(genes[i])));	
		}
		return suma;
	}
	
	@Override
	public void escalado(double a, double b) {
		
			
		setAptitud_neta(a*aptitud +b);
		
	}

	

	

	

	
	
	
}
