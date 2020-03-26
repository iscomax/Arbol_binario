// ab.java 
 
import java.util.*; //usamos el paquete util, importando toas las clases con *
import javax.swing.JOptionPane; // JOptionPane : Es para abrir ventanas de dialogo o informativas, no las estamos usando aqui.


// Clase ab
public class ab { 

  /*
 
   Nodo:
   El arbol binario usa una clase anidada llamada Nodo, la cual no contine funciones miembro (operaciones) solo un constructor.
   Cada nodo almacena un elemento y tiene dos apuntadores.
   The binary tree is built using this nested node class.

  */ 

  private static class Nodo { 
    Nodo izq; 
    Nodo der; 
    int dato;

    Nodo(int nDato) { 
      izq = null; 
      der = null; 
      dato = nDato; 
    } //Fin constructor de la clase Nodo
  } //Fin clase Nodo

  // Nodo Raiz 
  public Nodo raiz; 
 
  /** 
   Constructor de la clase ab: Crea un arbol binario vacio con la raiz apuntando a la constante null. 
   Tambien crea una grafica a visualizar con JUNG
  **/ 
  public ab(){ 
    raiz = null;  
  } 
 
  /** 
   Buscar: Devuelve 1 si la variable entera dato esta en el arbol binario (los nodos almacenan enteros). 
   Recursivamente explora el arbol. 
  **/ 
  public boolean buscar(int dato) { 
    return(buscar(raiz, dato)); 
  } 
 

  /** 
   Buscar: homonimia de funciones (mismo nombre diferente no. de parametros), una busqueda RECURSIVA a partir de un nodo, 
   recursivamente buscamos un dato,
   suponiendo un orden en el arbol, en el cual los numeros menores estan a la izq. y los mayores a la der.
  */ 
  private boolean buscar(Nodo nodo, int dato) { 
    if (nodo==null) { 
      return(false); 
    }

    if (dato==nodo.dato) { 
      return(true); 
    } 
    else if (dato<nodo.dato) { 
      return(buscar(nodo.izq, dato)); 
    } 
    else { 
      return(buscar(nodo.der, dato)); 
    } 
  } 
 

    /** 
   Insertar: Inserta un dato en el arbol binario. 
   Usa una funcion recursiva con mismo nombre pero dos parametros (nodo, dato). 
  */ 
  public void insertar(int data) { 
    raiz = insertar(raiz, data); 
  } 
 

  /** 
   Insercion recursiva -- a partir del nodo recorre hacia abajo e 
   inserta un dato en el arbol. Devuelve el apuntador al nuevo nodo.
  */ 
  private Nodo insertar(Nodo nodo, int dato) { 
    if (nodo==null) { 
      nodo = new Nodo(dato); 
    } //Fin if
    else { 
      if (dato <= nodo.dato) { 
	  nodo.izq = insertar(nodo.izq, dato); 
      } 
      else { 
        nodo.der = insertar(nodo.der, dato); 
      } 
    }//Fin else
    return nodo; // En cualquier caso devuelve el apuntador al nodo inicial , es una funcion recursiva
  } //Fin Node 
  //-----------------------------------------------------------------------------
  //metodo calcula la altura del nodo

    public int altura ( Nodo nodo){
        int altura =0;
        if (nodo != null) {
            if (nodo.izq !=null) {
              altura = Math.max(altura, altura(nodo.izq));
            } 
            if (nodo.der !=null) {
                altura = Math.max(altura, altura(nodo.der));
            }
            altura++;
        }
        return altura;
    }
    //--------------------------------------------------------------------------

    public void pre(){
	pre(raiz);
    }

    private void pre(Nodo nodo) {
	if(nodo == null)
	    return;
	System.out.print("\t"+nodo.dato);
	pre(nodo.izq);
	pre(nodo.der);
    }

    public void in(){
	in(raiz);
    }

    private void in(Nodo nodo) {
	if(nodo == null)
	    return;
	in(nodo.izq);
	System.out.print("\t"+nodo.dato);
	in(nodo.der);
    }

    public void pos(){
	pos(raiz);
    }
    private void pos(Nodo nodo) {
	if(nodo == null)
	    return;
	pos(nodo.izq);
	pos(nodo.der);
	System.out.print("\t"+nodo.dato);
    }

    // Funciones para buscar en el ABB
    

    private Nodo buscar2(Nodo nodo, int dat)
    {
	if(nodo.dato == dat)
	    return nodo;
	if(dat <= nodo.dato)
	    return buscar2(nodo.izq,dat);
	else return buscar2(nodo.der,dat);
        
    }

    public Nodo buscar2(int dat){
	return buscar2(raiz, dat);
    }

    //Regresa el nodo/vertice padre del nodo con el dato, explora a partir de un sub-arbol con raiz nodo.
    private Nodo padre(Nodo nodo, int dato){
	if(nodo.izq == null && nodo.der == null && nodo.dato == dato) //Solo hay un nodo y ese nodo tiene el dato
	    return nodo; //regresa el padre
	if(nodo.izq != null && (nodo.izq).dato == dato) //Esta en el primer hijo de la raiz, izquierdo 
	    return nodo; //regresa el padre
	if(nodo.der != null && (nodo.der).dato == dato) //Esta en el segundo hijo de la raiz, derecho
	    return nodo; //regresa el padre

	if(dato <= nodo.dato)
	    return padre(nodo.izq,dato);
	    else
		return padre(nodo.der,dato);
    }

