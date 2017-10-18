package cl.utfsm.inf.aia.predicates;
import cl.utfsm.inf.aia.interfaces.Block;

public class On extends Predicate {
	private Block block1;
	private Block block2;
	
	public On (Block block1, Block block2) {
		this.block1 = block1;
		this.block2 = block2;
	}
	
	@Override
	public String toString() {
		return ("On " + block1.getName() + " " + block2.getName());
	}
}
