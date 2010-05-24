
package AG;




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
	 private boolean esHc;
	 private int profTotal;
	 private ArrayList<String> lista;
	 private int pos;
	 private boolean admite_if;
	 
	 public boolean isEsHc() {
			return esHc;
		}
		public void setEsHc(boolean esHc) {
			this.esHc = esHc;
		}
    public ArrayList<String> getLista() {
			return lista;
		}
    public void setLista(ArrayList<String> lista) {
			this.lista = lista;
		}
	public boolean isAdmite_if() {
		return admite_if;
	}
	public void setAdmite_if(boolean admite_if) {
		this.admite_if = admite_if;
	}
	//Metodos Accesores y Mutadores 
	public boolean getHoja(){
		return hoja;
	}
	public String getNombre() {
		return nombre;
	}
	 public int getPos() {
			return pos;
		}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Arbol getHd() {
		return hd;
	}
	public void setHd(Arbol hd_in) {
		//this.hd = hd;
		if (hd_in!= null){
			hd = new Arbol(hd_in,this);
			this.setEsHi(false);
			this.setEsHc(false);
			this.setHoja(false);
		}
		else
			hd = null;
	}
	public Arbol getHc() {
		return hc;
	}
	public void setHc(Arbol hc_in) {
		//this.hc = hc;
		if (hc_in!= null){
			hc = new Arbol(hc_in,this);
			this.setEsHi(false);
			this.setEsHc(true);
			this.setHoja(false);
		}
		else
			hc = null;
	}
	public Arbol getHi() {
		return hi;
	}
	public void setHi(Arbol hi_in) {
		//this.hi = hi;
		if (hi_in!= null){
			hi = new Arbol(hi_in,this);
			this.setEsHi(true);
			this.setEsHc(false);
			this.setHoja(false);
		}
		else
			hi = null;
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
		esHc = false;
		lista = new ArrayList<String>();
		this.admite_if = in_admite_if;
	}
	//----------------------------------------------------------------

	public Arbol(String[] cjtoFuns,  String[] cjtoTerms,
			  int hmax, int prof, Arbol pater, boolean esHizq, boolean esHCentral,boolean esRaiz,boolean in_admite_if,int posicion){
			    
				int nuevaProf = prof+1;
			    boolean  rnd=boolRandom();
			    profundidad=prof;
			    padre = pater;
			    esHi = esHizq;
			    esHc = esHCentral;
			    posicion ++;
			    pos = posicion;
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
				      hi = new Arbol(cjtoFuns, cjtoTerms, hmax, nuevaProf, this, true,false, false,admite_if,pos);
				      numNodos = numNodos + hi.getNumNodos();
				      hc=null;
				      hd = new Arbol(cjtoFuns, cjtoTerms, hmax, nuevaProf, this, false,false,false,admite_if,hi.getNumNodos()+ pos);
				      numNodos = numNodos + hd.getNumNodos();
				      hoja = false;
			      }
			      else
			      {
			    	  if(nombre.equals("NOT"))
			    	  {
			    		  hc = new Arbol(cjtoFuns, cjtoTerms, hmax, nuevaProf, this, false,true, false,admite_if,pos);
					      numNodos = numNodos + hc.getNumNodos();
					      hoja=false;
					      hd=null;
					      hi=null;
			    	  }
			    	  else 
			    	  {
			    		  if(nombre.equals("IF"))
			    	  	  {
			    			  hi = new Arbol(cjtoFuns, cjtoTerms, hmax, nuevaProf, this, true,false, false,admite_if,pos);
						      numNodos = numNodos + hi.getNumNodos();
						      hc = new Arbol(cjtoFuns, cjtoTerms, hmax, nuevaProf, this, false,true, false,admite_if,hi.getNumNodos() + pos);
						      numNodos = numNodos + hc.getNumNodos();
						      hd = new Arbol(cjtoFuns, cjtoTerms, hmax, nuevaProf, this, false,false, false,admite_if,hc.getNumNodos() +pos);
						      numNodos = numNodos + hd.getNumNodos();
						      hoja = false;
			    		  
			    	  	  }
			    	  }
			      }
			    }
	}
	
	//----------------------------------------------------------------
	
 	/*public Arbol (Arbol arbol){

	    this.setNombre(arbol.getNombre()) ;
	    String ls_nombre = arbol.getNombre() ;
	    this.setPos(arbol.getPos());
	    this.setHoja(arbol.getHoja());
	    if (arbol.isRaiz())
	    	this.setRaiz(true);    
	    else
	    	this.setRaiz(false);
	    this.setNumNodos(arbol.getNumNodos());
	    this.setProfundidad(arbol.getProfundidad());
	    this.setEsHi(arbol.isEsHi());
	    if (!arbol.getHoja())
	    {
	      if ( (ls_nombre.equals("OR")) || (ls_nombre.equals("AND"))) {
	    	  this.setHi(new Arbol(arbol.getHi()));
	    	  this.setHc(null);
	    	  this.setHd(new Arbol(arbol.getHd()));

	      }	
		  if ( (ls_nombre.equals("NOT")) ){
		    	this.setHi(null);
		        this.setHc(new Arbol(arbol.getHc()));
		        this.setHd(null);
		  }      
		  if ( (ls_nombre.equals("IF"))){
		    	  //  hi = new Arbol(arbol.getHi(), this);
		    	    this.setHi(new Arbol(arbol.getHi()));
		    	    this.setHc(new Arbol(arbol.getHc()));
		    	    this.setHd(new Arbol(arbol.getHd()));
	    	  //  hc = new Arbol(arbol.getHc(), this);
		      //  hd = new Arbol(arbol.getHd(), this);
	      }
	    }	
		
	}*/
	public Arbol(Arbol arbol, Arbol pater)
	{
	    nombre = arbol.getNombre();
	    pos = arbol.getPos();
	    hoja = arbol.getHoja();
	    if (pater==null)
	      raiz = true;
	    else
	      raiz = false;
	    numNodos = arbol.getNumNodos();
	    profundidad = arbol.getProfundidad();
	    padre = pater;
	    esHi = arbol.isEsHi();
	    esHc = arbol.isEsHc();
	    if (!hoja)
	    	if ( (nombre.equals("OR")) || (nombre.equals("AND"))) {
		    	  this.setHi(new Arbol(arbol.getHi(),this));
		    	  this.setHc(null);
		    	  this.setHd(new Arbol(arbol.getHd(),this));

		      }	
			  if ( (nombre.equals("NOT")) ){
			    	this.setHi(null);
			        this.setHc(new Arbol(arbol.getHc(),this));
			        this.setHd(null);
			  }      
			  if ( (nombre.equals("IF"))){
			    	    this.setHi(new Arbol(arbol.getHi(),this));
			    	    this.setHc(new Arbol(arbol.getHc(),this));
			    	    this.setHd(new Arbol(arbol.getHd(),this));
		      }	    
	}

	
	
	
	
	
	
	
	
	
	
	
	
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

		return (int)(Math.random()*(max-min))+min;
	}
	public int altura() {
	    int alt = 0;
	    int altHi = 0;
	    int altHc = 0;
	    int altHd = 0;

	    if (!isHoja())
	    {
	    	if(getHi()!= null)
	    		altHi = getHi().altura();
	    	else
	    		altHi = 0;
	    	if(getHc()!= null)
	    		altHc = getHc().altura();
	    	else
	    		altHc = 0;
	    	if(getHd()!= null)
	    		altHd = getHd().altura();
	    	else
	    		altHd = 0;
	    	if(altHi > altHc)
	    		if(altHi > altHd)
	    			return altHi;
	    		else
	    			return altHd;	
	    	else
	    		if(altHc > altHd)
	    			return altHc;
	    		else
	    			return altHd;	
	    }
	    else
	      alt = 1;

	    return alt;
	}

	public void actualizar(int prof) {
		 int nuevaProf = prof+1;
		  if (isRaiz()) 
			    pos = 1;
		  setProfundidad(prof);
		  if (isHoja()) {
		    numNodos = 1;
		    if (getPadre()!=null)
		    	pos = getPadre().getPos() +1 ;
		    }
		  else
		  {
			
		    if ( (nombre.equals("OR")) || (nombre.equals("AND"))) {
		    	hi.actualizar(nuevaProf);
		    	numNodos = 1 + hi.getNumNodos();
		    	hd.actualizar(nuevaProf);
		    	numNodos = numNodos + hd.getNumNodos();
		    	hi.setPos(pos + 1);
		    	hd.setPos( hi.getNumNodos()+pos+1);
		    }    
		    if ( (nombre.equals("NOT")) ){
		    	hc.actualizar(nuevaProf);
		    	numNodos = 1 + hc.getNumNodos();
		    	hc.setPos(pos + 1);
		    }
		    if ( (nombre.equals("IF"))){
		    	hi.actualizar(nuevaProf);
		    	numNodos = 1 + hi.getNumNodos();
		    	hc.actualizar(nuevaProf);
		    	numNodos = numNodos + hc.getNumNodos();
		    	hd.actualizar(nuevaProf);
		    	numNodos = numNodos + hd.getNumNodos();
		    	hi.setPos(pos + 1);
		    	hc.setPos( hi.getNumNodos()+pos+1);
		    	hd.setPos( hc.getNumNodos()+hi.getNumNodos()+pos+1);	    	
		    }
		   /* if(!(isRaiz()) && isEsHi()){
		    	pos = getPadre().getPos()+1;
		    }
		    if(!(isRaiz()) && isEsHc()){
		    	if (getPadre().getHi() != null)
		    		pos = getPadre().getHi().getNumNodos()+ getPadre().getPos()+1;
		    	else
		    		pos = getPadre().getPos()+1;
		    }
		    if(!(isRaiz()) && !isEsHi() && !isEsHc()){
		    	if (getPadre().getHc() != null)
		    		pos = getPadre().getHi().getNumNodos()+ getPadre().getHc().getNumNodos()+getPadre().getPos()+1;
		    	else
		    		pos = getPadre().getHi().getNumNodos()+ getPadre().getPos()+1;
		    }
		    */
		  }
		
	}
	
	private void preorden(Arbol a)
	{
	  if (a != null) {
		if(a.getHoja()== false){
			lista.add("(");
		}
	    tratar(a); //Realiza una operación en nodo
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
		//a.setPos(pos + 1);
	}
	public Arbol preordenMut(Arbol a,IntHolder posic,int aleat)
	{
		Arbol b,c,d;
		b=c=d=null;
		  if (a != null) {
			
			if(tratarMut(a,posic,aleat))
			{
				return a;
			}
			posic.pos++;
		    b=preordenMut(a.getHi(),posic,aleat);
		    c=preordenMut(a.getHc(),posic,aleat);
		    d=preordenMut(a.getHd(),posic,aleat);
			
		  }
		  if(b!=null)
			  return b;
		  else
			  if(c!=null)
				  return c;
			  else
				  if(d!=null)
					  return d;
				  else
					  return null;
	}
	
	private boolean tratarMut(Arbol a,IntHolder pos,int aleat) {
		
		return pos.pos==aleat;
		
	}
	public Arbol GetArbolPosicion(Arbol a,int posicionbusqueda){
		    if (posicionbusqueda == 1 || a.getPos()== posicionbusqueda ){
			    return a;
			    }
		    else {		
		    	 if ( (a.getNombre().equals("OR")) || (a.getNombre().equals("AND"))) {
		    		 if(posicionbusqueda <= a.getPos()+a.getHi().getNumNodos())
		    			 return GetArbolPosicion(a.getHi(),posicionbusqueda);
		    		 else
		    			 return GetArbolPosicion(a.getHd(),posicionbusqueda);
		    	 }
		    	 if (a.getNombre().equals("IF")) {
		    		 if(posicionbusqueda<= a.getPos()+a.getHi().getNumNodos())
		    			 return GetArbolPosicion(a.getHi(),posicionbusqueda);
		    		 if(posicionbusqueda<= a.getPos()+a.getHc().getNumNodos())
		    			 return GetArbolPosicion(a.getHc(),posicionbusqueda);
		    		 else
		    			 return GetArbolPosicion(a.getHd(),posicionbusqueda);	 
		    	 }
		    	 if (a.getNombre().equals("NOT")) {
					return GetArbolPosicion(a.getHc(),posicionbusqueda);
					}
		    	 else{
		    		 System.out.println("Error al buscar el nodo");
		    		 return a;
		    	 }
			}	
	}
		
	private void  SetNombrePosicion(Arbol a,int posicionbusqueda,String Nombre){
		if (a != null) {
			if(a.getPos() == posicionbusqueda){
				a.setNombre(Nombre);
			}
			else{
				SetNombrePosicion(a.getHi(),posicionbusqueda,Nombre);
				SetNombrePosicion(a.getHc(),posicionbusqueda,Nombre);
				SetNombrePosicion(a.getHd(),posicionbusqueda,Nombre);
			}		
		}
	}
	public ArrayList<String> dameExpresion()
	{
	//	pos=0; 
		if (this.lista == null){
			lista = new ArrayList<String>();
		}
		this.lista.clear();
		preorden(this);
		return lista;
		
	}
	public Arbol ArbolAleatorio(){
		int posicionbusqueda = this.aleatorioInt2(1, this.numNodos);
		return GetArbolPosicion(this, posicionbusqueda);
	}
	public Arbol ArbolAleatorioconProb(){
		boolean selecccion = false;
		int posicionbusqueda = this.aleatorioInt2(1, this.numNodos);
		Arbol aux= GetArbolPosicion(this, posicionbusqueda);
		while (selecccion==false){
			if(aux.getHoja() && aleatorio() > 0.1){
				selecccion = true;
			}
			else{
				if(aleatorio() < 0.9){
					selecccion = true;
				}
			}
			if (selecccion==false){
				 posicionbusqueda = this.aleatorioInt2(1, this.numNodos);
				 aux= GetArbolPosicion(this, posicionbusqueda);	
			}			
		}
		return aux;
	}
	public void borraArbol() {
		
		numNodos=0;
		hi=null;
		hc=null;
		hd=null;
		profundidad=0;
		
	}
	
}