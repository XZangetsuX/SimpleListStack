package Stack;

public interface iStack<T> {
	public T pop() throws StackEmptyException;
	public void push(T value) throws StackFullException;
	public boolean isempty();
	public boolean isfull();
	public T peek() throws StackEmptyException;
	public int size();
	public void clear();
	public T search(T value) throws StackEmptyException;
}
