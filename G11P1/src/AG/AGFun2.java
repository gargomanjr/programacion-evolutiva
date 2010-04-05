package AG;

import java.util.ArrayList;

public class AGFun2 extends AlgoritmoGenetico{
	
	//Atributos Propios
	
	private ArrayList<Double> listaElMejor;
	private ArrayList<Double> listaMedioAptitud;
	private ArrayList<Double> listaMaximoAptitud; 
	
	private ArrayList<Double> listaElMejorY;
	private ArrayList<Double> listaMedioAptitudY;
	private ArrayList<Double> listaMaximoAptitudY;
	
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



	public ArrayList<Double> getListaElMejorY() {
		return listaElMejorY;
	}



	public void setListaElMejorY(ArrayList<Double> listaElMejorY) {
		this.listaElMejorY = listaElMejorY;
	}



	public ArrayList<Double> getListaMedioAptitudY() {
		return listaMedioAptitudY;
	}



	public void setListaMedioAptitudY(ArrayList<Double> listaMedioAptitudY) {
		this.listaMedioAptitudY = listaMedioAptitudY;
	}



	public ArrayList<Double> getListaMaximoAptitudY() {
		return listaMaximoAptitudY;
	}



	public void setListaMaximoAptitudY(ArrayList<Double> listaMaximoAptitudY) {
		this.listaMaximoAptitudY = listaMaximoAptitudY;
	}


	//Constructora

	public AGFun2(int tamañoPob, int numIter , double probCruce , double probMut, double tolerancia, Funcion funcion,double elitismo)
	{
		super( tamañoPob,  numIter ,  probCruce ,  probMut,  tolerancia, funcion,elitismo);	
		//Gen X
		listaElMejor	=	new ArrayList<Double>();
    	listaMaximoAptitud	=	new ArrayList<Double>();
    	listaMedioAptitud	=	new ArrayList<Double>();
    	//Gen Y
    	listaElMejorY	=	new ArrayList<Double>();
    	listaMaximoAptitudY	=	new ArrayList<Double>();
    	listaMedioAptitudY	=	new ArrayList<Double>();
	}



	

	public void inicializa() {
		for(int i=0; i < tamañoPob ; i++)
		{
			pob[i] = new CromosomaFuncion2(tolerancia);
			pob[i].inicializaCromosoma();
			pob[i].setAptitud(pob[i].evalua());
			longCrom= ((CromosomaFuncion2)pob[0]).getLongCromosoma();
			
			
		}
		int posMejo = 0;
		double aptitudMejor		= 0;
	
		
		
		for(int i=0; i<tamañoPob; i++)
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
		this.selecciona_mejores();
		double prob;
		int posSeleccionado;
		for(int i=0; i< tamañoPob - this.getNum_pob_elite(); i++)
		{
			prob = aleatorio(); 
			posSeleccionado = 0;
			while((posSeleccionado < tamañoPob - 1)&&(prob > pob[posSeleccionado].getPuntuacion_neta_acumulada()))
			//while((posSeleccionado < tamañoPob - 1)&&(prob > pob[posSeleccionado].getPuntuacion_acumulada()))
			{
				posSeleccionado++;
			}
			seleccion[i]= posSeleccionado;
		}
		for(int i=0; i< tamañoPob - this.getNum_pob_elite(); i++)
		{
			pobIntermedia[i]= pob[seleccion[i]];
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
		int puntoCruceX;
		int puntoCruceY;
		
		hijo1 = new CromosomaFuncion2(tolerancia);
		hijo2 = new CromosomaFuncion2(tolerancia);
		
		puntoCruceX= aleatorioPCruce(0,((CromosomaFuncion2)elMejor).getLonX());
		puntoCruceY= aleatorioPCruce(((CromosomaFuncion2)elMejor).getLonX(),((CromosomaFuncion2)elMejor).getLongCromosoma());
		for(int i=0; i< numSelecCruce - this.getNum_pob_elite(); i=i+2)
		{
			cruce(pobIntermedia[seleccionCruce[i]],pobIntermedia[seleccionCruce[i+1]],hijo1,hijo2,puntoCruceX,puntoCruceY);
			pobIntermedia[seleccionCruce[i]]= hijo1;
			pobIntermedia[seleccionCruce[i+1]]= hijo2;
		}
		
	}

	public void cruce(Cromosoma padre1, Cromosoma padre2,
			Cromosoma hijo1, Cromosoma hijo2, int puntoCruceX,int puntoCruceY)
	{
		
		
		for(int i=0; i< puntoCruceX; i++)
		{
			hijo1.getGenes()[i]= padre1.getGenes()[i];
			hijo2.getGenes()[i]= padre2.getGenes()[i];
		}
		for(int i=puntoCruceX; i<((CromosomaFuncion2) hijo1).getLonX(); i++)
		{
			hijo1.getGenes()[i]= padre2.getGenes()[i];
			hijo2.getGenes()[i]= padre1.getGenes()[i];
		}
		
		for(int i=((CromosomaFuncion2) hijo1).getLonX(); i< puntoCruceY; i++)
		{
			hijo1.getGenes()[i]= padre1.getGenes()[i];
			hijo2.getGenes()[i]= padre2.getGenes()[i];
		}
		for(int i=puntoCruceY; i<((CromosomaFuncion2) hijo1).getLongCromosoma(); i++)
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
		for(int i=0; i< tamañoPob - this.getNum_pob_elite(); i++)
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
		double a_resultado= ((P_aux-1)*this.medioAptitud)/ (this.maximoAptitud - this.medioAptitud); 
		return a_resultado;
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
			this.pobIntermedia[i + tamañoPob - this.getNum_pob_elite()]= pob[indices_seleccionados.get(i)];
		}		
	}


	
	

	
	

}
