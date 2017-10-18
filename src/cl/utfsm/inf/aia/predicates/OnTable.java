package cl.utfsm.inf.aia.predicates;

import cl.utfsm.inf.aia.interfaces.Block;

public class OnTable extends Predicate {
	private Block block;
		
	public OnTable (Block block) {
		this.block = block;
	}
	
	@Override
	public String toString() {
		return ("OnTable " + block.getName());
	}
}
