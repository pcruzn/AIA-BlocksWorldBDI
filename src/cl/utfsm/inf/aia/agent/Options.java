package cl.utfsm.inf.aia.agent;
import java.util.ArrayList;
import cl.utfsm.inf.aia.predicates.Predicate;

public class Options {
	public static ArrayList<Desire> getDesires(ArrayList<Predicate> beliefs, String intention){
		ArrayList<Desire> desires = new ArrayList<Desire>();
		desires.add(new AchieveClear());
		desires.add(new AchieveBlockStacked());
		desires.add(new BlockStacked());
		
		return desires;
		
	}
}
