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
	
	public AGFun1(int tamañoPob, int numIter , double probCruce , double probMut, double tolerancia, Funcion funcion,double elitismo)
	{
		super( tamañoPob,  numIter ,  probCruce ,  probMut,  tolerancia, funcion,elitismo);	
		listaElMejor	=	new ArrayList<Double>();
    	listaMaximoAptitud	=	new ArrayList<Double>();
    	listaMedioAptitud	=	new ArrayList<Double>();
	}



	public void inicializa() {
		
		for (int i = 0; i < tamañoPob; i++) {
			
			pob[i] = new CromosomaFuncion1(tolerancia);
			pob[i].inicializaCromosoma();
			pob[i].setAptitud(pob[i].evalua());
			longCrom = ((CromosomaFuncion1) pob[0]).getLongCromosoma();
		}
		//revisar_adaptacion_minimiza();
		int posMejo = 0;
		double aptitudMejor = 0;
		for (int i = 0; i < tamañoPob; i++) {
			if (pob[i].getAptitud() > aptitudMejor) {
				posMejo = i;
				aptitudMejor = pob[i].getAptitud();
			}
		}
		elMejor = new CromosomaFuncion1((CromosomaFuncion1) pob[posMejo]);
		log.info("Inicializada la poblacion. \n Apitud: " + elMejor.getAptitud() + "  Fenotipo: "
				+ elMejor.getFenotipo()+"\n");
		
	}



	public void evaluarPoblacion() 
	{
		int posMejo = 0; 
		double puntAcumulada	= 0;
		double aptitudMejor		= elMejor.getAptitud();
		double sumAptitud		= 0;
		double aptitudMejorPob  = 0;
		for(int i=0; i<tamañoPob; i++)
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
		for(int i=0; i<tamañoPob; i++)
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
		setMedioAptitud(sumAptitud/ tamañoPob);
	}
	
	public void seleccionRuleta() {
		
		int[] seleccion= new int[tamañoPob];
		selecciona_mejores();
		double prob;
		int posSeleccionado;
		for(int i=0; i< tamañoPob - this.getNum_pob_elite(); i++)
		{
			prob = aleatorio(); 
			posSeleccionado = 0;
			//while((posSeleccionado < tamañoPob -1)&&(prob > pob[posSeleccionado].getPuntuacion_neta_acumulada()))
			while((posSeleccionado < tamañoPob - 1)&&(prob > pob[posSeleccionado].getPuntuacion_acumulada()))
			{
				posSeleccionado++;
			}
			seleccion[i]= posSeleccionado;
		}
		for(int i=0; i< tamañoPob - this.getNum_pob_elite() ; i++)
		{
			System.out.println(seleccion[i]);
			pobIntermedia[i]= new CromosomaFuncion1((CromosomaFuncion1) pob[seleccion[i]]);
		}
	}

	private void selecciona_mejores() {
		ArrayList <Integer> indices_seleccionados = new ArrayList();
		int mayor = 0;
		double mayor_aptitud = Integer.MIN_VALUE;
		for(int i =0; i< this.getNum_pob_elite() ; i++)
		{
			mayor_aptitud = Integer.MIN_VALUE;
			mayor = 0;
			for(int j=0; j< tamañoPob ; j++)
			{
				if(pob[j].getAptitud() > mayor_aptitud && indices_seleccionados.contains(j)==false ){
					mayor = j;
					mayor_aptitud = pob[j].getAptitud();
				}
			}
			indices_seleccionados.add(mayor);
		}
		for(int i=0 ; i< this.getNum_pob_elite() ; i++){
			pobIntermedia[i + tamañoPob - this.getNum_pob_elite()]= new CromosomaFuncion1((CromosomaFuncion1)pob[indices_seleccionados.get(i)]);
			//this.pobIntermedia[i + tamañoPob - this.getNum_pob_elite()]= pob[indices_seleccionados.get(i)];
		}		
	}

	

	public void reproduccion()
	{
		
		int[] seleccionCruce= new int[tamañoPob - this.getNum_pob_elite()];
		int numSelecCruce=0;
		double prob;
		
		for(int i=0; i< tamañoPob - this.getNum_pob_elite(); i++)
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
			hijo1.setGenesi(padre1.getGenes()[i], i);
			hijo2.setGenesi(padre2.getGenes()[i], i);
		}
		for(int i=puntoCruce; i< longCrom; i++)
		{
			hijo1.setGenesi(padre1.getGenes()[i], i);
			hijo2.setGenesi(padre2.getGenes()[i], i);
		}
		hijo1.setFenotipo(((CromosomaFuncion1) hijo1).fenotipo());
		hijo2.setFenotipo(((CromosomaFuncion1) hijo2).fenotipo());
		hijo1.setAptitud(hijo1.evalua());
		hijo2.setAptitud(hijo2.evalua());
	}

	

	public void mutacion() 
	{
		boolean mutado;
		double prob;
		for(int i=0; i< tamañoPob - this.getNum_pob_elite(); i++)
		{
			mutado= false;
			for(int j=0; j< longCrom; j++)
			{
				prob= aleatorio()*100;
				if(prob < probMut)
				{
					pobIntermedia[i].setGenesi(!(pobIntermedia[i].getGenes()[j]),j);
					mutado=true;
				}
				if(mutado)
				{
					pobIntermedia[i].setFenotipo(((CromosomaFuncion1) pobIntermedia[i]).fenotipo());
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
		listaElMejor.add(getElMejor().getAptitud());
		listaMaximoAptitud.add(getMaximoAptitud());
		listaMedioAptitud.add(getMedioAptitud());
		//escalado();
		while(!terminado())
		{
			IncrementoNumIter();
			seleccionRuleta();
			reproduccion();
			mutacion();
			//revisar_adaptacion_minimiza();
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
		for(int i=0; i<tamañoPob;i++)
		{		
			pob[i].escalado(a, b);
			sumAptitud_neta = sumAptitud_neta + pob[i].getAptitud_neta();
		}
		
		for(int i=0; i<tamañoPob; i++)
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
		//double P_aux = this.elMejor.getAptitud()/this.medioAptitud;
		//double P_aux = this.P;
		double P_aux = 0.01;
		//double P_aux = 4;
		//System.out.println(this.medioAptitud);
		//System.out.println(this.maximoAptitud);
		double a_resultado= (this.medioAptitud)/ (this.medioAptitud - this.getMinimaadaptacion()); 
		//double a_resultado= ((P_aux-1)*this.medioAptitud)/ (this.maximoAptitud - this.medioAptitud); 
		return a_resultado;
	}
    private void revisar_adaptacion_minimiza (){
		
		double Cmax = Integer.MIN_VALUE;
		for(int i=0; i<tamañoPob; i++)
		{
			if (pob[i].getAptitud() > Cmax){
				Cmax = pob[i].getAptitud();
			}
		}
		Cmax = Cmax * 1.05;
		for(int i=0; i<tamañoPob; i++)
		{
			pob[i].setAptitud(Cmax - pob[i].getAptitud());
		}
	}


}
