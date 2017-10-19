package cl.utfsm.inf.aia.agent;
import java.util.ArrayList;
import cl.utfsm.inf.aia.actions.PickUp;
import cl.utfsm.inf.aia.helpers.BeliefsHelper;
import cl.utfsm.inf.aia.interfaces.Block;
import cl.utfsm.inf.aia.interfaces.Table;
import cl.utfsm.inf.aia.plans.ClearABlock;
import cl.utfsm.inf.aia.plans.MetaLevelPlan;
import cl.utfsm.inf.aia.plans.MoveBlockOnClear;
import cl.utfsm.inf.aia.predicates.ArmEmpty;
import cl.utfsm.inf.aia.predicates.Clear;
import cl.utfsm.inf.aia.predicates.On;
import cl.utfsm.inf.aia.predicates.OnTable;
import cl.utfsm.inf.aia.predicates.Predicate;
import cl.utfsm.inf.aia.world.AbstractWorldFactory;
import cl.utfsm.inf.aia.world.WorldFactory;


public class Agent {
	public static void main(String[] args) {
		// simulate initial case
		ArrayList<Predicate> beliefs = new ArrayList<Predicate>();
					
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
		
		// Initial Beliefs - BEGINNING
		BeliefsHelper.addBelief(beliefs, new Clear(blockA));
		BeliefsHelper.addBelief(beliefs, new On(blockA, blockB));
		BeliefsHelper.addBelief(beliefs, new OnTable(blockB));
		BeliefsHelper.addBelief(beliefs, new OnTable(blockC));
		BeliefsHelper.addBelief(beliefs, new Clear(blockC));
		BeliefsHelper.addBelief(beliefs, new ArmEmpty());
		// Initial Beliefs - ENDING
		
		System.out.println("INITIAL BELIEFS...\n");
		BeliefsHelper.showBeliefs(beliefs);
		
		// MetaLevelPlan is the artifact used in the approach of BDI/procedural reasoning systems
		// The MetaLevelPlan contains the initial intention and it calls to other 'sub plans'
		// in order to achieve the big goal.
		beliefs = new MetaLevelPlan(beliefs, blockA, blockB, blockC).run();
		
		
		System.out.println("\nFINAL BELIEFS...");
		BeliefsHelper.showBeliefs(beliefs);
	}

}