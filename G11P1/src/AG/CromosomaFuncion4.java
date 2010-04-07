package AG;

public class CromosomaFuncion4 extends Cromosoma {

	private	double Xmin;
	private double Xmax;
	
	private double f;
	public double getF() {
		return f;
	}



	public void setF(double f) {
		this.f = f;
	}



	public double getF_punt() {
		return f_punt;
	}



	public void setF_punt(double f_punt) {
		this.f_punt = f_punt;
	}



	public double getF_punt_acum() {
		return f_punt_acum;
	}



	public void setF_punt_acum(double f_punt_acum) {
		this.f_punt_acum = f_punt_acum;
	}

	private double f_punt;
	private double f_punt_acum;
	
	public double getGenX1() {
		return genX1;
	}

	public void setGenX1(double genX) {
		this.genX1 = genX;
	}

	public double getGenX2() {
		return genX2;
	}

	public void setGenX2(double genX2) {
		this.genX2 = genX2;
	}

	private double genX1;
	private double genX2;
	
	private int lonX1;
	public int getLonX1() {
		return lonX1;
	}

	public void setLonX1(int lonX) {
		this.lonX1 = lonX;
	}

	public int getLonX2() {
		return lonX2;
	}

	public void setLonX2(int lonX2) {
		this.lonX2 = lonX2;
	}

	private int lonX2;
	
		
	

	public CromosomaFuncion4(double tolerancia)
	{
		super(tolerancia);
		this.Xmin=-10;
		this.Xmax=10;
		this.setLongCromosoma(longitudCrom());
		iniciaGen(longCromosoma);		
		
	}
	
	public CromosomaFuncion4(CromosomaFuncion4 cr) {
				
		super(cr);
		setF(cr.getF());
		setF_punt(cr.getF_punt());
		setF_punt_acum(cr.getF_punt_acum());
		genX1 = cr.getGenX1();
		genX2 = cr.getGenX2();
		this.Xmin = -10;
		this.Xmax = 10;
	//    setGenX1(((CromosomaFuncion4)cr).getGenX1());
	//	setGenX2(((CromosomaFuncion4)cr).getGenX2());
		this.setLongCromosoma(longitudCrom());
		 
		 
	}

	private boolean boolRandom()
	{
		if(Math.random()<0.5)
			return false;
		else
			return true;	
		
		
	}
	
	public void copiaCromosoma(CromosomaFuncion4 cr) {
		 
		 setGenes(cr.getGenes());
		 setAptitud(cr.getAptitud());
		 setFenotipo(cr.getFenotipo());
		 setPuntuacion(cr.getPuntuacion());
		 setF(cr.getF());
		 setF_punt(cr.getF_punt());
		 setF_punt_acum(cr.getF_punt_acum());
		 setPuntuacion_acumulada(cr.getPuntuacion_acumulada());
		 setGenX1(((CromosomaFuncion4)cr).getGenX1());
		 setGenX2(((CromosomaFuncion4)cr).getGenX2());
		 this.Xmin = -10;
		 this.Xmax = 10;
		 this.setLongCromosoma(longitudCrom());
	}
	
	public void inicializaCromosoma()
	{
		for(int i=0;i<this.longCromosoma;i++)
			getGenes()[i]= boolRandom(); 
		
	}
	

	private int longitudCrom() {
		
		lonX1=lonX2=(int)Math.ceil(Math.log(1+((this.Xmax-this.Xmin)/this.tolerancia))/Math.log(2));
		return lonX1+lonX2;
	}
	
	public double evalua()
	{
		
		genX1=fenotipoX1();
		genX2= fenotipoX2();
		return f(genX1,genX2);
		
	}

	public double fenotipoX1() {
		
		double valor;
		valor = Xmin + ( Xmax - Xmin )* binToDec(getGenes(),0,lonX1)/(Math.pow(2, lonX1)-1);
		return valor;
	}
	
	public double fenotipoX2() {
		
		double valor;
		valor = Xmin + ( Xmax - Xmin )* binToDec(getGenes(),lonX1,longCromosoma)/(Math.pow(2, lonX2)-1);
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
		
		
		double sumX1=0;
		double sumX2=0;
		for(int i=1; i<6;i++ )
		{
			sumX1=sumX1+ ( i*Math.cos((i+1)*genX1+i));  
			
		}
		for(int i=1; i<6;i++ )
		{
			sumX2=sumX2+ ( i*Math.cos((i+1)*genX2+i));  
			
		}
		
		return sumX1*sumX2;
	}

	@Override
	public void escalado(double a, double b) {
		// TODO Auto-generated method stub
		
	}
	
}// FIN CLASE
