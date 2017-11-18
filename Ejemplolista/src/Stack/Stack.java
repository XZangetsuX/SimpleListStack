package Stack;

import java.lang.reflect.Array;
import java.util.Iterator;

	public class Stack<T extends Comparable<T>>implements iStack<T>,Iterable<T>  {
		private T[] data = null;
		private Class<T> type = null;
		private int top = -1;
		private int count = 0;
	

		public Stack(Class<T> type) {
			// TODO Auto-generated constructor stub
			data = (T[]) Array.newInstance(type, 10);
			this.type = type;
		}

		public Stack(Class<T> type, int size) {
			data = (T[]) Array.newInstance(type, size);
			this.type = type;
		}

		@Override
		public Iterator<T> iterator() {
			
			return new Iterator<T>() {
				int _count = top;
				@Override
				public boolean hasNext() {
					
					return (_count >= 0);
				}

				@Override
				public T next() {
					
					return data[_count--];
				}
			};
		}

		@Override
		public T pop() throws StackEmptyException {
			if(isempty()) throw new StackEmptyException("Pila vacia");
			T tmp =data[top--];
			//top--;
			count--;
			return tmp;
		}

		@Override
		public void push(T value) throws StackFullException {
			if(isfull()) throw new StackFullException("Pila llena");
			data[++top] = value;//primero lo incrementa y luego lo guarda
			count++;
			
		}

		@Override
		public boolean isempty() {
			
			return (count == 0);
		}

		@Override
		public boolean isfull() {
			
			return (count == data.length);
		}

		@Override
		public T peek() throws StackEmptyException {
			if(isempty()) throw new StackEmptyException("Pila vacìa");
			return data[top];
			
		}

		@Override
		public int size() {
			
			return count;
		}

		@Override
		public void clear() {
			top = -1;
			count=0;
		}

		@Override
		public T search(T value) throws StackEmptyException {
			if(isempty()) throw new StackEmptyException("Pila vacia");
			for (T t : data) {
				if(t.equals(value))
					return t;
			}
			return null;
			
		}
		
}
