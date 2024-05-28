import entities.User;

import java.util.*;

public class Main {
	public static void main(String[] args) {

		User aldo = new User("Aldo", "Baglio", 20);
		User giovanni = new User("Giovanni", "Storti", 30);
		User giacomo = new User("Giacomo", "Poretti", 40);

		//ArrayList<User> usersList1 = new ArrayList<>();// Tra le parentesi angolari <> vado ad inserire il tipo di dato che sarà conservato nella lista
		List<User> usersList = new ArrayList<>(); // <-- UPCASTING, posso in futuro sostituire questa ArrayList con ad es una LinkedList perché avendo
		// utilizzato l'upcasting sono sicuro che nelle seguenti righe di codice avrò utilizzato solo metodi comuni a tutte le List e non specifici di ArrayList
		// Se avessi utilizzato metodi specifici di ArrayList non avrei potuto sostituirla con una LL in quanto essa non avrebbe avuto tali metodi

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

		// List<User> usersLinkedList = new LinkedList<>(); <-- UPCASTING

		// ************************************************ COLLECTIONS E TIPI PRIMITIVI ********************************************
		// Non posso creare collezioni di dati primitivi ArrayList<int> è sbagliato. Per poter comunque creare collezioni di interi, double, ecc
		// Devo utilizzare le loro WRAPPER CLASSES --> Integer, Double, Byte, Short, Boolean

		ArrayList<Integer> listaNumeri = new ArrayList<>();
		listaNumeri.add(2);

		// ********************************************** RIMUOVERE ELEMENTI DA UNA LISTA *******************************************

		ArrayList<String> listaStringhe = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));

/*		for (String lettera : listaStringhe) {
			if (lettera.equals("b")) listaStringhe.remove(lettera); // NON SI POSSONO RIMUOVERE ELEMENTI QUANDO SI ITERA UNA LISTA (JAVA LANCIA UN'ECCEZIONE)
			else System.out.println(lettera);
		}*/

		// Se volessi rimuovere elementi durante le iterazioni di un ciclo devo utilizzare gli ITERATORS
		Iterator<String> iterator = listaStringhe.iterator();
		while (iterator.hasNext()) { // <-- finchè ci sono ulteriori elementi, continua a ciclare
			String lettera = iterator.next(); // <-- mi torna l'elemento corrente
			if (lettera.equals("b")) iterator.remove(); // N.B. Non sto facendo listaStringhe.remove() ma iterator.remove()
			else System.out.println(lettera);
		}

		System.out.println(listaStringhe);

		// ************************************************************ SET ************************************************************
		Set<User> usersSet = new HashSet<>(); // Gli HashSet non consentono elementi duplicati e inoltre non mantengono l'ordine di inserzione degli elementi
		// Set<User> usersSet = new LinkedHashSet<>(); // I LinkedHashSet come sopra non consento duplicati però essi mantengono l'ordine di inserzione degli elementi
		// (occupano però più memoria degli HashSet)

		usersSet.add(aldo);
		usersSet.add(giovanni);
		usersSet.add(giacomo);
		// usersSet.add(aldo); <-- Fare una roba del genere non è vietato (nel senso che non mi verrà lanciata un'eccezione) però IntelliJ mi segnala
		// la cosa con un warning perché per aggiungere due volte uno stesso elemento in un Set, esso dovrà prima controllare tutti gli altri (potenzialmente
		// tanti) elementi, il che ovviamente può avere un costo notevole.

		System.out.println(usersSet);

		Set<String> lettereSet = new TreeSet<>();
		// Il TreeSet oltre a non ammettere duplicati, ordina anche gli elementi (operazione però molto onerosa)
		lettereSet.add("f");
		lettereSet.add("b");
		lettereSet.add("v");
		lettereSet.add("s");
		System.out.println(lettereSet);

		Set<User> usersTreeSet = new TreeSet<>();
		// Per rendere compatibili oggetti custom con il TreeSet, quella classe dovrà implementare l'interfaccia Comparable.
		// Quest'interfaccia ci obbligherà ad avere un metodo compareTo() che è quello che viene utilizzato dal TreeSet in fase di ordinamento
		usersTreeSet.add(giacomo);
		usersTreeSet.add(aldo);
		usersTreeSet.add(giovanni);
		System.out.println(usersTreeSet);

		// ****************************************************** MAPS ******************************************
		// Le Map sono strutture in cui ogni elemento sarà rappresentato dalla coppia <Chiave, Valore>
		Map<Integer, User> usersMap = new HashMap<>();
		// Sto dichiarando che ogni elemento della Map avrà come chiave un numero intero e come valore uno User
		// Ogni elemento sarà tipo:
		// 111111 - Aldo Baglio 20
		// 222222 - Giovanni Storti 30

		Map<String, String> dizionario = new HashMap<>(); // Qua sia chiavi che valori sono String
		// Ogni elemento sarà tipo:
		// "albero" - "Definizione di albero..."
		// "casa" - "Definizione di casa..."

		System.out.println("---------------------------------------- AGGIUNTA ELEMENTI -----------------------------------");
		usersMap.put(111111, aldo);
		usersMap.put(222222, giovanni);
		usersMap.put(333333, aldo);

		System.out.println(usersMap);

		dizionario.put("albero", "Definizione di albero...");
		dizionario.put("casa", "Definizione di casa...");
		dizionario.put("casa", "Altra definizione di casa..."); // Non ci possono essere duplicati nelle chiavi

		System.out.println(dizionario);

		System.out.println("---------------------------------------- LEGGERE ELEMENTI -----------------------------------");
		System.out.println(dizionario.get("albero")); // La chiave serve per accedere agli elementi in lettura, scrittura, rimozione...

		dizionario.replace("albero", "Definizione più aggiornata di albero");
		System.out.println(dizionario);
		// dizionario.remove("albero");
		System.out.println(dizionario);

		Set<String> chiaviDizionario = dizionario.keySet(); // Mi ritorna l'elenco di tutte le chiavi

		for (String chiave : chiaviDizionario) {
			System.out.println("Chiave: " + chiave);
			System.out.println("Valore: " + dizionario.get(chiave));
		}

		// dizionario.values();  <-- Ritorna l'elenco dei valori

	}
}