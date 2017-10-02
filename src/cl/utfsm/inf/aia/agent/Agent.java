package cl.utfsm.inf.aia.agent;
import java.util.ArrayList;
import java.util.Iterator;
import cl.utfsm.inf.aia.interfaces.Block;
import cl.utfsm.inf.aia.interfaces.Table;
import cl.utfsm.inf.aia.predicate.On;
import cl.utfsm.inf.aia.world.AbstractWorldFactory;
import cl.utfsm.inf.aia.world.InitialWorld;
import cl.utfsm.inf.aia.world.WorldFactory;


public class Agent {
	public static void main(String[] args) {
		// simulate initial case
		ArrayList<On> onRels = new ArrayList<On>();
		Iterator<On> onRelsIterator = null;
		
		// prepare the world objects' factory
		AbstractWorldFactory worldFactory = null;
		worldFactory = new WorldFactory();
		
		// there's only one table in the world
		Table table = worldFactory.createTable();
		
		// now let's create the blocks
		Block blockA = worldFactory.createBlock();
		blockA.setName("Block A");
		Block blockB = worldFactory.createBlock();
		blockB.setName("Block B");
		Block blockC = worldFactory.createBlock();
		blockC.setName("Block C");
		
		// blockA is over blockB, blockB is over blockC
		onRels.add(new On(blockA, blockB));
		onRels.add(new On(blockB, blockC));
		// with this, we create our initial world
		InitialWorld initialWorld = new InitialWorld(onRels);
		// end initial case simulation
		
		// initial belief
		// thrash code, or trash? only for checking
		System.out.println("Initial belief...");
		onRelsIterator = initialWorld.getOnRels().iterator();
		while (onRelsIterator.hasNext()) {
			System.out.println(onRelsIterator.next().toString());
		}
		
		// simulated end case
		onRels.add(new On(blockA, blockB));
		onRels.add(new On(blockB, blockC));
		
		// initial intent
		// for this time, we have set equal cases, both initial and ending
		
	}

}
