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

	@Override
	public Block getBlockUpside() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Block getBlockDownside() {
		// TODO Auto-generated method stub
		return null;
	}
}
