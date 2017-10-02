package cl.utfsm.inf.aia.world;
import cl.utfsm.inf.aia.interfaces.Block;

public class WorldBlock implements Block {
	
	private String name;
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
		
}
