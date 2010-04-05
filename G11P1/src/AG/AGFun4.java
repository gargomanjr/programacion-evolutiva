package AG;

import java.util.ArrayList;

public class AGFun4 extends AlgoritmoGenetico {

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

	public AGFun4(int tamañoPob, int numIter , double probCruce , double probMut, double tolerancia, Funcion funcion,double elitismo)
	{
		super( tamañoPob,  numIter ,  probCruce ,  probMut,  tolerancia, funcion,elitismo);	
		listaElMejor	=	new ArrayList<Double>();
    	listaMaximoAptitud	=	new ArrayList<Double>();
    	listaMedioAptitud	=	new ArrayList<Double>();
    	
	}



	

	public void inicializa() {
		for(int i=0; i < tamañoPob ; i++)
		{
			pob[i] = new CromosomaFuncion4(tolerancia);
			pob[i].inicializaCromosoma();
			pob[i].setAptitud(pob[i].evalua());
			longCrom= ((CromosomaFuncion4)pob[0]).getLongCromosoma();
			
			
		}
		int posMejo = 0;
		this.revisar_adaptacion_minimiza();
		double aptitudMejor = 0;
	
		
		
		for(int i=0; i<tamañoPob; i++)
		{
			
			if(((CromosomaFuncion4)pob[i]).getF()> aptitudMejor )
			{
				posMejo	=	i;
				aptitudMejor = ((CromosomaFuncion4)pob[i]).getF();
			}
		}	
		
			elMejor = new CromosomaFuncion4((CromosomaFuncion4)pob[posMejo]);
			
		log.info("Inicializada la poblacion: "+elMejor.getAptitud() +" " + elMejor.getFenotipo() );
		
		
	}


	public void evaluarPoblacion() 
	{
		int posMejo = 0; 
		double puntAcumulada	= 0;
		double fMejor		= ((CromosomaFuncion4)elMejor).getF();
		double sumAptitud		= 0;
		double aptitudMejorPob  = 0;
		double fMejorPob=0;
		double aptitudMejor		= elMejor.getAptitud();
		double sumF=0;
		for(int i=0; i<tamañoPob; i++)
		{
			sumF = sumF + ((CromosomaFuncion4)pob[i]).getF();
			sumAptitud = sumAptitud + pob[i].getAptitud();
			if(pob[i].getAptitud()< aptitudMejorPob )
			{
				aptitudMejorPob = pob[i].getAptitud();
			}
			if(aptitudMejor > pob[i].getAptitud())
			{
				posMejo	=	i;
				aptitudMejor = pob[i].getAptitud();
			}
		}	
		for(int i=0; i<tamañoPob; i++)
		{
			
			
			((CromosomaFuncion4)pob[i]).setF_punt(((CromosomaFuncion4)pob[i]).getF()/sumF);
			((CromosomaFuncion4)pob[i]).setF_punt_acum(((CromosomaFuncion4)pob[i]).getF_punt()+puntAcumulada);
			puntAcumulada	= puntAcumulada + ((CromosomaFuncion4)pob[i]).getF_punt();
		}
		if(aptitudMejor < elMejor.getAptitud() )
		{
		
				elMejor.copiaCromosoma(pob[posMejo]);
			
		}
		setMaximoAptitud(aptitudMejorPob);
		setMedioAptitud(sumAptitud/ tamañoPob);
	}
	
	public void seleccionRuleta() {
		
		int[] seleccion= new int[tamañoPob];
		double prob;
		this.selecciona_peores();
		int posSeleccionado;
		for(int i=0; i< tamañoPob -this.getNum_pob_elite() ; i++)
		{
			prob = aleatorio(); 
			posSeleccionado = 0;
			while((posSeleccionado < tamañoPob-1)&&(prob > pob[posSeleccionado].getPuntuacion_neta_acumulada()))
			//while((posSeleccionado < tamañoPob)&&(prob > ((CromosomaFuncion4)pob[posSeleccionado]).getF_punt_acum()))
			{
				posSeleccionado++;
			}
			seleccion[i]= posSeleccionado;
		}
		for(int i=0; i< tamañoPob -this.getNum_pob_elite(); i++)
		{
			pobIntermedia[i]= pob[seleccion[i]];
		}
	}

