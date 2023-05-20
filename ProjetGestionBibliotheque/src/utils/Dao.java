package utils;

import java.util.List;

public interface Dao<T> {
	
		// Méthode qui créée un element
		public abstract void create(T objet);
	
		// Methode qui récupère tout les éléments
		public abstract List<T> findAll();
		
		// Méthode qui récupère un élément avec son id
		public abstract T findById(int id);
		
		// Méthode qui modifie un élément
		public abstract T update(T objet);
		
		// Méthode qui supprime un élément 
		public abstract T deleteById(int id);
}
