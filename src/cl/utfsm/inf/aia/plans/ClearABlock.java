package cl.utfsm.inf.aia.plans;
import java.util.ArrayList;
import java.util.Iterator;
import cl.utfsm.inf.aia.actions.PutDown;
import cl.utfsm.inf.aia.actions.UnStack;
import cl.utfsm.inf.aia.helpers.BeliefsHelper;
import cl.utfsm.inf.aia.interfaces.Block;
import cl.utfsm.inf.aia.predicates.Clear;
import cl.utfsm.inf.aia.predicates.Predicate;

public class ClearABlock extends Plan {	
	private ArrayList<Predicate> beliefs;
	private Block blockDownside;
	private Predicate current;
		
	public ClearABlock (ArrayList<Predicate> beliefs, Block block) {
		this.beliefs = beliefs;
		this.blockDownside = block;
	}
	
	public ArrayList<Predicate> run() {
		Iterator<Predicate> beliefsIterator = beliefs.iterator();
		boolean blockAlreadyClear = true;
		while (beliefsIterator.hasNext()) {
			current = beliefsIterator.next();
			
			if (!BeliefsHelper.checkBelief(beliefs, new Clear(blockDownside))){
				if (current.toString().contains("On")) {
					if (current.getBlockDownside().getName().compareTo(blockDownside.getName()) == 0) {
						break;
					}
				}
				blockAlreadyClear = false;
			}
		}
		
		// if block is not already clear, we need to clear it!
		// otherwise, we do nothing
		if(!blockAlreadyClear) {
			beliefs = new UnStack(beliefs, current.getBlockUpside(), blockDownside).run();
			beliefs = new PutDown(beliefs, current.getBlockUpside()).run();
		}
		
		BeliefsHelper.showBeliefs(beliefs);
		
		return beliefs;	
	}
}
