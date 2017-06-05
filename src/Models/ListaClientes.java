package Models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import Exceptions.ElementNotAllowedException;
import Exceptions.ListSizeOverflownException;

public class ListaClientes<E> extends ArrayList <E> {
		private ArrayList <E> Lista;
		private Comparator <E> Comparador;
		
		
		/**
		 * 
		 * @param comp COMPARADOR QUE PASAMOS POR EL CONSTRUCTOR
		 */
		public ListaClientes(Comparator <E> comp){
			this.Comparador = comp;
			this.Lista = new ArrayList<E>();
		}
		
		@Override
		public boolean add(E element){
			if(element != null){
				
					boolean estado = this.add(element);
					this.sort(Comparador);
					return estado;
			}
				
			else{
				// INDICA SI EL ELEMENTO ES NULO
				throw new ElementNotAllowedException();
			}
		}
		
		/**
		 * AÑADE UNA COLECCION A LA LISTA
		 */
		@Override
		public boolean addAll(Collection<? extends E> coleccion){
			if(!coleccion.isEmpty()){
				return this.addAll(coleccion);
			}
			else {
				// INDICA SI HA SOBRE PASADO EL TAMAÑO DE LA LISTA
				throw new ListSizeOverflownException();
			}
		}
		
	
		
	

}
