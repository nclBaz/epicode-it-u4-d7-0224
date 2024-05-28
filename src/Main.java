import entities.User;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {

		User aldo = new User("Aldo", "Baglio", 20);
		User giovanni = new User("Giovanni", "Storti", 30);
		User giacomo = new User("Giacomo", "Poretti", 40);

		ArrayList<User> usersList = new ArrayList<>(); // Tra le parentesi angolari <> vado ad inserire il tipo di dato che sarà conservato nella lista

		System.out.println("La lista ha " + usersList.size() + " elementi");

		usersList.add(aldo);
		usersList.add(giovanni);
		usersList.add(1, giacomo);
		usersList.add(new User("Ajeje", "Brazorf", 60));

		System.out.println("La lista ha " + usersList.size() + " elementi");

		System.out.println(usersList);

		for (User user : usersList) {
			System.out.println(user);
		}

		try {
			System.out.println("------------------------------------- GET ---------------------------------------");
			User found = usersList.get(3);
			System.out.println("L'elemento con indice 3 è " + found);
			System.out.println("L'indice di Aldo è " + usersList.indexOf(aldo));
		} catch (IndexOutOfBoundsException ex) {
			System.out.println(ex.getMessage());
		}


		System.out.println("------------------------------------- CONTAINS ---------------------------------------");
		if (usersList.contains(aldo)) {
			// .contains() internamente utilizza il metodo .equals() degli oggetti in questione, ovviamente posso anche sovrascriverlo per avere
			// un criterio di comparazione personalizzato
			System.out.println("La lista contiene Aldo");
		} else {
			System.out.println("La lista non contiene Aldo");
		}

		System.out.println("------------------------------------- REMOVE ---------------------------------------");
		usersList.remove(aldo);
		usersList.remove(0);

		System.out.println("La lista ha " + usersList.size() + " elementi");
		System.out.println(usersList);


		System.out.println("------------------------------------- ADD ALL ---------------------------------------");
		User[] usersArray = {aldo, giovanni, giacomo};
		usersList.addAll(Arrays.asList(usersArray)); // <-- non posso passare direttamente un array al metodo perché si aspetta una COLLECTION
		// quindi potrò passargli Liste, Set o Code ma non array. La soluzione è convertire l'array in una Collection ad es in una Lista
		System.out.println("La lista ha " + usersList.size() + " elementi");
		System.out.println(usersList);

		System.out.println("------------------------------------- CLEAR ---------------------------------------");
		System.out.println("La lista è vuota? " + usersList.isEmpty());
		usersList.clear(); // Svuoto la lista
		System.out.println("La lista è vuota? " + usersList.isEmpty());
	}
}