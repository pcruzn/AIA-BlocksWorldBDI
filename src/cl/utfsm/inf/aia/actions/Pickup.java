package cl.utfsm.inf.aia.actions;
import java.util.ArrayList;

import cl.utfsm.inf.aia.helpers.BeliefsHelper;
import cl.utfsm.inf.aia.interfaces.Block;
import cl.utfsm.inf.aia.predicates.ArmEmpty;
import cl.utfsm.inf.aia.predicates.Clear;
import cl.utfsm.inf.aia.predicates.Holding;
import cl.utfsm.inf.aia.predicates.OnTable;
import cl.utfsm.inf.aia.predicates.Predicate;

public class Pickup extends Action {
	private ArrayList<Predicate> beliefs;
	private Block blockToPickup; 
	
	public Pickup (ArrayList<Predicate> beliefs, Block block) {
		this.beliefs = beliefs;
		this.blockToPickup = block;
	}
	
	public ArrayList<Predicate> run() {
		if (BeliefsHelper.checkBelief(beliefs, new Clear(blockToPickup))
				&& BeliefsHelper.checkBelief(beliefs, new OnTable(blockToPickup))
				&& BeliefsHelper.checkBelief(beliefs, new ArmEmpty())) {
			
			beliefs = BeliefsHelper.addBelief(beliefs, new Holding(blockToPickup));
			beliefs = BeliefsHelper.removeBelief(beliefs, new ArmEmpty());
			beliefs = BeliefsHelper.removeBelief(beliefs, new OnTable(blockToPickup));
			
		}
		
		return beliefs;	
	}
}