    //Devuelve el valor entero almacenado en el subarbol que tiene como raiz al parametro nodo
    private int minderint(Nodo nodo)
    {
	int tmp;
	if (nodo.izq == null && nodo.der == null){//Si es una hoja.
            tmp = nodo.dato;
	    padre(nodo,nodo.dato).izq = null;
	    padre(nodo,nodo.dato).der = null;
	    return tmp;
	}
	else return minderint(nodo.izq); //Recursividad
    }

    //Devuelve el nodo con el dato mas pequeño a partir de un nodo 
    private Nodo minder(Nodo nodo)
    {
	if (nodo.izq == null && nodo.der == null){
	    padre(nodo,nodo.dato).izq = null;
	    padre(nodo,nodo.dato).der = null;
	    return nodo;
	}
	else return minder(nodo.izq);//Buscamos a la izquierda
    }

    //Funcion que invoca a la funcion borrar.
   public void borrar(int dato){
	Nodo nodoborrar;
	if(buscar(dato)) //Buscamos el nodo que tiene el dato
	    {
		//nodoborrar = buscar2(dato);
		//borrar(nodoborrar,dato);//Borramos a partir de ese nodo
		borrarNodo(raiz,dato); //Borra desde la raiz.

	    }
	else JOptionPane.showMessageDialog(null,"El dato a borrar no se encuentra en el ABB");
    }

    //Funcion para borrar un nodo en un ABB
    private Nodo borrarNodo(Nodo root, int data) {
    Nodo cur = root; //temporalmente almacena el nodo que se esta explorando, es una llamada por valor o referencia?
    if(cur == null){ //Si es null regrasa cur
        return cur;//regresa el nodo cur
    }
    if(cur.dato > data){ //Si esta el dato esta en el lado izq
        cur.izq = borrarNodo(cur.izq, data); //llamada recursiva
    }else if(cur.dato < data){ //Si esta en el lado der. 
        cur.der = borrarNodo(cur.der, data);//Lamada recursiva
    }else{//No es nullo ni esta a la izq. ni a la der.          
        if(cur.izq == null && cur.der == null){ //Si no tiene hijos
            cur = null; //hacerlo null
        }else if(cur.der == null){ //si tiene hijo izq.
            cur = cur.izq; //bajar con el hijo izq.
        }else if(cur.izq == null){ //Si tiene hijo der.
            cur = cur.der; //bajamos con el hijo der.
        }else{ // si no tiene dos hijos
            Nodo temp  = minder(cur.der); //tmpo es el nodo con el valor minimo a la derecha.
            cur.dato = temp.dato; //el dato de tmp.data se lo asignamos a cur.data (el nodo a borrar), 
            cur.der = borrarNodo(cur.der, temp.dato); //Borramos desde cur.right el temp.dato
        }
    }
    return cur;
}
    //Funcion para Borrar un nodo en un ABB
    private void borrar(Nodo nodo, int dato)
    {
	int mind; //para almacenar el valor minimo del subarbol derecho
	Nodo curtmp = nodo; //Esta es una observacion importante, durante la recursion tenemos que tener guardado en cada paso
	//un nodo que almacena el nodo a borrar, si no, no tenemos control 

	 if (curtmp==null) //Si el ABB esta vacio
	    return;
	
	if ( curtmp.dato == dato && curtmp == raiz) // Si es esta en nodo raiz pero la raiz tiene hijos
	    {
		JOptionPane.showMessageDialog(null,"Actualmente no podemos borrar la raiz");
		return;
	    }
      
	if (curtmp.dato == dato && curtmp.izq == null && curtmp.der == null && curtmp == raiz){ //Si el dato esta en la raiz y la raiz no tiene hijos
	    raiz = null;
	    return;
		};

        if (curtmp.dato == dato && curtmp.izq == null && curtmp.der == null){ //Si el dato esta en una hoja
	    padre(curtmp,dato).izq = null;
	    padre(curtmp,dato).der = null;
       	    nodo = null;
	    return;
		}; 

	//Casos con un hijo
	if (curtmp.dato == dato && curtmp.der != null && curtmp.izq == null) // Si es un nodo interior con hijo derecho
	    {
		padre(curtmp,dato).der = curtmp.der;
		return;
	    }

	if (curtmp.dato == dato && curtmp.izq != null && curtmp.der == null) // Si es un nodo interior con hijo izquierdo
	    {
		if(padre(curtmp,dato).dato < curtmp.dato)
		    {
			padre(curtmp,dato).der = curtmp.izq;
			return;
		    }

		if(padre(curtmp,dato).dato >= curtmp.dato)
		    {
			padre(curtmp,dato).izq = curtmp.izq;
			return;
		    }
	    }
	
	//Caso con dos hijos
	if (curtmp.dato == dato && curtmp.izq != null && curtmp.der != null)
	    {
		mind=minderint(curtmp); //Esta funcion devuelve un entero
		curtmp.dato = mind; //Solo cambiamos el valor no borramos.
	    }

        if (dato <= nodo.dato) //Recursion en el arbol binario de busqueda
        borrar(nodo.izq, dato); 
	else borrarNodo(nodo.der, dato);
     }//Fin borrar

    
} //Fin Clase ab 
