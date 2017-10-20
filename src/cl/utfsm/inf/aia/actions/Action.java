package cl.utfsm.inf.aia.actions;
import java.util.ArrayList;
import cl.utfsm.inf.aia.predicates.Predicate;

public abstract class Action {
	public abstract ArrayList<Predicate> run();
}
