package cl.utfsm.inf.aia.agent;
import java.util.ArrayList;
import java.util.Iterator;

import cl.utfsm.inf.aia.interfaces.Block;
import cl.utfsm.inf.aia.plans.ClearABlock;
import cl.utfsm.inf.aia.plans.MoveBlockOnClear;
import cl.utfsm.inf.aia.plans.Plan;
import cl.utfsm.inf.aia.predicates.Predicate;

public class Planning {
	
	public static Plan getAPlan(ArrayList<Predicate> beliefs, String intention, Block block) {
		Plan planToBeReturned = null;
		// Build the plan library (statically)
		ArrayList<Plan> plansLibrary = new ArrayList<Plan>();
		plansLibrary.add(new ClearABlock(beliefs, block));
		//plansLibrary.add(new MoveBlockOnClear());
		// End of plan library building
		Iterator<Plan> plansIterator = plansLibrary.iterator();
		

		while (plansIterator.hasNext()){
			// Case in which intention is "AchieveClearBlock"
			planToBeReturned = plansIterator.next();
			if (planToBeReturned.toString().compareTo(intention)==0){
				planToBeReturned = new ClearABlock(beliefs, block);
				break;
			}
		}
		
		
		return planToBeReturned;
	}
}
