package cl.utfsm.inf.aia.plans;
import java.util.ArrayList;
import java.util.Iterator;
import cl.utfsm.inf.aia.actions.PutDown;
import cl.utfsm.inf.aia.actions.UnStack;
import cl.utfsm.inf.aia.helpers.BeliefsHelper;
import cl.utfsm.inf.aia.interfaces.Block;
import cl.utfsm.inf.aia.predicates.Predicate;

public class ClearABlock extends Plan {	
	private ArrayList<Predicate> beliefs;
	private Block blockDownside;
	private Predicate current;
		
	public ClearABlock (ArrayList<Predicate> beliefs, Block block) {
		super.goal = new AchieveClearBlock();
		this.beliefs = beliefs;
		this.blockDownside = block;
	}
	
	public ClearABlock (){
		super.goal = new AchieveClearBlock();
	}
	
	public ArrayList<Predicate> run() {
		Iterator<Predicate> beliefsIterator = beliefs.iterator();
		
		while (beliefsIterator.hasNext()) {
			current = beliefsIterator.next();
			
			if (current.toString().contains("On")) {
				if (current.getBlockDownside().getName().compareTo(blockDownside.getName()) == 0) {
					break;
				}
			}
			
							
		}
		
		
		beliefs = new UnStack(beliefs, current.getBlockUpside(), blockDownside).run();
		beliefs = new PutDown(beliefs, current.getBlockUpside()).run();
	
		BeliefsHelper.showBeliefs(beliefs);
		
		return beliefs;	
	}
}
