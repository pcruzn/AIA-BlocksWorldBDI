package cl.utfsm.inf.aia.predicates;
import cl.utfsm.inf.aia.interfaces.Block;

public class Clear extends Predicate {
	private Block block;
	
	public Clear (Block block) {
		this.block = block;
	}
	
	@Override
	public String toString() {
		return ("Clear " + block.getName());
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
