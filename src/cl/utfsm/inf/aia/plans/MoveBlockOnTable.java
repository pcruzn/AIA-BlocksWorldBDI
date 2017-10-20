package cl.utfsm.inf.aia.plans;
import java.util.ArrayList;
import java.util.Iterator;
import cl.utfsm.inf.aia.actions.PutDown;
import cl.utfsm.inf.aia.actions.UnStack;
import cl.utfsm.inf.aia.helpers.BeliefsHelper;
import cl.utfsm.inf.aia.interfaces.Block;
import cl.utfsm.inf.aia.predicates.On;
import cl.utfsm.inf.aia.predicates.Predicate;

public class MoveBlockOnTable extends Plan {
	private ArrayList<Predicate> beliefs;
	private Block block;
	private Predicate current;
		
	public MoveBlockOnTable(ArrayList<Predicate> beliefs, Block block) {
		this.beliefs = beliefs;
		this.block = block;
	}
	
	public ArrayList<Predicate> run() {
		Iterator<Predicate> beliefsIterator = beliefs.iterator();
		
		while (beliefsIterator.hasNext()) {
			current = beliefsIterator.next();
			
			if (current instanceof On) {
				if (current.getBlockUpside().getName().compareTo(block.getName()) == 0) {
					break;
				}
			}
						
		}
		
		beliefs = new UnStack(beliefs, block, current.getBlockDownside()).run();
		beliefs = new PutDown(beliefs, block).run();
		
		BeliefsHelper.showBeliefs(beliefs);
		
		return beliefs;	
	}
}
