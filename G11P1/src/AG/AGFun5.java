    package AG;

import java.util.ArrayList;
import java.util.logging.Logger;

public class AGFun5 extends AlgoritmoGenetico {

	/**
	 * @param args
	 */

	
	//Atributos Propios
	
	private ArrayList<Double> listaElMejor;
	private ArrayList<Double> listaMedioAptitud;
	private ArrayList<Double> listaMaximoAptitud; 
	private int n;
	
	public int getn(){
		return this.n;
	}
	//Metodos Accesores y Mutadores de Atributos Propios
	public ArrayList<Double> getListaElMejor() {
		return listaElMejor;
	}

	public void setListaElMejor(ArrayList<Double> listaElMejor) {
		this.listaElMejor = listaElMejor;
	}

	public ArrayList<Double> getListaMedioAptitud() {
		return listaMedioAptitud;
	}

	public void setListaMedioAptitud(ArrayList<Double> listaMedioAptitud) {
		this.listaMedioAptitud = listaMedioAptitud;
	}

	public ArrayList<Double> getListaMaximoAptitud() {
		return listaMaximoAptitud;
	}

	public void setListaMaximoAptitud(ArrayList<Double> listaMaximoAptitud) {
		this.listaMaximoAptitud = listaMaximoAptitud;
	}

	//Constructora
	
	public AGFun5(int tama�oPob, int numIter , double probCruce , double probMut, double tolerancia, Funcion funcion,int n_aux)
	{
		super( tama�oPob,  numIter ,  probCruce ,  probMut,  tolerancia, funcion);	
		listaElMejor	=	new ArrayList<Double>();
    	listaMaximoAptitud	=	new ArrayList<Double>();
    	listaMedioAptitud	=	new ArrayList<Double>();
    	this.n = n_aux;
	}



	public void inicializa() {
		
		for (int i = 0; i < tama�oPob; i++) {
			
			pob[i] = new CromosomaFuncion5(tolerancia,this.n);
			pob[i].inicializaCromosoma();
			pob[i].setAptitud(pob[i].evalua());
			longCrom = ((CromosomaFuncion5) pob[0]).getLongCromosoma();
		}
		int posMejo = 0;
		this.revisar_adaptacion_minimiza();
		double aptitudMejor = Integer.MAX_VALUE;
		for (int i = 0; i < tama�oPob; i++) {
			if (pob[i].getAptitud() < aptitudMejor) {
				posMejo = i;
				aptitudMejor = pob[i].getAptitud();
			}
		}
		elMejor = new CromosomaFuncion5((CromosomaFuncion5) pob[posMejo]);
		double[] resul = new double[this.n];
		resul = ((CromosomaFuncion5) elMejor).fenotipo();
		for(int i = 0;i<this.n;i++){
		log.info("Inicializada la poblacion. \n Apitud: " + elMejor.getAptitud() + "  Fenotipo: "
				+ resul[i]+"\n");
		}
		
	}

	

	public void evaluarPoblacion() 
	{
		int posMejo = 0; 
		double puntAcumulada	= 0;
		double aptitudMejor		= elMejor.getAptitud();
		double sumAptitud		= 0;
		double aptitudMejorPob  = Integer.MAX_VALUE;
		for(int i=0; i<tama�oPob; i++)
		{
			sumAptitud = sumAptitud + pob[i].getAptitud();
			if(pob[i].getAptitud()< aptitudMejorPob )
			{
				aptitudMejorPob = pob[i].getAptitud();
			}
			if(pob[i].getAptitud()< aptitudMejor )
			{
				posMejo	=	i;
				aptitudMejor = pob[i].getAptitud();
			}
		}	
		for(int i=0; i<tama�oPob; i++)
		{
			pob[i].setPuntuacion(pob[i].getAptitud()/sumAptitud);
			pob[i].setPuntuacion_acumulada(pob[i].getPuntuacion()+ puntAcumulada);
			puntAcumulada	= puntAcumulada + pob[i].getPuntuacion();
		}
		if(aptitudMejor < elMejor.getAptitud() )
		{
		
				elMejor.copiaCromosoma(pob[posMejo]);
			
		}
		setMaximoAptitud(aptitudMejorPob);
		setMedioAptitud(sumAptitud/ tama�oPob);
	}
	
	public void seleccionRuleta() {
		
		int[] seleccion= new int[tama�oPob];
		double prob;
		int posSeleccionado;
		for(int i=0; i< tama�oPob; i++)
		{
			prob = aleatorio(); 
			posSeleccionado = 0;
			//while((posSeleccionado < tama�oPob)&&(prob > pob[posSeleccionado].getPuntuacion_neta_acumulada()))
			while((posSeleccionado < tama�oPob)&&(prob > pob[posSeleccionado].getPuntuacion_acumulada()))
			{
				posSeleccionado++;
			}
			seleccion[i]= posSeleccionado;
		}
		for(int i=0; i< tama�oPob; i++)
		{
			pobIntermedia[i]= pob[seleccion[i]];
		}
	}

