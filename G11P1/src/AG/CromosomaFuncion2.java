package AG;

import java.util.ArrayList;
import java.util.Random;


public class CromosomaFuncion2 extends Cromosoma {

	private	double Xmin;
	private double Xmax;
	private double Ymin;
	private double Ymax;
	
	public double getGenX() {
		return genX;
	}

	public void setGenX(double genX) {
		this.genX = genX;
	}

	public double getGenY() {
		return genY;
	}

	public void setGenY(double genY) {
		this.genY = genY;
	}

	private double genX;
	private double genY;
	
	private int lonX;
	public int getLonX() {
		return lonX;
	}

	public void setLonX(int lonX) {
		this.lonX = lonX;
	}

	public int getLonY() {
		return lonY;
	}

	public void setLonY(int lonY) {
		this.lonY = lonY;
	}

	private int lonY;
	
		
	

	public CromosomaFuncion2(double tolerancia)
	{
		super(tolerancia);
		this.Xmin=-3.0;
		this.Xmax=12.1;
		this.Ymin=4.1;
		this.Ymax=5.8;
		this.setLongCromosoma(longitudCrom());
		iniciaGen(longCromosoma);		
		
	}
	
	public CromosomaFuncion2(CromosomaFuncion2 cr) {
				
		super(cr); 
		this.setGenX(cr.getGenX());
		this.setGenY(cr.getGenY());
		this.Xmin = -3.0;
		this.Xmax = 12.1;
		this.Ymin = 4.1;
		this.Ymax = 5.8;
		this.setLongCromosoma(this.longitudCrom());
		
		 
	}

	private boolean boolRandom()
	{
		if(Math.random()<0.5)
			return false;
		else
			return true;	
		
		
	}
	
	public void copiaCromosoma(Cromosoma cr) {
		 
		 setGenes(cr.getGenes());
		 setAptitud(cr.getAptitud());
		 setPuntuacion(cr.getPuntuacion());
		 setPuntuacion_acumulada(cr.getPuntuacion_acumulada());
		 setLongCromosoma(cr.getLongCromosoma());
		 setAptitud_neta(cr.getAptitud_neta());
		 setPuntuacion_neta(cr.getPuntuacion_neta());
		 setPuntuacion_neta_acumulada(cr.getPuntuacion_neta_acumulada());
		 setTolerancia(cr.getTolerancia());
		 setGenX(((CromosomaFuncion2)cr).getGenX());
		 setGenY(((CromosomaFuncion2)cr).getGenY());
		 this.Xmin = -3.0;
		 this.Xmax = 12.1;
		 this.Ymin = 4.1;
		 this.Ymax = 5.8;
		 setLongCromosoma(this.longitudCrom());
	}
	
	public void inicializaCromosoma()
	{
		for(int i=0;i<this.longCromosoma;i++)
			getGenes()[i]= boolRandom(); 
		
	}
	

	private int longitudCrom() {
		
		lonX=(int)Math.ceil(Math.log(1+((this.Xmax-this.Xmin)/this.tolerancia))/Math.log(2));
		lonY=(int)Math.ceil(Math.log(1+((this.Ymax-this.Ymin)/this.tolerancia))/Math.log(2));
		return lonX+lonY;
	}
	
	public double evalua()
	{
		
		genY=fenotipoY();
		genX= fenotipoX();
		return f(genX,genY);
		
	}

	public double fenotipoX() {
		
		double valor;
		valor = Xmin + ( Xmax - Xmin )* binToDec(getGenes(),0,lonX)/(Math.pow(2, lonX)-1);
		return valor;
	}
	
	public double fenotipoY() {
		
		double valor;
		valor = Ymin + ( Ymax - Ymin )* binToDec(getGenes(),lonX,longCromosoma)/(Math.pow(2, lonY)-1);
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

	private double f(double x,double y) {
		
		double resultado;
		resultado=21.5 +  x*Math.sin(4*Math.PI*x) + y*Math.sin(20*Math.PI*y);
		return resultado;
	}

	@Override
	public void escalado(double a, double b) {
		// TODO Auto-generated method stub
		
	}
	
}// FIN CLASE