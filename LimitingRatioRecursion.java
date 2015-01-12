import java.util.ArrayList;

public class LimitingRatioRecursion {
	
	public static void main(String[] args) {
		ArrayList<Double> seq = new ArrayList<Double>();
		seq.add(1.0);
		seq.add(1.0);
		seq.add(1.0);
		for(int i=3;i<100;i++) {
			seq.add(seq.get(i-1)+seq.get(i-3));
		}
		for(int i=1;i<seq.size();i++) {
			System.out.println(seq.get(i)/seq.get(i-1));
		}
	}
}