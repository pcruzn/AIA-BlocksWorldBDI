package cl.utfsm.inf.aia.plans;
import java.util.ArrayList;
import java.util.Iterator;

import cl.utfsm.inf.aia.interfaces.Block;
import cl.utfsm.inf.aia.predicates.On;
import cl.utfsm.inf.aia.predicates.Predicate;

public class MetaLevelPlan extends Plan{
	private ArrayList<Predicate> beliefs;
	private ArrayList<Predicate> toAchieve = new ArrayList<Predicate>();
	
	public MetaLevelPlan(ArrayList<Predicate> beliefs, Block blockA, Block blockB, Block blockC){
		this.beliefs = beliefs;
		// Here, we "meta-describe" what to achieve!
		toAchieve.add(new On(blockB, blockC));
		//toAchieve.add(new OnTable(blockC));
	}
	
	@Override
	public ArrayList<Predicate> run() {
		Iterator<Predicate> toAchieveIterator = toAchieve.iterator();
		Predicate currentPredicate;
		while(toAchieveIterator.hasNext()){
			currentPredicate = toAchieveIterator.next(); 
			if(currentPredicate instanceof On){
				beliefs = new MoveBlockOnClear(beliefs, currentPredicate.getBlockUpside(), currentPredicate.getBlockDownside()).run();
			}
		}
		return beliefs;
	}

}
