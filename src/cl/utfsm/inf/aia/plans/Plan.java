package cl.utfsm.inf.aia.plans;
import java.util.ArrayList;
import cl.utfsm.inf.aia.predicates.Predicate;

public abstract class Plan {
	protected Goal goal;
	public abstract ArrayList<Predicate> run();
}
