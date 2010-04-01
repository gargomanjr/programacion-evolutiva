package AG;

import java.util.ArrayList;
import java.util.logging.Logger;

public class AGFun1 extends AlgoritmoGenetico {

	/**
	 * @param args
	 */

	
	//Atributos Propios
	
	private ArrayList<Double> listaElMejor;
	private ArrayList<Double> listaMedioAptitud;
	private ArrayList<Double> listaMaximoAptitud; 
	
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
	
	public AGFun1(int tama�oPob, int numIter , double probCruce , double probMut, double tolerancia, Funcion funcion)
	{
		super( tama�oPob,  numIter ,  probCruce ,  probMut,  tolerancia, funcion);	
		listaElMejor	=	new ArrayList<Double>();
    	listaMaximoAptitud	=	new ArrayList<Double>();
    	listaMedioAptitud	=	new ArrayList<Double>();
	}



	public void inicializa() {
		
		for (int i = 0; i < tama�oPob; i++) {
			
			pob[i] = new CromosomaFuncion1(tolerancia);
			pob[i].inicializaCromosoma();
			pob[i].setAptitud(pob[i].evalua());
			longCrom = ((CromosomaFuncion1) pob[0]).getLongCromosoma();
		}
		int posMejo = 0;
		double aptitudMejor = 0;
		for (int i = 0; i < tama�oPob; i++) {
			if (pob[i].getAptitud() > aptitudMejor) {
				posMejo = i;
				aptitudMejor = pob[i].getAptitud();
			}
		}
		elMejor = new CromosomaFuncion1((CromosomaFuncion1) pob[posMejo]);
		log.info("Inicializada la poblacion. \n Apitud: " + elMejor.getAptitud() + "  Fenotipo: "
				+ elMejor.getFenotipo()+"\n");
		
	}

	private void inicializaFun2() {
		for(int i=0; i < tama�oPob ; i++)
		{
			pob[i] = new CromosomaFuncion2(tolerancia);
			pob[i].inicializaCromosoma();
			pob[i].setAptitud(pob[i].evalua());
			longCrom= ((CromosomaFuncion2)pob[0]).getLongCromosoma();
			
			
		}
		int posMejo = 0;
		double aptitudMejor		= 0;
	
		
		
		for(int i=0; i<tama�oPob; i++)
		{
			
			if(pob[i].getAptitud()> aptitudMejor )
			{
				posMejo	=	i;
				aptitudMejor = pob[i].getAptitud();
			}
		}	
		
			elMejor = new CromosomaFuncion2((CromosomaFuncion2)pob[posMejo]);
			
		log.info("Inicializada la poblacion: "+elMejor.getAptitud() +" " + elMejor.getFenotipo() );
		
		
	}


	public void evaluarPoblacion() 
	{
		int posMejo = 0; 
		double puntAcumulada	= 0;
		double aptitudMejor		= elMejor.getAptitud();
		double sumAptitud		= 0;
		double aptitudMejorPob  = 0;
		for(int i=0; i<tama�oPob; i++)
		{
			sumAptitud = sumAptitud + pob[i].getAptitud();
			if(pob[i].getAptitud()> aptitudMejorPob )
			{
				aptitudMejorPob = pob[i].getAptitud();
			}
			if(pob[i].getAptitud()> aptitudMejor )
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
		if(aptitudMejor > elMejor.getAptitud() )
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
			while((prob > pob[posSeleccionado].getPuntuacion_acumulada())&&(posSeleccionado < tama�oPob))
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
		hijo1 = new CromosomaFuncion1(tolerancia);
		hijo2 = new CromosomaFuncion1(tolerancia);
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
		while(!terminado())
		{
			IncrementoNumIter();
			seleccionRuleta();
			reproduccion();
			mutacion();
			evaluarPoblacion();
			listaElMejor.add(getElMejor().getAptitud());
			listaMaximoAptitud.add(getMaximoAptitud());
			listaMedioAptitud.add(getMedioAptitud());		
		}
		
	}

}