	public void reproduccion()
	{
		
		int[] seleccionCruce= new int[tama�oPob];
		int numSelecCruce=0;
		double prob;
		
		for(int i=0; i< tama�oPob; i++)
		{
			prob=aleatorio()*100;
			if(prob < probCruce)
			{
				seleccionCruce[numSelecCruce]= i;
				numSelecCruce++;
			}
		}
		if((numSelecCruce % 2)==1)
			numSelecCruce--;
		Cromosoma hijo1,hijo2;
		int puntoCruce;
		hijo1 = new CromosomaFuncion5(tolerancia,this.n);
		hijo2 = new CromosomaFuncion5(tolerancia,this.n);
		puntoCruce = aleatorioPCruce(0,longCrom);
		for(int i=0; i< numSelecCruce; i=i+2)
		{
			cruce(pobIntermedia[seleccionCruce[i]],pobIntermedia[seleccionCruce[i+1]],hijo1,hijo2,puntoCruce);
			pobIntermedia[seleccionCruce[i]]= hijo1;
			pobIntermedia[seleccionCruce[i+1]]= hijo2;
		}
		
//		else if(funcion.equals(Funcion.FUNCION_2))
//		{
//			int puntoCruceX;
//			int puntoCruceY;
//			
//			hijo1 = new CromosomaFuncion2(tolerancia);
//			hijo2 = new CromosomaFuncion2(tolerancia);
//			
//			puntoCruceX= aleatorioPCruce(0,((CromosomaFuncion2)elMejor).getLonX());
//			puntoCruceY= aleatorioPCruce(((CromosomaFuncion2)elMejor).getLonX(),((CromosomaFuncion2)elMejor).getLongCromosoma());
//
	}

	public void cruce(Cromosoma padre1, Cromosoma padre2,
			Cromosoma hijo1, Cromosoma hijo2, int puntoCruce)
	{
		
		
		for(int i=0; i< puntoCruce; i++)
		{
			hijo1.getGenes()[i]= padre1.getGenes()[i];
			hijo2.getGenes()[i]= padre2.getGenes()[i];
		}
		for(int i=puntoCruce; i< longCrom; i++)
		{
			hijo1.getGenes()[i]= padre2.getGenes()[i];
			hijo2.getGenes()[i]= padre1.getGenes()[i];
		}
		hijo1.setAptitud(hijo1.evalua());
		hijo2.setAptitud(hijo2.evalua());
	}

	

	public void mutacion() 
	{
		boolean mutado;
		double prob;
		for(int i=0; i< tama�oPob; i++)
		{
			mutado= false;
			for(int j=0; j< longCrom; j++)
			{
				prob= aleatorio()*100;
				if(prob < probMut)
				{
					pobIntermedia[i].getGenes()[j]= !(pobIntermedia[i].getGenes()[j]);
					mutado=true;
				}
				if(mutado)
				{
					pobIntermedia[i].setAptitud(pobIntermedia[i].evalua());
				}
			}
			
		}
		pob=pobIntermedia;
		
	}
	
	


	@Override
	public void ejecuta() {

		inicializa();
		evaluarPoblacion();	
		//escalado();
		while(!terminado())
		{
			IncrementoNumIter();
			seleccionRuleta();
			reproduccion();
			mutacion();
			this.revisar_adaptacion_minimiza();
			evaluarPoblacion();
			//escalado();
			listaElMejor.add(getElMejor().getAptitud());
			listaMaximoAptitud.add(getMaximoAptitud());
			listaMedioAptitud.add(getMedioAptitud());		
		}
		
	}

	@Override
	public void escalado() {
		
		double a=a();
		double b=b();
		double sumAptitud_neta		= 0;
		double puntAcumulada_neta	= 0;
		for(int i=0; i<tama�oPob;i++)
		{
			
			pob[i].escalado(a, b);
			sumAptitud_neta = sumAptitud_neta + pob[i].getAptitud_neta();
		}
		
		for(int i=0; i<tama�oPob; i++)
		{
			pob[i].setPuntuacion_neta(pob[i].getAptitud_neta()/sumAptitud_neta);
			pob[i].setPuntuacion_neta_acumulada(pob[i].getPuntuacion_neta()+ puntAcumulada_neta);
			puntAcumulada_neta	= puntAcumulada_neta + pob[i].getPuntuacion();
		}
	}

	private double b() {
		double b_resultado= (1- a())*this.medioAptitud;
		return b_resultado;
	}

	private double a() {
		double a_resultado= ((this.P-1)*this.medioAptitud)/ (this.maximoAptitud - this.medioAptitud); 
		return a_resultado;
	}

	private void revisar_adaptacion_minimiza (){
		
		double Cmax = Integer.MIN_VALUE;
		for(int i=0; i<tama�oPob; i++)
		{
			if (pob[i].getAptitud() > Cmax){
				Cmax = pob[i].getAptitud();
			}
		}
		Cmax = Cmax * 1.05;
		for(int i=0; i<tama�oPob; i++)
		{
			pob[i].setAptitud(Cmax - pob[i].getAptitud());
		}
	}
}