package cl.utfsm.inf.aia.plans;

import java.util.ArrayList;

import cl.utfsm.inf.aia.actions.PickUp;
import cl.utfsm.inf.aia.actions.Stack;
import cl.utfsm.inf.aia.actions.UnStack;
import cl.utfsm.inf.aia.helpers.BeliefsHelper;
import cl.utfsm.inf.aia.interfaces.Block;
import cl.utfsm.inf.aia.predicates.Predicate;

public class MoveBlockOnClear extends Plan {
	private ArrayList<Predicate> beliefs;
	private Block blockX;
	private Block blockY;
	
	public MoveBlockOnClear(ArrayList<Predicate> beliefs, Block blockX, Block blockY) {
		super.goal = new StackBlocksOnClear();
		this.beliefs = beliefs;
		this.blockX = blockX;
		this.blockY = blockY;
	}
	
	public MoveBlockOnClear() {
		super.goal = new StackBlocksOnClear();
	}
	
	public ArrayList<Predicate> run() {
		beliefs = new ClearABlock(beliefs, blockX).run();
		//beliefs = new ClearABlock(beliefs, blockY).run();
		beliefs = new PickUp(beliefs, blockX).run();
		beliefs = new Stack(beliefs, blockX, blockY).run();
		
		BeliefsHelper.showBeliefs(beliefs);
		
		return beliefs;	
	}
}
