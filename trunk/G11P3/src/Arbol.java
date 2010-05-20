import java.util.ArrayList;
import java.util.Random;


public class Arbol {
	
	 private String nombre;
	 private Arbol hi;
	 private Arbol hc;
	 private Arbol hd;
	 private Arbol padre;
	 private int profundidad;
	 private int numNodos;
	 private boolean hoja;
	 private boolean raiz;
	 private boolean esHi;
	 private int profTotal;
	 private ArrayList<String> lista;
	 private int pos;
	 private boolean admite_if;

	 
	//Metodos Accesores y Mutadores 
	public boolean getHoja(){
		return hoja;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Arbol getHd() {
		return hd;
	}
	public void setHd(Arbol hd) {
		this.hd = hd;
	}
	public Arbol getHc() {
		return hc;
	}
	public void setHc(Arbol hc) {
		this.hc = hc;
	}
	public Arbol getHi() {
		return hi;
	}
	public void setHi(Arbol hi) {
		this.hi = hi;
	}
	public Arbol getPadre() {
		return padre;
	}
	public void setPadre(Arbol padre) {
		this.padre = padre;
	}
	public int getProfundidad() {
		return profundidad;
	}
	public void setProfundidad(int profundidad) {
		this.profundidad = profundidad;
	}
	public int getNumNodos() {
		return numNodos;
	}
	public void setNumNodos(int numNodos) {
		this.numNodos = numNodos;
	}
	public boolean isHoja() {
		return hoja;
	}
	public void setHoja(boolean hoja) {
		this.hoja = hoja;
	}
	public boolean isRaiz() {
		return raiz;
	}
	public void setRaiz(boolean raiz) {
		this.raiz = raiz;
	}
	public boolean isEsHi() {
		return esHi;
	}
	public void setEsHi(boolean esHi) {
		this.esHi = esHi;
	}
	public int getProfTotal() {
		return profTotal;
	}
	public void setProfTotal(int profTotal) {
		this.profTotal = profTotal;
	}
	//----------------------------------------------------------------
	//Cosntructoras
	
	public Arbol(boolean in_admite_if){
		nombre=null;
		hd = null;
		hi = null;
		profundidad = 0;
		numNodos = 1;
		hoja = false;
		raiz = true;
		esHi = false;
		lista = new ArrayList<String>();
		this.admite_if = in_admite_if;
	}
	//----------------------------------------------------------------

	public Arbol(String[] cjtoFuns,  String[] cjtoTerms,
			  int hmax, int prof, Arbol pater, boolean esHizq, boolean esRaiz,boolean in_admite_if){
			    
				int nuevaProf = prof+1;
			    boolean  rnd=boolRandom();
			    profundidad=prof;
			    padre = pater;
			    esHi = esHizq;
			    raiz = esRaiz;
			    lista = new ArrayList<String>();
			    admite_if = in_admite_if;
			    if (padre == null) raiz = true;
			    numNodos = 1;
			    if ((rnd) || (profundidad + 1 == hmax))
			    {
			      int intRand = aleatorioInt2(0,cjtoTerms.length);
			      nombre = cjtoTerms[intRand];
			      hoja = true;
			    }
			    else
			    {
			      int intRand2 = 0 ;
			      if(this.admite_if){
				      intRand2 = aleatorioInt2(0,cjtoFuns.length);			    	  
			      }
			      else{
				      intRand2 = aleatorioInt2(0,cjtoFuns.length-1);			    	  
			      }		      
			      //int intRand2 = aleatorioInt2(0,cjtoFuns.length-1);	
			      nombre = cjtoFuns[intRand2];
			      if(nombre.equals("AND") || nombre.equals("OR")){
				      hi = new Arbol(cjtoFuns, cjtoTerms, hmax, nuevaProf, this, true, false,admite_if);
				      numNodos = numNodos + hi.getNumNodos();
				      hc=null;
				      hd = new Arbol(cjtoFuns, cjtoTerms, hmax, nuevaProf, this, false, false,admite_if);
				      numNodos = numNodos + hd.getNumNodos();
				      hoja = false;
			      }
			      else
			      {
			    	  if(nombre.equals("NOT"))
			    	  {
			    		  hc = new Arbol(cjtoFuns, cjtoTerms, hmax, nuevaProf, this, true, false,admite_if);
					      numNodos = numNodos + hc.getNumNodos();
					      hoja=false;
					      hd=null;
					      hi=null;
			    	  }
			    	  else 
			    	  {
			    		  if(nombre.equals("IF"))
			    	  	  {
			    			  hi = new Arbol(cjtoFuns, cjtoTerms, hmax, nuevaProf, this, true, false,admite_if);
						      numNodos = numNodos + hi.getNumNodos();
						      hc = new Arbol(cjtoFuns, cjtoTerms, hmax, nuevaProf, this, true, false,admite_if);
						      numNodos = numNodos + hc.getNumNodos();
						      hd = new Arbol(cjtoFuns, cjtoTerms, hmax, nuevaProf, this, false, false,admite_if);
						      numNodos = numNodos + hd.getNumNodos();
						      hoja = false;
			    		  
			    	  	  }
			    	  }
			      }
			    }
	}
	
	//----------------------------------------------------------------
	
	public Arbol (Arbol hd,Arbol hi){}
	//----------------------------------------------------------------
	private boolean boolRandom()
	{
		if(Math.random()<0.5)
			return false;
		else
			return true;
	}
	private double aleatorio() 
	{
		
		return  Math.random();
	}
	private int aleatorioInt2(int min, int max) {
		// TODO Auto-generated method stub
		return (int)(Math.random()*(max-min))+min;
	}
	public int altura() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void actualizar(int profundidad2) {
		// TODO Auto-generated method stub
		
	}
	
	private void preorden(Arbol a)
	{
	  if (a != null) {
		if(a.getHoja()== false){
			lista.add("(");
		}
	    tratar(a);          //Realiza una operación en nodo
	    preorden(a.getHi());
	    preorden(a.getHc());
	    preorden(a.getHd());
		if(a.getHoja()== false){
			lista.add(")");
		}
	  }
	}
	private void tratar(Arbol a) {
		
		lista.add(a.getNombre());
		pos++;
	}
	
	public ArrayList<String> dameExpresion()
	{
		pos=0;
		preorden(this);
		return lista;
		
	}

	
}