	public void reproduccion()
	{
		
		int[] seleccionCruce= new int[tamañoPob -this.getNum_pob_elite()];
		int numSelecCruce=0;
		double prob;
		
		for(int i=0; i< tamañoPob -this.getNum_pob_elite(); i++)
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
		int puntoCruceX1;
		int puntoCruceX2;
		
		hijo1 = new CromosomaFuncion4(tolerancia);
		hijo2 = new CromosomaFuncion4(tolerancia);
		
		puntoCruceX1= aleatorioPCruce(0,((CromosomaFuncion4)elMejor).getLonX1());
		puntoCruceX2= aleatorioPCruce(((CromosomaFuncion4)elMejor).getLonX2(),((CromosomaFuncion4)elMejor).getLongCromosoma());
		for(int i=0; i< numSelecCruce; i=i+2)
		{
			cruce(pobIntermedia[seleccionCruce[i]],pobIntermedia[seleccionCruce[i+1]],hijo1,hijo2,puntoCruceX1,puntoCruceX2);
			pobIntermedia[seleccionCruce[i]]= hijo1;
			pobIntermedia[seleccionCruce[i+1]]= hijo2;
		}
		
	}

	public void cruce(Cromosoma padre1, Cromosoma padre2,
			Cromosoma hijo1, Cromosoma hijo2, int puntoCruceX1,int puntoCruceX2)
	{
		
		
		for(int i=0; i< puntoCruceX1; i++)
		{
			hijo1.getGenes()[i]= padre1.getGenes()[i];
			hijo2.getGenes()[i]= padre2.getGenes()[i];
		}
		for(int i=puntoCruceX1; i<((CromosomaFuncion4) hijo1).getLonX1(); i++)
		{
			hijo1.getGenes()[i]= padre2.getGenes()[i];
			hijo2.getGenes()[i]= padre1.getGenes()[i];
		}
		
		for(int i=((CromosomaFuncion4) hijo1).getLonX1(); i< puntoCruceX2; i++)
		{
			hijo1.getGenes()[i]= padre1.getGenes()[i];
			hijo2.getGenes()[i]= padre2.getGenes()[i];
		}
		for(int i=puntoCruceX2; i<((CromosomaFuncion4) hijo1).getLongCromosoma(); i++)
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
		for(int i=0; i< tamañoPob -this.getNum_pob_elite(); i++)
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
		listaElMejor.add(getElMejor().getAptitud());
		listaMaximoAptitud.add(getMaximoAptitud());
		listaMedioAptitud.add(getMedioAptitud());
		escalado();
		while(!terminado())
		{
			IncrementoNumIter();
			seleccionRuleta();
			reproduccion();
			mutacion();
			this.revisar_adaptacion_minimiza();
			evaluarPoblacion();
			escalado();
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
		//double a_resultado= ((P_aux-1)*this.medioAptitud)/ (this.maximoAptitud - this.medioAptitud); 
		double a_resultado= (this.medioAptitud)/ (this.medioAptitud - this.getMaximaadaptacion()); 
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
			((CromosomaFuncion4)pob[i]).setF(Cmax - pob[i].getAptitud());
		}
	}
	private void selecciona_peores() {
		ArrayList <Integer> indices_seleccionados = new ArrayList();
		int mayor = 0;
		double mayor_aptitud = Integer.MAX_VALUE;
		for(int i =0; i< this.getNum_pob_elite() ; i++)
		{
			mayor_aptitud = Integer.MAX_VALUE;
			mayor = 0;
			for(int j=0; j< tamañoPob ; j++)
			{
				if(pob[j].getAptitud() < mayor_aptitud && indices_seleccionados.contains(j)==false ){
					mayor = j;
					mayor_aptitud = pob[j].getAptitud();
				}
			}
			indices_seleccionados.add(mayor);
		}
		for(int i=0 ; i< this.getNum_pob_elite() ; i++){
			this.pobIntermedia[i + tamañoPob - this.getNum_pob_elite()]= pob[indices_seleccionados.get(i)];
		}		
	}
}