package linkedlist;


import NODO.nodo;
import Stack.StackEmptyException;

public class Linkedlist<T> {
	/*
	 *  add          <- listo 
	 *  serchr       <- listo
	 *  addLast      <- listo 
	 *  addFirst     <- listo 
	 *  addAfter     <- listo 
	 *  addBefore    <- listo 
	 *  removeAfter  <- listo 
	 *  removeBefore <- listo
	 *  removeFirst  <- listo
	 *  removeLast   <- listo 
	 *  size         <- listo
	 *  clear        <- listo
	 *  isEmty       <- listo
	 *  replace      <- listo
	 *  getFirst     <- listo 
	 *  getLast      <- listo
	 *  removeBefore <- listo
	 *  removeAfter  <- listo
	 *  removeFirst  <- listo
	 *  removeLast   <- listo
	 *  reIndex      <- listo
	 *  IndexOf      <- listo
	 * ------------------------------------------------------- 

	 *  list(print)  <- 
	 * 	
	 *  
	 * 
	 */
	 
	 
	
	private nodo<T> sentinel = null;

	public Linkedlist() {

		sentinel = new nodo<T>();
		sentinel.setIndex(-1);
	}

	public Linkedlist(T value) {
		this();// llama el contructor de arriba
		nodo<T> tmp = new nodo(value);
		tmp.setIndex(0);
		sentinel.setNext(tmp);

	}
     //------------------------------------------------
	// MEtodo que añade un nodo antes de ejecucion
	public void addStart(T value) {
		nodo<T> tmp = sentinel.getNext();
		nodo<T> _new = new nodo<T>(value);

		_new.setNext(tmp);

		sentinel.setNext(_new);
		reIndex();

	}
	//---------------------------------------

	// Agrega un nodo con su valor cuando el next del ultimo nodo sea null
	public void addLast1(T value) {
		nodo<T> tmp = sentinel;
		while (tmp.getNext() != null) {
			tmp = tmp.getNext();
		}
		tmp.setNext(new nodo<T>(value));
		reIndex();
	}
//------------------------------------
	// agregar ultimo recursivo
	public void addEnd(T value) {
		addEnd(value, sentinel);
	}
	
	public void addEnd(T value, nodo<T> list) {
		if (list.getNext() == null) {
			list.setNext(new nodo<T>(value));
			reIndex();
			return;

		}
		addEnd(value, list.getNext());
	}

	// --------------
	public nodo<T> remmove(T value) {
		return null;
	}

	public boolean remove(T value) {
		nodo<T> tmp = sentinel;
		while (tmp.getNext() != null) {
			if (tmp.getNext().getValue().equals(value)) {
				tmp.setNext(tmp.getNext().getNext());
				return true;
			} else {
				tmp = tmp.getNext();
			}
		}
		return false;
	}
//---------------------------------------------
	public boolean remover(T value) {
		return remover(value, sentinel);
	}
	public boolean remover(T value, nodo<T> lista) {

		if (lista.getNext() == null) {
			return false;
		}
		if (lista.getNext().getValue().equals(value)) {
			lista.setNext(lista.getNext().getNext());
			reIndex();
			return true;
		} else {
			return remover(value, lista.getNext());
		}

	}
	// ----------------------------------------

	public nodo<T> search(T value) {
		
		return search(value, sentinel);
	}

	private nodo<T> search(T value, nodo<T> list) {
		if (list.getNext() == null)
			return null;
		if (list.getNext().getValue().equals(value)) {
			return list.getNext();
		} else {
			return search(value, list.getNext());
		}

	}

	// --------------------------------
	public boolean addLast(T value, T newvalue) {
		nodo<T> finder = search(value);
		if (finder != null) {
			return addLast(new nodo<T>(newvalue), finder);
		} else {
			return false;

		}
	}

	public boolean addLast(T value, nodo<T> node) {
		nodo<T> finder = search(value);

		if (finder != null) {
			return addLast(node, finder);
		} else {
			return false;
		}
	}

	public boolean addLast(nodo<T> node, nodo<T> lista) {

		lista.setNext(node.getNext());
		lista.setNext(node);
		reIndex();

		return true;
	}

	// ----------------------------------------------
	public boolean addBefore(T value, T newvalue) {
	    nodo<T> tmp=sentinel;
	    
	    while(tmp.getNext() !=null && !tmp.getNext().getValue().equals(value))
	    	tmp=tmp.getNext();
	    
	    return(tmp.getNext() !=null)?addLast(new nodo<T>(newvalue),tmp):false;
	}
		

	

