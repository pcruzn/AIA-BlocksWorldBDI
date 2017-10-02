package cl.utfsm.inf.aia.strategies;

public class Plan {
	private PlanStrategy planStrategy;
	
	public Plan (PlanStrategy planStrategy) {
		this.planStrategy = planStrategy;
	}
	
	public int runPlan() {
		return planStrategy.act();
	}
	
}
