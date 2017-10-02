package cl.utfsm.inf.aia.world;
import java.util.ArrayList;
import cl.utfsm.inf.aia.predicate.On;

public abstract class World {
	private ArrayList<On> onRels;
	
	public World(ArrayList<On> onRels) {
		this.onRels = onRels;
	}

	public ArrayList<On> getOnRels() {
		return onRels;
	}

	public void setOnRels(ArrayList<On> onRels) {
		this.onRels = onRels;
	}
	
}
