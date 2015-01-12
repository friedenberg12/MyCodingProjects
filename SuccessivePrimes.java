import java.util.ArrayList;
import java.util.Collections;

public class SuccessivePrimes {
	
	public static int n = 1000000;

	public static void main(String[] args) {
		ArrayList<Integer> seq = new ArrayList<Integer>();
		ArrayList<Integer> seqdiff = new ArrayList<Integer>();
		for(int i=1;i<n;i++) {
			if(isPrime(i)) {
				seq.add(i);
			}
		}
		for(int i=1;i<seq.size();i++) {
			seqdiff.add(seq.get(i)-seq.get(i-1));
		}
		System.out.println(Collections.frequency(seqdiff, 6));
		/*int freq_num = 0;
		int highest_freq = 0;
		for(int i=0;i<100000;i++) {
			int a = Collections.frequency(seqdiff, i);
			if(a > highest_freq) {
				freq_num = i;
				highest_freq = a;
			}
		}
		System.out.println(freq_num);
		/*double sum = 0.0;
		for(int i=1;i<seq.size();i++) {
			sum += (seq.get(i)-seq.get(i-1));
		}
		System.out.println(sum/n);*/
	}

	public static boolean isPrime(int n) {
		boolean notPrime = false;
		for(int i=2;i<=Math.sqrt(n);i++) {
			if(isPrime(i) && n%i==0) {
				notPrime = true;
				break;
			}
		}
		return !notPrime;
	}
}