package cl.utfsm.inf.aia.helpers;
import java.util.ArrayList;
import java.util.Iterator;

import cl.utfsm.inf.aia.predicates.Predicate;

public class BeliefsHelper {
	
	public static ArrayList<Predicate> removeBelief (ArrayList<Predicate> beliefs, Predicate predicate) {
		beliefs.remove(getBeliefPosition (beliefs, predicate));
				
		return beliefs;
	}
	
	public static int getBeliefPosition (ArrayList<Predicate> beliefs, Predicate predicate) {
		Iterator<Predicate> beliefsIterator = beliefs.iterator();
		
		int currentBeliefIndex = 0;
		while (beliefsIterator.hasNext()) {
			if (beliefsIterator.next().toString().compareTo(predicate.toString())== 0) {
				return currentBeliefIndex;
			}
			currentBeliefIndex++;
		}
		
		return 0;
	}
	
	public static ArrayList<Predicate> addBelief (ArrayList<Predicate> beliefs, Predicate predicate) {
		beliefs.add(predicate);
		
		return beliefs;
	}
	
	public static boolean checkBelief (ArrayList<Predicate> beliefs, Predicate predicate) {
		Iterator<Predicate> beliefsIterator = beliefs.iterator();
		
		
		while (beliefsIterator.hasNext()) {
			if (beliefsIterator.next().toString().compareTo(predicate.toString())== 0) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void showBeliefs (ArrayList<Predicate> beliefs) {
		Iterator<Predicate> beliefsIterator = beliefs.iterator();
		while (beliefsIterator.hasNext()) {
			System.out.println(beliefsIterator.next().toString());
		}
	}

}
