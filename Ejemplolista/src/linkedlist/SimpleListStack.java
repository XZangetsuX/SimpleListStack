package linkedlist;

import java.util.Iterator;
import java.util.ListIterator;

import NODO.nodo;
import Stack.StackEmptyException;
import Stack.StackFullException;
import Stack.iStack;

public class SimpleListStack<T extends Comparable<T>>implements iStack<T>,Iterable<T> {

	private nodo<T> sentinel = null;
	private int size=5;
	private int count=0;

	public SimpleListStack() {

		sentinel = new nodo<T>();
		sentinel.setIndex(-1);
	}

	public SimpleListStack(T value) {
		this();// llama el contructor de arriba
		nodo<T> tmp = new nodo(value);
		tmp.setIndex(0);
		sentinel.setNext(tmp);

	}
	
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<T>() {

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				nodo<T> sig = sentinel;
				sentinel = sentinel.getNext();
				return (sentinel != null) ? true : false;
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				return sentinel.getValue();
			}
		};
		
	}

	@Override
	public T pop() throws StackEmptyException {
		// TODO Auto-generated method stub
		if(isempty()) { throw new StackEmptyException("Pila vacia!!");}
		return pop(sentinel);
		
	}
	private T pop(nodo<T> list){
		
		nodo<T> tmp=list;
		T value=tmp.getNext().getValue();
		if(tmp.getNext()==null) {
			return null;
		}else {
		tmp.setNext(tmp.getNext().getNext());
		
		}
		count--;
		return value;
	}

	@Override
	public void push(T value) throws StackFullException {
		// TODO Auto-generated method stub
		if(isfull()) throw new StackFullException("Pila llena!!");
		nodo<T> tmp = sentinel.getNext();
		nodo<T> _new = new nodo<T>(value);
		_new.setNext(tmp);
		sentinel.setNext(_new);
		count++;
		
	}

	@Override
	public boolean isempty() {
		// TODO Auto-generated method stub
		return count<=0;
		
	}

	@Override
	public boolean isfull() {
		// TODO Auto-generated method stub
		
		return count == size ;
	}

	@Override
	public T peek() throws StackEmptyException {
		// TODO Auto-generated method stub
		if(isempty()) throw new StackEmptyException("Pila vacia");
		nodo<T> tmp=sentinel;
		while(tmp.getNext()!=null) {
			  tmp=tmp.getNext();
		}
		return tmp.getValue();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		nodo<T> tmp;
		while(sentinel.getNext()!=null) {
			tmp=sentinel.getNext();
			sentinel.setNext(null);
			sentinel=tmp;
			
		}
		System.gc();
		count=0;
	}

	@Override
	public T search(T value) throws StackEmptyException {
		// TODO Auto-generated method stub
		if(isempty()) throw new StackEmptyException("Pila vacia");
		return search(value, sentinel);
	}
	private T search(T value, nodo<T> list) {
		if (list.getNext() == null)
			return null;
		if (list.getNext().getValue().equals(value)) {
			return list.getNext().getValue();
		} else {
			return search(value, list.getNext());
		}

	}

}
