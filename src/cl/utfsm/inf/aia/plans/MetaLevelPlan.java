package cl.utfsm.inf.aia.plans;
import java.util.ArrayList;
import java.util.Iterator;
import cl.utfsm.inf.aia.interfaces.Block;
import cl.utfsm.inf.aia.predicates.On;
import cl.utfsm.inf.aia.predicates.OnTable;
import cl.utfsm.inf.aia.predicates.Predicate;

public class MetaLevelPlan extends Plan{
	private ArrayList<Predicate> beliefs;
	private ArrayList<Predicate> toAchieve = new ArrayList<Predicate>();
	
	public MetaLevelPlan(ArrayList<Predicate> beliefs, Block blockA, Block blockB, Block blockC){
		this.beliefs = beliefs;
		// we "meta-describe" what to achieve!
		// the ordering is important, as the meta level plan is, intrinsically, considering a 'utility' for plans
		// remember the meta level plan embodies the planning function
		toAchieve.add(new OnTable(blockA));
		toAchieve.add(new On(blockC, blockA));
	}
	
	@Override
	public ArrayList<Predicate> run() {
		Iterator<Predicate> toAchieveIterator = toAchieve.iterator();
		Predicate currentPredicateToAchieve;
		while(toAchieveIterator.hasNext()){
			currentPredicateToAchieve = toAchieveIterator.next(); 
			if(currentPredicateToAchieve instanceof OnTable){
				beliefs = new MoveBlockOnTable(beliefs, currentPredicateToAchieve.getBlockUpside()).run();
			}
			if(currentPredicateToAchieve instanceof On){
				beliefs = new MoveBlockOnClear(beliefs, currentPredicateToAchieve.getBlockUpside(), currentPredicateToAchieve.getBlockDownside()).run();
			}
			
		}
		return beliefs;
	}

}
