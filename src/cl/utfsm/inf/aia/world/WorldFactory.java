package cl.utfsm.inf.aia.world;

public class WorldFactory extends AbstractWorldFactory {

	@Override
	public WorldBlock createBlock() {
		return new WorldBlock();
	}

	@Override
	public WorldTable createTable() {
		return new WorldTable();
	}
	

}
