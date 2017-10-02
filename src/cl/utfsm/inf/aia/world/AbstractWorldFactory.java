package cl.utfsm.inf.aia.world;
import cl.utfsm.inf.aia.interfaces.Block;
import cl.utfsm.inf.aia.interfaces.Table;

public abstract class AbstractWorldFactory {
	public abstract Block createBlock();
	public abstract Table createTable();
}
