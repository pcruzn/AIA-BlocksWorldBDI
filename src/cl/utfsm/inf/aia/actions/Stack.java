package cl.utfsm.inf.aia.actions;

import java.util.ArrayList;
import cl.utfsm.inf.aia.helpers.BeliefsHelper;
import cl.utfsm.inf.aia.interfaces.Block;
import cl.utfsm.inf.aia.predicates.ArmEmpty;
import cl.utfsm.inf.aia.predicates.Clear;
import cl.utfsm.inf.aia.predicates.Holding;
import cl.utfsm.inf.aia.predicates.On;
import cl.utfsm.inf.aia.predicates.Predicate;

public class Stack extends Action {
	private ArrayList<Predicate> beliefs;
	private Block blockX;
	private Block blockY;
	
	public Stack (ArrayList<Predicate> beliefs, Block blockX, Block blockY) {
		this.beliefs = beliefs;
		this.blockX = blockX;
		this.blockY = blockY;
	}
	
	@Override
	public ArrayList<Predicate> run() {
		if (BeliefsHelper.checkBelief(beliefs, new Clear(blockY))
				&& BeliefsHelper.checkBelief(beliefs, new Holding(blockX))) {
			
			beliefs = BeliefsHelper.removeBelief(beliefs, new Clear(blockY));
			beliefs = BeliefsHelper.removeBelief(beliefs, new Holding(blockX));
			beliefs = BeliefsHelper.addBelief(beliefs, new ArmEmpty());
			beliefs = BeliefsHelper.addBelief(beliefs, new On(blockX, blockY));
		}
		
		return beliefs;	
	}
	
	
	
}
