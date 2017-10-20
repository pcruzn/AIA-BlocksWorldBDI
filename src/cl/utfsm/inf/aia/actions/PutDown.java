package cl.utfsm.inf.aia.actions;

import java.util.ArrayList;

import cl.utfsm.inf.aia.helpers.BeliefsHelper;
import cl.utfsm.inf.aia.interfaces.Block;
import cl.utfsm.inf.aia.predicates.ArmEmpty;
import cl.utfsm.inf.aia.predicates.Holding;
import cl.utfsm.inf.aia.predicates.OnTable;
import cl.utfsm.inf.aia.predicates.Predicate;

public class PutDown extends Action {
	private ArrayList<Predicate> beliefs;
	private Block blockToPutdown; 
	
	public PutDown (ArrayList<Predicate> beliefs, Block block) {
		this.beliefs = beliefs;
		this.blockToPutdown = block;
	}
	
	@Override
	public ArrayList<Predicate> run() {
		if (BeliefsHelper.checkBelief(beliefs, new Holding(blockToPutdown))) {
			
			
			beliefs = BeliefsHelper.removeBelief(beliefs, new Holding(blockToPutdown));
			beliefs = BeliefsHelper.addBelief(beliefs, new ArmEmpty());
			beliefs = BeliefsHelper.addBelief(beliefs, new OnTable(blockToPutdown));
		}
		
		return beliefs;	
	}
}