	// --------------------------------------

	private void reIndex() {
		int i=0;
		nodo<T> tmp=sentinel;
		
		while(tmp.getNext()!=null) {
			
			tmp.setIndex(i++);
			tmp=tmp.getNext();
		}
	}
	//------------------------------------------
	
	public int size() {
		int size = 0;
		nodo<T> tmp = sentinel;
		while (tmp.getNext() != null) {
			tmp = tmp.getNext();
			size++;
		}
		return size;
	}
//-------------------------------------------------------
	public void clear() {
		
		nodo<T> tmp;
		while(sentinel.getNext()!=null) {
			tmp=sentinel.getNext();
			sentinel.setNext(null);
			sentinel=tmp;
			
		}
		System.gc();
	}
	//-----------------------------------------
	
	public String isemty() {
		String answer;
		nodo<T> tmp=sentinel;
		if(tmp.getNext()!=null) {
			
			answer="no esta vacia";
			
		}else {
			answer="esta vacia";
		}
		
		return answer;
	}
	
	//------------------------------------------------------
	
	public void replace(T oldValue, T newValue) {
		
		nodo<T> tmp=search(oldValue);
		tmp.setValue(newValue);
		reIndex();
	}
	
	//------------------------------------------------------
	
	public T getFirst() {
		nodo<T> tmp=sentinel;
		return tmp.getNext().getValue();
	}
	
	//----------------------------------------------------------
	
	public T getLast() {
		nodo<T> tmp=sentinel;
		while(tmp.getNext()!=null) {
			  tmp=tmp.getNext();
		}
		return tmp.getValue();
	}
	//--------------------------------------------------
	
	public T removeBefore(T value) {
		
		return removeBefore(value,sentinel);
	}
	
	private T removeBefore(T value,nodo<T> list) {
		nodo<T> tmp = list;
		
		if(tmp.getNext()==null) {
			return value;
		}
		list=list.getNext();
		if(list.getNext().getValue().equals(value)) {
			tmp.setNext(tmp.getNext().getNext());
			reIndex();
			
		}else {
			return removeBefore(value,list);
		}
		return value;
	}
	
	
	//----------------------------------------------------	

    public T removeAfter(T value) {
		
		return removeAfter(value,sentinel);
	}
	
	private T removeAfter(T value,nodo<T> list) {
		
		
		if(list.getNext()==null) {
			return value;
		}
		if(list.getNext().getValue().equals(value)) {
			list=list.getNext();
			list.setNext(list.getNext().getNext());
			reIndex();
		}else {
			return removeAfter(value,list.getNext());
		}
		return value;
	}
	
	
	//------------------------------------------------------
	
	
	public boolean removeFirst() {
		nodo<T> tmp = sentinel;
		if(tmp.getNext()==null) {
			return false;
		}else {
		tmp.setNext(tmp.getNext().getNext());
		reIndex();
		}
		return true;
	}
	//-------------------------------------------------------
	
	public boolean removeLast(){
		return removeLast(sentinel);
	}
	
	private boolean removeLast(nodo<T> list){
		nodo<T> tmp=list;
        if(list.getNext().getNext()!=null){
			
			return removeLast(list.getNext());
		}else if(list.getNext().getNext()==null) {
			
			tmp.setNext(null);
			System.gc();
			reIndex();
		}
		return true;
	}
	
	//------------------------------------------
	
	public T IndexOf(long index) {
		return IndexOf(index,sentinel);
	}
	
	private T IndexOf(long index, nodo<T> list) {
		
		if (list.getNext()==null) {
			return null;
		}
		long i=list.getIndex();
		if(i==index) {
			return list.getNext().getValue();
		}else {
			return IndexOf(index, list.getNext());
		}
		
	}
	//---------------------------------------------------
	
	
	
	
	
	
	
	//---------------------------------------------------

	public void printer() {
		printer(sentinel);
	}

	
	private void printer(nodo<T> tmp) {
		reIndex();
		if (tmp.getNext() == null) {
			return;
		} else {
			System.out.println(tmp.getNext().getValue()+" index:"+tmp.getIndex());
			printer(tmp.getNext());
		}

	}

	

	

	

	

	

}
