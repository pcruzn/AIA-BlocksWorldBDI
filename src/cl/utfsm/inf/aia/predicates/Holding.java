package cl.utfsm.inf.aia.predicates;
import cl.utfsm.inf.aia.interfaces.Block;

public class Holding extends Predicate {
	private Block block;
	
	public Holding (Block block) {
		this.block = block;
	}
	
	@Override
	public String toString() {
		return ("Holding " + block.getName());
	}
}
