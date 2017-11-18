package APP;

import linkedlist.Linkedlist;
import linkedlist.SimpleListStack;
import javafx.collections.*;
import java.util.*;

import Stack.StackEmptyException;
import Stack.StackFullException;
import linkedlist.SimpleListStack;

public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SimpleListStack<String> names = new SimpleListStack<String>();
		try {
			names.push("Gustavo");
			names.push("Edna");
			names.push("Norma");
			names.push("Ana");
			names.push("Diego");
			//System.out.println(names.pop());
			//names.push("Daniel");
			//names.push("Monica");
			//System.out.println(names.pop());
			//System.out.println(names.pop());
			//System.out.println(names.pop());
			//System.out.println(names.pop());
			//System.out.println(names.pop());
			//System.out.println(names.pop());
			//System.out.println("El primero es: "+names.peek());
			//names.clear();
			//System.out.println(names.search("Norma"));
			System.out.println("El tamaño de la lista es: "+names.size());
			System.out.println("-----------Listas--------------");
			for (String string : names) {
				System.out.println(string);
			}
		
		} catch (Exception e ) {
			System.err.println(e);
		}

		/*
		 * Linkedlist <String>names = new Linkedlist<String>();
		 * Linkedlist<String>lastnames= new Linkedlist<String>();
		 * Linkedlist<Integer>ages = new Linkedlist<Integer>(19);
		 * +
		 * 
		 * 
		 * 
		 * 
		 * 
		 * names.addStart("Ana"); names.addStart("Ricardos"); names.addStart("Juansho");
		 * names.addLast("Ana", "Gus"); names.addEnd("Arturo");
		 * 
		 * 
		 * 
		 * ages.addStart(18); ages.addStart(50); ages.addEnd(29);
		 * 
		 * //ages.addBefore(19, 200);
		 * 
		 * System.out.println("La lista nombres "+names.isemty());
		 * System.out.println("La lista apellidos "+lastnames.isemty());
		 * System.out.println("La lista edades "+ages.isemty());
		 * 
		 * 
		 * 
		 * //names.remover("Ana"); //ages.remover(29);
		 * 
		 * 
		 * 
		 * //names.clear(); //ages.clear();
		 * 
		 * 
		 * 
		 * 
		 * names.replace("Ricardos", "Gustavos");
		 * 
		 * names.removeBefore("Gus"); names.removeAfter("Gus");
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * names.printer(); ages.printer();
		 * 
		 * System.out.println("-----------------------------");
		 * 
		 * System.out.println(names.getFirst()); System.out.println(ages.getFirst());
		 * 
		 * System.out.println(names.getLast()); System.out.println(ages.getLast());
		 * 
		 * 
		 * 
		 * System.out.println("El tamaño de la lista de nombres es  : "+names.size());
		 * System.out.println("El tamaño de la lista de edades es  : "+ages.size());
		 * System.out.println("El tamaño de la lista de apellido es  : "+lastnames.size(
		 * ));
		 * 
		 * System.out.println(names.IndexOf(0)); app p=new app();
		 */

	}

}
